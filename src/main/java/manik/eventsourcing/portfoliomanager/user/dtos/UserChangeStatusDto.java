package manik.eventsourcing.portfoliomanager.user.dtos;

import lombok.Data;
import manik.eventsourcing.portfoliomanager.user.Status;

@Data
public class UserChangeStatusDto {
    private Status status;
}
