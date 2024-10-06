package org.ashutosh;
import org.ashutosh.entities.*;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;

    void initializeGame(){
        players = new ArrayDeque<>();
        Player playerOne = new Player("Ashutosh", Symbol.X);
        Player playerTwo = new Player("Pandey", Symbol.O);
        players.add(playerOne);
        players.add(playerTwo);
        board = new Board(3);
    }

    String startGame(){
        boolean winner = false;
        while(!winner){
            Player currPlayer = players.removeFirst();
            Scanner scn = new Scanner(System.in);

            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++){
                    String cellValue = (board.getCellValue(i, j) == null) ? " " : board.getCellValue(i, j).toString();
                    System.out.print(cellValue);
                    if (j < board.getSize() - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println(); // Move to a new line after each row
            }

            System.out.println("Current Player turn: "+currPlayer.getName()+" and your symbol  is: "+ currPlayer.getSymbol());
            System.out.print("Please enter the row and col you want to fill: ");
            int row = scn.nextInt();
            int col = scn.nextInt();
            System.out.println((board.isAValidCell(row, col)));
            if(!board.isAValidCell(row, col)){
                System.out.println("Incorrect position chosen");
                players.addFirst(currPlayer);
                continue;
            }
            board.updateBoard(currPlayer.getSymbol(), row, col);
            players.addLast(currPlayer);

            winner = isThereAWinner(row, col, currPlayer.getSymbol());
            System.out.println(winner);
            if(winner){
                return "Player: "+currPlayer.getName()+" has won the game";
            }
        }
        return "No one has won the game. It is a draw";
    }

    boolean isThereAWinner(int row, int col, Symbol symbol){
        boolean rowCheck = true;
        boolean colCheck = true;
        boolean diagonalCheck = true;
        boolean antidiagonalCheck = true;

        for(int i=0; i<board.getSize(); i++){
            if(board.getCellValue(row, i) == null || board.getCellValue(row, i) != symbol){
                rowCheck = false;
                break;
            }
        }

        for(int i=0; i< board.getSize(); i++){
            if(board.getCellValue(i, col) == null || board.getCellValue(i, row) != symbol){
                colCheck = false;
                break;
            }
        }

        for(int i=0; i< board.getSize(); i++){
            if(board.getCellValue(i, i) == null || board.getCellValue(i, i) != symbol){
                diagonalCheck = false;
                break;
            }
        }

        for(int i=0; i< board.getSize(); i++){
            if((board.getCellValue(i, board.getSize()-i-1) == null || board.getCellValue(i, board.getSize() - i - 1) != symbol)){
                antidiagonalCheck = false;
                break;
            }
        }

        return rowCheck || colCheck || diagonalCheck || antidiagonalCheck;
    }
}
