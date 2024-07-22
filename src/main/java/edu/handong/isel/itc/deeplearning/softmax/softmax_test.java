package edu.handong.isel.itc.deeplearning.softmax;

public class softmax_test {
    private double xData[][];
    private double yData[][];
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

    public softmax_test(double[][] x_Data, double[][] y_Data, double learningRate, double[] weight, double count) {
        this.xData = x_Data;
        this.yData = y_Data;
        this.learningRate = learningRate;
        this.weight = weight;
        this.count = count;
        this.dataAll = new double[x_Data.length][4];
        this.dif = new double[x_Data.length];
    }


    public double[] mutliHyperthesis(double w[], double[][] data) {
        double[] result = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = 0;
            for (int j = 0; j < w.length; j++) {
                result[i] += w[j] * data[i][j];
            }
        }
        return result;
    }

    public double Hypothesis(double w, double x) {
        return w * x;
    }

    public double calculateCost(double w[], double[][] x,double[][] y) {
        double cost = 0;
        dif = mutliHyperthesis(w, dataAll);
        for (int i = 0; i < dataAll.length; i++) {
            for(int j =0; i< yData.length; j++){
                dif[i] = dif[i] - yData[i][j];
            }
            cost += (dif[i] * dif[i]);
        }
        return cost / dataAll.length;
    }

    public double Gradient(double w, double[] x, double[] y, int input) {
        double gradient = 0.0;
        for (int i = 0; i < x.length; i++) {
            double error = Hypothesis(w, x[i]) - y[input];
            gradient += error * x[i];
        }
        gradient = gradient / x.length;
        return gradient;
    }


    public void train() {
        for (int i = 0; i < count; i++) {
            cost = calculateCost(weight, xData, yData);
            for(int j=0; j<yData.length; j++){
                weight[j] = Gradient(weight[j], xData[j],yData[j],j);
            }
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
    private double[] softmax(double[] x, double input) {

//            double total = Arrays.stream(neuronValues).map(Math::exp).sum();
//            return Math.exp(input) / total;

        //1, 정규화하여 모든 클래스의 확률값의 합이 1이 되게 만들기
//            double rsult = Math.exp(x)/Double.sum(Math.exp(x));

        double max = Double.NEGATIVE_INFINITY;
        for (double val : x) {
            if (val > max) {
                max = val;
            }
        }
        double sum = 0.0;
        double[] softmax = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            softmax[i] = Math.exp(x[i] - max);
            sum += softmax[i];
        }
        for (int i = 0; i < x.length; i++) {
            softmax[i] /= sum;
        }
        return softmax;
    }
}
