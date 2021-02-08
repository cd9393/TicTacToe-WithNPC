package com.craig;

import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard {
    private char[][] grid;
    private final int gridSize = 3;
    public GameBoard() {
        this.grid = new char[gridSize][gridSize];
        for (char[] chars : this.grid) {
            Arrays.fill(chars, '_');
        }
    }

    public void printGameBoard() {
        System.out.println("---------");
        for (int i = 0; i < gridSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == '_') {
                    System.out.print("  ");
                }else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public void populateGameBoard(Coordinate coordinate, char symbol) {
        this.grid[coordinate.getX()][coordinate.getY()] = symbol;
    }

    public ArrayList<Coordinate> getAvailableCells() {
        ArrayList<Coordinate> availableCells = new ArrayList<Coordinate>();
        for (int i =0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == '_') {
                    Coordinate coordinate = new Coordinate(i,j);
                    availableCells.add(coordinate);
                }
            }
        }
        return availableCells;
    }

    public boolean isGameOver() {
        if (!hasWin('X') && !hasWin('O') && hasSpaceFree()) {
            return false;
        } else {
            return true;
        }
    }

    public void gameStatus() {
        if (!hasWin('X') && !hasWin('O') && hasSpaceFree()) {
            System.out.println("Game not finished!");
        }

        if (!hasWin('X') && !hasWin('O') && !hasSpaceFree()) {
            System.out.println("Draw!");
        }

        if (hasWin('X') && !hasWin('O')) {
            System.out.println("X wins");
        }

        if (hasWin('O') && !hasWin('X')) {
            System.out.println("O wins");
        }

    }

    public boolean hasSpaceFree() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == '_') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWin(char player) {
        boolean hasWon = false;
        int winValue = 0;
        if (player == 'X') {
            winValue = 264;
        } else {
            winValue = 237;
        }
        if (hasRowWin(winValue) || hasColumnWin(winValue) || hasDiagonalWin(winValue)) {
            return true;
        }
        return false;
    }

    public boolean hasRowWin(int winValue) {
        int sum = 0;
        for (int i = 0; i < gridSize; i++) {
            sum = grid[i][0] + grid[i][1] + grid[i][2];
            if (sum == winValue) {
                return true;
            }
        }
        return false;
    }

    public boolean hasColumnWin(int winValue) {
        int sum = 0;
        for (int i = 0; i < gridSize; i++) {
            sum = grid[0][i] + grid[1][i] + grid[2][i];
            if (sum == winValue) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDiagonalWin(int winValue) {
        if (grid[0][0] + grid[1][1] + grid[2][2] == winValue) {
            return true;
        }
        if (grid[0][2] + grid[1][1] + grid[2][0] == winValue) {
            return true;
        }
        return false;
    }

    public boolean isCellTaken(Coordinate coordinate) {
        if (grid[coordinate.getX()][coordinate.getY()] == 'X' || grid[coordinate.getX()][coordinate.getY()] == 'O') {
            return true;
        }
        return false;
    }

    public char whichTurn() {
        int x = 0;
        int o = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 'X') {
                    x++;
                } else if (grid[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (x > o) {
            return 'O';
        } else {
            return 'X';
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
}
