package ru.dmirtuk.raiffeisentesttask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.models.User;
import ru.dmirtuk.raiffeisentesttask.repositoty.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService  {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(String name, Status status) {
        User user = new User();
        user.setName(name);
        user.setStatus(status);
        userRepository.save(user);
        return user;
    }

    public boolean exist(String name){
        return userRepository.existsByName(name);
    }

    @Override
    public User getUser(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User getUserByStatus(Status status) {
       return  userRepository.findUserByStatus(status).stream().findFirst().get();
    }

    @Override
    public Status getStatus(String name) {
        return userRepository.findUserByName(name).getStatus();
    }

    @Override
    public Status setStatus(String name, Status status) {
        User user = userRepository.findUserByName(name);
        user.setStatus(status);
        userRepository.save(user);
        return status;
    }

    @Override
    public boolean existsStatus(Status status) {
        if(userRepository.findUserByStatus(status) != null){
            return true;
        }else{
            return false;
        }
    }


}
