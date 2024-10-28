package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;


public class MyThread extends Thread {
    Socket socket;

    public MyThread(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ascolto                                                                              // (ricevere)
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // parla (invia)
            String messaggioRicevuto;
            ArrayList<String> lista=new ArrayList<>();
            do {
                messaggioRicevuto=in.readLine();
                switch (messaggioRicevuto) {
                    case "?":
                        for(int i=0; i<lista.size();i++){
                            out.writeBytes((i+1)+": "+lista.get(i)+ "\n");
                        }
                        out.writeBytes("@"+"\n");
                        break;
                    case "!":
                        break;
                
                    default:
                        lista.add(messaggioRicevuto);

                        out.writeBytes("OK\n");
                        break;
                }

            } while ( !messaggioRicevuto.equals("!"));
            socket.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
