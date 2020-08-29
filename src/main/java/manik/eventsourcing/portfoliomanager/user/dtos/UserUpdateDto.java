package manik.eventsourcing.portfoliomanager.user.dtos;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String name;
    private String username;
    private String email;
}
