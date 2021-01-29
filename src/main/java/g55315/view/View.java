package g55315.view;

import g55315.model.Board;
import g55315.model.Direction;
import g55315.model.Model;
import g55315.model.Position;
import java.util.Scanner;

/**
 * displays an instance of a game
 * @author oscar
 */
public class View implements InterfaceView{

    /**
     * displays the gameBoard of a certain instance of a game
     * @param game the game of which the gameBoard will be printed
     */
     @Override
     public void displayBoard(Model game) {
         if (game == null) {
             throw new IllegalArgumentException("argument was null");
         }
         Board board = game.getGameBoard();
        for (int row = 0; row < board.getWidth(); row++) {
            System.out.print("[");
            for (int col = 0; col < board.getHeight(); col++) {
                System.out.printf("%5d",
                        !board.isPosEmpty(new Position(row, col)) ? 
                                board.getValue(new Position(row, col))
                                : 0);
            }
            System.out.println("]");
        }
        System.out.println();
    }

     
     /**
      * asks in which direction you want the gameboard to be moved
      * @return the chosen direction
      */
     public Direction askDirection() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Please enter a direction: ");
        String dir = clavier.next().toUpperCase();
        Direction d;
        while (!(dir.equals("UP") || dir.equals("LEFT") 
                || dir.equals("RIGHT") || dir.equals("DOWN"))) {
            System.out.println("Wrong direction , please try again ");
            dir = clavier.next().toUpperCase();
        }
        switch (dir) {
            case "UP":
                d = Direction.UP;
                break;
            case "DOWN":
                d = Direction.DOWN;
                break;
            case "LEFT":
                d = Direction.LEFT;
                break;
            default:
                d = Direction.RIGHT;
                break;
        }
        return d;
    }
     
     /**
      * prints a message to congratulate the player that just won
      */
     public void printWinMessage() {
         System.out.println("Congrats, you've won!!!");
     }
     
     /**
      * prints a message for the loser
      */
    public void printLoserMessage() {
         System.out.println("You've lost...");
     }

     
}
