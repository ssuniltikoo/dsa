package dev.dp.machinecode.tictatoe.client;


import dev.dp.machinecode.tictatoe.controller.GameController;
import dev.dp.machinecode.tictatoe.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInterface {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GameController gameController = new GameController();
        System.out.println("========================Welcome to Tic-Toe Game==================");
        System.out.println("What is the dimension of the game");
        int size = in.nextInt();

        System.out.println("Will there a bot in the game: y/n"  );

        String isBotString = in.next();

        List<Player> players = new ArrayList<Player>();

        int toIterate = size -1;

        if(isBotString.equals("y")) {
            toIterate -= 1;
        }

        for(int i=1;i <=toIterate;i++) {
            System.out.println("What is the name of the player ?" + i );
            String playerName = in.next();

            System.out.println("What is the symbol of the player ?" + i );
            char symbol = in.next().charAt(0);

            players.add(new Player(playerName,symbol, PlayerType.HUMAN));
        }

        if(isBotString.equals("y")) {
            System.out.println("What is the name of the bot? ");
            String botName = in.next();

            System.out.println("What is the symbol for this bot? ");
            char botSymbol = in.next().charAt(0);

            players.add(new Bot(botName,botSymbol, BotDifficulityLevel.EASY));

        }

        String winningStrategy = "onlywin";

        Game game  = gameController.createGame(size, players, winningStrategy);

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            System.out.println("This is your current board");
            gameController.displayBoard(game);
            gameController.playGame(game);
        }

        System.out.println("Game has ended. Result was:: ");

        if(!game.getGameState().equals(GameState.DRAW)){
            System.out.println("winner is "+ gameController.getWinner(game).getName());
            gameController.displayBoard(game);
        }

    }
}
