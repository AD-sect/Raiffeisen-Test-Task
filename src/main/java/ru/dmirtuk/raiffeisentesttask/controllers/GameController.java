package ru.dmirtuk.raiffeisentesttask.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;
import ru.dmirtuk.raiffeisentesttask.enums.Status;
import ru.dmirtuk.raiffeisentesttask.repositoty.StatisticsRepository;
import ru.dmirtuk.raiffeisentesttask.services.GameService;
import ru.dmirtuk.raiffeisentesttask.services.StatisticsService;
import ru.dmirtuk.raiffeisentesttask.services.UserService;
import ru.dmirtuk.raiffeisentesttask.services.UserServiceImpl;

@RestController
@RequestMapping(value ="/game")
public class GameController {

    private GameService gameService;
    private StatisticsService statisticsService;
    private UserService userService;

    @Autowired
    public  GameController(GameService gameService, StatisticsService statisticsService, UserService userService) {
        this.gameService = gameService;
        this.statisticsService = statisticsService;
        this.userService = userService;
    }

    @GetMapping("/{move}")
    public String gaming(@PathVariable String move){

        if(userService.existsStatus(Status.GAMER)) {
            Move compMove = gameService.getRandomMove();
            Move userMove = Move.valueOf(move.toUpperCase());
            Result res = gameService.chooseWinner(userMove, compMove);
            statisticsService.addStatistics(userService.getUserByStatus(Status.GAMER), res, compMove, userMove);

            return "Your move was: " + move.toUpperCase() + "\n"+
                    "Computer move was: " + compMove +"\n" +
                    "Result: " + res;

        }else {
            return "You didn't start the game with any nickname";
        }

    }





}
