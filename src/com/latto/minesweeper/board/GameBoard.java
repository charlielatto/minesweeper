/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.board;

/**
 *
 * @author Charles Latto
 */
public class GameBoard {
    
    private String[][] board;
    
    public GameBoard(int x, int y){
        board = new String[y][x];
    }
    
    public String[][] getBoard() {
        return board;
    }
    
    public String getBoardSquare(int x, int y){
        return board[y][x];
    }
    
    public void setBoardSquare(String content, int x, int y){
        board[y][x] = content;
    }
    
    public void printBoard(){
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }
   
}
