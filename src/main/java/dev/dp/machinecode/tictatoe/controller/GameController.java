package dev.dp.machinecode.tictatoe.controller;

import dev.dp.machinecode.tictatoe.entity.Game;
import dev.dp.machinecode.tictatoe.entity.GameState;
import dev.dp.machinecode.tictatoe.entity.Player;
import dev.dp.machinecode.tictatoe.strategy.gamewinning.RowColDiaWinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int size, List<Player> players, String winningStrategy){

       return Game.getBuilder()
                .setPlayers(players)
                .setGameWinningStrategy(winningStrategy)
                .setSize(size)
                .build();
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void playGame(Game game){
        game.makeNextMove();
    }


    public Player getWinner(Game game){
        return game.identifyWinner();
    }

}
