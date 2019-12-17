package by.bntu.fitr.capitoska.model;


import java.util.ArrayList;
import java.util.List;

public class Table implements Executer {
    private int rowAmount;
    private int columnAmount;
    private Line[][] horizontalLines;
    private Line[][] verticalLines;
    private Circle[][] circles;
    private List<Circle> optimalWay;


    public Table(int rowAmount, int columnAmount) {
        this.rowAmount = rowAmount;
        this.columnAmount = columnAmount;
        circles = new Circle[rowAmount][columnAmount];
        createCirclesObject();
        horizontalLines = new Line[rowAmount][columnAmount - 1];
        createLinesObject(horizontalLines);
        verticalLines = new Line[rowAmount - 1][columnAmount];
        createLinesObject(verticalLines);
    }

    private void createCirclesObject() {
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                circles[i][j] = new Circle();
            }
        }
    }

    private void createLinesObject(Line[][] lines) {
        int columnAmount = lines[0].length;
        int rowAmount = lines.length;
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                lines[i][j] = new Line();
            }
        }
    }

    public int getRowAmount() {
        return rowAmount;
    }

    public int getColumnAmount() {
        return columnAmount;
    }

    public Line[][] getHorizontalLines() {
        return horizontalLines;
    }

    public Line[][] getVerticalLines() {
        return verticalLines;
    }

    public Circle[][] getCircles() {
        return circles;
    }

    public void fillLinesObject(Line[][] lines, int[][] values) {
        int columnAmount = lines[0].length;
        int rowAmount = lines.length;
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                lines[i][j].setValue(values[i][j]);
            }
        }
    }

    private void fillFirstRowCircles() {
        for (int i = 1; i < columnAmount; i += 1) {
            circles[0][columnAmount - i - 1].setValue(this.horizontalLines[0][this.horizontalLines[0].length - i].getValue()
                    + circles[0][columnAmount - i].getValue());
            circles[0][columnAmount - i - 1].setPrevCircle(circles[0][columnAmount - i]);
        }
    }

    private void fillLastColumnCircles() {
        for (int i = 1; i < rowAmount; i += 1) {
            circles[i][columnAmount - 1].setValue(
                    this.verticalLines[i - 1][this.verticalLines[0].length - 1].getValue() +
                            this.circles[i - 1][columnAmount - 1].getValue());
            System.out.println(circles[i][columnAmount - 1].getValue());
            circles[i][columnAmount - 1].setPrevCircle(this.circles[i - 1][columnAmount - 1]);
        }
    }

    private void fillCentreCellCircles() {
        for (int i = rowAmount - 1; i > 0; i--) {
            for (int j = columnAmount - 1; j > 0; j--) {
                if (circles[rowAmount - i - 1][j - 1].getValue() + verticalLines[rowAmount - i - 1][j - 1].getValue() <
                        circles[rowAmount - i][j].getValue() + horizontalLines[rowAmount - i][j - 1].getValue()) {
                    circles[rowAmount - i][j - 1].setValue(circles[rowAmount - i - 1][j - 1].getValue() +
                            verticalLines[rowAmount - i - 1][j - 1].getValue());
                    circles[rowAmount - i][j - 1].setPrevCircle(circles[rowAmount - i - 1][j - 1]);
                } else {
                    circles[rowAmount - i][j - 1].setValue(circles[rowAmount - i][j].getValue() +
                            horizontalLines[rowAmount - i][j - 1].getValue());
                    circles[rowAmount - i][j - 1].setPrevCircle(circles[rowAmount - i][j]);
                }
            }
        }
    }

    public String toStringTableValues() {
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                System.out.print(circles[i][j].getValue() + " ");
            }
            System.out.println();
        }
        return "";
    }

    public List<Circle> getOptimalWay() {
        return optimalWay;
    }

    public void setOptimalWay(List<Circle> optimalWay) {
        this.optimalWay = optimalWay;
    }

    private void calculateWay() {
        this.optimalWay = getWay();
    }


    private List<Circle> getWay() {
        List<Circle> way = new ArrayList<Circle>();
        Circle currentCircle = circles[rowAmount - 1][0];
        while (currentCircle.getPrevCircle() != null) {
            way.add(currentCircle);
            currentCircle = currentCircle.getPrevCircle();
        }
        way.add(currentCircle);
        return way;
    }

    @Override
    public void execute() {

        circles[0][columnAmount - 1].setValue(0);
        fillFirstRowCircles();
        fillLastColumnCircles();
        fillCentreCellCircles();
        calculateWay();
        toStringTableValues();
    }
}
