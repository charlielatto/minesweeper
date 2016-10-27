/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.board;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author charles latto
 */
public class MineBoard extends GameBoard {

    private final int x;
    private final int y;
    private int mines;
    private final String MINE = "*";
    private final String NONE = "0";

    public MineBoard(int x, int y, int mines) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.mines = mines;
        initaliseBoard();
    }

    public void addMines() {
        for (int i = 0; i < mines; i++) {
            int[] coords = generateXY();
            if (!checkSquareOccupied(coords[0], coords[1])) {
                super.setBoardSquare(MINE, coords[0], coords[1]);
            } else {
                i--;
            }
        }
    }

    public void fillOutArray() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!super.getBoardSquare(i, j).equals(MINE)) {
                    int count = 0;
                    if ( i < x-1 && super.getBoardSquare(i + 1, j).equals(MINE) ) {
                        count++;
                    }
                    if ( i < x-1 && j < y-1 && super.getBoardSquare(i + 1, j + 1).equals(MINE)) {
                        count++;
                    }
                    if ( i < x-1 && j > 0 && super.getBoardSquare(i + 1, j - 1).equals(MINE)) {
                        count++;
                    }
                    
                    
                    if ( i > 0 && j < y-1 && super.getBoardSquare(i - 1, j + 1).equals(MINE)) {
                        count++;
                    }
                    if (i > 0 && j > 0 && super.getBoardSquare(i - 1, j - 1).equals(MINE)) {
                        count++;
                    }
                    if ( i > 0 && super.getBoardSquare(i - 1, j).equals(MINE)) {
                        count++;
                    }
                    
                    
                    if ( j < y-1 && super.getBoardSquare(i, j + 1).equals(MINE) ) {
                        count++;
                    }
                    if ( j > 0 && super.getBoardSquare(i, j - 1).equals(MINE)) {
                        count++;
                    }
                    
                    
                    super.setBoardSquare(""+count, i, j);
                }
            }
        }
    }

    public void initaliseBoard() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                super.setBoardSquare(NONE, i, j);
            }
        }
    }

    public int[] generateXY() {
        int[] coords = new int[2];
        coords[0] = ThreadLocalRandom.current().nextInt(0, x);
        coords[1] = ThreadLocalRandom.current().nextInt(0, y);
        return coords;
    }

    public boolean checkSquareOccupied(int x, int y) {
        String value = super.getBoardSquare(x, y);
        if (value.equals("*")) {
            return true;
        } else {
            return false;
        }
    }

}
