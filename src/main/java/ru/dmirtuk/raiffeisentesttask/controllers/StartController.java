package ru.dmirtuk.raiffeisentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.services.GameService;
import ru.dmirtuk.raiffeisentesttask.services.UserService;

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
