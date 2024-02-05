/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domen.Adresa;
import domen.Karakteristika;
import domen.KategorijaStana;
import domen.Korisnik;
import domen.Stan;
import domen.TipGrejanja;
import domen.Ugovor;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Communication {
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request;
    Response response;
    private static Communication instance;
    
    private Communication() throws IOException{
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);   
    }
    
    public static Communication getInstance() throws IOException{
        if(instance==null){
            instance = new Communication();
        }
        
        return instance;
    }
    
    public Object logIn(String username,String password){
        try {
            Zaposleni user = new Zaposleni(-1, username, password, null, null);
            request = new Request(Operation.LOGIN,user);
            sender.send(request);
            System.out.println("Poslao zahtev");
            response = (Response) receiver.receive();
            System.out.println("Primio zahtev");
            if(response.getException()==null){
                return response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object addKorisnik(Korisnik k) {
        try {
            request = new Request(Operation.ADD, k);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Korisnik createKorisnik(Korisnik ko) {
        try {
            request = new Request(Operation.CREATE,ko);
            sender.send(request);
            response = (Response)receiver.receive();
            return (Korisnik) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Object updateKorisnik(Korisnik k) {
        try {
            request = new Request(Operation.UPDATE, k);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList<Korisnik> getAllKorisnik() {
        try {
            request = new Request(Operation.GET,new Korisnik());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Korisnik>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object deleteKorisnik(Korisnik kor) {
        try {
            request = new Request(Operation.DELETE, kor);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Stan createStan(Stan stan) {
         try {
            request = new Request(Operation.CREATE,stan);
            sender.send(request);
            response = (Response)receiver.receive();
            return (Stan) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updateStan(Stan stan) {
        try {
            request = new Request(Operation.UPDATE, stan);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList<KategorijaStana> getAllKategorije() {
        try {
            request = new Request(Operation.GET,new KategorijaStana());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<KategorijaStana>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<TipGrejanja> getAllTipGrejanja() {
        try {
            request = new Request(Operation.GET,new TipGrejanja());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<TipGrejanja>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Karakteristika> getAllKarakteristika() {
        try {
            request = new Request(Operation.GET,new Karakteristika());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Karakteristika>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Stan> getAllStanovi() {
         try {
            request = new Request(Operation.GET,new Stan());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Stan>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Adresa> getAllAdrese() {
         try {
            request = new Request(Operation.GET,new Adresa());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Adresa>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object deleteStan(Stan sta) {
        try {
            request = new Request(Operation.DELETE, sta);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object addUgovor(Ugovor u) {
        try {
            request = new Request(Operation.ADD, u);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList<Ugovor> getAllUgovor() {
        try {
            request = new Request(Operation.GET,new Ugovor());
            sender.send(request);
            response = (Response) receiver.receive();
            return (ArrayList<Ugovor>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updateUgovor(Ugovor u) {
        try {
            request = new Request(Operation.UPDATE, u);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Ugovor createUgovor(Ugovor ugovor) {
        try {
            request = new Request(Operation.CREATE,ugovor);
            sender.send(request);
            response = (Response)receiver.receive();
            return (Ugovor) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
