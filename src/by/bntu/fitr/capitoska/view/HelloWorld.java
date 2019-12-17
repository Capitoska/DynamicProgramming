package by.bntu.fitr.capitoska.view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld extends Application {
    private GridPane infoGrid;
    private GridPane mainGrid;
    private StackPane root;
    private List<Node> nodes = new ArrayList<Node>();
    private Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    public void ShowComponent(){
        this.root = new StackPane();
        root.getChildren().addAll(nodes);
        this.stage.setScene(new Scene(this.root,1000,800));
        this.stage.show();

    }


    @Override
    public void start(Stage primaryStage) {
        this.root = new StackPane();
        this.infoGrid = setInfoGrid();
        this.infoGrid.setLayoutX(20);
        this.infoGrid.setLayoutY(20);
        nodes.add(infoGrid);
//        this.mainGrid = createDynamicGrid(4,5);
        root.getChildren().addAll(infoGrid);

        System.out.println(getNodeByRowColumnIndex(0, 0, infoGrid));

//        primaryStage.setScene(new Scene(this.root, 1000, 800));
//        primaryStage.show();
        this.stage = primaryStage;
        ShowComponent();

    }

    public GridPane createDynamicGrid(int columnAmount, int rowAmount) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(300, 100, 50, 50));
        gridPane.setVgap(40);
        gridPane.setHgap(40);
        for (int i = 0; i < columnAmount; i++) {
            for (int j = 0; j < rowAmount; j++) {
                UpgradeCircle upgradeCircle = new UpgradeCircle();
                GridPane.setConstraints(upgradeCircle.getStackPane(), i, j);
                gridPane.getChildren().add(upgradeCircle.getStackPane());
            }
        }
        return gridPane;
    }

    public GridPane setInfoGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
//Defining the Name text field
        final TextField rowAmount = new TextField();
        System.out.println(rowAmount);
        rowAmount.setPromptText("Введите количество строк");
        rowAmount.setPrefColumnCount(10);
        rowAmount.getText();
        GridPane.setConstraints(rowAmount, 0, 0);
        grid.getChildren().add(rowAmount);
//Defining the Last Name text field
        final TextField lastName = new TextField();
        lastName.setPromptText("Введите количество колонок");
        GridPane.setConstraints(lastName, 0, 1);
        grid.getChildren().add(lastName);
//Defining the Submit button
        Button submit = new Button("Построить график");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);
//Defining the Clear button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

//Adding a Label

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        //Setting an action for the Submit button
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (mainGrid != null){
                    nodes.remove(mainGrid);
                }
                int a = Integer.parseInt(((TextField) getNodeByRowColumnIndex(0, 0, infoGrid)).getText());
                int b = Integer.parseInt(((TextField) getNodeByRowColumnIndex(1, 0, infoGrid)).getText());
                System.out.println(((TextField) getNodeByRowColumnIndex(0, 0, infoGrid)).getText());
                System.out.println(((TextField) getNodeByRowColumnIndex(1, 0, infoGrid)).getText());
                mainGrid = createDynamicGrid(a, b);
//                root.getChildren().add(mainGrid);
                nodes.add(0,mainGrid);
                ShowComponent();
//                if ((comment.getText() != null && !comment.getText().isEmpty())) {
//                    label.setText(name.getText() + " " + lastName.getText() + ", "
//                            + "thank you for your comment!");
//                } else {
//                    label.setText("You have not left a comment.");
//                }
            }
        });

//Setting an action for the Clear button
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                rowAmount.clear();
                lastName.clear();
                label.setText(null);
            }
        });
        return grid;
    }

    public GridPane getInfoGrid() {
        return infoGrid;
    }

    public GridPane getMainGrid() {
        return mainGrid;
    }

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

}