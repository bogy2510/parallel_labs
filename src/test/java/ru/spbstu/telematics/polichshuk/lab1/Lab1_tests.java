package ru.spbstu.telematics.polichshuk.lab1;
import org.junit.Test;
import org.junit.Assert;
/**
 * Created by Bogdan on 07.05.2017.
 */
public class Lab1_tests {
    @Test
    public void testFileRead(){
        FileRead testread = new FileRead();
        String str=testread.filereader("C:/Users/Bogdan/IdeaProjects/lab01/src/main/resources/yahz");
        org.junit.Assert.assertEquals("Ty vse eshe nedoumok",str);
    }

}
