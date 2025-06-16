package dev.dp.machinecode.tictatoe.entity;


import java.util.Scanner;

public class Player {

    private String name;
    private char symbol;

    private PlayerType playerType;

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }


    private Scanner scanner;
    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        scanner = new Scanner(System.in);
    }




    public Move markBoard(Board board) {
        //while(true) {
            System.out.println("which row you want to mark starting from 0 to " + (board.getSize() - 1));
            int row = scanner.nextInt();

            System.out.println("which column you want to mark starting from 0 to " + (board.getSize() - 1));
            int col = scanner.nextInt();

            Cell currentCell = board.getBoard().get(row).get(col);
            return new Move(this, currentCell);
        //}

    }

    public GameRules queryGameRules() {
        return null;
    }

}
