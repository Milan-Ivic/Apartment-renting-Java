/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handler;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domen.Zaposleni;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProcessClientRequest extends Thread{
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request = null;
    Response response = null;
    
    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while(true){
        
            try {
                request = (Request) receiver.receive();
                response = new Response();
                switch (request.getOperation()) {
                    case LOGIN:
                        Zaposleni user = (Zaposleni) request.getArgument();
                        
                        
                        response.setResult(Controller.getInstance().login(user));
                       
                        break;
                        case ADD:
                        response.setResult(Controller.getInstance().add(request.getArgument()));
                        break;
                        case GET:
                        response.setResult(Controller.getInstance().getAll(request.getArgument()));
                        break;
                        case UPDATE:
                        response.setResult(Controller.getInstance().update(request.getArgument()));
                        break;
                        case CREATE:
                        response.setResult(Controller.getInstance().create(request.getArgument()));
                        break;
                        case DELETE:
                        response.setResult(Controller.getInstance().delete(request.getArgument()));
                        break;
                        case GET_ONE:
                        response.setResult(Controller.getInstance().getOne(request.getArgument()));
                        break;
                        
                   default:
                        throw new AssertionError();
                }
                sender.send(response);
            } catch (Exception ex) {
                System.out.println("Nema odgovora.");
                Logger.getLogger(ProcessClientRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
     public Socket getSocket() {
        return socket;
    }
    
}
