package edu.handong.isel.itc.deeplearning.xorProblem;

public class Backward {
    public static double[][] Sigback(double[][] y, double[][] back) {
        double[][] result = new double[y.length][y[0].length];
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y[i].length; j++) {
                result[i][j] = back[i][j] * y[i][j] * (1 - y[i][j]);
            }
        }
        return result;
    }

    public static double[][] backwardCost(double[][] hypothesis, double[][] y){
        double[][] dervH = Matrix.mul(-1.0/ hypothesis.length, Matrix.add(
                Matrix.mul(y, Matrix.reciprocal( Matrix.add(1e-7, hypothesis))),
                Matrix.mul(Matrix.add(-1, y), Matrix.reciprocal( Matrix.add(1.000000000001, Matrix.mul(-1, hypothesis))))
        ));
        return dervH;
    }
}
