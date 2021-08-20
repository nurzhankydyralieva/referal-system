package kg.megacom.referalsystem.services;

import kg.megacom.referalsystem.models.dto.InviteDto;

public interface InviteService {
    InviteDto sendInvite(InviteDto inviteDto);
}
