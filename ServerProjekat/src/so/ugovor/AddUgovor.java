/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.ugovor;

import domen.Ugovor;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class AddUgovor extends AbstractGenericOperation{

    private boolean dodat = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Ugovor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ugovor!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dodat = repository.add((Ugovor)param);
    }
    
    public boolean sacuvano(){
    
        return dodat;
    }
}
