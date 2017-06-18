package ru.spbstu.telematics.polichshuk.lab2;

import org.apache.commons.math3.exception.NullArgumentException;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
/**
 * Created by Bogdan on 04.06.2017.
 */
public class MyLinkedList<T> implements List<T>, Iterable<T>
{
    private Node<T> head;
    private int counter;
    public MyLinkedList()
    {
        head=null;
        counter=0;
    }
    public void addFirst(T item)
    {
        head = new Node<T>(item, head);
    }
    @Override
    public boolean add(T item)
    {
        if( head == null)
            addFirst(item);
        else
        {
            Node<T> tmp = head;
            while(tmp.next != null) tmp = tmp.next;

            tmp.next = new Node<T>(item, null);
        }
        counter++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        T key =(T)o;
        if(head == null)
            throw new RuntimeException("cannot delete");

        if( head.data.equals(key) )
        {
            head = head.next;
            counter--;
            return false;
        }

        Node<T> cur  = head;
        Node<T> prev = null;

        while(cur != null && !cur.data.equals(key) )
        {
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
        counter--;
        return true;
    }

    public int size()
    {
        return counter;
    }

    @Override
    public T get(int index)
    {
        if (head==null) throw new IndexOutOfBoundsException();
        Node<T> tmp = head;
        for (int k=0;k<index;k++) tmp=tmp.next;
        if (tmp==null) throw new IndexOutOfBoundsException();
        return tmp.data;
    }

    @Override
    public boolean contains(Object o) {
        T x=(T)o;
        for (T tmp: this)
            if(tmp.equals(x)) return true;
        return false;
    }

    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private Node<T> nextNode = head;

            public boolean hasNext()
            {
                return nextNode != null;
            }

            public T next()
            {
                if (!hasNext()) throw new NullArgumentException();
                T res = nextNode.data;
                nextNode = nextNode.next;
                return res;
            }

            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    @Override
    public T remove(int index)
    {
        return null;
    }
    @Override
    public void add(int index, T element) {
// TODO Auto-generated method stub

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
// TODO Auto-generated method stub

    }

    @Override
    public boolean containsAll(Collection<?> c) {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public int indexOf(Object o) {
// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
// TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public T set(int index, T element) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
// TODO Auto-generated method stub
        return null;
    }
}
