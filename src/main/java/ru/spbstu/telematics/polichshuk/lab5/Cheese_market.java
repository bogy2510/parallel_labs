package ru.spbstu.telematics.polichshuk.lab5;

import java.util.ArrayList;

/**
 * Created by Bogdan on 18.06.2017.
 */
public class Cheese_market {
    public ArrayList<client> clients;
    static Boolean sync = new Boolean(false);

    synchronized void  get_cheese()
    {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        clients.get(0).cheese();
        synchronized (sync) {
            int type_bought = clients.get(0).client_type;
            clients.set(0, clients.get(1));
            clients.get(0).client_id=0;
            clients.set(1, clients.get(2));
            clients.get(1).client_id=1;
            clients.set(2, clients.get(3));
            clients.get(2).client_id=2;
            clients.set(3, new client(type_bought,this));
            new Thread(clients.get(3)).start();
        }

    }
    Cheese_market()
    {
        clients = new ArrayList<client>();
        for (int i=0;i<4;i++)
        {
            clients.add(new client(2-i/2,this));
            clients.get(i).client_id=i;
            System.out.println("Yet another client have joined the queue!");
        }
        for (int i=0;i<4;i++) {
            new Thread(clients.get(i)).start();
        }

    }

}
