package manik.eventsourcing.portfoliomanager.user.commands;

import manik.eventsourcing.portfoliomanager.core.BaseCommand;

import java.util.UUID;

public class UpdateUserCommand extends BaseCommand<UUID> {

    public final String name;
    public final String username;
    public final String email;

    public UpdateUserCommand(UUID id, String name, String username, String email) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
