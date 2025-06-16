package dev.dp.machinecode.tictatoe.strategy.gamewinning;

import dev.dp.machinecode.tictatoe.entity.Board;
import dev.dp.machinecode.tictatoe.entity.Cell;
import dev.dp.machinecode.tictatoe.entity.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Cell cell, Player player);
}
