package ru.dmirtuk.raiffeisentesttask.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String  username);
    List<User> findAll();
    boolean existsBy();
    boolean existsByName(String name);

//    Status getStatusByName(String name);
    List<User> findUserByStatus(Status status);


}
