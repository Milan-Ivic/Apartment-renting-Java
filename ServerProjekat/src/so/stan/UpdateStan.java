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
public class UpdateStan extends AbstractGenericOperation{

    private boolean updatovano = false;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stan!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        
        repository.update((Stan)param);
        boolean flag = false;
        boolean uspesno = false;
        
        ArrayList<Adresa> adr = ((Stan)param).getAdrese();
        if(!adr.isEmpty()){
        
            for (Adresa adresa : adr) {
                uspesno = repository.update(adresa);
                if(!uspesno){
                
                    flag = true;
                }
            }
            
        }
        
        if(!flag){
        
            updatovano = true;
        }
        
    }
    
    public boolean uspesno(){
    
        return updatovano;
    }
    
}
