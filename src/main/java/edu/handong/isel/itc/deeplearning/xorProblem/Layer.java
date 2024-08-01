package edu.handong.isel.itc.deeplearning.xorProblem;

public class Layer {
    private double[][] x;
    private double[][] w;
    private double[] b;
    private double[][] hypothesis;
    private double[][] w_grad;
    private double[] b_grad;
    public Layer(double[][] x, double[][] w, double[] b){
        this.x = x;
        this.w = w;
        this.b = b;
    }

    public double[][] forward(){
        this.hypothesis = Forward.sigfor(Matrix.dot(x, w, b));
        return hypothesis;
    }

    public double[][] backward(double[][] back){
        double[][] dervXW = Backward.Sigback(hypothesis, back);
        w_grad = Matrix.dot(Matrix.transpose(x), dervXW);
        b_grad = calculationB_grad(b.length, dervXW);
        double[][] dervX = Matrix.dot(dervXW, Matrix.transpose(w));
        return dervX;
    }


    public double[][] wGrad(){
        return w_grad;
    }


    public double[] biasgrad(){
        return b_grad;
    }


    public double[] calculationB_grad(int size, double[][] matrix){
        double[] b_grad = new double[size];
        for(int i = 0; i < size; i++){
            for(int j=0; j < matrix.length; j++){
                b_grad[i] += matrix[j][i];
            }
        }
        return b_grad;
    }

}
