package edu.handong.isel.itc.deeplearning.lec3;

public class MultiLinearRegressionBuilder {

    private double xData[][];
    private double yData[];
    private double dataAll[][];
    private double learningRate;
    private double weight[];
    private double gradient[];
    private double cost;
    private double[] descent;
    private double[] dif;
    private double count;

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public MultiLinearRegressionBuilder(double[][] x_Data, double[] y_Data, double learningRate, double[] weight, double count) {
        this.xData = x_Data;
        this.yData = y_Data;
        this.learningRate = learningRate;
        this.weight = weight;
        this.count = count;
        this.dataAll = new double[x_Data.length][4];
        this.dif = new double[x_Data.length];
    }

    public double[][] getxData() {
        return xData;
    }

    public void setxData(double[][] xData) {
        this.xData = xData;
    }

    public double[] getyData() {
        return yData;
    }

    public void setyData(double[] yData) {
        this.yData = yData;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double[][] getDataAll() {
        return dataAll;
    }

    public void setDataAll(double[][] dataAll) {
        this.dataAll = dataAll;
    }

    public double[] getWeight() {
        return weight;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }

    public double[] getGradient() {
        return gradient;
    }

    public void setGradient(double[] gradient) {
        this.gradient = gradient;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double[] getDescent() {
        return descent;
    }

    public void setDescent(double[] descent) {
        this.descent = descent;
    }

    public double[] calculateHyperthesis(double w[], double[][] data) {
        double[] result = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = 0;
            for (int j = 0; j < w.length; j++) {
                result[i] += w[j] * data[i][j];
            }
        }
        return result;
    }

    public double calculateCost(double w[], double[][] dataAll) {
        double cost = 0;
        dif = calculateHyperthesis(w, dataAll);
        for (int i = 0; i < dataAll.length; i++) {
            dif[i] = dif[i] - yData[i];
            cost += (dif[i] * dif[i]);
        }
        return cost / dataAll.length;
    }

    public void calculateGradient(double w[], double data[][]) {
        gradient = new double[w.length];
        for (int i = 0; i < w.length; i++) {
            gradient[i] = 0;
            for (int j = 0; j < data.length; j++) {
                gradient[i] += dif[j] * data[j][i];
            }
            gradient[i] = gradient[i] / data.length;
            w[i] = w[i] - gradient[i] * learningRate;
        }
    }

    public void train() {
        for (int i = 0; i < count; i++) {
            cost = calculateCost(weight, xData);
            calculateGradient(weight, xData);
            printAll(i);
        }
    }

    public void printAll(int i) {
        System.out.print("i= " + i);
        System.out.print(" | cost = " + cost);
        for (int j = 0; j < weight.length; j++) {
            System.out.print(" | Weight[" + j + "] = " + weight[j]);
        }
        System.out.println();
    }

    public double predict(double[] x) {
        double result = 0;
        for (int i = 0; i < weight.length; i++) {
            result += x[i] * weight[i];
        }
        return result;
    }
}

