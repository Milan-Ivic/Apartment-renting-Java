/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.karakteristikaStana;

import domen.Karakteristika;
import domen.Stan;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllKarakteristika extends AbstractGenericOperation{
    
     private List<Karakteristika> karakteristike;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Karakteristika)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Karakteristika!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        karakteristike = repository.getAll((Karakteristika)param);
    }
    
    public List<Karakteristika> getKarakteristike(){
        return karakteristike;
    }
}
