package ru.spbstu.telematics.polichshuk.lab4_client;

/**
 * Created by Bogdan on 18.06.2017.
 */
import javax.swing.*;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class client extends JFrame {
    private final String HOST="192.168.0.56";
    private final int PORT=23456;
    private String clientNameStr="";
    private JTextArea messagesField;
    private JTextField clientMessage;
    private JLabel clientName;
    private JButton ok;
    private JPanel clientMessagesPanel;

    private Socket sock;
    private Scanner in;
    private PrintWriter out;

    void SetConnection() throws UnknownHostException, IOException, ConnectException{
        sock = new Socket(InetAddress.getByName(HOST), PORT);
        in = new Scanner(sock.getInputStream());
        out = new PrintWriter(sock.getOutputStream());
    }

    void send(){
        String mes=clientMessage.getText();
        if (clientNameStr.equals("")){
            clientNameStr=clientMessage.getText();
            clientName.setText(clientNameStr+": ");
            out.println(clientNameStr+" entered the chat");
            out.flush();
        }
        else {
            out.println(clientNameStr+": "+mes);
            out.flush();
        }
        clientMessage.setText("");
    }

    void recv(){
        String mes = in.nextLine();
        messagesField.append(mes+"\n");
    }

    void end() throws IOException{
        out.println(clientNameStr+" leaves the chat");
        out.println("__exit");
        out.flush();
        out.close();
        in.close();
        sock.close();
    }

    void SetGUI(){
        setTitle("Chat");
        setBounds(0,0,1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        messagesField = new JTextArea();
        messagesField.setEditable(false);
        messagesField.setForeground(Color.BLACK);
        messagesField.setBackground(Color.LIGHT_GRAY);
        add(messagesField, BorderLayout.CENTER);

        clientName = new JLabel("Enter your name: ");
        clientMessage = new JTextField();
        clientMessage.setForeground(Color.BLACK);
        ok = new JButton("Send");
        clientMessagesPanel = new JPanel(new BorderLayout());
        clientMessagesPanel.add(clientName,BorderLayout.WEST);
        clientMessagesPanel.add(clientMessage,BorderLayout.CENTER);
        clientMessagesPanel.add(ok,BorderLayout.EAST);
        add(clientMessagesPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    client(){
        SetGUI();
        try {
            SetConnection();
        } catch (ConnectException e) {
            messagesField.append("Cannot connect to host: "+HOST+":"+PORT);
            return;
        }  catch (UnknownHostException e) {
            messagesField.append("Cannot resolve host: "+HOST);
            return;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (!clientMessage.getText().isEmpty()) {
                    send();
                }
            }
        });
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            recv();
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    end();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}