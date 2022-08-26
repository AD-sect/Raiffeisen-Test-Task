package ru.dmirtuk.raiffeisentesttask.services;

import ru.dmirtuk.raiffeisentesttask.enums.Type;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;
import ru.dmirtuk.raiffeisentesttask.models.User;

import java.util.List;

public interface StatisticsService {
    public Statistic addStatistics(User user, Result res,
                                   Move compMove, Move userMove, Type choosedType);
    public List<Statistic> getStatistics();
    public Statistic getLastStatistic();
    public List<Statistic> getStatisticByName(String name);

    public boolean isEmpty();
    public int countWin();
    public int countWinByName(String name);
    public int countLosses();
    public int countLossesByName(String name);

    public int countGames();
    public int countGamesByName(String name);

    public Move oftenUserMoveByName(String name);
    public Move oftenUserMove();

    public int countDrawsByName(String name);
    public int countDraws();



}

