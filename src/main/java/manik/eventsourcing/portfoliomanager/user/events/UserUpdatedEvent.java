package manik.eventsourcing.portfoliomanager.user.events;

import manik.eventsourcing.portfoliomanager.core.BaseEvent;

public class UserUpdatedEvent extends BaseEvent<String> {

    public final String name;
    public final String username;
    public final String email;

    public UserUpdatedEvent(String id, String name, String username, String email) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
