package edu.handong.isel.itc.deeplearning.logisticregression;
import Jama.Matrix;


public class LogisticRegressionTM {
    private double[] xData;
    private double[] yData;
    private double learningRate;
    private double weight;
    private int iterations;
    private double bias;
    private double[] xData_input;
    private double[] yData_input;


    public LogisticRegressionTM(double[] xData, double[] yData, double learningRate, double weight, int iterations, double[] xData_input,double[] yData_input) {
        this.xData = xData;
        this.yData = yData;
        this.learningRate = learningRate;
        this.weight = weight;
        this.iterations = iterations;
        this.xData_input = xData_input;
        this.yData_input = yData_input;
    }

    public double Hyperthesis(double w, double x, double b)
    {
        return sigmoid(w * x + b); // 편향 추가
        //이 부분에 음수가 들어오면 된다. 그래야 0/5 이하로 내려간다 어떻게??? w 값이 1보다 커야 한다.
        //bias 편향 값을 추가로 진해 해당 값에 크기에 따라서 변동되게 설정
    }

    public double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
        //식의 이상은 없다.
    }

    //    public double Cost(double w, double[] x, double[] y) {
//        double cost = 0.0;
//        for (int i = 0; i < x.length; i++) {
//            double h = Hyperthesis(w, x[i]);
//            cost += -y[i] * Math.log(h + 1e-10) - (1.0 - y[i]) * Math.log(1.0 - h + 1e-10);
//            //cost 함수의 예정이 이상하지 않다. case2개로 나눠서 진행해보자
//
//        }
//        cost = cost / x.length;
//        return cost;
//    }
    public double Cost(double w, double b, double[] x, double[] y) {
        double cost = 0.0;
        for (int i = 0; i < x.length; i++) {
            double h = Hyperthesis(w, x[i], b);
            cost += -y[i] * Math.log(h + 1e-10) - (1.0 - y[i]) * Math.log(1.0 - h + 1e-10);
        }
        cost = cost / (double)x.length;
        return cost;
    }

//    public double calculateGradient(double w, double[] x, double[] y) {
//        double gradient = 0.0;
//        for (int i = 0; i < x.length; i++) {
//            double error = Hyperthesis(w, x[i]) - y[i];
//            gradient += error * x[i];
//        }
//        gradient = gradient / x.length;
//        return gradient;
//    }

    public double calculateGradient(double w, double b, double[] x, double[] y) {
        double weightGradient = 0.0;
        double biasGradient = 0.0;

        for (int i = 0; i < x.length; i++) {
            double h = Hyperthesis(w, x[i], b);
            double error = h - y[i];
            weightGradient += error * x[i];
            biasGradient += error;
        }

        weightGradient = weightGradient / x.length;
        biasGradient = biasGradient / x.length;

        return weightGradient; // gradient를 반환
    }
    private double calculateBiasGradient(double w, double b, double[] x, double[] y) {
        double biasGradient = 0.0;
        for (int i = 0; i < x.length; i++) {
            double h = Hyperthesis(w, x[i], b);
            double error = h - y[i];
            biasGradient += error;
        }
        return biasGradient / x.length;
    }


    public void train() {
        for (int i = 0; i < iterations; i++) {
            double cost = Cost(weight, bias, xData, yData);
            double weightGradient = calculateGradient(weight, bias, xData, yData);
            double biasGradient = calculateBiasGradient(weight, bias, xData, yData);

            weight -= learningRate * weightGradient;
            bias -= learningRate * biasGradient;

            printAll(i, cost, weight, bias, weightGradient, biasGradient);
        }
    }
    public void printAll(int i, double cost, double weight, double bias, double weightGradient, double biasGradient) {
        System.out.println("count " + i + " | Cost: " + cost + " | Weight: " + weight + " | Bias: " + bias + " | Weight Gradient: " + weightGradient + " | Bias Gradient: " + biasGradient);
    }

    public void predictAll(double x[]) {
        for(int i=0;i<xData_input.length;i++){
            System.out.println("Testcase" +i+" = "+predict_x(xData_input[i]) + "  Wegight = " + weight);
//            System.out.println("Testcase" +i+" = "+predict_x(xData_input[i]) + "Y = " + predict_y(xData_input[i],yData_input[i]));
        }
    }
    public double predict_x(double x) {
        return Hyperthesis(weight, x, bias); // 확률 계산
    }
}
