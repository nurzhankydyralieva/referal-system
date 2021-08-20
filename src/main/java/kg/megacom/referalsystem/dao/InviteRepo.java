package kg.megacom.referalsystem.dao;

import kg.megacom.referalsystem.models.Invite;
import kg.megacom.referalsystem.models.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InviteRepo extends CrudRepository<Invite,Long> {

    long countAllBySenderAndStartDateAfter(Subscriber sender, Date date);

}
