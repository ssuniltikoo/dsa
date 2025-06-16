package dev.dp.machinecode.tictatoe.strategy.gamewinning;

import dev.dp.machinecode.tictatoe.entity.Board;
import dev.dp.machinecode.tictatoe.entity.Cell;
import dev.dp.machinecode.tictatoe.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowColDiaWinningStrategy implements GameWinningStrategy {

    // [{x -> 1, 0 -> 2}]

    private List<HashMap<Character,Integer>> rowSymbolCount = new ArrayList<>();
    private List<HashMap<Character,Integer>> columnSymbolCount = new ArrayList<>();

    private HashMap<Character,Integer> topLeftDiagonalSymbolCount = new HashMap<>();
    private HashMap<Character,Integer> topRightDiagonalSymbolCount = new HashMap<>();

    public RowColDiaWinningStrategy(int size) {
        for(int i = 0; i < size; i++) {
            rowSymbolCount.add(new HashMap<>());
            columnSymbolCount.add(new HashMap<>());

        }
    }

    private boolean isCellOnTopLeftDiagonal(int row, int col){
        return row==col;

    }

    private boolean isCellOnTopRightDiagonal(int row, int col, int size){
        return row+col == size -1;
    }


    @Override
    public boolean checkWinner(Board board, Cell playerMove, Player player) {

//        char symbol = playerMove.getPlayer().getSymbol();
//        int row = playerMove.getRow();
//        int col = playerMove.getCol();
//
//        int size = board.getSize();
//
//        if(!rowSymbolCount.get(row).containsKey(symbol)){
//            rowSymbolCount.get(row).put(symbol, 0);
//        }
//
//        rowSymbolCount.get(row).
//                put(symbol, rowSymbolCount.get(row).get(symbol) + 1
//        );
//
//        if(!columnSymbolCount.get(col).containsKey(symbol)){
//            columnSymbolCount.get(col).put(symbol, 0);
//        }
//
//        columnSymbolCount.get(col).
//                put(symbol, columnSymbolCount.get(col).get(symbol) + 1
//        );
//
//        if(isCellOnTopLeftDiagonal(row,col)){
//            if(!topLeftDiagonalSymbolCount.containsKey(symbol)){
//                topLeftDiagonalSymbolCount.put(symbol, 0);
//            }
//
//            topLeftDiagonalSymbolCount.put(
//                    symbol, topLeftDiagonalSymbolCount.get(symbol) + 1
//            );
//        }
//
//        if(isCellOnTopRightDiagonal(row,col,size)){
//            if(!topRightDiagonalSymbolCount.containsKey(symbol)){
//                topRightDiagonalSymbolCount.put(symbol, 0);
//            }
//            topRightDiagonalSymbolCount.put(
//                    symbol, topRightDiagonalSymbolCount.get(symbol) + 1
//            );
//        }
//
//
//        if(rowSymbolCount.get(row).get(symbol) == size || columnSymbolCount.get(col).get(symbol) == size){
//            return true;
//        }
//
//        if(isCellOnTopRightDiagonal(row,col,size) && topLeftDiagonalSymbolCount.get(symbol) == size){
//            return true;
//        }
//
//        if(isCellOnTopLeftDiagonal(row,col) && topRightDiagonalSymbolCount.get(symbol) == size){
//            return true;
//        }

        return false;


    }
}
