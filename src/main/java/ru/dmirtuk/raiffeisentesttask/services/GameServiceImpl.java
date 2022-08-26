package ru.dmirtuk.raiffeisentesttask.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;


import java.util.Arrays;
import java.util.Random;

// TODO: 25.08.2022 реализовать вторую стратегию

@Service("gameServiceImpl")
public class GameServiceImpl implements GameService{



    StatisticsService statisticsService;

    @Autowired
    public GameServiceImpl( StatisticsService statisticsService){
        this.statisticsService = statisticsService;
    }

    @Override
    public Move getRandomMove(){
        Move[] moveArr = Move.values();
        Random random = new Random();
        int num = random.nextInt(Move.values().length);
        return moveArr[num];
    }

    @Override
    public Move getStrategyMove() {
        if(statisticsService.exists()){
            Statistic stat = statisticsService.getLastStatistic();
            Move userMove = stat.getUserMove();
            Move compMove = stat.getCompMove();
            Result result = stat.getRes();

            if(result.equals(Result.LOOSE)){
                return userMove;
            }else if(result.equals(Result.WIN)){
                Move[] moveArr = Move.values();
                return Arrays.stream(moveArr)
                        .filter(m -> !(m.equals(userMove)))
                        .filter(m -> !(m.equals(compMove)))
                        .findFirst().get();
            }else{
                return getRandomMove();
            }
        }else{
            return getRandomMove();
        }
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
