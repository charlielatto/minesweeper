/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.board;

import com.latto.minesweeper.board.RevealBoard;
import com.latto.minesweeper.board.MineBoard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charles latto
 */
public class RevealBoardTest {
    
    public RevealBoardTest() {
    }

    /**
     * Test of populateBoard method, of class RevealBoard.
     */
    @Test
    public void testPopulateBoard() {
        RevealBoard instance = new RevealBoard(5,5);
        assertEquals("H",instance.getBoardSquare(0, 0));
        assertEquals("H",instance.getBoardSquare(3, 2));
        assertEquals("H",instance.getBoardSquare(1, 4));

    }

    /**
     * Test of revealSquare method, of class RevealBoard.
     */
    @Test
    public void testRevealSquare() {
        int x = 4;
        int y = 3;
        RevealBoard instance = new RevealBoard(5,5);
        MineBoard mineboard = new MineBoard(5,5,3);
        mineboard.addMines();
        mineboard.fillOutArray();
        instance.printBoard();
        instance.revealSquare(x, y,mineboard);
        System.out.println();
        instance.printBoard();
        assertEquals(mineboard.getBoardSquare(x, y),instance.getBoardSquare(x, y));
        assertEquals("H", instance.getBoardSquare(x-1,y-1));
    }
    
}
