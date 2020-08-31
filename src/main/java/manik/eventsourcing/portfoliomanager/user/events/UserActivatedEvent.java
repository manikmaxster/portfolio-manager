package manik.eventsourcing.portfoliomanager.user.events;

import manik.eventsourcing.portfoliomanager.core.BaseEvent;
import manik.eventsourcing.portfoliomanager.user.Status;

public class UserActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public UserActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
