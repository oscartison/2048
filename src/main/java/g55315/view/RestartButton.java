package g55315.view;

import g55315.controller.ControllerUI;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RestartButton extends Button {
    private final ControllerUI ctrl;

    /**
     * creates a restart button
     * @param ctrl the controller that will be triggered by this button
     */
    public RestartButton(ControllerUI ctrl){
        super("RECOMMENCER");
        this.ctrl = ctrl;
        addEventHandlerRestart();
    }

    /**
     * adds an event on the button when it's clicked.
     */
    private void addEventHandlerRestart() {
        this.setOnMouseClicked((MouseEvent arg0) -> ctrl.restartGame());
    }

}
