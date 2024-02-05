/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import handler.ProcessClientRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Server extends Thread{
    private ServerSocket serverSocket;
    List<ProcessClientRequest> activeClients;

    public Server() throws IOException {
        serverSocket = new ServerSocket(9000);
        activeClients = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected!");
                handleClient(socket);
            } catch (Exception ex) {
                System.err.println("Server je iskljucen.");
                //ex.printStackTrace();
            }
        }
        cancelClients();
    }
    
    

    private void handleClient(Socket socket) {
        ProcessClientRequest processClientRequest = new ProcessClientRequest(socket);
        activeClients.add(processClientRequest);
        processClientRequest.start();
    }
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    

    private void cancelClients() {
        
        for (ProcessClientRequest k : activeClients) {
            try {
                k.getSocket().close();
                activeClients.remove(k);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
