/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaposleni;

import domen.Zaposleni;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Admin
 */
public class GetAllZaposleni extends AbstractGenericOperation{
    
    private List<Zaposleni> zaposleni;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        zaposleni = repository.getAll((Zaposleni)param);
    }
    
    public List<Zaposleni> getZaposleni(){
        return zaposleni;
    }

}
