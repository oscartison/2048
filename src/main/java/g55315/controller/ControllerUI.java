package g55315.controller;

import g55315.model.Direction;
import g55315.model.Game;
import g55315.model.Model;

/**
 * The controller for the 2048 with javaFX
 * @author oscar
 */
public class ControllerUI {
    private final Model game;

    /**
     * a constructor for the controller
     */
    public ControllerUI() {
        this.game = new Game();
    }

    /**
     * moves the game in a direction
     * @param dir the direction in which the game will move
     */
    public void move(Direction dir) {
        game.move(dir);
    }

    /**
     * a getter for the game
     * @return the game
     */
    public Model getGame() {
        return game;
    }

    /**
     * restarts with a new game
     */
    public void restartGame() {
        this.game.reset();
    }
    
    
    
    
    
    
    
}
