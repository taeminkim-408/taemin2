package edu.handong.isel.itc.deeplearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Setting {
    private List<List<String>> csvList;
    private String[] label;
    private double[][] x_data;
    private double[] y_data;
    private double[] weight;
    private double bias;
    private double learning_rate;
    private int epoch;

    public String[] getLabel() {
        return label;
    }
    public double[][] getX_data() {
        return x_data;
    }
    public double[] getY_data() {
        return y_data;
    }
    public double[] getWeight() {
        return weight;
    }
    public void setWeight(double[] weight) {
        this.weight = weight;
    }
    public double getBias() {
        return bias;
    }
    public double getLearning_rate() {
        return learning_rate;
    }
    public int getEpoch() {
        return epoch;
    }

    public void reader(String file_name) {
        csvList = new ArrayList<List<String>>();
        File csv = new File("/Users/taemin/Desktop/handong/ISEL/isel_Itc/KTM/src/main/java/edu/handong/isel/itc/deeplearning/testing1.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(",");
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        //	Testing.Read(csvList);
    }

    public void preprocess() {
        // setting for x_daya and y_data, weights, bias, epoch and learning_rate
        label = new String[csvList.get(0).size()];
        x_data = new double[csvList.size()-1][csvList.get(0).size()];
        y_data = new double[csvList.size()-1];
        weight = new double[csvList.get(0).size()];
        int x1;
        for(x1=0;x1<csvList.size();x1++) {
            int x2;
            if(x1 == 0) {
                for(x2=0;x2<csvList.get(0).size();x2++) {
                    label[x2] = csvList.get(x1).get(x2);
                    //	System.out.print(x_y_data.get(x1).get(x2)+" ");
                    if(x2 != csvList.get(0).size()-1)
                        weight[x2] = Math.random() * 1;
                }
            } else {
                for(x2=0;x2<csvList.get(0).size()-1;x2++) {
                    x_data[x1-1][x2] = Double.parseDouble(csvList.get(x1).get(x2));
                    //	System.out.print(x_y_data.get(x1).get(x2)+" ");
                }
                y_data[x1-1] = Double.parseDouble(csvList.get(x1).get(x2));
                //	System.out.print(x_y_data.get(x1).get(x2));
            }
            //t	System.out.println();
        }
        bias = Math.random() * 2;
        learning_rate = 0.5;
        epoch = 50;

        putBias();
        //	Testing.setting(label, x_data, y_data, weight, bias, epoch, learning_rate);
    }

    private void putBias() {
        weight[weight.length-1] = bias;
        for(int i=0;i<x_data.length;i++)
            x_data[i][x_data[0].length-1] = 1;
    }
}