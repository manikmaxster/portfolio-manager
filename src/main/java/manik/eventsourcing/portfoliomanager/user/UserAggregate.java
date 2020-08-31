package manik.eventsourcing.portfoliomanager.user;

import manik.eventsourcing.portfoliomanager.user.commands.ChangeUserStatusCommand;
import manik.eventsourcing.portfoliomanager.user.commands.CreateUserCommand;
import manik.eventsourcing.portfoliomanager.user.commands.UpdateUserCommand;
import manik.eventsourcing.portfoliomanager.user.events.UserActivatedEvent;
import manik.eventsourcing.portfoliomanager.user.events.UserCreatedEvent;
import manik.eventsourcing.portfoliomanager.user.events.UserDeactivatedEvent;
import manik.eventsourcing.portfoliomanager.user.events.UserUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private String username;
    private String email;
    private String status;

    public UserAggregate(){

    }

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand){
        AggregateLifecycle.apply(new UserCreatedEvent(createUserCommand.id, createUserCommand.name, createUserCommand.username, createUserCommand.email));
    }

    @EventSourcingHandler
    protected void on(UserCreatedEvent userCreatedEvent){
        this.id = userCreatedEvent.id;
        this.name = userCreatedEvent.name;
        this.username = userCreatedEvent.username;
        this.email = userCreatedEvent.email;
        this.status = String.valueOf(Status.CREATED);

        AggregateLifecycle.apply(new UserActivatedEvent(this.id, Status.ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(UserActivatedEvent userActivatedEvent){
        this.status = String.valueOf(userActivatedEvent.status);
    }

    @EventSourcingHandler
    protected void on(UserDeactivatedEvent userDeactivatedEvent){
        this.status = String.valueOf(userDeactivatedEvent.status);
    }

    @CommandHandler
    protected void on(UpdateUserCommand updateUserCommand){
        AggregateLifecycle.apply(new UserUpdatedEvent(
                updateUserCommand.id,
                updateUserCommand.name,
                updateUserCommand.username,
                updateUserCommand.email
        ));
    }

    @CommandHandler
    protected void on(ChangeUserStatusCommand changeUserStatusCommand){
        switch (changeUserStatusCommand.status){
            case ACTIVATED:
                AggregateLifecycle.apply(new UserActivatedEvent(
                        changeUserStatusCommand.id,
                        changeUserStatusCommand.status
                ));
                break;
            case DEACTIVATED:
                AggregateLifecycle.apply(new UserDeactivatedEvent(
                        changeUserStatusCommand.id,
                        changeUserStatusCommand.status
                ));
                break;
        }
    }

    @EventSourcingHandler
    protected void on(UserUpdatedEvent userUpdatedEvent){
        this.name = userUpdatedEvent.name;
        this.username = userUpdatedEvent.username;
        this.email = userUpdatedEvent.email;
    }
}
