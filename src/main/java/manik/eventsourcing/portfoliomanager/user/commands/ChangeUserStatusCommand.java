package manik.eventsourcing.portfoliomanager.user.commands;

import manik.eventsourcing.portfoliomanager.core.BaseCommand;
import manik.eventsourcing.portfoliomanager.user.Status;

public class ChangeUserStatusCommand extends BaseCommand<String> {

    public final Status status;

    public ChangeUserStatusCommand(String id, Status status) {
        super(id);
        this.status = status;
    }
}
