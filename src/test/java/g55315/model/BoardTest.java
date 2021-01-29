package g55315.model;

import g55315.model.Board;
import g55315.model.Direction;
import g55315.model.Position;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Oscar Tison
 */
public class BoardTest {


    @Test
    public void testNewBoardException() {
        System.out.println("Not right argument");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board b = new Board(-1, -1);
                });
    }

    @Test
    public void testAddBox() {
        Board b = new Board( 2, 2);
        int[][] boardBoxes = {{4, 2}, {8, 0}};
        b.setBoard(boardBoxes);
        b.addBox();
        boolean expResult = b.isFull();
        assertEquals(expResult, true);

    }
    
    @Test
    public void testIsPosEmpty() {
        Board b = new Board(4, 4);
        int[][] boardBoxes = {{0, 0}, {2, 0}};
        b.setBoard(boardBoxes);
        boolean result = b.isPosEmpty(new Position(0, 0));
        assertEquals(true, result);
    }

    @Test
    public void testIsPosEmptyNOT() {
        Board b = new Board(4, 4);
        int[][] boardBoxes = {{0, 0}, {2, 0}};
        b.setBoard(boardBoxes);
        boolean result = b.isPosEmpty(new Position(1, 0));
        assertEquals(false, result);
    }

    @Test
    public void testIsPosEmptyExc() {
        System.out.println("Not right argument");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board b = new Board(4, 4);
                    int[][] boardBoxes = {{0, 0}, {2, 0}};
                    b.setBoard(boardBoxes);
                    b.isPosEmpty(new Position(7, 0));
                });
    }

    @Test
    public void testIsPosEmptyExc2() {
        System.out.println("Not right argument");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board b = new Board(4, 4);
                    int[][] boardBoxes = {{0, 0}, {2, 0}};
                    b.setBoard(boardBoxes);
                    b.isPosEmpty(null);
                });
    }

    @Test
    public void testGetHeight() {
        Board b = new Board(4, 4);
        int result = b.getHeight();
        int expResult = 4;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWidth() {
        Board b = new Board(4, 4);
        int result = b.getWidth();
        int expResult = 4;
        assertEquals(expResult, result);
    }

    @Test
    public void testReverse() {
        Board b = new Board(4, 4);
        int[][] boardBoxes = {{0, 8}, {2, 0}};
        b.setBoard(boardBoxes);
        b.reverse();
       int result = b.getBoardCopy()[1][1];
        int expResult = 8;
        assertEquals(expResult, result);  
    }

    @Test
    public void testMoveDOWN() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{2, 8}, {0, 0}};
        b.setBoard(boardBoxes);
        b.move(Direction.DOWN);
        int result = b.getBoardCopy()[1][1];
        int expResult = 8;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveDOWNMerge() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{2, 8}, {0,8}};
        b.setBoard(boardBoxes);
        b.move(Direction.DOWN);
        int result = b.getBoardCopy()[1][1];
        int expResult = 16;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveRight() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{2, 0}, {0, 0}};
        b.setBoard(boardBoxes);
        b.move(Direction.RIGHT);
        int result = b.getBoardCopy()[0][1];
        int expResult = 2;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveRIGHTMerge() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{2, 2}, {0, 8}};
        b.setBoard(boardBoxes);
        b.move(Direction.RIGHT);
        int result = b.getBoardCopy()[0][1];
        int expResult = 4;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveLEFT() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{0, 16}, {0, 0}};
        b.setBoard(boardBoxes);
        b.move(Direction.LEFT);
        int result = b.getBoardCopy()[0][0];
        int expResult = 16;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveLEFTMerge() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 16}, {0, 8}};
        b.setBoard(boardBoxes);
        b.move(Direction.LEFT);
        int result = b.getBoardCopy()[0][0];
        int expResult = 32;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveUP() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{0, 16}, {16, 0}};
        b.setBoard(boardBoxes);
        b.move(Direction.UP);
        int result = b.getBoardCopy()[0][0];
        int expResult = 16;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveUPMerge() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 16}, {16, 8}};
        b.setBoard(boardBoxes);
        b.move(Direction.UP);
        int result = b.getBoardCopy()[0][0];
        int expResult = 32;
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFull() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 16}, {16, 8}};
        b.setBoard(boardBoxes);
        boolean result = b.isFull();
        assertEquals(true, result);
    }

    @Test
    public void testIsFullNOT() {
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 0}, {16, 8}};
        b.setBoard(boardBoxes);
        boolean result = b.isFull();
        assertEquals(false, result);
    }

}
