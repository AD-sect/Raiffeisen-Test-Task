package ru.dmirtuk.raiffeisentesttask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;
import ru.dmirtuk.raiffeisentesttask.models.User;
import ru.dmirtuk.raiffeisentesttask.repositoty.StatisticsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository statisticsRepository){
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public Statistic addStatistics(User user, Result res, Move compMove, Move userMove) {
        Statistic stat = new Statistic();
        stat.setRes(res);
        stat.setCompMove(compMove);
        stat.setUserMove(userMove);
        stat.setUser(user);
        statisticsRepository.save(stat);
    return stat;
    }

    @Override
    public List<Statistic> getStatistics() {
        return statisticsRepository.findAll().stream().collect(Collectors.toList());
    }
}
