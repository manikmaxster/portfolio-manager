package manik.eventsourcing.portfoliomanager.user;

import manik.eventsourcing.portfoliomanager.user.events.UserActivatedEvent;
import manik.eventsourcing.portfoliomanager.user.events.UserCreatedEvent;
import manik.eventsourcing.portfoliomanager.user.events.UserDeactivatedEvent;
import manik.eventsourcing.portfoliomanager.user.repositories.UserViewRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryService {

    private final UserViewRepository userViewRepository;

    @Autowired
    public UserQueryService(UserViewRepository userViewRepository) {
        this.userViewRepository = userViewRepository;
    }

    @EventHandler
    public void on(UserCreatedEvent event){
        UserView userView = new UserView();
        userView.set_id(event.id);
        userView.setName(event.name);
        userView.setUsername(event.username);
        userView.setEmail(event.email);
        userView.setStatus(Status.CREATED);
        userViewRepository.save(userView);
    }

    private void changeStatus(String userId, Status status){
        Optional<UserView> userView = userViewRepository.findById(userId);
        if(userView.isPresent()){
            UserView user = userView.get();
            user.setStatus(status);
            userViewRepository.save(user);
        }
    }

    @EventHandler
    public void on(UserActivatedEvent event){
        changeStatus(event.id, event.status);
    }

    @EventHandler
    public void on(UserDeactivatedEvent event){
        changeStatus(event.id, event.status);
    }

    public Optional<UserView> getUser(String userId){
        return userViewRepository.findById(userId);
    }
}
