package g55315.view;

import javafx.scene.paint.Color;

/**
 * a class with the different colors that a box can have.
 */
public class Colors {

    private static final Color[] colorList = {
            Color.rgb(204, 192, 179),
            Color.rgb(238, 228, 218),
            Color.rgb(237, 224, 200),
            Color.rgb(242, 177, 121),
            Color.rgb(245, 149, 99),
            Color.rgb(246, 124, 95),
            Color.rgb(246, 94, 59),
            Color.rgb(237, 207, 114),
            Color.rgb(237, 204, 97),
            Color.rgb(237, 200, 80),
            Color.rgb(237, 197, 63),
            Color.rgb(237, 194, 46)};


    /**
     * a getter for the list with colors
     * @return the list with colors
     */
    public static Color[] getColorList() {
        return colorList;
    }

}

