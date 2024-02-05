/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.ugovor;

import domen.Ugovor;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllUgovor extends AbstractGenericOperation{

    
    private List<Ugovor> ugovor;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Ugovor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ugovor!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ugovor = repository.getAll((Ugovor)param);
    }
    
    public List<Ugovor> getPolazniks(){
        return ugovor;
    }
    
}
