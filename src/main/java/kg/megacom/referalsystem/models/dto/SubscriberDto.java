package kg.megacom.referalsystem.models.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class SubscriberDto {
    private Long subs_id;
    private String phone;
    private boolean active;
    private Date addDate;
    private Date editDate;

}
