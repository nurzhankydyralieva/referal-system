package kg.megacom.referalsystem.services.impl;

import kg.megacom.referalsystem.dao.InviteRepo;
import kg.megacom.referalsystem.exeptions.InviteLimitReached;
import kg.megacom.referalsystem.mappers.SubscriberMapper;
import kg.megacom.referalsystem.models.dto.InviteDto;
import kg.megacom.referalsystem.services.InviteService;
import kg.megacom.referalsystem.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class InviteServiceImpl implements InviteService {


    private SubscriberService subscriberService;
    private InviteRepo inviteRepo;
    private SubscriberMapper subscriberMapper = SubscriberMapper.INSTANCE;

    public InviteServiceImpl(SubscriberService subscriberService, InviteRepo inviteRepo) {
        this.subscriberService = subscriberService;
        this.inviteRepo = inviteRepo;
    }

    @Override
    public InviteDto sendInvite(InviteDto inviteDto) {
        inviteDto.setSender(subscriberService.getOrCreate(inviteDto.getSender()));
        inviteDto.setReceiver(subscriberService.getOrCreate(inviteDto.getReceiver()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        long count = inviteRepo.countAllBySenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime()
        );
        if (count > 5) {
            throw new InviteLimitReached("Достигнуто максимальное количество за сутки");
        }
        System.out.println(inviteDto);
        return inviteDto;
    }
}
