package ru.dmirtuk.raiffeisentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;
import ru.dmirtuk.raiffeisentesttask.services.StatisticsService;

import java.util.List;

// TODO: 25.08.2022 сделать фильтрацию статистики и посчет выигрышей пригрышей 

@RestController
@RequestMapping(value ="/statistics")
public class StatisticsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/")
    public List<Statistic> statistics(){
        return statisticsService.getStatistics();
    }
}
