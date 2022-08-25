package ru.dmirtuk.raiffeisentesttask.services;


import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.models.User;

import java.util.List;

public interface UserService {
    public User addUser(String name, Status status);
    public boolean exist(String name);
    public User getUser(String name);
    public User getUserByStatus(Status status);

    public Status getStatus(String name);
    public Status setStatus(String name, Status gamer);
    public boolean existsStatus(Status status);

}
