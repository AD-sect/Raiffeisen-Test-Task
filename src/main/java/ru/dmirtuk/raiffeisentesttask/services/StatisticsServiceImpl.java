package ru.dmirtuk.raiffeisentesttask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;
import ru.dmirtuk.raiffeisentesttask.models.User;
import ru.dmirtuk.raiffeisentesttask.repositoty.StatisticsRepository;
import ru.dmirtuk.raiffeisentesttask.repositoty.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private StatisticsRepository statisticsRepository;
    private UserRepository userRepository;

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository statisticsRepository, UserRepository userRepository){
        this.statisticsRepository = statisticsRepository;
        this.userRepository = userRepository;
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

    @Override
    public Statistic getLastStatistic() {
       return statisticsRepository.findFirstByOrderByCreatedAtDesc();
    }

    @Override
    public List<Statistic> getStatisticByName(String name) {
        return statisticsRepository.findByUserId(userRepository.findUserByName(name).getId());
    }

    @Override
    public boolean exists() {
        return statisticsRepository.existsBy();
    }


}
