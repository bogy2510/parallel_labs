package ru.spbstu.telematics.polichshuk.lab1;
import org.apache.commons.math3.linear.*;
import java.util.Scanner;
/**
 * Created by Bogdan on 07.05.2017.
 */
public class SumMatrix {
    RealMatrix matr1, matr2;

    SumMatrix(int dim)
    {
        System.out.println("\n");
        matr1=create(dim);
        matr2=create(dim);
    }

    public RealMatrix create(int dim){
        RealMatrix matr=MatrixUtils.createRealMatrix(dim, dim);
        Scanner in=new Scanner(System.in);
        System.out.println("\nMatr:");
        for (int i=0;i<dim;i++)
            for (int j=0;j<dim;j++)
            {
                double x=in.nextDouble();
                matr.setEntry(i,j,x);
            }
        show(matr);
        return matr;
    }

    public void add() {
        matr1=matr1.add(matr2);
        System.out.println("\nMatrSumm:");
        show(matr1);
    }

    public void show(RealMatrix matr) {
        RealMatrixFormat formatter = new RealMatrixFormat("", "", "", "", "\n", "\t");
        System.out.println(formatter.format(matr));
    }
}
