package ru.dmirtuk.raiffeisentesttask.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.models.User;
import ru.dmirtuk.raiffeisentesttask.services.UserService;

import java.util.List;

/**
 *It is the controller class, which implements the viewing user's nicknames.
 *
 * User can get all nicknames with statuses, and also get the nickname of current Gamer status.
 *
 * REST API:
 *  GET /users - get all users
 *  GET /users/gamer - get user with status Gamer
 */



@RestController
@RequestMapping(value ="/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers(){
        if(userService.isEmpty()){
            return userService.getAll();
        }else{
            return null;
        }

    }

    @GetMapping("/gamer")
    public String getGamerUser(){
        if(userService.existsStatus(Status.GAMER)) {
            User user = userService.getGamerUser();
            return "Active gamer nickname : " + user.getName().toUpperCase();
        }else{
            return "No gamer nickname. For gaming start the game!";
        }
    }


}
