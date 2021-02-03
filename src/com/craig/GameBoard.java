package com.craig;

public class GameBoard {
    private char[][] grid;
    private final int gridSize = 3;
    public GameBoard() {
        this.grid = new char[gridSize][gridSize];
    }

    public void printGameBoard() {
        System.out.println("---------");
        for (int i = 0; i < gridSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public void populateGameBoard(Coordinate coordinate, char symbol) {
        this.grid[coordinate.getX()][coordinate.getY()] = symbol;
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
