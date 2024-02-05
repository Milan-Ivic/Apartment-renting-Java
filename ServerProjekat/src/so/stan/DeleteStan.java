/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stan;

import domen.Adresa;
import domen.Stan;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class DeleteStan extends AbstractGenericOperation{

    private boolean uspesno = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stan!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        
        ArrayList<Adresa> adrese = ((Stan)param).getAdrese();
        
        boolean flag = repository.delete(adrese.get(0));
        if(flag){
         uspesno = repository.delete((Stan)param);
        }
    }
    
    public boolean obrisano(){
        return uspesno;
    }
}
