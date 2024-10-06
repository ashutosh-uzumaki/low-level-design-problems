package org.ashutosh.entities;

public class Board {
    int size;
    Symbol[][] board;

    public Board(int size){
        board = new Symbol[size][size];
    }

    public int getSize(){
        return board.length;
    }
    public void updateBoard(Symbol symbol, int x, int y){
        board[x][y] = symbol;
    }

    public boolean isAValidCell(int x, int y){
        if(board[x][y] != null){
            return false;
        }
        return true;
    }
    public Symbol getCellValue(int x, int y){
        return board[x][y];
    }
}
