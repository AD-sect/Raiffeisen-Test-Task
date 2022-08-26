package ru.dmirtuk.raiffeisentesttask.services;

import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;
import ru.dmirtuk.raiffeisentesttask.models.User;

import java.util.List;

public interface StatisticsService {
    public Statistic addStatistics(User user, Result res,
                                   Move compMove, Move userMove);
    public List<Statistic> getStatistics();
    public Statistic getLastStatistic();
    public List<Statistic> getStatisticByName(String name);

    public boolean exists();
}
