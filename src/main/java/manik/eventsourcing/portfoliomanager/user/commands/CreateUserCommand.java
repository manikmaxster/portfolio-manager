package manik.eventsourcing.portfoliomanager.user.commands;

import manik.eventsourcing.portfoliomanager.core.BaseCommand;

public class CreateUserCommand extends BaseCommand<String> {

    public final String name;
    public final String username;
    public final String email;

    public CreateUserCommand(String id, String name, String username, String email) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
