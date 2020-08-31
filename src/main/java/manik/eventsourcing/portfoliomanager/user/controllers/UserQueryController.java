package manik.eventsourcing.portfoliomanager.user.controllers;

import io.swagger.annotations.Api;
import manik.eventsourcing.portfoliomanager.user.UserQueryService;
import manik.eventsourcing.portfoliomanager.user.UserView;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/usersQ")
@Api(value = "User Query", tags = "User Query")
public class UserQueryController {

    private final UserQueryService userQueryService;

    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping(value = "{userId}")
    public Optional<UserView> getUser(@PathVariable(value = "userId") String userId){
        return userQueryService.getUser(userId);
    }
}
