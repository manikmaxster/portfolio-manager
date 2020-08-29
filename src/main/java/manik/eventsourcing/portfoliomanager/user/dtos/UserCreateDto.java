package manik.eventsourcing.portfoliomanager.user.dtos;

import lombok.Data;

@Data
public class UserCreateDto {
    private String name;
    private String username;
    private String email;
}
