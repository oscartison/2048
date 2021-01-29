package g55315.view;

import g55315.desigpatern.Observable;
import g55315.desigpatern.Observer;
import g55315.model.Model;
import g55315.model.Position;
import javafx.scene.Node;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author oscar
 */
public class MyGridPane extends GridPane implements Observer {

    private final Model game;
    private final int size;

    /**
     * a constructor for the gridpane that represents the gameboard
     * @param game the game to represent
     */
    public MyGridPane(Model game) {
        super();
        if (game == null) {
            throw new IllegalArgumentException("the given game was null");
        }
        this.game = game;
        this.size = game.getGameBoard().getHeight();
        this.setPadding(new Insets(size));
        initialize();
    }

    /**
     * initializes the the view of the game. It will create a new box for every position in the game.
     */
    private void initialize() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                int value = game.getGameBoard().getValue(new Position(row, col));

                BoxUI box = new BoxUI(value, row, col, game);

                this.add(box, col, row);
            }
        }
    }


    /**
     * updates the state of the board.
     * @param observable the observable that notified the observer
     * @param arg an argument
     */
    @Override
    public void update(Observable observable, Object arg) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (Node node : this.getChildren()) {
                    BoxUI box = (BoxUI) node;
                    if (GridPane.getColumnIndex(box) == col && GridPane.getRowIndex(box) == row) {
                        box.setValue(game.getGameBoard().getValue(new Position(row,col)));
                    }
                }
            }
        }
    }

}
