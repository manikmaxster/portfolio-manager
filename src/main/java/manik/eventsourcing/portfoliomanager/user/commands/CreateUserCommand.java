package manik.eventsourcing.portfoliomanager.user.commands;

import manik.eventsourcing.portfoliomanager.core.BaseCommand;
import manik.eventsourcing.portfoliomanager.user.UserAggregate;

import java.util.UUID;

public class CreateUserCommand extends BaseCommand<UUID> {

    public final String name;
    public final String username;
    public final String email;

    public CreateUserCommand(UUID id, String name, String username, String email) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
