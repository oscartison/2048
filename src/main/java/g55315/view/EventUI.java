/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.view;

import g55315.desigpatern.Observable;
import g55315.desigpatern.Observer;
import java.text.SimpleDateFormat;
import java.util.Date;

import g55315.model.Model;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

/**
 * this class will represent a list with all the events of the game.
 * @author oscar
 */
public class EventUI extends ListView<Text> implements Observer {

    /**
     * a constructor for EventUI
     */
    public EventUI() {
        super();
        this.setFocusTraversable(false);
        addData("Bienvenue au 2048");
    }

    /**
     * updates the list, adds the event to the list
     * @param observable the observable that notified the observer
     * @param arg an argument
     */
    @Override
    public void update(Observable observable, Object arg) {
        Model game = (Model) observable;
        if(game.isNewGame()) {
            addData("nouveau jeu est cree");
        }
        if(!game.getWasMoved()){
            addData("mouvement impossible");
        }
        if (!game.getCanMove()) {
            addData("vous avez perdu");
        }
        if(game.getWon()) {
            addData("vous avez gagne");
        }

    }

    /**
     * adds a string to ListView with the current time
     * @param s the string to add in the list.
     */
    public void addData(String s) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Text text = new Text(formatter.format(date) + " - " + s);
        this.getItems().add(text);
    }
}
