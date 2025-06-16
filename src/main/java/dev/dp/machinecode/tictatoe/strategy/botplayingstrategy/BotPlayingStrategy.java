package dev.dp.machinecode.tictatoe.strategy.botplayingstrategy;

import dev.dp.machinecode.tictatoe.entity.Board;
import dev.dp.machinecode.tictatoe.entity.Move;
import dev.dp.machinecode.tictatoe.entity.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
