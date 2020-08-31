package manik.eventsourcing.portfoliomanager.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class UserView {

    @Id
    private String _id;
    private String name;
    private String username;
    private String email;
    private Status status;
}
