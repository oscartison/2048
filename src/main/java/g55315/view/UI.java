/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.view;

import g55315.controller.ControllerUI;
import g55315.model.Direction;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author oscar
 */
public class UI extends VBox implements EventHandler<Event> {

    private final MyGridPane board;
    private final EventUI eventText;
    private final RestartButton button;
    private final ControllerUI ctrl;
    private final MoveView moves;

    public MoveView getMoves() {
        return moves;
    }

    /**
     * the constructor for the user interface.
     * @param ctrl the controller that will be triggered by this UI.
     */
    public UI(ControllerUI ctrl) {
        super();
        
        HBox hbox = new HBox();
        hbox.getStyleClass().add("box");
        
        this.eventText = new EventUI();
        this.ctrl = ctrl;
        this.board = new MyGridPane(ctrl.getGame());
        this.button = new RestartButton(ctrl);
        this.moves = new MoveView();
        button.getStyleClass().add("button");
        
        hbox.getChildren().addAll(board,eventText,moves);
        
        this.getChildren().addAll(hbox, button);
    }

    /**
     * a simple getter for the EventList
     * @return the EventUI
     */
    public EventUI getEventText() {
        return eventText;
    }

    /**
     * a getter for the gridpane where the board is displayed.
     * @return the gridpane with the board
     */
    public MyGridPane getBoard() {
        return board;
    }

    /**
     * a event handler that will handle different keystrokes.
     * @param event the event on the keyboard.
     */
    @Override
    public void handle(Event event) {
        if (event instanceof KeyEvent) {
            KeyEvent e = (KeyEvent) event;
            switch (e.getCode()) {
                case DOWN:
                    ctrl.move(Direction.DOWN);
                    break;
                case UP:
                    ctrl.move(Direction.UP);
                    break;
                case RIGHT:
                    ctrl.move(Direction.RIGHT);
                    break;
                case LEFT:
                    ctrl.move(Direction.LEFT);
                    break;
            }
        }
    }
}

