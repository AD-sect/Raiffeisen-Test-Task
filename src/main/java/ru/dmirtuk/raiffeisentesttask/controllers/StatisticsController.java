package ru.dmirtuk.raiffeisentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;
import ru.dmirtuk.raiffeisentesttask.services.StatisticsService;
import ru.dmirtuk.raiffeisentesttask.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value ="/statistics")
public class StatisticsController {
    private StatisticsService statisticsService;
    private UserService userService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService, UserService userService) {
        this.statisticsService = statisticsService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<Statistic> getAllStatistics(){
        if(statisticsService.isEmpty()) {
            return statisticsService.getStatistics();
        }else{
            return null;
        }
    }
    @GetMapping("/{name}")
    public List<Statistic> getStatisticsByName(@PathVariable String name){
        if(userService.existName(name)) {
            return statisticsService.getStatisticByName(name);
        } else{
            return null;
            }
    }

    @GetMapping("count/")
    public String getCountedStatistic(){
        if(statisticsService.isEmpty()) {
            int games = statisticsService.countGames();
            int wins = statisticsService.countWin();
            int losses = statisticsService.countLosses();
            int draws = statisticsService.countDraws();
            Move move = statisticsService.oftenUserMove();

            return "Total games: " + games + "\n" +
                    "Total wins: " + wins + "\n" +
                    "Total losses: " + losses + "\n" +
                    "Total draws: " + draws + "\n" +
                    "Often move: " + move + "\n";
        }else{
            return "There is no statistic yet!";
        }
    }

    @GetMapping("count/{name}")
    public String getCountedStatistic(@PathVariable String name){
         if(userService.existName(name)) {
             int games = statisticsService.countGamesByName(name);
             int wins = statisticsService.countWinByName(name);
             int losses = statisticsService.countLossesByName(name);
             Move move = statisticsService.oftenUserMoveByName(name);
             int draws = statisticsService.countDrawsByName(name);

             return "Total games: " + games + "\n" +
                     "Total wins: " + wins + "\n" +
                     "Total losses: " + losses + "\n" +
                     "Total draws: " + draws + "\n" +
                     "Often move: " + move + "\n";
         }else{
             return null;
         }
    }



}
