/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Adresa;
import domen.Karakteristika;
import domen.KategorijaStana;
import domen.Korisnik;
import domen.Stan;
import domen.TipGrejanja;
import domen.Ugovor;
import domen.Zaposleni;
import operation.AbstractGenericOperation;
import repository.Repository;
import so.adresa.GetAllAdresa;
import so.karakteristikaStana.GetAllKarakteristika;
import so.kategorija.GetAllKategorijaStana;
import so.korisnik.AddKorisnik;
import so.korisnik.CreateKorisnik;
import so.korisnik.DeleteKorisnik;
import so.korisnik.GetAllKorisnik;
import so.korisnik.UpdateKorisnik;
import so.login.Login;
import so.stan.CreateStan;
import so.stan.DeleteStan;
import so.stan.GetAllStan;
import so.stan.UpdateStan;
import so.tipGrejanja.GetAllTipGrejanja;
import so.ugovor.AddUgovor;
import so.ugovor.CreateUgovor;
import so.ugovor.GetAllUgovor;
import so.ugovor.UpdateUgovor;

/**
 *
 * @author Admin
 */
public class Controller {
     private static Controller instance;
    private AbstractGenericOperation operation;

    public Controller() {
    }

    public static Controller getInstance() {
        if(instance==null){
        
            instance = new Controller();
        }
        return instance;
    }
     public boolean add(Object argument) throws Exception {
        if(argument instanceof Korisnik) return addKorisnik(argument);
        if(argument instanceof Ugovor) return addUgovor(argument);
        
        return false;
    }
     
     public Object getAll(Object argument) throws Exception {
        if(argument instanceof Korisnik) return getAllKorisnik(argument);
        if(argument instanceof Karakteristika) return getAllKarakteristika(argument);
        if(argument instanceof TipGrejanja) return getAllTipGrejanja(argument);
        if(argument instanceof KategorijaStana) return getAllKategorijaStana(argument);
        if(argument instanceof Stan) return getAllStan(argument);
        if(argument instanceof Adresa) return getAllAdresa(argument);
        if(argument instanceof Ugovor) return getAllUgovor(argument);
        
        return null;
        
    }
     
     public boolean update(Object argument) throws Exception {
       if(argument instanceof Korisnik) return updateKorisnik(argument);
       if(argument instanceof Stan) return updateStan(argument);
       if(argument instanceof Ugovor) return updateUgovor(argument);
        return false;
    }
     
      public Object create(Object argument) throws Exception {
        if(argument instanceof Korisnik) return createKorisnik(argument);
        if(argument instanceof Stan) return createStan(argument);
        if(argument instanceof Ugovor) return createUgovor(argument);
        
        return null;
    }
      public boolean delete(Object argument) throws Exception {
        if(argument instanceof Korisnik) return deleteKorisnik(argument);
        if(argument instanceof Stan) return deleteStan(argument);
        
        return false;
    }
      
      public Object getOne(Object argument) throws Exception {
       
        return null;
    }
      
     
    
    public Object login(Zaposleni user) throws Exception{
        operation = new Login();
        operation.execute(user);
        return ((Login)operation).getLogin();
    }

    private boolean addKorisnik(Object argument) throws Exception {
        operation = new AddKorisnik();
        operation.execute(argument);
        return ((AddKorisnik)operation).sacuvano();
    }

    private Object createKorisnik(Object argument) throws Exception {
        operation = new CreateKorisnik();
        operation.execute(argument);
        return ((CreateKorisnik)operation).getCreatedKorisnik();
    }

    private boolean updateKorisnik(Object argument) throws Exception {
        operation = new UpdateKorisnik();
        operation.execute(argument);
        return ((UpdateKorisnik)operation).uspesno();
    }

    private Object getAllKorisnik(Object argument) throws Exception {
        operation = new GetAllKorisnik();
        operation.execute(argument);
        return ((GetAllKorisnik)operation).getPolazniks();
    }

    private boolean deleteKorisnik(Object argument) throws Exception {
        operation = new DeleteKorisnik();
        operation.execute(argument);
        return ((DeleteKorisnik)operation).obrisano();
    }

    private Object createStan(Object argument) throws Exception {
        operation = new CreateStan();
        operation.execute(argument);
        return ((CreateStan)operation).getCreatedKurs();
    }

    private boolean updateStan(Object argument) throws Exception {
        operation = new UpdateStan();
        operation.execute(argument);
        return ((UpdateStan)operation).uspesno();
    }

    private Object getAllKarakteristika(Object argument) throws Exception {
        operation = new GetAllKarakteristika();
        operation.execute(argument);
        return ((GetAllKarakteristika)operation).getKarakteristike();
    }

    private Object getAllTipGrejanja(Object argument) throws Exception {
        operation = new GetAllTipGrejanja();
        operation.execute(argument);
        return ((GetAllTipGrejanja)operation).getTipoviGrejanja();
    }

    private Object getAllKategorijaStana(Object argument) throws Exception {
        operation = new GetAllKategorijaStana();
        operation.execute(argument);
        return ((GetAllKategorijaStana)operation).getKategorije();
    }

    private Object getAllStan(Object argument) throws Exception {
        operation = new GetAllStan();
        operation.execute(argument);
        return ((GetAllStan)operation).getPolazniks();
    }

    private Object getAllAdresa(Object argument) throws Exception {
        operation = new GetAllAdresa();
        operation.execute(argument);
        return ((GetAllAdresa)operation).getPolazniks();
    }

    private boolean deleteStan(Object argument) throws Exception {
        operation = new DeleteStan();
        operation.execute(argument);
        return ((DeleteStan)operation).obrisano();
    }

    private boolean addUgovor(Object argument) throws Exception {
        operation = new AddUgovor();
        operation.execute(argument);
        return ((AddUgovor)operation).sacuvano();
    }

    private Object getAllUgovor(Object argument) throws Exception {
        operation = new GetAllUgovor();
        operation.execute(argument);
        return ((GetAllUgovor)operation).getPolazniks();
    }

    private boolean updateUgovor(Object argument) throws Exception {
        operation = new UpdateUgovor();
        operation.execute(argument);
        return ((UpdateUgovor)operation).uspesno();
    }

    private Object createUgovor(Object argument) throws Exception {
        operation = new CreateUgovor();
        operation.execute(argument);
        return ((CreateUgovor)operation).getCreatedKurs();
    }

  

    

}
