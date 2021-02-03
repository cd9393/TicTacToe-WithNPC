package com.craig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        GameBoard gameBoard = new GameBoard();
        System.out.println("Enter the cells for the state of the game:");

        try(Scanner scanner = new Scanner(System.in)) {
            initializeGame(scanner,gameBoard);
            char playersTurn = gameBoard.whichTurn();
            takeTurn(scanner,playersTurn,gameBoard);

        } catch(Exception exception) {

        }
    }

    public static void takeTurn(Scanner scanner, char symbol, GameBoard gameBoard) {
        boolean isCoordinateOkay = false;
        String coordinate = null;

        while (!isCoordinateOkay) {
            coordinate = scanner.nextLine();
            isCoordinateOkay = checkCoordinate(coordinate);
        }
        gameBoard.populateGameBoard(createCoordinate(coordinate),symbol);
        gameBoard.printGameBoard();
    }

    public static Coordinate createCoordinate(String coordinate) {
        String[] coordinates = coordinate.split(" ");
        Coordinate position = new Coordinate(Integer.parseInt(coordinates[0]) - 1, Integer.parseInt(coordinates[1]) - 1);
        return position;
    }

    public static boolean checkCoordinate(String coordinate) {
        String[] coordinates = coordinate.split(" ");

        if (coordinates.length > 2 || coordinates.length < 0) {
            System.out.println("Error! you should only enter 2 coordinates");
            return false;
        }

        if (!coordinates[0].matches("^[1-3]+$") || !coordinates[1].matches("^[1-3]+$")) {
            System.out.println("Error! Coordinates can only be numbers between 1 and 3");
            return false;
        }

        if (Integer.parseInt(coordinates[0]) > 3 || Integer.parseInt(coordinates[0]) < 1 || Integer.parseInt(coordinates[1]) > 3 || Integer.parseInt(coordinates[1]) < 1) {
            System.out.println("Error! Coordinates X and Y must be between 1 and 3");
            return false;
        }

        return true;
    }

    public static void initializeGame(Scanner scanner, GameBoard gameBoard) {
        boolean isInitialStateOkay = false;
        String initialState = null;

        while(!isInitialStateOkay) {
            initialState = scanner.nextLine();
            isInitialStateOkay = checkInitialInput(initialState);
        }
        populateInitialState(gameBoard, initialState);
        gameBoard.printGameBoard();
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
