package edu.handong.isel.itc.deeplearning.linearregression;


public class LinearRegression {
    private double[] xData;
    private double[] yData;
    private double learningRate;
    private double weight;
    private int count;

    public LinearRegression(double[] xData, double[] yData, double learningRate, double weight, int count, double predict) {
        this.xData = xData;
        this.yData = yData;
        this.learningRate = learningRate;
        this.weight = weight;
        this.count = count;
    }

    public double model(double w, double x) {
        return w * x;
    }

    public double GradientCost(double w, double[] x, double[] y) {
        double cost = 0.0;
        for (int i = 0; i < x.length; i++) {
            double diff = (model(w, x[i]) - y[i]);
            cost += diff * diff;
        }
        cost = cost / x.length;
        return cost;
    }

    public double Gradient(double w, double[] x, double[] y) {
        double gradient = 0.0;
        for (int i = 0; i < x.length; i++) {
            double error = model(w, x[i]) - y[i];
            gradient += error * x[i];
        }
        gradient = gradient / x.length;
        return gradient;
    }

    public void train() {
        for (int i = 0; i < count; i++) {
            double cost = GradientCost(weight, xData, yData);
            double gradient = Gradient(weight, xData, yData);
            weight = weight - learningRate * gradient;
            printAll(i, cost, weight, gradient);
        }

    }

    public void printAll(int i, double cost, double weight, double gradient) {
        System.out.println("count " + i + " | Cost: " + cost + " | Weight: " + weight + " | Gradient: " + gradient);
    }


    public double predict(double x) {
        System.out.println("Predict of " + x + "is " + model(x, weight));
        return 0;
    }
}