/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.korisnik;

import domen.Korisnik;
import operation.AbstractGenericOperation;

/**
 *
 * @author Admin
 */
public class AddKorisnik extends AbstractGenericOperation{
    
    private boolean dodat = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dodat = repository.add((Korisnik)param);
    }
    
    public boolean sacuvano(){
    
        return dodat;
    }
}
