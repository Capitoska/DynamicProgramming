package by.bntu.fitr.capitoska.model;

public class Line extends Figure {
    public static final int STANDART_VALUE = 2;
    private int second_x;
    private int secont_y;

    public Line() {
        super.setValue(Line.STANDART_VALUE);
    }

    public Line(int value) {
        super.setValue(value);
    }
}
