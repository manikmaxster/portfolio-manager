package manik.eventsourcing.portfoliomanager.user;

import manik.eventsourcing.portfoliomanager.user.commands.ChangeUserStatusCommand;
import manik.eventsourcing.portfoliomanager.user.commands.CreateUserCommand;
import manik.eventsourcing.portfoliomanager.user.commands.UpdateUserCommand;
import manik.eventsourcing.portfoliomanager.user.dtos.UserChangeStatusDto;
import manik.eventsourcing.portfoliomanager.user.dtos.UserCreateDto;
import manik.eventsourcing.portfoliomanager.user.dtos.UserUpdateDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class UserCommandService {

    private final CommandGateway commandGateway;

    public UserCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createUser(UserCreateDto userCreateDto){
        return commandGateway.send(new CreateUserCommand(UUID.randomUUID().toString(), userCreateDto.getName(), userCreateDto.getUsername(), userCreateDto.getEmail()));
    }

    public CompletableFuture<String> updateUser(String userId, UserUpdateDto userUpdateDto){
        return commandGateway.send(new UpdateUserCommand(
                userId,
                userUpdateDto.getName(),
                userUpdateDto.getUsername(),
                userUpdateDto.getEmail()
        ));
    }

    public CompletableFuture<String> changeUserStatus(String userId, UserChangeStatusDto userChangeStatusDto){
        return commandGateway.send(new ChangeUserStatusCommand(
                userId,
                userChangeStatusDto.getStatus()
        ));
    }
}
