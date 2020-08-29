package manik.eventsourcing.portfoliomanager.user.controllers;

import io.swagger.annotations.Api;
import manik.eventsourcing.portfoliomanager.user.UserCommandService;
import manik.eventsourcing.portfoliomanager.user.dtos.UserChangeStatusDto;
import manik.eventsourcing.portfoliomanager.user.dtos.UserCreateDto;
import manik.eventsourcing.portfoliomanager.user.dtos.UserUpdateDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User Commands", tags = "User Commands")
public class UserCommandController {

    private final UserCommandService userCommandService;

    public UserCommandController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping
    public CompletableFuture<UUID> createUser(@RequestBody UserCreateDto userCreateDto){
        return userCommandService.createUser(userCreateDto);
    }

    @PutMapping(value = "{userId}")
    public CompletableFuture<UUID> updateUser(@PathVariable(value = "userId") String userId, @RequestBody UserUpdateDto userUpdateDto){
        return userCommandService.updateUser(userId, userUpdateDto);
    }

    @PutMapping(value = "{userId}")
    public CompletableFuture<UUID> changeUserStatus(@PathVariable(value = "userId") String userId, @RequestBody UserChangeStatusDto userChangeStatusDto){
        return userCommandService.changeUserStatus(userId, userChangeStatusDto);
    }
}
