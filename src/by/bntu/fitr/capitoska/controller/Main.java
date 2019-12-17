package by.bntu.fitr.capitoska.controller;

import by.bntu.fitr.capitoska.model.Circle;
import by.bntu.fitr.capitoska.model.Line;
import by.bntu.fitr.capitoska.model.Table;

public class Main {
    public static void main(String[] args) {

        Line[][] HorizontalLines =
                {{new Line(3), new Line(2)}
                        , {new Line(1), new Line(4)}
                        , {new Line(2), new Line(6)}};

        Line[][] VerticalLines =
                {{new Line(3), new Line(2), new Line(1)}
                        , {new Line(1), new Line(4), new Line(2)}
                };

        int[][] horizontalValue = {{3, 2}, {1, 4}, {2, 6}};
        int[][] verticalValue = {{3, 2, 1}, {1, 4, 2}};
        Circle[][] circles = new Circle[3][3];
//
//        Table table = new Table(3, 3);
//        table.fillLinesObject(table.getHorizontalLines(), horizontalValue);
//        table.fillLinesObject(table.getVerticalLines(), verticalValue);

//        table.execute();

        Table table1 = new Table(3, 4);
        int[][] horizontalValue1 = {{5, 3, 2}, {3, 5, 6}, {2, 4, 1}};
        int[][] verticalValue1 = {{3, 1, 3, 1}, {3, 2, 2, 4}};

        table1.fillLinesObject(table1.getHorizontalLines(), horizontalValue1);
        table1.fillLinesObject(table1.getVerticalLines(), verticalValue1);
        table1.execute();
        for (Circle circle : table1.getOptimalWay()
        ) {
            System.out.println(circle.getValue() + " ");
        }
//        table.toStringTableValues();
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                circles[i][j] = new Circle();
//            }
//        }
//        System.out.println(circles.length);
//        circles[0][circles.length-1].setValue(0);
//        for (int i = 1; i < circles[0].length; i++) {
//            circles[0][circles.length-i-1].setValue(HorizontalLines[0][HorizontalLines.length-i-1].getValue() + circles[0][circles.length-i].getValue());
//            System.out.println(circles[0][circles.length-i-1].getValue());
//        }
//
//        for(int i = 1; i<circles[0].length)
//    }

    }
}
