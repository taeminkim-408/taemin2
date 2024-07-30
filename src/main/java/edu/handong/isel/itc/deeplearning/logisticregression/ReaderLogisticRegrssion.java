package edu.handong.isel.itc.deeplearning.logisticregression;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderLogisticRegrssion {
    public static double[][] readCSV(String path) {
        List<List<String>> ret = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(path));
            String line = "";
            while ((line = br.readLine()) != null) {
                List<String> lineList = Arrays.asList(line.split(","));
                ret.add(lineList);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Convert List<List<String>> to double[][]
        double[][] arr = new double[ret.size()][ret.get(0).size()];
        try {
            for (int i = 0; i < arr.length; i++) {
                String[] temp = ret.get(i).toArray(new String[0]);
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = Double.parseDouble(temp[j]);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static void printAll(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(i + "번째 데이터 [ ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}

