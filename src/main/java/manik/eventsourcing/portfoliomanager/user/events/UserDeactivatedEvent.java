package manik.eventsourcing.portfoliomanager.user.events;

import manik.eventsourcing.portfoliomanager.core.BaseEvent;
import manik.eventsourcing.portfoliomanager.user.Status;

public class UserDeactivatedEvent extends BaseEvent<String> {

    public final Status status;

    public UserDeactivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
