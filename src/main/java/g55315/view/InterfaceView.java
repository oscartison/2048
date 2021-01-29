/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.view;

import g55315.model.Direction;
import g55315.model.Model;

/**
 *
 * @author oscartison
 */
public interface InterfaceView {
    
    /**
     * displays the gameBoard of a certain instance of a game
     * @param game the game of which the gameBoard will be printed
     */
    void displayBoard(Model game) ;
    

     /**
      * asks in which direction you want the gameboard to be moved
      * @return the chosen direction
      */
     Direction askDirection();
     
     /**
      * prints a message to congratulate the player that just won
      */
     void printWinMessage();
     
     /**
      * prints a message for the loser
      */
    void printLoserMessage();
    
}
