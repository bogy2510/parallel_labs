package ru.spbstu.telematics.polichshuk.lab2;

import org.junit.Test;

import java.util.ListIterator;

/**
 * Created by Bogdan on 04.06.2017.
 */
public class Lab2_tests {
    @Test
    public void testsize(){
        MyLinkedList<String> listadd = new MyLinkedList<String>();
        org.junit.Assert.assertEquals(0, listadd.size());
    }
    @Test
    public void testadd(){
        MyLinkedList<String> listadd = new MyLinkedList<String>();
        for(int i=0;i<4;i++)
        {
            listadd.add(Integer.toString(i));
        }
        org.junit.Assert.assertEquals(4, listadd.size());
    }
    @Test
    public void testcontains(){
        MyLinkedList<String> listadd = new MyLinkedList<String>();
        for(int i=0;i<4;i++)
        {
            listadd.add(Integer.toString(i));
        }
        org.junit.Assert.assertEquals(true, listadd.contains("1"));
    }
    @Test
    public void testremove(){
        MyLinkedList<String> listadd = new MyLinkedList<String>();
        for(int i=0;i<4;i++)
        {
            listadd.add(Integer.toString(i));
        }
        listadd.remove("0");
        org.junit.Assert.assertEquals(false, listadd.contains("0"));
    }
    @Test
    public void testget(){
        MyLinkedList<String> listadd = new MyLinkedList<String>();
        for(int i=0;i<4;i++)
        {
            listadd.add(Integer.toString(i));
        }
        org.junit.Assert.assertEquals( "0", listadd.get(0));
    }
}
