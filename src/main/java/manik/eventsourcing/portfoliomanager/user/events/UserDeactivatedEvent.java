package manik.eventsourcing.portfoliomanager.user.events;

import manik.eventsourcing.portfoliomanager.core.BaseEvent;
import manik.eventsourcing.portfoliomanager.user.Status;

import java.util.UUID;

public class UserDeactivatedEvent extends BaseEvent<UUID> {

    public final Status status;

    public UserDeactivatedEvent(UUID id, Status status) {
        super(id);
        this.status = status;
    }
}
