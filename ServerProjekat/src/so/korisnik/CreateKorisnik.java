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
public class CreateKorisnik extends AbstractGenericOperation{

    private Korisnik korisnik;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        korisnik = (Korisnik) repository.create((Korisnik)param);
    }
    
    public Korisnik getCreatedKorisnik(){
        return korisnik;
    }
    
}
