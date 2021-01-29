package g55315.model;

import g55315.model.Board;
import g55315.model.Direction;
import g55315.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Oscar Tison
 */
public class GameTest {

    @Test
    public void testIsPosEmptyExc2() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Game g = new Game();
                    g.move(null);
                });
    }


    @Test
    public void testMoveUpScoreMerge() {
        Game g = new Game();
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16,4}, {4, 4}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        g.move(Direction.UP);
        int result = g.getGameBoard().getBoardCopy()[0][1];
        int expResult = 8;
        assertEquals(expResult, result);
    }




    @Test
    public void testMoveRightScoreMerge() {
        Game g = new Game();
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 4}, {4, 4}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        g.move(Direction.RIGHT);
        int result = g.getGameBoard().getBoardCopy()[1][1];
        int expResult = 8;
        assertEquals(expResult, result);
    }



    @Test
    public void testMoveDownScoreMerge() {
        Game g = new Game();
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 4}, {4, 4}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        g.move(Direction.DOWN);
        int result = g.getGameBoard().getBoardCopy()[1][1];
        int expResult = 8;
        assertEquals(expResult, result);
    }



    @Test
    public void testMoveLeftScoreMerge() {
        Game g = new Game();
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 4}, {4, 4}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        g.move(Direction.LEFT);
        int result = g.getGameBoard().getBoardCopy()[1][0];
        int expResult = 8;
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMove() {
        Game g = new Game();
        boolean result = g.canMove();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveNOT() {
        Game g = new Game();
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 2}, {4, 8}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        boolean result = g.canMove();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void testIsWon() {
        Board b = new Board(2, 2);
        Game g = new Game();
        int[][] boardBoxes = {{16, 2048}, {4, 2}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        boolean result = g.isWon();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testIsWonNOT() {
        Board b = new Board(2, 2);
        Game g = new Game();
        int[][] boardBoxes = {{16, 2}, {4, 2}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        boolean result = g.isWon();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGameBoard() {
        Game g = new Game();
        Board b = new Board(2, 2);
        int[][] boardBoxes = {{16, 2}, {2048, 8}};
        b.setBoard(boardBoxes);
        g.setBoard(b);
        int result = g.getGameBoard().getBoardCopy()[0][0];
        int expResult = 16;
        assertEquals(expResult, result);
    }


}
