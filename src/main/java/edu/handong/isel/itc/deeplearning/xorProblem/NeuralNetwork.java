package edu.handong.isel.itc.deeplearning.xorProblem;

import java.util.ArrayList;
public class NeuralNetwork {
    private double[][] x;
    private double[][] y;
    private ArrayList<double[][]> w;
    private ArrayList<double[]> b;
    private int NumOfLayer;
    private double[][] hypothesis;
    private double cost;
    private double learningRate;
//    private Layer[][] layers; //
    private Layer[] layers;
    public NeuralNetwork(double[][] x, double[][] y, ArrayList<double[][]> w, ArrayList<double[]> b, int NumOfLayer, double learningRate){
        this.x = x;
        this.y = y;
        this.w = w;
        this.b = b;
        this.NumOfLayer = NumOfLayer; //layer에 따라서 받아들이기 무조건 1차원 배열
        this.learningRate = learningRate;
        this.layers = new Layer[NumOfLayer];
    }

    public void run(){
        //forward
        for(int i = 0; i < NumOfLayer; i++){
            layers[i] = new Layer(x, w.get(i), b.get(i));
            hypothesis = layers[i].forward();
        }
        this.cost = Function.forwardCost(hypothesis,y);
        //해당 층에 cost 값을 추가



        //backward
        double[][] derv = Function.backwardCost(hypothesis, y); //back word를 할려고 함
        for(int i = NumOfLayer-1; i >= 0; i--){
            derv = layers[i].backward(derv);
        }
        for(int i = 0; i < NumOfLayer; i++){
            w.set(i, Matrix.sub(w.get(i), Matrix.mul(learningRate, layers[i].getW_Grad())));
            b.set(i, Matrix.sub(b.get(i), Matrix.mul(learningRate, layers[i].getB_grad())));
        }
    }

    public double predict(){
        double temp = 0;
        for(int i = 0; i < hypothesis.length; i++){
            if(hypothesis[i][0]  > 0.5 && y[i][0] == 1) temp++;
            else if(hypothesis[i][0]  < 0.5 && y[i][0] == 0) temp++;
        }
        return temp/hypothesis.length;
    }
    public double testDataAccuracy(double[][] x, double[][] y){
        hypothesis = x;
        for(int i = 0; i < NumOfLayer; i++){
            layers[i] = new Layer(hypothesis, w.get(i), b.get(i));
            hypothesis = layers[i].forward();
        }
        double temp = 0;
        for(int i = 0; i < hypothesis.length; i++){
            if(hypothesis[i][0]  > 0.5 && y[i][0] == 1) temp++;
            else if(hypothesis[i][0]  < 0.5 && y[i][0] == 0) temp++;
        }
        return temp/hypothesis.length;
    }
    public double getCost(){
        return cost;
    }
    public double[][] getHypothesis() { return hypothesis;}
    public ArrayList<double[][]> getW() { return w; }

}

