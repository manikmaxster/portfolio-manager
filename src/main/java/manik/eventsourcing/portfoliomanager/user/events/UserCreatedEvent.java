package manik.eventsourcing.portfoliomanager.user.events;

import manik.eventsourcing.portfoliomanager.core.BaseEvent;

import java.util.UUID;

public class UserCreatedEvent extends BaseEvent<UUID> {

    public final String name;
    public final String username;
    public final String email;

    public UserCreatedEvent(UUID id, String name, String username, String email) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
