package edu.handong.isel.itc.deeplearning.logisticregression;

import Jama.Matrix;


public class Main {
    public static void main(String[] args)
    {
        double[][] x_train ={{1., 2.},
                {2., 3.},
                {3., 1.},
                {4., 3.},
                {5., 3.},
                {6., 2.}};
        double[][] y_train ={{0.},{0.},{0.},{1.},{1.},{1.}};
        double[][] x_test = {{5.,2.}};
        double[][] y_test = {{1.}};

        Matrix X = new Matrix(x_train);
        Matrix Y = new Matrix(y_train);
        Matrix X_test = new Matrix(x_test);
        Matrix Y_test = new Matrix(y_test);

        Matrix W = Matrix.random(2,1);//weight
        Matrix B = Matrix.random(6,1);//bias
        Matrix hypo = null;
        Matrix UW = null;
        double learningRate = 0.00001;
        int epoch = 5001;
        double threshold =0.5;
        for(int i=0;i<epoch;i++)
        {
            Matrix pre_hypo = X.times(W);
            hypo = tools.sigmoid(pre_hypo);

            Matrix cost = tools.precost(hypo,Y);

            for(int j = 0; j < x_train.length; j++) {
                UW = (X.transpose()).times(X.times(W).plus(B).minus(Y).times(2.0/W.getColumnDimension())); // get derivative value
            }

            W = W.minus(UW.times(learningRate));


            if(i % 100 == 0) { // print out the results
                System.out.println(String.format("%4d | %.4f |accurate : %.4f", i, cost.get(0,0), tools.Accurate(hypo,Y,threshold)));

            }










        }












    }



}