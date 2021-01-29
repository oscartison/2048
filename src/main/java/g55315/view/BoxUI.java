package g55315.view;

import g55315.model.Model;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * represents 1 square in on the user interface
 */
public class BoxUI extends StackPane {
    private int row;
    private int col;
    private int value;
    private final Text text;
    private final Rectangle tile;
    private final Model game;

    /**
     * a constructor for the game
     * @param value the value of the square
     */
    public BoxUI(int value, int row, int col, Model game) {
        super();
    
        this.value = value;
        this.col = col;
        this.row = row;
        tile = new Rectangle(70,70);
        
        text = new Text();
        text.setText(String.valueOf(value));

        updateColor();

        this.getChildren().addAll(tile,text);
        this.game = game;

        addEventHandler0();
    }

    /**
     * changes the value of the square
     * @param value the new value
     */
    public void setValue(int value) {
        this.value = value;
        this.text.setText(String.valueOf(value));
        updateColor();
    }

    /**
     * updates the color of a square according to its color.
     */
    private void updateColor() {
        if(value == 0) {
            tile.setFill(Colors.getColorList()[0]);
        } else {
            int color_index = (int) (Math.log(value) / Math.log(2));
             tile.setFill(Colors.getColorList()[color_index]);
        }
    }

    private void addEventHandler0() {
        this.setOnMouseClicked((MouseEvent arg0) -> game.setToNull(row,col));
    }
}


