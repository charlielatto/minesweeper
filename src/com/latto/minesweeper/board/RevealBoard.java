/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.board;

/**
 *
 * @author chrls
 */
public class RevealBoard extends GameBoard {
    
    private final int x;
    private final int y;
    
    public RevealBoard(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        populateBoard();
    }
    
    public void populateBoard(){
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                super.setBoardSquare("H", i, j); 
            }
        }
    }
    
    public void revealSquare(int x, int y, GameBoard b){
        super.setBoardSquare(b.getBoardSquare(x, y), x, y);
    }
    
}
