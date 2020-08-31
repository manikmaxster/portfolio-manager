package manik.eventsourcing.portfoliomanager.user.controllers;

import io.swagger.annotations.Api;
import manik.eventsourcing.portfoliomanager.user.UserCommandService;
import manik.eventsourcing.portfoliomanager.user.dtos.UserChangeStatusDto;
import manik.eventsourcing.portfoliomanager.user.dtos.UserCreateDto;
import manik.eventsourcing.portfoliomanager.user.dtos.UserUpdateDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public CompletableFuture<String> createUser(@RequestBody @Valid UserCreateDto userCreateDto){
        return userCommandService.createUser(userCreateDto);
    }

    @PutMapping(value = "{userId}")
    public CompletableFuture<String> updateUser(@PathVariable(value = "userId") String userId, @RequestBody @Valid UserUpdateDto userUpdateDto){
        return userCommandService.updateUser(userId, userUpdateDto);
    }

    @PutMapping(value = "/changeStatus/{userId}")
    public CompletableFuture<String> changeUserStatus(@PathVariable(value = "userId") String userId, @RequestBody @Valid UserChangeStatusDto userChangeStatusDto){
        return userCommandService.changeUserStatus(userId, userChangeStatusDto);
    }
}
