package edu.handong.isel.itc.deeplearning.linearregression;

public class SetDataLinearRegression {
    private double[] X;
    private double[] Y;

    public SetDataLinearRegression(double[][] data) {
        setX(data);
        setY(data);
    }

    public void setX(double[][] data) {
        X = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            X[i] = data[i][0]; // 첫 번째 열을 X로 설정
        }
    }

    public void setY(double[][] data) {
        Y = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            Y[i] = data[i][1]; // 두 번째 열을 Y로 설정
        }
    }

    public double[] getX() {
        return X;
    }

    public double[] getY() {
        return Y;
    }
}
