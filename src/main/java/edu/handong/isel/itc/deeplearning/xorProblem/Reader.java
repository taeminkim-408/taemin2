package edu.handong.isel.itc.deeplearning.xorProblem;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static double[][] readCSV(String path){
        List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        try{
            br = Files.newBufferedReader(Paths.get(path));
            String line = "";
            while((line = br.readLine()) != null){
                List<String> Line = new ArrayList<String>();
                String array[] = line.split(",");
                Line = Arrays.asList(array);
//                System.out.println(Line); //줄마다 간격 출력
                ret.add(Line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        double [][] arr = new double[ret.size()-1][ret.get(0).size()]; //파일을 읽는다. 줄간격으로
        try {
            for(int i=1;i< arr.length;i++){
                String[] temp = ret.get(i).toArray(new String[ret.size()]);
                for(int j=0; j < arr[0].length; j++){
                    arr[i][j] = Double.parseDouble(temp[j]);
                }
            }
        }
        catch (NullPointerException e){
        }
        return arr;
    }
    public static void printAll(double[][] data) {
        for (int i=0;i<data.length;i++) {
            System.out.print(i + "번째 데이터 [ ");
            for (int j=0;j<data[i].length;j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
