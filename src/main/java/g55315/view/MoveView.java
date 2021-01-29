package g55315.view;

import g55315.desigpatern.Observable;
import g55315.desigpatern.Observer;
import g55315.model.Model;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MoveView extends VBox implements Observer {

    private Text moveUp;
    private Text moveDown;
    private Text moveRight;
    private Text moveLeft;

    public MoveView() {
        this.moveLeft = new Text("0");
        this.moveRight = new Text("0");
        this.moveDown = new Text("0");
        this.moveUp = new Text("0");

        this.getChildren().addAll(moveDown,moveUp,moveLeft,moveRight);
    }

    @Override
    public void update(Observable observable, Object arg) {
        Model game = (Model) observable;
        this.moveLeft.setText(String.valueOf(game.getMoveLeft()));
        this.moveRight.setText(String.valueOf(game.getMoveRight()));
        this.moveUp.setText(String.valueOf(game.getMoveUp()));
        this.moveDown.setText(String.valueOf(game.getMoveDown()));
    }
}
