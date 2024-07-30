package edu.handong.isel.itc.deeplearning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderAll {
    public static double[][] readCSV(String path) {
        List<double[]> data = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(path));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                double[] numericFields = new double[fields.length];
                try {
                    for (int i = 0; i < fields.length; i++) {
                        numericFields[i] = Double.parseDouble(fields[i]);
                    }
                    data.add(numericFields);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + path);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Exception when reading file: " + path);
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

        return data.toArray(new double[0][]);
    }

    public static double[][] xData(double[][] data) {
        int rows = data.length;
        int cols = data[0].length - 1; // Assuming last column is Y
        double[][] xData = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, xData[i], 0, cols);
        }
        return xData;
    }

    public static double[] yData(double[][] data) {
        int rows = data.length;
        double[] yData = new double[rows];
        for (int i = 0; i < rows; i++) {
            yData[i] = data[i][data[i].length - 1];
        }
        return yData;
    }


}
