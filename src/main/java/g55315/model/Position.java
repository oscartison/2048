package g55315.model;
import java.util.Objects;

/**
 * this makes a Position out of the row and column where you are situated
 *
 * @author Oscar Tison
 */
public class Position {

    final private int row;
    final private int column;

    /**
     * Constructor of Position.
     *
     * @param row the value of the row
     * @param column the value of the column
     */
    public Position(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("One of the arguments was negative");
        }
        this.row = row;
        this.column = column;
    }

    /**
     * constructor of position without parameters
     */
    public Position() {
        this.row = 0;
        this.column = 0;
    }

    /**
     * a simple getter for the column
     *
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * a simple getter for the row
     *
     * @return the value of row
     */
    public int getRow() {
        return row;
    }

}
