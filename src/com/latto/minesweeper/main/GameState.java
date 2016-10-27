/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.main;

import com.latto.minesweeper.board.RevealBoard;
import com.latto.minesweeper.board.MineBoard;

/**
 *
 * @author chrls
 */
public class GameState {
    
    private RevealBoard playerBoard;
    private MineBoard backgroundBoard;
    private int x;
    private int y;
    
    public GameState(int x, int y, int mines){
        this.x = x;
        this.y = y;
        playerBoard = new RevealBoard(x,y);
        backgroundBoard = new MineBoard(x,y,mines);
    }
    
    public void setUpGame(){
        playerBoard.populateBoard();
        backgroundBoard.addMines();
        backgroundBoard.fillOutArray();
    }
    
    public int gameOver(){
       if(playerWins()){
           return 1;
       } else if (playerLoses()) {
           return 2;
       } else {
           return 0;
       }
    }
    
    public boolean playerWins(){
        for(int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++){
                if (playerBoard.getBoardSquare(i, j).equals("H") && !backgroundBoard.getBoardSquare(i, j).equals("*")){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean playerLoses(){
        for(int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++){
                if (playerBoard.getBoardSquare(i, j).equals("*")){
                    return true;
                }
            }
        }
        return false;
    }
    
    public RevealBoard getPlayerBoard() {
        return playerBoard;
    }

    public MineBoard getBackgroundBoard() {
        return backgroundBoard;
    }
    
    public void takeTurn(int x, int y){
        playerBoard.revealSquare(x, y, backgroundBoard);
    }
    
}
