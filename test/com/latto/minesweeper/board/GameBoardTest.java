/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.board;

import com.latto.minesweeper.board.GameBoard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrls
 */
public class GameBoardTest {
    
    public GameBoardTest() {
    }

    @Test
    public void testBoardGetter() {
        GameBoard test = new GameBoard(5,5);
        assertArrayEquals(new String[5][5],test.getBoard());
    }
    
    @Test
    public void testSetGetBoardSquare(){
        GameBoard test = new GameBoard(5,5);
        String content = "Test";
        int x = 3;
        int y = 2;
        test.setBoardSquare(content,x,y);
        assertEquals(content,test.getBoardSquare(x, y));
    }
    
    
    @Test
    public void testBoardPrinter() {
        GameBoard test = new GameBoard(3,5);
        test.printBoard();
    }
}
