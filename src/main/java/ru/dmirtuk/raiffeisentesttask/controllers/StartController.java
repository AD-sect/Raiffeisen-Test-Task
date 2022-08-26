package ru.dmirtuk.raiffeisentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.services.GameService;
import ru.dmirtuk.raiffeisentesttask.services.UserService;

/**
 *It is the controller class, which implements the start of the game.
 *
 * Only users with status Gamer can pass the game answers to the game url.To get the status Gamer
 * user have to pass nickname to the start url. Nickname identify user in statistic table.
 *
 * Gamer in User table can be only one.
 *
 * If this nickname is new and other nicknames are not Gamers, user with this nickname
 * will be created with status Gamer, and user can play game. In other way, if Gamer exists in User table,
 * it is impossible to make new start with new nickname, until another Gamer is stopped.
 * If nickname have already existed and has status Gamer, nothing happens.
 * If nickname have already existed, but has status Guest, status will be changed and game will start.
 */

@RestController
@RequestMapping(value ="/start")
public class StartController {

    private UserService userService;

    @Autowired
    public  StartController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public String startGame(@PathVariable String name){

        if(userService.existsStatus(Status.GAMER)){
            return "You didn't stop the game with nickname : "
                    + userService.getUserByStatus(Status.GAMER).getName().toUpperCase();
        }

        if(!userService.existName(name)) {
            userService.addUser(name, Status.GAMER);
            return "You started the first game!";

        }else if(userService.getStatus(name).equals(Status.GAMER)){
            return "Game have already started!";

        }else{
            userService.setStatus(name, Status.GAMER);
            return "You started another game!";
        }
    }






}
