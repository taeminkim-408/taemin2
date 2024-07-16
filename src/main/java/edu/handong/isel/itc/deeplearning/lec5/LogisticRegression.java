package edu.handong.isel.itc.deeplearning.lec5;

class LogisticRegression {
    private double[] xData;
    private double[] yData;
    private double learningRate;
    private double weight;
    private int iterations;
    private double lambda; // Regularization parameter

    public LogisticRegression(double[] xData, double[] yData, double learningRate, double weight, int iterations, double lambda) {
        this.xData = xData;
        this.yData = yData;
        this.learningRate = learningRate;
        this.weight = weight;
        this.iterations = iterations;
        this.lambda = lambda;
    }

    public double calculateHypothesis(double w, double x) {
        return sigmoid(w * x);
    }

    public double calculateCost(double w, double[] x, double[] y) {
        double cost = 0.0;
        for (int i = 0; i < x.length; i++) {
            double h = calculateHypothesis(w, x[i]);
            cost += -y[i] * Math.log(h) - (1.0 - y[i]) * Math.log(1.0 - h);
        }
        cost = cost / x.length;
        cost += lambda * w * w / 2; // L2 Regularization
        return cost;
    }

    public double calculateGradient(double w, double[] x, double[] y) {
        double gradient = 0.0;
        for (int i = 0; i < x.length; i++) {
            double error = calculateHypothesis(w, x[i]) - y[i];
            gradient += error * x[i];
        }
        gradient = gradient / x.length;
        gradient += lambda * w; // L2 Regularization
        return gradient;
    }

    public void train() {
        for (int i = 0; i < iterations; i++) {
            double cost = calculateCost(weight, xData, yData);
            double gradient = calculateGradient(weight, xData, yData);
            weight -= learningRate * gradient;
            printAll(i, cost, weight, gradient);
        }
    }

    public void printAll(int i, double cost, double weight, double gradient) {
        System.out.println("Iteration " + i + " | Cost: " + cost + " | Weight: " + weight + " | Gradient: " + gradient);
    }

    public double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public double getWeight() {
        return weight;
    }
}
