package kg.megacom.referalsystem.services;

import kg.megacom.referalsystem.models.dto.SubscriberDto;

public interface SubscriberService {

    SubscriberDto getOrCreate(SubscriberDto subscriberDto);
}
