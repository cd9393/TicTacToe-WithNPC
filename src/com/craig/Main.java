package com.craig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        GameBoard gameBoard = new GameBoard();
        System.out.println("Enter the cells for the state of the game:");

        try(Scanner scanner = new Scanner(System.in)) {
            boolean isInitialStateOkay = false;
            String initialState = null;

            while(!isInitialStateOkay) {
                initialState = scanner.nextLine();
                isInitialStateOkay = checkInitialInput(initialState);
            }
            populateInitialState(gameBoard, initialState);
            gameBoard.printGameBoard();

        } catch(Exception exception) {

        }
    }

    public static void populateInitialState(GameBoard grid, String initialState) {
            for( int i = 0; i < initialState.length(); i++) {
                char symbol = initialState.charAt(i);
                if (i < 3) {
                    Coordinate coordinate = new Coordinate(0, i);
                    grid.populateGameBoard(coordinate,symbol);
                }
                else if (i >= 3 & i < 6) {
                    Coordinate coordinate = new Coordinate(1, i - 3 );
                    grid.populateGameBoard(coordinate,symbol);
                }
                else {
                    Coordinate coordinate = new Coordinate(2, i - 6);
                    grid.populateGameBoard(coordinate, symbol);
                }
            }
    }

    public static boolean checkInitialInput(String initialState) {
        if (initialState.length() != 9) {
            System.out.println("Error! initial state should contain state for all 9 cells!");
            return false;
        }
        if (!initialState.matches("^[XO_]+$")) {
            System.out.println("Error! Game only uses the following characters for state - X, O, _");
            return false;
        }
        return true;
    }
}
