package ru.dmirtuk.raiffeisentesttask.services;


import org.springframework.stereotype.Service;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;

import java.util.Random;

// TODO: 25.08.2022 реализовать вторую стратегию

@Service("gameServiceImpl")
public class GameServiceImpl implements GameService{

    @Override
    public Move getRandomMove(){
        Move[] moveArr = Move.values();
        Random random = new Random();
        int num = random.nextInt(Move.values().length);
        return moveArr[num];
    }

    @Override
    public Move getStrategyMove() {
        return  null;
    }

    @Override
    public Result chooseWinner(Move move, Move compMove) {
//        Move compMove = getRandomMove();
        if(compMove.equals(move))
            return Result.DRAW;
        switch(move){
            case PIPER:
                if(compMove.equals(Move.STONE)){
                    return Result.WIN;
                }else{
                    return Result.LOOSE;
                }
            case STONE:
                if(compMove.equals(Move.SCISSORS)){
                    return Result.WIN;
                }else{
                    return Result.LOOSE;
                }
            case SCISSORS:
                if(compMove.equals(Move.PIPER)){
                    return Result.WIN;
                }else{
                    return Result.LOOSE;
                }
        }
    return Result.DRAW;
    }


}
