package g55315.Model;

import g55315.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Oscar Tison
 */
public class PositionTest {
    
    @Test
    public void testNewPositionException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Position pos = new Position(-2,0);
                });
    }

    @Test
    public void testGetColumn() {
        Position pos = new Position(8,0);
        int result = pos.getColumn();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRow() {
                Position pos = new Position(8,0);
        int result = pos.getRow();
        int expResult = 8;
        assertEquals(expResult, result);
    }

    
}
