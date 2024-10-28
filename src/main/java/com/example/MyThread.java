package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyThread extends Thread {
    Socket socket;

    public MyThread(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ascolto                                                                              // (ricevere)
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // parla (invia)

            do {
                
            } while (true);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
