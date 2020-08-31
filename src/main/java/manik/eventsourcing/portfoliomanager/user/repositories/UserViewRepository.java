package manik.eventsourcing.portfoliomanager.user.repositories;

import manik.eventsourcing.portfoliomanager.user.UserView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserViewRepository extends MongoRepository<UserView, String> {
    Optional<UserView> findByUsername(String username);
    Optional<UserView> findById(String _id);
}
