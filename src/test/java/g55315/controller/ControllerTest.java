package g55315.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author Oscar Tison
 */
public class ControllerTest {

        @Test
    public void testNewBoardException() {
        System.out.println("Not right argument");
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Controller c = new Controller(null, null);
            }
        });
    }
}
