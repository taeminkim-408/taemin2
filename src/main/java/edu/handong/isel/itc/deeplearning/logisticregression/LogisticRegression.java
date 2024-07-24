package edu.handong.isel.itc.deeplearning.logisticregression;
import Jama.Matrix;

import java.util.Arrays;

public class LogisticRegression {
    private double[] weights;
    private double bias;
    private double learningRate;
    private int iterations;

    public LogisticRegression(int numFeatures, double learningRate, int iterations) {
        this.weights = new double[numFeatures];
        this.bias = 0.0;
        this.learningRate = learningRate;
        this.iterations = iterations;
    }

    public void train(double[][] X, double[] y) {


        int m = X.length;
        for (int i = 0; i < iterations; i++) {
            double[] linearModel = new double[m];
            double[] predictions = new double[m];
            for (int j = 0; j < m; j++) {
                linearModel[j] = bias;
                for (int k = 0; k < weights.length; k++) {
                    linearModel[j] += weights[k] * X[j][k];
                }
                predictions[j] = sigmoid(linearModel[j]);
                //weight 값을 구함
//                System.out.println("Gradient value is = " +predictions[j] );
            }

            double[] errors = new double[m];
            for (int j = 0; j < m; j++) {
                errors[j] = predictions[j] - y[j];
            }

            for (int k = 0; k < weights.length; k++) {
                double gradient = 0.0;
                for (int j = 0; j < m; j++) {
                    gradient += X[j][k] * errors[j];
                }
                weights[k] -= learningRate * gradient / m;
                System.out.println("Gradient value is = " +weights[k]);
            }

            double biasGradient = 0.0;
            for (int j = 0; j < m; j++) {
                biasGradient += errors[j];
            }
            bias -= learningRate * biasGradient / m;
        }


    }

    public double predict(double[] X) {
        double linearModel = bias;
        for (int i = 0; i < weights.length; i++) {
            linearModel += weights[i] * X[i];
        }
        return sigmoid(linearModel);
    }

    private double sigmoid(double z) {
        return 1 / (1 + Math.exp(-z));
    }

    public static void main(String[] args) {
        // 예제 데이터: 4개의 샘플과 2개의 특징을 가진 데이터
        double[][] X = {
                {0.5, 1.0},
                {1.5, 2.0},
                {3.0, 4.0},
                {5.0, 6.0}
        };
        double[] y = {0, 0, 1, 1};

        LogisticRegression model = new LogisticRegression(2, 0.1, 1000);
        model.train(X, y);

        // 테스트 데이터
        double[] testSample = {2.0, 3.0};
        double prediction = model.predict(testSample);
        System.out.println("Predicted probability: " + prediction);
        System.out.println("Predicted class: " + (prediction >= 0.5 ? 1 : 0));
    }
}
