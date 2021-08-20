package kg.megacom.referalsystem.dao;

import kg.megacom.referalsystem.models.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber, Long> {
}
