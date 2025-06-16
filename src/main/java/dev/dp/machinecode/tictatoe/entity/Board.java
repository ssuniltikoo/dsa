package dev.dp.machinecode.tictatoe.entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(final int size) {
        this.size = size;
        this.board = new ArrayList<List<Cell>>();

        for(int i = 0; i < size; i++) {
            this.board.add(new ArrayList<>());
            for(int j = 0; j < size; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void display(){
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(this.board.get(i).get(j).getState().equals(CellState.EMPTY)){
                    System.out.print("| |");
                }else{
                    System.out.print("| "+board.get(i).get(j).getPlayer().getSymbol() + "|");
                }
            }
        }
    }
}
