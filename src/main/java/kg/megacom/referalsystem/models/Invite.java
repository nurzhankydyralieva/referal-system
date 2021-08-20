package kg.megacom.referalsystem.models;

import kg.megacom.referalsystem.enums.InviteStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "invites")
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Subscriber sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Subscriber receiver;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private InviteStatus status;
}
