package dev.dp.machinecode.tictatoe.entity;

public class Cell {
    private int row;
    private int col;
    private Player player;

    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public CellState getState() {
        return cellState;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
