package ru.spbstu.telematics.polichshuk.lab1;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Bogdan on 07.05.2017.
 */
public class SumMatrixAndFileRead {
    public static void main(String[] args)
    {
        System.out.println("HELLO nedoumok");
        FileRead filereader = new FileRead();
        String str=filereader.filereader("C:/Users/Bogdan/IdeaProjects/lab01/src/main/resources/yahz");
        SumMatrix summatr= new SumMatrix(2);
        summatr.add();
    }

}
