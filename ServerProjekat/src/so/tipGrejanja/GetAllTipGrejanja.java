/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tipGrejanja;

import domen.Karakteristika;
import domen.TipGrejanja;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllTipGrejanja extends AbstractGenericOperation{
    private List<TipGrejanja> tipovi;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof TipGrejanja)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipGrejanja!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tipovi = repository.getAll((TipGrejanja)param);
    }
    
    public List<TipGrejanja> getTipoviGrejanja(){
        return tipovi;
    }
}
