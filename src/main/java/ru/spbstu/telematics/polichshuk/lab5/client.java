package ru.spbstu.telematics.polichshuk.lab5;


/**
 * Created by Bogdan on 18.06.2017.
 */
public class client implements Runnable {
    int client_id=3;
    int client_type;
    int bought=0;
    Cheese_market market;
    public void run()
        {
            System.out.println("Who is last? Well it's me. My id is "+client_id+" My type is "+client_type);
            while(true) {
                if (client_id == 0) {
                    System.out.println("New client trying to buy the cheese!");
                    market.get_cheese();
                    while (bought != 1) {
                    }
                    System.out.println("Client have bought the cheese!");
                    return;
                }
                else {
                    synchronized (market.sync) {
                        if (client_id > 1 && client_type == 1 && market.clients.get(client_id - 1).client_type == 2) {
                            System.out.println("Place swap between "+client_id+" and "+(client_id-1));
                            market.clients.set(client_id, market.clients.get(client_id - 1));
                            market.clients.set(client_id - 1, this);
                            market.clients.get(client_id - 1).client_id++;
                            client_id--;
                        }
                    }
                }
            }
        }
    public void cheese()
        {
            bought=1;
        }
    client(int type, Cheese_market market)
    {
        this.client_type=type;
        this.market=market;
    }
}

