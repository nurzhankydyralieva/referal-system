package kg.megacom.referalsystem.exeptions;

public class InviteLimitReached extends RuntimeException{
    public InviteLimitReached(String message) {
        super(message);
    }
}
