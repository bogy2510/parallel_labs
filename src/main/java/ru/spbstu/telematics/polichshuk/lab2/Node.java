package ru.spbstu.telematics.polichshuk.lab2;

/**
 * Created by Bogdan on 04.06.2017.
 */
public class Node<T>
{
    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }
}