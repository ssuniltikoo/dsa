package dev.dp.machinecode.tictatoe.entity;

import dev.dp.machinecode.tictatoe.factories.BotPlayingStrategyFactory;
import dev.dp.machinecode.tictatoe.strategy.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficulityLevel botDifficultyLevel;

    public Bot(String name, char symbol, BotDifficulityLevel difficultyLevel) {
        super(name, symbol,PlayerType.BOT);
        this.botDifficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficulityLevel(difficultyLevel);
    }

    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this, board);
    }
}
