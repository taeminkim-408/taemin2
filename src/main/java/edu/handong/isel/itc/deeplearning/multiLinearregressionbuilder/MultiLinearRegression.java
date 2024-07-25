package edu.handong.isel.itc.deeplearning.multiLinearregressionbuilder;
import Jama.Matrix;

public class MultiLinearRegression {

    private double[][] xData;
    private double[] yData;
    private double learningRate;
    private double[] weight;
    private double count;
    private double cost;
    private double[][] input;

    private Matrix xMatrix;
    private Matrix yMatrix;
    private Matrix wMAtrix;
    private Matrix inputMatrix;
    private Matrix Hypothiesis;

    public MultiLinearRegression(double[][] xData, double[] yData, double learningRate, double[] weight, double count, double[][] predict ) {
        this.xData = xData;
        this.yData = yData;
        this.learningRate = learningRate;
        this.weight = weight;
        this.count = count;
        this.input = predict;
        this.xMatrix = new Matrix(xData);
        this.yMatrix = new Matrix(yData, yData.length);
        this.wMAtrix = new Matrix(weight, weight.length);
        this.inputMatrix = new Matrix(input);
    }


    public Matrix multiHypothesis(Matrix w, Matrix data) {
        return data.times(w);
    }

//    public double[] mutliHyperthesis(double[] w, double[][] data) {
//        double[] result = new double[data.length];
//        for (int i = 0; i < data.length; i++) {
//            result[i] = 0;
//            for (int j = 0; j < w.length; j++) {
//                result[i] += w[j] * data[i][j];
//            }
//        }
//        return result;
//    }

    public double Hypothesis(double w, double x) {
        return w * x;
    }

//    public double calculateCost(double[] w, double[][] dataAll) {
//        double cost = 0;
//        double[] dif = mutliHyperthesis(w, dataAll);
//        for (int i = 0; i < dataAll.length; i++) {
//            dif[i] = dif[i] - yData[i];
//            cost += (dif[i] * dif[i]);
//        }
//        return cost / dataAll.length;
//    }
    public double calculateCost(Matrix w, Matrix data, Matrix bias) {
        Matrix predictions = multiHypothesis(w, data);
        Matrix errors = predictions.minus(bias);
            return errors.normF() / (2 * bias.getRowDimension());
    }

//    public double Gradient(double w, double[] x, double[] y, int input) {
//        double gradient = 0.0;
//        for (int i = 0; i < x.length; i++) {
//            double error = Hypothesis(w, x[i]) - y[input];
//            gradient += error * x[i];
//        }
//        gradient = gradient / x.length;
//        return gradient;
//    }

    public Matrix Gradient(Matrix w, Matrix data, Matrix bias) {
        Matrix predictions = multiHypothesis(w, data);
        Matrix errors = predictions.minus(bias);
        return data.transpose().times(errors).times(1.0 / bias.getRowDimension());
    }
//    public void train() {
//        for (int i = 0; i < count; i++) {
//            cost = calculateCost(weight, xData);
//            for (int j = 0; j < weight.length; j++) {
//                weight[j] = weight[j] - learningRate * Gradient(weight[j], xData[j], yData, j);
//            }
//            printAll(i);
//        }
        // Matrix 배열 형태로 출력
//        Matrix predictions = predict(input);
//        predictions.print(10,2);

    public void train() {
        for (int i = 0; i < count; i++) {
            double cost = calculateCost(wMAtrix, xMatrix, yMatrix);
            Matrix gradient = Gradient(wMAtrix, xMatrix, yMatrix);
            wMAtrix = wMAtrix.minus(gradient.times(learningRate));
            printAll(i, cost);
        }

        Matrix predictions = predict(inputMatrix);
        System.out.println("Predictions:");
        predictions.print(10, 2); // 출력 방식 변경
    }
//
//        // double 배열 형태로 출력
//        double[] pr = predict(input);
//        System.out.println("Predictions:");
//        for(double prediction : pr) {
//            System.out.println(prediction);
//        }
//    }

//    public void printAll(int i) {
//        System.out.print("count= " + i);
//        System.out.print(" | cost = " + cost);
//        for (int j = 0; j < weight.length; j++) {
//            System.out.print(" | Weight[" + j + "] = " + weight[j]);
//        }
//        System.out.println();
//    }
    public void printAll(int i, double cost) {
        System.out.print("count= " + i);
        System.out.print(" | cost = " + cost);
        for(int j = 0; j < wMAtrix.getRowDimension(); j++) {
            System.out.print(" | Weight[" + j + "] = " + wMAtrix.get(j, 0));
        }
        System.out.println();
    }
    public Matrix predict(Matrix data) {
        return multiHypothesis(wMAtrix, data);
    }

//    public double[] predict(double[][] xData) {
//        System.out.println("dndjndj");
//        // 입력 데이터를 기반으로 예측값을 계산
//        double[] result = new double[xData.length];
//        for (int i = 0; i < xData.length; i++) {
//            result[i] = 0;
//            for (int j = 0; j < weight.length; j++) {
//                result[i] += xData[i][j] * weight[j];
//            }
//        }
//        return result;
//    }

}
