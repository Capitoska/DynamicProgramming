package by.bntu.fitr.capitoska.view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;


public class UpgradeCircle {
    private Circle circle;
    private Text text;
    private StackPane stackPane;
    private static final Color STANDART_FILL_COLOR = Color.WHITE;
    private static final Color TAGGED_FILL_COLOR = Color.RED;
    private static final int RADIUS = 20;


    public UpgradeCircle() {
        this.circle = createCircle();
        this.text = createText();
        this.stackPane = new StackPane();
        stackPane.getChildren().addAll(circle, text);
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    private Circle createCircle() {
        Circle circle = new Circle(RADIUS);
        circle.setStroke(Color.AQUA);
        circle.setStrokeWidth(1);
        circle.setFill(STANDART_FILL_COLOR);
        return circle;
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    private Text createText() {
        final Text text = new Text("3");

        text.setFont(new Font(30));
        text.setBoundsType(TextBoundsType.VISUAL);
//        centerText(text);
        return text;
    }
}
