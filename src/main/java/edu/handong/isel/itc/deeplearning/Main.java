package edu.handong.isel.itc.deeplearning;


import edu.handong.isel.itc.deeplearning.linearregression.LinearRegression;
import edu.handong.isel.itc.deeplearning.linearregression.SetDataLinearRegression;
import edu.handong.isel.itc.deeplearning.logisticregression.LogisticRegressionTM;
import edu.handong.isel.itc.deeplearning.logisticregression.Setdata;
import edu.handong.isel.itc.deeplearning.multiLinearregressionbuilder.MultiLinearRegression;
import edu.handong.isel.itc.deeplearning.multiLinearregressionbuilder.ReaderMLRegression;
import edu.handong.isel.itc.deeplearning.multiLinearregressionbuilder.SetDataMLRegression;
import edu.handong.isel.itc.deeplearning.softmax.Softmax;
import edu.handong.isel.itc.deeplearning.xorProblem.NeuralNetwork;
import edu.handong.isel.itc.deeplearning.xorProblem.Reader;
import edu.handong.isel.itc.deeplearning.xorProblem.SetData;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        switch (args[0]) {
//            case "LinearRegression": {
            case "-L": {
//                double[] xData = {1, 2, 3, 4, 5};
//                double[] yData = {1, 2, 3, 4, 5};
                Reader rd = new Reader();
                double[][] data = rd.readCSV("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/linearregression/train.csv");
                SetDataLinearRegression sd = new SetDataLinearRegression(data); // 수정된 부분

                double[] xData = sd.getX(); // 입력 데이터
                double[] yData = sd.getY(); // 출력 데이터

                double learningRate = 0.001;
                double w_data = 5;
                int count = 100;
                double inputForPredict = 7;
                LinearRegression lr = new LinearRegression(xData, yData, learningRate, w_data, count, inputForPredict);
                lr.train();
                lr.predict(inputForPredict);
                break;
            }

//            case "LogisticRegression": {
                case "-Lo": {
                    double[] x_data = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
                    double[] y_Data = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};

                        Reader rd = new Reader();
                        double[][] data = rd.readCSV("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/logisticregression/diabetes2.csv"); // 파일 경로 수정
                        Setdata sd = new Setdata(data);

                        double[] xData = sd.getX();
                        double[] yData = sd.getY();

                        double learningRate = 0.001;
                        double w_data = 0;
                        int count = 10000;
                        double[] input_x = {1, 2, 3, 4, 5, 6, 20, 8, 9, 10};
                        double[] input_y = {0, 1};
                        LogisticRegressionTM lr = new LogisticRegressionTM(x_data, y_Data, learningRate, w_data, count, input_x, input_y);
                        lr.train();
                        lr.predictAll(input_x);
                        break;

            }

//            case "MultiLinearRegression": {
                case "-ML": {
///Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/multiLinearregressionbuilder/MultiLinear.csv
//                    ReaderMLRegression rd = new ReaderMLRegression();
//                    double[][] data = Reader.readCSV("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/multiLinearregressionbuilder/MultiLinear.csv");
//                    SetDataMLRegression sd = new SetDataMLRegression(data);
//                    double[][] xData = sd.getX();
//                    double[] yData = sd.getY();
//
//                    double[][] x_Data = {{1, 2, 3, 5}, {1, 3, 4, 5}, {1, 2, 3, 5}, {1, 3, 4, 5}};
//                    double[] y_Data = {1, 2, 3,  5};
//                    double learningRate = 0.01;
//                    double[] w_data = {3, 3, 3,3};
//                    double[][] predict = x_Data; // xData를 predict 데이터로 사용
//                    int count = 100 ;
//
//                    MultiLinearRegression lr = new MultiLinearRegression(x_Data, y_Data, learningRate, w_data, count, predict);
//                    lr.train();
//                    break;
                    ReaderMLRegression rd = new ReaderMLRegression();
                    double[][] data = rd.readCSV("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/multiLinearregressionbuilder/MultiLinear.csv");
                    SetDataMLRegression sd = new SetDataMLRegression(data);

                    double[][] xData = sd.getX();
                    double[] yData = sd.getY();

                    double learningRate = 0.01;
                    double[] w_data = new double[xData[0].length];
                    int count = 100;
                    double[][] predict = {{1, 2, 3, 5}, {1, 3, 4, 5}, {1, 2, 3, 5}, {1, 3, 4, 5}};

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
            case "-Xor": {
                Reader rd = new Reader();
                double[][] data = rd.readCSV("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/xorProblem/Xor_Dataset.csv");
                int NumOfLayer = 5;
                double learningRate = 0.01;


                SetData tm = new SetData(data, NumOfLayer); //데이터 만든 걸 구체화하자



                double[][] x = tm.getX();
                double[][] y = tm.getY();
                ArrayList<double[][]> w = tm.getW();;
                ArrayList<double[]> b = tm.getB();
                int epoch = 1000;


                NeuralNetwork nw = new NeuralNetwork(x, y, w, b, NumOfLayer, learningRate);


                for(int i = 0; i <= epoch; i++){
                    nw.run();
                    double cost = nw.getCost();
                    double accuracy = nw.predict();
                    if(i % 100 == 0) {
                        learningRate /= 10;
                        System.out.println("epoch = " + i + "\tcost = " + cost );
                        System.out.println("epoch = " + i + "\tcost = " + cost + "\tTraining Accuracy = " + accuracy);
                    }
                }

                double[][] testData = rd.readCSV("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/xorProblem/Xor_Dataset.csv");
//                rd.printAll(testData);
                SetData td = new SetData(testData,NumOfLayer);
                System.out.println("Test case data Accuracy = " + nw.testDataAccuracy(td.getX(), td.getY()));
                break;
            }



            case "-file": {
                Reader rd = new Reader();
                break;
            }

            default:
                System.out.println("ERROR Command!!!!");
        }
    }
}