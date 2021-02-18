/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pogliani.mattia
 */
public class ServerMultiThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server
                    = new ServerSocket(5500);
            System.out.println("Server è attivo e in ascolto");

            while (true) {
                Socket client = server.accept();
                System.out.println("connessione ricevuta, ora se la smazza il thread");
                Thread Serverino
                        = new Thread(new ServerThread(client));
                Serverino.start();

            }

        } catch (IOException ex) {
            Logger.getLogger(ServerMultiThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
