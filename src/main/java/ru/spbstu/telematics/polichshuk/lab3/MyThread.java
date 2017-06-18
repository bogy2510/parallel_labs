package ru.spbstu.telematics.polichshuk.lab3;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bogdan on 04.06.2017.
 */
public class MyThread extends Thread{
    int lineIndex;
    int columnIndex;
    ArrayList<ArrayList<Double>> matr;

    public MyThread(ArrayList<ArrayList<Double>> matr, int lineIndex, int columnIndex) {
        if (matr == null)
            throw new NullPointerException();
        if(lineIndex>matr.size()-1 || columnIndex>matr.size()-1)
            throw new IndexOutOfBoundsException();
        this.lineIndex = lineIndex;
        this.columnIndex = columnIndex;
        this.matr = matr;
    }

    public void run() {
        matr.get(lineIndex).set(columnIndex, 1000*Math.random());
    }
}
