package com.craig.NPCControllers;

import com.craig.Coordinate;
import com.craig.GameBoard;

import java.util.ArrayList;
import java.util.Random;

public class EasyNPC {
    private GameBoard gameBoard;

    public EasyNPC(GameBoard gameboard) {
        this.gameBoard = gameboard;
    }

    public void makeMove() {
        System.out.println("Making move level \"easy\"");
        ArrayList<Coordinate> availableCells = gameBoard.getAvailableCells();
        Random random = new Random();
        gameBoard.populateGameBoard(availableCells.get(random.nextInt(availableCells.size())),'O');
        gameBoard.printGameBoard();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
}
