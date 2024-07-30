package edu.handong.isel.itc.deeplearning.xorProblem;

public class Matrix {

    public static double[][] dot(double[][] a, double[][] b){
        double[][] result = new double[a.length][b[0].length];
        for(int z=0; z < b[0].length;z++){
            for(int i = 0; i < a.length; i++){
                double temp = 0;
                for(int j = 0; j < a[0].length; j++){
                    temp += (a[i][j]*b[j][z]);
                }
                result[i][z] = temp;
            }
        }
        return result;
    }
    public static double[][] dot(double[][] a, double[][] b, double[] c){
        double[][] result = new double[a.length][b[0].length];
        for(int z=0; z < b[0].length;z++){
            for(int i = 0; i < a.length; i++){
                double temp = 0;
                for(int j = 0; j < a[0].length; j++){
                    temp += (a[i][j]*b[j][z]);
                }
                result[i][z] = temp + c[z];
            }
        }
        return result;
    }
    public static double[][] mul(double[][] a, double[][] b){
        double[][] result = new double[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                result[i][j] = a[i][j] * b[i][j];
            }
        }
        return result;
    }

    public static double[][] mul(double num, double[][] matrix){
        double[][] result = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result[i][j] = matrix[i][j] * num;
            }
        }
        return result;
    }
    public static double[][][] mul(double num, double[][][] matrix){
        double[][][] result = new double[matrix.length][matrix[0].length][matrix[0][0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for(int z = 0; z < matrix[i][j].length; z++){
                    result[i][j][z] = matrix[i][j][z] * num;
                }
            }
        }
        return result;
    }
    public static double[] mul(double num, double[] matrix){
        double[] result = new double[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            result[i] = matrix[i] * num;
        }
        return result;
    }
    public static double[] sub(double[] a, double[] b){
        double[] result = new double[b.length];
        for(int i = 0; i < a.length; i++){
            result[i] = a[i] - b[i];
        }
        return result;
    }
    public static double[][] sub(double[][] a, double[][] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public static double[][] add(double[][] a, double[][] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    public static double[][] add(double a, double[][] b){
        double[][] result = new double[b.length][b[0].length];
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[0].length; j++){
                result[i][j] = b[i][j] + a;
            }
        }
        return result;
    }
    public static double[][][] add(double[][][] a, double[][][] b){
        double[][][] result = new double[a.length][a[0].length][a[0][0].length];
        for(int i = 0; i < result.length; i++){
            for(int j=0; j < result[0].length;j++){
                for(int z=0; z<result[0][0].length;z++){
                    result[i][j][z] = a[i][j][z] + b[i][j][z];
                }
            }
        }
        return result;
    }
    public static double[] add(double a, double[] b){
        double[] result = new double[b.length];
        for(int i = 0; i < b.length; i++){
            result[i] = b[i] + a;
        }
        return result;
    }

    public static double[][] log(double[][] m){
        double[][] result = new double[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                result[i][j] = Math.log(m[i][j]);
            }
        }
        return result;
    }

    public static double[][] transpose(double[][] m){
        double[][] result = new double[m[0].length][m.length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                result[j][i] = m[i][j];
            }
        }
        return result;
    }
    public static double[][] reciprocal(double[][] m){
        double[][] result = new double[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                result[i][j] = 1/m[i][j];
            }
        }
        return result;
    }
    public static double reduce_mean(double[][] matrix) {
        double result = 0;
        for(int i=0;i< matrix.length;i++){
            result += matrix[i][0];
        }
        result /= matrix.length;
        return result;
    }
}

