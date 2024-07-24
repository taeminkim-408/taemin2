    package edu.handong.isel.itc.deeplearning.softmax;
    import Jama.Matrix;
    public class Softmax {
        private double xData[][];
        private double yData[][];
        private double learningRate;
        private double weight[];
        private double count;


        public Softmax(double[][] x_Data, double[][] y_Data, double learningRate, double[] weight, double count) {
            this.xData = x_Data;
            this.yData = y_Data;
            this.learningRate = learningRate;
            this.weight = weight;
            this.count = count;
        }

        private double[] softmax(double[] z) {
//            double max =0; // 무한으로
            double max = Double.NEGATIVE_INFINITY; // 무한으로
            for (double val : z) {
                if (val > max) {
                    max = val;
                }
            }
            double sum = 0.0;
            double[] softmax = new double[z.length];
            for (int i = 0; i < z.length; i++) {
                softmax[i] = Math.exp(z[i] - max);
                sum += softmax[i];
            }
            for (int i = 0; i < z.length; i++) {
                softmax[i] /= sum;
            }
            return softmax;
        }

        private double[] predict(double[] x) {
            double[] z = new double[weight.length];
            for (int i = 0; i < weight.length; i++) {
                z[i] = 0;
                for (int j = 0; j < x.length; j++) {
                    z[i] += x[j] * weight[i];
                }
            }
            return softmax(z);
        }

        public void predictPrintX(double[][] xInputs) {
            System.out.println("---------------------------------------------------------");
            for (int i = 0; i < xInputs.length; i++) {
                double[] prediction = predict(xInputs[i]);
                System.out.print("Prediction for xInput[" + i + "]: ");
                for (double val : prediction) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------------------------------------------");
        }

        public void predictPrintY(double[][] yInputs) {

            for (int i = 0; i < yInputs.length; i++) {
                double[] prediction = predict(yInputs[i]);
                System.out.print("Prediction for yInput[" + i + "]: ");
                for (double val : prediction) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------------------------------------------");
        }

        private double calCost() {
            double cost = 0.0;
            for (int i = 0; i < xData.length; i++) {
                double[] predicted = predict(xData[i]);
                for (int j = 0; j < yData[i].length; j++) {
                    cost -= yData[i][j] * Math.log(predicted[j]);
                }
            }
            return cost / xData.length;
        }

        private void updateWeights() {
            double[] gradients = new double[weight.length];
            for (int i = 0; i < xData.length; i++) {
                double[] predicted = predict(xData[i]);
                for (int j = 0; j < yData[i].length; j++) {
                    double error = predicted[j] - yData[i][j];
                    for (int k = 0; k < xData[i].length; k++) {
                        gradients[k] += error * xData[i][k];
                    }
                }
            }
            for (int j = 0; j < weight.length; j++) {
                weight[j] -= learningRate * gradients[j] / xData.length;
            }
        }

        public void train() {
            for (int i = 0; i < count; i++) {
                double cost = calCost();
                updateWeights();
                printAll(i, cost);
            }
        }

        public void printAll(int count, double cost) {
            System.out.print("Iteration: " + count);
            System.out.print(" | Cost: " + cost);
            for (int j = 0; j < weight.length; j++) {
                System.out.print(" | Weight[" + j + "] = " + weight[j]);
            }
            System.out.println();

            System.out.println("Predictions:");


            System.out.println("---------------------------------------------------------");
            for (int i = 0; i < xData.length; i++) {
                double[] prediction = predict(xData[i]);
                System.out.print("Data[" + i + "]: ");
                double sum = 0.0;
                for (double val : prediction) {
                    System.out.print(val + " ");
                    sum += val;
                }
                System.out.println(" | Sum: " + sum);
                System.out.println("---------------------------------------------------------");
            }
        }

    }

//        public double[] mutliHyperthesis(double w[], double[][] data) {
//            double[] result = new double[data.length];
//            for (int i = 0; i < data.length; i++) {
//                result[i] = 0;
//                for (int j = 0; j < w.length; j++) {
//                    result[i] += w[j] * data[i][j];
//                }
//            }
//            return result;
//        }
//
//        public double Hypothesis(double w, double x) {
//            return w * x;
//        }
//
//        private double calCost() {
//            double cost = 0.0;
//            for (int i = 0; i < xData.length; i++) {
//                double[] predicted = predict(xData[i]);
//                for (int j = 0; j < yData[i].length; j++) {
//                    cost -= yData[i][j] * Math.log(predicted[j]);
//                }
//            }
//            return cost / xData.length;
//        }
//
//
//        public double Gradient(double w, double[] x, double[] y, int input) {
//            double gradient = 0.0;
//            for (int i = 0; i < x.length; i++) {
//                double error = Hypothesis(w, x[i]) - y[input];
//                gradient += error * x[i];
//            }
//            gradient = gradient / x.length;
//            return gradient;
//        }
//
//
//
//
//        public void train() {
//            for (int i = 0; i < count; i++) {
//                cost = calCost(weight, xData, yData);
//                for(int j=0; j<yData.length; j++){
//                    weight[j] = Gradient(weight[j], xData[j],yData[j],j);
//                }
//                printAll(i);
//            }
//        }
//
//        public void printAll(int i) {
//            System.out.print("i= " + i);
//            System.out.print(" | cost = " + cost);
//            for (int j = 0; j < weight.length; j++) {
//                System.out.print(" | Weight[" + j + "] = " + weight[j]);
//            }
//            System.out.println();
//        }
//        public double predict(double[] x) {
//            double result = 0;
//            for (int i = 0; i < weight.length; i++) {
//                result += x[i] * weight[i];
//            }
//            return result;

//        private double[] softmax(double[] x, double input) {
//
////            double total = Arrays.stream(neuronValues).map(Math::exp).sum();
////            return Math.exp(input) / total;
//
//            //1, 정규화하여 모든 클래스의 확률값의 합이 1이 되게 만들기
////            double rsult = Math.exp(x)/Double.sum(Math.exp(x));
//
//            double max = Double.NEGATIVE_INFINITY;
//            for (double val : x) {
//                if (val > max) {
//                    max = val;
//                }
//            }
//            double sum = 0.0;
//            double[] softmax = new double[x.length];
//            for (int i = 0; i < x.length; i++) {
//                softmax[i] = Math.exp(x[i] - max);
//                sum += softmax[i];
//            }
//            for (int i = 0; i < x.length; i++) {
//                softmax[i] /= sum;
//            }
//            return softmax;
//        }
//    private double[] softmax(double[] z) {
//        double max = Arrays.stream(z).max().getAsDouble();
//        double sum = Arrays.stream(z).map(val -> Math.exp(val - max)).sum();
//        return Arrays.stream(z).map(val -> Math.exp(val - max) / sum).toArray();
//    }
//    private double[] predict(double[] x) {
//            double[] z = new double[weight.length];
//            for (int i = 0; i < weight.length; i++) {
//                z[i] = x[i] * weight[i];
//            }
//            return softmax(z);
//        }



