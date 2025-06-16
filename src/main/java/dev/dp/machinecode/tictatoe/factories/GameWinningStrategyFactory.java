package dev.dp.machinecode.tictatoe.factories;

import dev.dp.machinecode.tictatoe.strategy.gamewinning.GameWinningStrategy;
import dev.dp.machinecode.tictatoe.strategy.gamewinning.RowColDiaWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(String winningStrategy, int size) {
        if(winningStrategy.equals("onlywin")){
            return new RowColDiaWinningStrategy(size);
        }
        return null;
    }
}
