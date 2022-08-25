package ru.dmirtuk.raiffeisentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.services.UserService;

@RestController
@RequestMapping(value ="/stop")
public class StopController {

    private UserService userService;

    @Autowired
    public StopController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/{name}")
    public String stop(@PathVariable String name){
        if(!userService.exist(name)) {
            return "Gamer with this name doesn't played!";

        }else if(userService.getStatus(name).equals(Status.GAMER)){
            userService.setStatus(name, Status.GUEST);
            return "Game stopped!";

        }else {
            return "You didn't start the game!";
        }
    }
}
