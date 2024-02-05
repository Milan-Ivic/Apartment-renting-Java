/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.korisnik;

import domen.Korisnik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllKorisnik extends AbstractGenericOperation{

    
    private List<Korisnik> polaznici;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Polaznik!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        polaznici = repository.getAll((Korisnik)param);
    }
    
    public List<Korisnik> getPolazniks(){
        return polaznici;
    }
    
}
