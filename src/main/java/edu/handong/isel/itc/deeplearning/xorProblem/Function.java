package edu.handong.isel.itc.deeplearning.xorProblem;

public class Function {
    public static double[][] Sigfor(double[][] x){
        double[][] result = new double[x.length][x[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                result[i][j] = 1.0 / (1.0 + Math.exp(-x[i][j]));
            }
        }
        return result;
    }
    public static double[][] Sigback(double[][] y, double[][] back) {
        double[][] result = new double[y.length][y[0].length];
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y[i].length; j++) {
                result[i][j] = back[i][j] * y[i][j] * (1 - y[i][j]);
            }
        }
        return result;
    }
    public static double forwardCost(double[][] hypothesis, double[][] y){
        double[][] temp = Matrix.add(
                Matrix.mul(y, Matrix.log(hypothesis)),//Y log(h)
                Matrix.mul(Matrix.add(1, Matrix.mul(-1,y)), Matrix.log(Matrix.add(1,Matrix.mul(-1,hypothesis)))) //(1−y)log(1−h):
        );
        double cost = -Matrix.reduce_mean(temp);

        return cost;
    }
    public static double[][] backwardCost(double[][] hypothesis, double[][] y){
        double[][] dervH = Matrix.mul(-1.0/ hypothesis.length, Matrix.add(
                Matrix.mul(y, Matrix.reciprocal( Matrix.add(1e-7, hypothesis))),
                Matrix.mul(Matrix.add(-1, y), Matrix.reciprocal( Matrix.add(1.000000000001, Matrix.mul(-1, hypothesis))))
        ));
        return dervH;
    }
}
