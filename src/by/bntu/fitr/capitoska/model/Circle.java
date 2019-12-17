package by.bntu.fitr.capitoska.model;

public class Circle extends Figure {
    private Circle prevCircle;

    public Circle() {
        this.setValue(-2);
        prevCircle = null;
    }

    public Circle getPrevCircle() {
        return prevCircle;
    }

    public void setPrevCircle(Circle prevCircle) {
        this.prevCircle = prevCircle;
    }
}
