package edu.handong.isel.itc.deeplearning;


import edu.handong.isel.itc.deeplearning.linearregression.LinearRegression;
import edu.handong.isel.itc.deeplearning.logisticregression.LogisticRegressionTM;
import edu.handong.isel.itc.deeplearning.multiLinearregressionbuilder.MultiLinearRegression;
import edu.handong.isel.itc.deeplearning.softmax.Softmax;
import edu.handong.isel.itc.deeplearning.softmax.softmax_test;

public class Main {
    public static void main(String[] args) {

        switch (args[0]) {
//            case "LinearRegression": {
            case "-L": {
                double[] xData = {1, 2, 3, 4, 5};
                double[] yData = {1, 2, 3, 4, 5};
                double learningRate = 0.01;
                double w_data = 3;
                int count = 1002;
                double inputForPredict = 7;
                LinearRegression lr = new LinearRegression(xData, yData, learningRate, w_data, count, inputForPredict);
                lr.train();
                lr.predict(inputForPredict);
                break;
            }

//            case "LogisticRegression": {
                case "-Lo": {
                    double[] x_data = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
                    double[] yData = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
                double learningRate = 0.001;
                    double[] input_x = {1, 2, 3, 4, 5, 6, 20, 8, 9, 10};
                    double[] input_y = {0,1};
                double w_data = 0;
                int count = 10000;
                LogisticRegressionTM lr = new LogisticRegressionTM(x_data, yData, learningRate, w_data, count,input_x,input_y);
                lr.train();
                lr.predictAll(input_x);
                break;
            }

//            case "MultiLinearRegression": {
                case "-ML": {
                double[][] xData = {{1, 2, 3, 5}, {1, 3, 4, 5}, {1, 2, 3, 5}, {1, 3, 4, 5}};
                double[] yData = {1, 2, 3,  5};
                double learningRate = 0.01;
                double[] w_data = {3, 3, 3,3};
                double[][] predict = {{73.,  80.,  75., 152.},
                        {93.,  88.,  93., 185.},
                        {89.,  91.,  90., 180. },
                        { 96.,  98., 100., 196. },
                        {73.,  66.,  70., 142. },};
                int count = 100 ;

                MultiLinearRegression lr = new MultiLinearRegression(xData, yData, learningRate, w_data, count, predict);
                lr.train();
                break;
            }
//            case "softmax": {
                case "-S": {
                double[][] xData = {{1, 1, 2, 1, 1}, {1, 2, 1, 3, 2}, {1, 3, 1, 3, 4}, {1, 4, 1, 5, 5}, {1, 1, 7, 5, 5}, {1, 1, 2, 5, 6}, {1, 1, 6, 6, 6}, {1, 1, 7, 7, 7}};
                double[][] yData = {{0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {1, 0, 0}, {1, 0, 0}};
                double[] w_data = {1, 2, 3, 4, 5};
                double learningRate = 0.01;
                    double[][] xInput = {
                            {1.0, 2.0, 3.0, 4.0, 5.0},
                            {2.0, 3.0, 4.0, 5.0, 6.0},
                            {3.0, 4.0, 5.0, 6.0, 7.0},
                            {4.0, 5.0, 6.0, 7.0, 8.0},
                            {5.0, 6.0, 7.0, 8.0, 9.0}
                    };
                    double[][] yInput = {
                            {1.0, 0.0, 0.0},
                            {0.0, 1.0, 0.0},
                            {0.0, 0.0, 1.0},
                            {0.0, 0.0, 0.0},
                            {0.0, 0.0, 0.0}
                    };
                int count = 100;
                Softmax softmax = new Softmax(xData, yData, learningRate, w_data, count);
                softmax.train();
                softmax.predictPrintX(xInput);
                softmax.predictPrintY(yInput);
                break;
            }
            case "-St": {
                double[][] x_data = {{1, 1, 2, 1, 1}, {1, 2, 1, 3, 2}, {1, 3, 1, 3, 4}, {1, 4, 1, 5, 5}, {1, 1, 7, 5, 5}};
                double[][] y_data = {{0, 0, 1, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 1, 0, 1}, {0, 1, 0, 0, 0}, {0, 1, 0, 0, 0}};
                double[] w_data = {1, 2, 3, 4, 5};
                double learningRate = 0.01;
                int count = 100;
                Softmax softmax = new Softmax(x_data, y_data, learningRate, w_data, count);
                softmax.train();
                break;
            }
            default:
                System.out.println("ERROR Command!!!!");
        }
    }
}