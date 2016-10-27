/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.main;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrls
 */
public class GameStateTest {
    
    private int x = 10;
    private int y = 10;
    private int mines = 3;
    
    public GameStateTest() {
    }

    /**
     * Test of gameOver method, of class GameState.
     */
    @Test
    public void testGameOverWin() {
        GameState instance = new GameState(x,y,mines);
        instance.getPlayerBoard().populateBoard();
        instance.getBackgroundBoard().setBoardSquare("*", 0, 0);
        instance.getBackgroundBoard().fillOutArray();
        assertEquals(0, instance.gameOver());
        for(int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++){
                if(!(j == 0 && i == 0)) {
                    assertEquals(0, instance.gameOver());
                    instance.takeTurn(i, j);
                    
                }
            }
        }
        assertEquals(1, instance.gameOver());

    }
    
    /**
     * Test of gameOver method, of class GameState.
     */
    @Test
    public void testGameOverLose() {
        GameState instance = new GameState(x,y,mines);
        instance.getPlayerBoard().populateBoard();
        instance.getBackgroundBoard().setBoardSquare("*", 0, 0);
        instance.getBackgroundBoard().fillOutArray();
        assertEquals(0, instance.gameOver());
        instance.takeTurn(0, 0);
        assertEquals(2, instance.gameOver());
    }

    /**
     * Test of playerWins method, of class GameState.
     */
    @Test
    public void testPlayerWins() {
        GameState instance = new GameState(x,y,mines);
        instance.getPlayerBoard().populateBoard();
        instance.getBackgroundBoard().setBoardSquare("*", 0, 0);
        instance.getBackgroundBoard().fillOutArray();
        for(int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++){
                if(!(j == 0 && i == 0)) {
                    assertEquals(false, instance.playerWins());
                    instance.takeTurn(i, j);
                    
                    
                }
            }
        }
        instance.getPlayerBoard().printBoard();
        assertEquals(true, instance.playerWins());
        
    }

    /**
     * Test of playerLoses method, of class GameState.
     */
    @Test
    public void testPlayerLoses() {
        GameState instance = new GameState(x,y,mines);
        instance.getPlayerBoard().populateBoard();
        instance.getBackgroundBoard().setBoardSquare("*", 0, 0);
        instance.getBackgroundBoard().fillOutArray();
        instance.getPlayerBoard().revealSquare(0, 1, instance.getBackgroundBoard());
        assertEquals(false, instance.playerLoses());
        instance.getPlayerBoard().revealSquare(0, 0, instance.getBackgroundBoard());
        assertEquals(true, instance.playerLoses());

    }
    
}
