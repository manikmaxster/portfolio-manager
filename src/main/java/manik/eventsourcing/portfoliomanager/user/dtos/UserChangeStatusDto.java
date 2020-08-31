package manik.eventsourcing.portfoliomanager.user.dtos;

import lombok.Data;
import manik.eventsourcing.portfoliomanager.user.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserChangeStatusDto {

    @NotNull
    private Status status;
}
