package g55315;

import g55315.controller.ControllerUI;
import g55315.view.UI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author oscartison
 */
public class App extends Application {

    /**
     * launches the application
     * @param args the arguments given in the terminal (none are expected and none will be used here)
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {

        ControllerUI ctrl = new ControllerUI();
        UI view = new UI(ctrl);
        ctrl.getGame().addObserver(view.getBoard());
        ctrl.getGame().addObserver(view.getEventText());
        ctrl.getGame().addObserver(view.getMoves());
        Scene scene = new Scene(view);
        scene.getStylesheets().add("css/2048.css");
        scene.setOnKeyReleased(view);
        primaryStage.setTitle("HE2B ESI - 2048");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
}
