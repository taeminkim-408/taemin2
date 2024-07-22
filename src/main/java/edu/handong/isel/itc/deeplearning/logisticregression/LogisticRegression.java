package edu.handong.isel.itc.deeplearning.logisticregression;
import Jama.Matrix;

public class LogisticRegression {
    private double[] xData;
    private double[] yData;
    private double learningRate;
    private double weight;
    private int iterations;

    private double[] xData_input;
    private double[] yData_input;


    public LogisticRegression(double[] xData, double[] yData, double learningRate, double weight, int iterations, double[] xData_input,double[] yData_input) {
        this.xData = xData;
        this.yData = yData;
        this.learningRate = learningRate;
        this.weight = weight;
        this.iterations = iterations;
        this.xData_input = xData_input;
        this.yData_input = yData_input;
    }

    public double Hyperthesis(double w, double x) {
        return sigmoid(w * x);
    }

    public double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public double Cost(double w, double[] x, double[] y) {
        double cost = 0.0;
        for (int i = 0; i < x.length; i++) {
            double h = Hyperthesis(w, x[i]);
            cost += -y[i] * Math.log(h) - (1.0 - y[i]) * Math.log(1.0 - h);
        }
        cost = cost / x.length;
        return cost;
    }

    public double calculateGradient(double w, double[] x, double[] y) {
        double gradient = 0.0;
        for (int i = 0; i < x.length; i++) {
            double error = Hyperthesis(w, x[i]) - y[i];
            gradient += error * x[i];
        }
        gradient = gradient / x.length;
        return gradient;
    }

    public void train() {
        for (int i = 0; i < iterations; i++) {
            double cost = Cost(weight, xData, yData);
            double gradient = calculateGradient(weight, xData, yData);
            weight -= learningRate * gradient;
            printAll(i, cost, weight, gradient);
        }
        for(int i=0;i<xData_input.length;i++){
            System.out.println("Testcase" +i+" = "+predict_x(xData_input[i]));
//            System.out.println("Testcase" +i+" = "+predict_x(xData_input[i]) + "Y = " + predict_y(xData_input[i],yData_input[i]));
        }

        for(int i=0;i<xData_input.length;i++){
            for(int j=0;j<yData_input.length;j++){
//                System.out.println("Testcase" +i+" Y = " + predict_y(xData_input[i],yData_input[i]));
            }
        }


    }



    public void printAll(int i, double cost, double weight, double gradient) {
        System.out.println("count " + i + " | Cost: " + cost + " | Weight: " + weight + " | Gradient: " + gradient);
    }

    public double predict_x(double x) {
        return Hyperthesis(weight, x); //확률 계산
    }
    public double predict_y(double x, double y) {
        double check = Hyperthesis(weight, x);

        if (check > y){
            return 1.0;
        }
        else{
            return 0.0;
        }

    }


}
