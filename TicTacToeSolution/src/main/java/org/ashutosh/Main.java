package org.ashutosh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        String result = game.startGame();
        System.out.println(result);
    }
}