/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stan;

import domen.Stan;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class AddStan extends AbstractGenericOperation{

    private boolean dodat = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stan!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dodat = repository.add((Stan)param);
    }
    
    public boolean sacuvano(){
    
        return dodat;
    }
}
