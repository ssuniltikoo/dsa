package dev.dp.machinecode.tictatoe.entity;



import dev.dp.machinecode.tictatoe.factories.GameWinningStrategyFactory;
import dev.dp.machinecode.tictatoe.strategy.gamewinning.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game  {

    public void makeNextMove(){
        Player toMovePlayer = players.get(currentPlayerIndex);
        System.out.println("It is " + toMovePlayer.getName() + "'s turn");

        Move move = toMovePlayer.markBoard(board);

        boolean isValidMove= ValidateMove(move);

        int row  = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Move happened at" + row + "," + col);

        board.getBoard().get(row).get(col).setCellState(CellState.MARKED);

        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        moves.add(move);

        if(this.gameWinningStrategy.checkWinner(board,move.getCell(),toMovePlayer)){
            gameState = GameState.ENDED;
            winner = toMovePlayer;
        }

        currentPlayerIndex+=1;
        currentPlayerIndex %=players.size();

    }




    private List<Player> players;

    private Board board;

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    private int currentPlayerIndex;

    private Player winner;

    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    private Rule gamesRules;

    private List<Move> moves;

    private GameWinningStrategy gameWinningStrategy;

    private Game(){}


    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void displayBoard() {
         this.board.display();
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setGamesRules(Rule gamesRules) {
        this.gamesRules = gamesRules;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Board resetGame() {
       List<List<Cell>> cells = board.getBoard();
       cells.forEach(List::clear);
        return board;
    }


    public Player identifyWinner() {
       // return gameWinningStrategy.checkWinner(this.board,players.get(currentPlayerIndex));
        return this.winner;
    }


    public boolean ValidateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        return row >= 0 && row < board.getSize() &&
                col >= 0 && col < board.getSize() &&
                move.getCell().getState().equals(CellState.EMPTY);
    }





    public Player announceWinner() {
        return winner;
    }

    public Rule getGamesRules() {
        return gamesRules;
    }

     public static class Builder{
        private int size;
        private List<Player> players;

        private GameWinningStrategy gameWinningStrategy;

        public Builder setSize(int size){
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setGameWinningStrategy(String winningStrategy){
            this.gameWinningStrategy = GameWinningStrategyFactory.getGameWinningStrategy(winningStrategy,size);
            return this;
        }

        public void validate() {
            if(this.size < 3){
                throw new IllegalArgumentException("size must be at least 3");
            }
        }


        public Game build(){

            validate();

            Game game = new Game();
            game.setPlayers(players);
            game.setBoard(new Board(size));
            game.setGameState(GameState.IN_PROGRESS);
            game.setGameWinningStrategy(this.gameWinningStrategy);
            game.setCurrentPlayerIndex(0);
            game.setMoves(new ArrayList<>());
            return game;
        }

    }

}
