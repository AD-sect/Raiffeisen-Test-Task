package ru.dmirtuk.raiffeisentesttask.services;

import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;

public interface GameService {
    public Move getRandomMove();
    public Move getStrategyMove();
    public Result chooseWinner(Move move, Move compMove);



}
