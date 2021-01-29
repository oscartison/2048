package g55315;

import g55315.controller.Controller;
import g55315.model.Game;
import g55315.view.View;

/**
 * the Main class contains the main function to start the game.
 * @author Oscar Tison
 */
public class Main {
    /**
     * a main function that creates a controller and starts the game from here
     * @param args the arguments given in the terminal (none are expected and none will be used here)
     */
    public static void main(String[] args) {
        Controller ctrl = new Controller(new Game(), new View());
        ctrl.startGame();
    }
}
