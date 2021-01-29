package g55315.controller;

import g55315.model.Model;
import g55315.view.InterfaceView;

/**
 * The controller class takes the game and the view and controls the actions 
 * in the game that will be displayed by the view
 * @author Oscar Tison
 */
public class Controller {
    private final Model game;
    private final InterfaceView view;

    /**
     * the constructor of the class Controller
     * @param game the game 
     * @param view  the view that will display the game
     */
     public Controller(Model game, InterfaceView view) {
         if(game == null || view == null) {
             throw new IllegalArgumentException("One of the parameters were NULL");
         }
        this.game = game;
        this.view = view;
    }
     
     /**
      * the function that starts the gameLoop. 
      */
     public void startGame() {
         while(!game.isWon() && game.canMove()) {
             view.displayBoard(game);
             game.move(view.askDirection());
         }
         if (game.isWon()) {
             view.printWinMessage();
         } else {
             view.printLoserMessage();
         }
     }
}
