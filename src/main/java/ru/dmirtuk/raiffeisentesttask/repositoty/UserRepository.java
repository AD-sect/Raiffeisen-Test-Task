package ru.dmirtuk.raiffeisentesttask.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.models.User;

import java.util.List;


/**
 *It is the repository interface for work with user data.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String  username);
    List<User> findAll();
    boolean existsBy();
    boolean existsByName(String name);
    List<User> findUserByStatus(Status status);


}
