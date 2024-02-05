/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kategorija;

import domen.Karakteristika;
import domen.KategorijaStana;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class GetAllKategorijaStana extends AbstractGenericOperation{
    private List<KategorijaStana> kategorije;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof KategorijaStana)) {
            throw new Exception("Prosledjeni objekat nije instanca klase KategorijaStana!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        kategorije = repository.getAll((KategorijaStana)param);
    }
    
    public List<KategorijaStana> getKategorije(){
        return kategorije;
    }
}
