package ru.spbstu.telematics.polichshuk.lab1;
import java.io.*;
/**
 * Created by Bogdan on 07.05.2017.
 */
public class FileRead {
    public String filereader(String filepath) {
        String letter=new String();
        try(FileReader reader = new FileReader(filepath))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1) {

                System.out.print((char) c);
                letter = letter + String.valueOf((char)c);
            }
        }
        catch(IOException ex){
            return null;
            //System.out.println(ex.getMessage());
        }
        return letter;
    }
}
