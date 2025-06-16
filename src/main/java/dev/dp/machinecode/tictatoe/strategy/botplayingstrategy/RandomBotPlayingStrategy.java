package dev.dp.machinecode.tictatoe.strategy.botplayingstrategy;

import dev.dp.machinecode.tictatoe.entity.Board;
import dev.dp.machinecode.tictatoe.entity.CellState;
import dev.dp.machinecode.tictatoe.entity.Move;
import dev.dp.machinecode.tictatoe.entity.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move decideMove(Player player, Board board) {
        for(int i=0; i <board.getSize(); i++) {
            for(int j=0; j <board.getSize(); j++) {
                if(board.getBoard().get(i).get(j).getState().equals(CellState.EMPTY)){
                    return new Move(player, board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
