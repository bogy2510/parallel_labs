package ru.spbstu.telematics.polichshuk.lab4_server;

/**
 * Created by Bogdan on 18.06.2017.
 */

import java.util.LinkedList;
import java.net.*;

public class main {
    private static final String HOST="0.0.0.0";
    private static final int PORT=23456;

    private static Boolean sync=false;

    private static LinkedList <Server_thread> clients=new LinkedList <Server_thread>();

    public static  void send_all(String message){
        synchronized(sync) {
            for (Server_thread client : clients)
                client.send(message);
        }
    }

    public static void delete_me(Server_thread client_to_delete){
        synchronized(sync) {
         //   for (Server_thread client : clients)
          //      if (client_to_delete.equals(client)) {
                    clients.remove(client_to_delete);
            //        return;
            //    }
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT, 0,InetAddress.getByName(HOST));
            while (true){
                clients.add(new Server_thread(server.accept()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
