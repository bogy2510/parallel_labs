package ru.spbstu.telematics.polichshuk.lab4_server;

/**
 * Created by Bogdan on 18.06.2017.
 */

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server_thread extends Thread{
    private Socket sock;
    private Scanner in;
    private PrintWriter out;

    Server_thread(Socket s){
        sock=s;
        try {
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    void send(String message){
        out.println(message);
        out.flush();//не ждать новых сообщений и пересылать сразу
    }

    void exit(){

        main.delete_me(this);
        out.close();
        in.close();
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            String message="";
            while (true){
                if (in.hasNext()){
                    message = in.nextLine();
                    if (message.equals("__exit"))
                        break;
                    main.send_all(message);
                }
            }
            exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
