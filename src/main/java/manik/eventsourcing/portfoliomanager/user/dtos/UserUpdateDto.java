package manik.eventsourcing.portfoliomanager.user.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String email;
}
