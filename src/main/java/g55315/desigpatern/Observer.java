package g55315.desigpatern;

/**
 *
 * @author aro
 */
public interface Observer {

    /**
     * updates the state of an observer
     * @param observable the observable that notified the observer
     * @param arg an argument
     */
    void update(Observable observable, Object arg);
}
