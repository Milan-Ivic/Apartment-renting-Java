/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.korisnik;

import domen.Korisnik;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class UpdateKorisnik extends AbstractGenericOperation{

    private boolean updatovano = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        updatovano = repository.update((Korisnik)param);
    }
    
    public boolean uspesno(){
    
        return updatovano;
    }
    
}
