package g55315.model;

import g55315.desigpatern.Observer;
import java.util.ArrayList;

import java.util.List;

/**
 * the game that has a gameboard and a score
 *
 * @author Oscar Tison
 */
public class Game implements Model {

    private final List<Observer> observers;
    private Board gameBoard;
    private boolean won;
    private boolean canMove;
    private boolean wasMoved;
    private boolean newGame;
    private int moveLeft;
    private int moveRight;
    private int moveUp;
    private int moveDown;

    /**
     * a constructor for the game that creates a game with a new gameBoard where
     * 1 box is added and the score starts at 0
     */
    public Game() {
        observers = new ArrayList<>();
        reset();
    }

    /**
     * resets the state of the game
     */
    @Override
    public void reset() {
        newGame = true;
        gameBoard = new Board();
        this.canMove = true;
        this.won = false;
        this.wasMoved = true;
        this.moveRight = 0;
        this.moveLeft = 0;
        this.moveUp = 0;
        this.moveDown = 0;

        notifyObservers();
    }


    /**
     * sets the gameBoard to another board. (only used for testing)
     *
     * @param b the new board
     */
    void setBoard(Board b) {
        this.gameBoard = b;
    }

    @Override
    public boolean isNewGame() {
        return newGame;
    }

    public int getMoveLeft() {
        return moveLeft;
    }

    public int getMoveRight() {
        return moveRight;
    }

    public int getMoveUp() {
        return moveUp;
    }

    public int getMoveDown() {
        return moveDown;
    }

    /**
     * moves the boxes of the gameBoard in a certain direction
     *
     * @param direction the direction in which the move has to be made
     */
    @Override
    public void move(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("No direction was given");
        }
        newGame = false;
        int[][] old_board = gameBoard.getBoardCopy();
        gameBoard.move(direction);
        wasMoved = gameBoard.wasMoved(old_board);
        if(wasMoved) {
            switch (direction){
                case UP:
                    moveUp++;
                    break;
                case DOWN:
                    moveDown++;
                    break;
                case LEFT:
                    moveLeft++;
                    break;
                case RIGHT:
                    moveRight++;
            }
        }
        if (!gameBoard.isFull() && wasMoved) {
            gameBoard.addBox();
        }
        this.canMove = canMove();
        this.won = isWon();
        notifyObservers();
    }

    @Override
    public void setToNull(int row, int col) {
        gameBoard.setCaseNull(row, col);
        notifyObservers();
    }

    /**
     * checks if there is still a move possible in the gameBoard. This is
     * possible if the gameBoard is not full or if the gameBoard is full but
     * there are two boxes with the same value are next to each other
     *
     * @return true if a move is possible, false if not
     */
    @Override
    public boolean canMove() {
        if (!gameBoard.isFull()) {
            return true;
        }
            for (int row = 0; row < gameBoard.getHeight(); row++) {
                for (int col = 0; col < gameBoard.getWidth(); col++) {
                    int current_case = gameBoard.getBoard()[row][col];
                    if ((row < gameBoard.getHeight() - 1
                            && current_case == gameBoard.getBoard()[row + 1][col])
                            || ((col < gameBoard.getWidth() - 1)
                            && current_case == gameBoard.getBoard()[row][col + 1])) {
                        return true;
                    }
                }
            }
        return false;
    }

    /**
     * a getter for the gameboard
     *
     * @return the gameBoard
     */
    @Override
    public Board getGameBoard() {
        return gameBoard;
    }

    /**
     * checks if the game is won, this is the case if 1 of the boxes has the
     * value 2048
     *
     * @return true if the game is won, false if not
     */
    @Override
    public boolean isWon() {
        boolean isWon = false;
        for (int row = 0; !isWon && row < gameBoard.getHeight(); row++) {
            for (int col = 0; !isWon && col < gameBoard.getWidth(); col++) {
                isWon = gameBoard.getBoard()[row][col] != 0 && gameBoard.getBoard()[row][col] == 2048;
            }
        }
        return isWon;
    }

    /**
     * getter for if a move is still possible
     * @return true if you could move. false otherwise
     */
    @Override
    public boolean getCanMove() {
        return canMove;
    }

    /**
     * a getter for wasMoved
     * @return true if the board was moved, false otherwise
     */
    @Override
    public boolean getWasMoved() {
        return wasMoved;
    }

    /**
     * a getter for won
     * @return true if the game was won, false otherwise
     */
    @Override
    public boolean getWon() {return won;}

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer observer : observers) {
            observer.update(this, arg);
        }
    }


}
