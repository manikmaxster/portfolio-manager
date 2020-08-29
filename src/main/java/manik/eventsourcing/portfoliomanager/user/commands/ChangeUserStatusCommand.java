package manik.eventsourcing.portfoliomanager.user.commands;

import manik.eventsourcing.portfoliomanager.core.BaseCommand;
import manik.eventsourcing.portfoliomanager.user.Status;

import java.util.UUID;

public class ChangeUserStatusCommand extends BaseCommand<UUID> {

    public final Status status;

    public ChangeUserStatusCommand(UUID id, Status status) {
        super(id);
        this.status = status;
    }
}
