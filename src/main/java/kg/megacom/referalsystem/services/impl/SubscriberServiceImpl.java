package kg.megacom.referalsystem.services.impl;

import kg.megacom.referalsystem.dao.SubscriberRepo;
import kg.megacom.referalsystem.exeptions.SubscriberNotFound;
import kg.megacom.referalsystem.mappers.SubscriberMapper;
import kg.megacom.referalsystem.models.Subscriber;
import kg.megacom.referalsystem.models.dto.SubscriberDto;
import kg.megacom.referalsystem.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    @Autowired
    private SubscriberRepo subscriberRepo;

    private SubscriberMapper subscriberMapper = SubscriberMapper.INSTANCE;
    @Override
    public SubscriberDto getOrCreate(SubscriberDto subscriberDto) {
        Subscriber subscriber = subscriberMapper.toSubscriber(subscriberDto);

//        if (subscriberRepo.existsById(subscriber.getSubs_id())){
//            subscriber = subscriberRepo.findById(subscriber.getSubs_id()).get();
//        }else{
//            subscriber.setAddDate(new Date());
//            subscriber.setEditDate(new Date());
//            subscriber.setActive(true);
//            subscriber = subscriberRepo.save(subscriber);
//        }
        try {
            subscriber = subscriberRepo.findById(subscriber.getSubs_id()).orElseThrow(()->new SubscriberNotFound());
        }catch (SubscriberNotFound e){
            subscriber.setAddDate(new Date());
            subscriber.setEditDate(new Date());
            subscriber.setActive(true);
            subscriber = subscriberRepo.save(subscriber);
        }

        return subscriberMapper.toSubscriberDto(subscriber);
    }
}
