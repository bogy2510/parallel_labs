package ru.spbstu.telematics.polichshuk.lab2;

import java.util.Iterator;

/**
 * Created by Bogdan on 04.06.2017.
 */
public class Main {

    public static void main(String[] args)
    {
        MyLinkedList<String> l = new MyLinkedList<String>();
        l.add("1");
        l.add("2");
        l.add("3");
        System.out.println("Элементы списка:");
        Iterator<String> itr1 = l.iterator();
        while(itr1.hasNext())
        {
            System.out.println(itr1.next());
        }
        System.out.println("Первый элемент списка "+l.get(0));
        l.remove("2");
        System.out.println("Длинна списка "+l.size());
        System.out.println(l.get(0));
        if(l.contains("2")) System.out.println("Элемент содержится");
                else System.out.println("Элемент не содержится");
        Iterator<String> itr = l.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
