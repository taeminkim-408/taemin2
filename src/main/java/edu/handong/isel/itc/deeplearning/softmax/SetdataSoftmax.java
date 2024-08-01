package edu.handong.isel.itc.deeplearning.softmax;

public class SetdataSoftmax {
    private double[][] xData;
    private double[][] yData;

    public SetdataSoftmax(double[][] data) {
        int rows = data.length;
        int cols = data[0].length;
        xData = new double[rows][cols - 1];
        yData = new double[rows][1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                xData[i][j] = data[i][j];
            }
            yData[i][0] = data[i][cols - 1];
        }
    }

    public double[][] getX() {
        return xData;
    }

    public double[][] getY() {
        return yData;
    }
}
