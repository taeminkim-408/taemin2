package edu.handong.isel.itc.deeplearning.softmax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ReaderSoftmax {
    public static double[][] readCSV(String filePath) {
        List<double[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double[] row = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Double.parseDouble(values[i]);
                }
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new double[0][]);
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
