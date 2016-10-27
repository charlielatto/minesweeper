/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latto.minesweeper.board;

import com.latto.minesweeper.board.MineBoard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrls
 */
public class MineBoardTest {
    
    public MineBoardTest() {
    }


    /**
     * Test of generateBoard method, of class MineBoard.
     */
    @Test
    public void testAddMines() {
        int x = 10;
        int y = 10;
        int mines = 6;
        int count = 0;
        MineBoard instance = new MineBoard(x,y,mines);
        instance.addMines();
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if (instance.getBoardSquare(i, j).equals("*")){
                    count++;
                }
            }
        }
        assertEquals(count,mines);
        //instance.printBoard();
    }
    
    

    /**
     * Test of generateXY method, of class MineBoard.
     */
    @Test
    public void testGenerateXY() {
        int x = 10;
        int y = 10;
        MineBoard instance = new MineBoard(x,y,2);
        int[] result = instance.generateXY();
        //System.out.println(result[0] + " " + result[1]);
        assert(result.length == 2);
        assert(result[0] >= 0);
        assert(result[0] < x);
        assert(result[1] >= 0);
        assert(result[1] < y);
    }

    /**
     * Test of checkSquare method, of class MineBoard.
     */
    @Test
    public void testCheckSquareOccupied() {
        int x = 0;
        int y = 0;
        MineBoard instance = new MineBoard(5,5,2);
        instance.setBoardSquare("*", x, y);
        instance.setBoardSquare("0", x+1, y+1);
        assertEquals(true, instance.checkSquareOccupied(x, y));
        assertEquals(false, instance.checkSquareOccupied(x+1, y+1));
    }



    /**
     * Test of initaliseBoard method, of class MineBoard.
     */
    @Test
    public void testInitaliseBoard() {
        MineBoard instance = new MineBoard(5,5,2);
        instance.initaliseBoard();
        assertEquals("0",instance.getBoardSquare(0, 0));
        assertEquals("0",instance.getBoardSquare(4, 4));
        assertEquals("0",instance.getBoardSquare(2, 1));
    }

    /**
     * Test of fillOutArray method, of class MineBoard.
     */
    @Test
    public void testFillOutArray() {
        int x = 10;
        int y = 10;
        int mines = 5;
        int coord1 = 3;
        int coord2 = 4;
        MineBoard instance = new MineBoard(x,y,mines);
        instance.setBoardSquare("*", coord1, coord2);
        instance.fillOutArray();
        if(checkNeighboursEmpty(instance,coord1,coord2)){
            fail("Bomb neighbour empty");
        }
        System.out.println();
        instance.setBoardSquare("*", coord1+1, coord2+1);
        instance.fillOutArray();
        if(checkNeighboursEmpty(instance,coord1+1,coord2+1)){
            fail("Bomb neighbour empty");
        }
    }

    private boolean checkNeighboursEmpty(MineBoard instance, int coord1, int coord2) {
        String[][] board = instance.getBoard();
        /*instance.setBoardSquare("T", coord1+1, coord2);
        instance.setBoardSquare("T", coord1-1, coord2);
        instance.setBoardSquare("T", coord1, coord2+1);
        instance.setBoardSquare("T", coord1, coord2-1);
        instance.setBoardSquare("T", coord1+1, coord2+1);
        instance.setBoardSquare("T", coord1+1, coord2-1);
        instance.setBoardSquare("T", coord1-1, coord2+1);
        instance.setBoardSquare("T", coord1-1, coord2-1);*/
        instance.printBoard();
        
        if (instance.getBoardSquare(coord1+1, coord2).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1-1, coord2).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1, coord2+1).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1, coord2-1).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1+1, coord2+1).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1+1, coord2-1).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1-1, coord2+1).equals("0")){
            return true;
        } else if (instance.getBoardSquare(coord1-1, coord2-1).equals("0")){
            return true;
        } else {
            return false;
        }
    }
    
}
