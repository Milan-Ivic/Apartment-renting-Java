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
public class CreateStan extends AbstractGenericOperation{

    private Stan stan;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stan!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        
        
        stan = (Stan) repository.create((Stan)param);
        
        ArrayList<Adresa> adrese = ((Stan)param).getAdrese();
        if(!adrese.isEmpty()){
        Adresa a = new Adresa();
        for (Adresa adresa : adrese) {
            a = adresa;
        }
        Adresa prazna = (Adresa) repository.create(a);
        ArrayList<Adresa> adresee = new ArrayList<>();
        adresee.add(prazna);
        stan.setAdrese(adresee);
        }
        
        
    }
    
    public Stan getCreatedKurs(){
        return stan;
    }
    
}
