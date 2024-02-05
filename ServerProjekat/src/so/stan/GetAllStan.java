/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stan;

import domen.Adresa;
import domen.Stan;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllStan extends AbstractGenericOperation{

    
    private List<Stan> stan;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stan!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stan = repository.getAll((Stan)param);
//        Adresa a;
//        Adresa adr = new Adresa();
//        ArrayList<Adresa> aaa = new ArrayList<>();
//        
//        for (Stan stan : stan) {
//            adr.setStan(stan);
//            a = (Adresa) repository.getOne(adr);
//            aaa.add(a);
//            stan.setAdrese(aaa);
//            aaa.remove(a);
//            
//        }
        
       
        
    }
    
    public List<Stan> getPolazniks(){
        return stan;
    }
    
}
