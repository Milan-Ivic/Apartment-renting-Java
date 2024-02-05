/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.adresa;

import domen.Adresa;

import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Admin
 */
public class GetAllAdresa extends AbstractGenericOperation{
    private List<Adresa> adrese;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Adresa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Adresa!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        adrese = repository.getAll((Adresa)param);
    }
    
    public List<Adresa> getPolazniks(){
        return adrese;
    }
    
}
