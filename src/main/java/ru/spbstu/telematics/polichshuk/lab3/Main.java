package ru.spbstu.telematics.polichshuk.lab3;
import java.util.ArrayList;
/**
 * Created by Bogdan on 04.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        ArrayList<ArrayList<Double>> matr = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < rows; i++) {
            matr.add(new ArrayList<Double>());
            for (int j = 0; j < columns; j++)
                matr.get(i).add((double) (0));
        }
        MyThread[] threads=new MyThread[rows*columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                threads[i*rows+j]=new MyThread(matr,i,j);
                threads[i*rows+j].start();
            }
        }
        try {
            for (int i=0;i<rows*columns;i++)
                threads[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
                System.out.print(matr.get(i).get(j) + "\t");
            System.out.println();
        }
    }
}
