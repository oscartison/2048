package g55315.model;

import g55315.desigpatern.Observable;
import g55315.desigpatern.Observer;


/**
 * the interface contains all the methods from game that are 
 * accessible outside the model
 * @author oscar
 */
public interface Model extends Observable{

    /**
     * a getter for the gameboard
     *
     * @return the gameBoard
     */
    Board getGameBoard();


    /**
     * checks if there is still a move possible in the gameBoard. This is
     * possible if the gameBoard is not full or if the gameBoard is full but
     * there are two boxes with the same value are next to each other
     *
     * @return true if a move is possible, false if not
     */
    boolean canMove();

    /**
     * moves the boxes of the gameBoard in a certain direction
     *
     * @param direction the direction in which the move has to be made
     */
    void move(Direction direction);
    
            /**
     * checks if the game is won, this is the case if 1 of the boxes has the
     * value 2048
     *
     * @return true if the game is won, false if not
     */
    boolean isWon();

    /**
     * checks if it is a new game
     * @return true if it is a new game, otherwise false
     */
    boolean isNewGame();

    /**
     * resets the state of the game
     */
    void reset();

    void addObserver(Observer obs);

    void notifyObservers();

     void notifyObservers(Object arg);

    /**
     * getter for if a move is still possible
     * @return true if you could move. false otherwise
     */
    boolean getCanMove();

    /**
     * a getter for wasMoved
     * @return true if the board was moved, false otherwise
     */
    boolean getWasMoved() ;

    /**
     * a getter for won
     * @return true if the game was won, false otherwise
     */
    boolean getWon();

     int getMoveLeft() ;

     int getMoveRight() ;

     int getMoveUp() ;

     int getMoveDown() ;

     void setToNull(int row, int col);
}
