package edu.handong.isel.itc.deeplearning.logisticregression;

import Jama.Matrix;

public class tools {

    public static Matrix sigmoid(Matrix pre_hypo)
    {
        Matrix hypo =null;
        double[][] res = new double[pre_hypo.getRowDimension()][pre_hypo.getColumnDimension()];
        for(int i=0;i<pre_hypo.getRowDimension();i++)
        {
            for(int j=0;j<pre_hypo.getColumnDimension();j++)
            {
                res[i][j] =(double) 1/(double)(Math.exp(pre_hypo.get(i,j)*-1)+1);

            }

        }
        hypo = new Matrix(res);
        return hypo;
    }

    public static Matrix precost(Matrix hypo, Matrix Y)
    {
        Matrix error = null;
        double[][] res = new double[hypo.getRowDimension()][hypo.getColumnDimension()];
        double case_0;
        double case_1;
        for(int i=0;i<hypo.getRowDimension();i++)
        {
            for(int j=0;j<hypo.getColumnDimension();j++)
            {
                case_0=(Y.get(i,j)*(-1))*Math.log(hypo.get(i,j));
                case_1= ((double)(1-Y.get(i,j)))*((double)(Math.log(1-hypo.get(i,j))));
                res[i][j] = case_0-case_1;
            }
        }
        error = new Matrix(res);

        return error;
    }

    public static double Accurate(Matrix hypo, Matrix Y,double th)
    {
        int count =0;
        double[][] pred = new double[Y.getRowDimension()][Y.getColumnDimension()];
        for(int i=0;i<hypo.getRowDimension();i++)
        {
            for(int j=0;j< hypo.getColumnDimension();j++)
            {
                if(hypo.get(i,j)>th) pred[i][j]=1;
                else pred[i][j] =0;
                if(pred[i][j]== Y.get(i,j)) count++;
                // System.out.println(hypo.get(i,j));
                // System.out.println(pred[i][j]);
            }
        }
        // System.out.println(count);
        //System.out.println(pred.length);
        return (double)count/ pred.length;

    }



}
