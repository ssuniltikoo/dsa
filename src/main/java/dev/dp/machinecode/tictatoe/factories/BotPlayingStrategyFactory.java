package dev.dp.machinecode.tictatoe.factories;

import dev.dp.machinecode.tictatoe.entity.BotDifficulityLevel;
import dev.dp.machinecode.tictatoe.strategy.botplayingstrategy.BotPlayingStrategy;
import dev.dp.machinecode.tictatoe.strategy.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyByDifficulityLevel(BotDifficulityLevel difficultyLevel) {
        if(difficultyLevel == BotDifficulityLevel.EASY) {
            return new RandomBotPlayingStrategy();
        }

        return null;
    }
}
