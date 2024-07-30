package edu.handong.isel.itc.deeplearning.xorProblem;

import java.util.ArrayList;
import java.util.Random;

public class SetData {
    private double[][] data;
    private double[][] X;
    private double[][] Y;
    private ArrayList<double[][]> w = new ArrayList<>();
    private ArrayList<double[]> b = new ArrayList<>();
    private int NumOfLayer;
    public SetData(double[][] data, int NumOfLayer){
        this.data = data;
        this.NumOfLayer = NumOfLayer;
        setX();
        setY();
        setW();
    }

    public void setX(){
        double[][] X = new double[data.length][data[0].length-1];
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[0].length-1; j++) {
                X[i][j] = data[i][j]; //받아 들인 값의 0,1 값을 받아들인다.
            }
        }
        this.X = X;
    }
    public void setY(){
        double[][] Y = new double[data.length][1];
        for(int i = 0; i < data.length; i++) {
            Y[i][0] = data[i][data[0].length-1]; //마지막 값=값이 y이다.
        }
        this.Y = Y;
    }
    public void setW(){
        double[][] w = new double[X[0].length][Y[0].length * 2];
        double[] b = new double[Y[0].length*2];
        double[] lastBias = new double[Y[0].length];
        double[][] lastweight = new double[X[0].length][Y[0].length];


        Random rand = new Random();

        //중간층 w 초기화
        for(int i = 0; i < NumOfLayer-1; i++){
            for(int j=0; j < w.length; j++){
                for(int k=0; k<w[0].length; k++){
                    w[j][k] = rand.nextDouble();
                }
            }
            this.w.add(w);
        }

        //마직막 층 초기화
        for(int i = 0; i < lastweight.length; i++){
            for(int j = 0; j < lastweight[0].length; j++){
                lastweight[i][j] = rand.nextDouble();
            }
        }
        this.w.add(lastweight);

        //중간 bias 처리
        for(int i = 0; i < NumOfLayer-1; i++){
            for(int j = 0; j < b.length; j++){
                b[j] = rand.nextDouble();
            }
            this.b.add(b);
        }

        //중간 처리
        for(int i = 0; i < lastBias.length; i++){
            lastBias[i] = rand.nextDouble();
        }
        this.b.add(lastBias);
    }
    public double[][] getX(){
        return X;
    }
    public double[][] getY(){
        return Y;
    }
    public ArrayList<double[][]> getW(){
        return w;
    }
    public ArrayList<double[]> getB() { return b;}
}
