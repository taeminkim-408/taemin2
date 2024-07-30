package edu.handong.isel.itc.deeplearning.multiLinearregressionbuilder;

public class SetDataMLRegression {
    private double[][] X;
    private double[] Y;

    public SetDataMLRegression(double[][] data) {
        setX(data);
        setY(data);
    }

    public void setX(double[][] data) {
        X = new double[data.length][data[0].length - 1];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length - 1; j++) {
                X[i][j] = data[i][j]; // 마지막 열을 제외한 나머지 열을 X로 설정
            }
        }
    }

    public void setY(double[][] data) {
        Y = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            Y[i] = data[i][data[0].length - 1]; // 마지막 열을 Y로 설정
        }
    }

    public double[][] getX() {
        return X;
    }

    public double[] getY() {
        return Y;
    }
}
