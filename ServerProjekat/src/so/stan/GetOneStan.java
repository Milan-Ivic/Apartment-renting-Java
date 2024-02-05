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
public class GetOneStan extends AbstractGenericOperation{
    private Stan stan;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Stan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stan!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stan = (Stan) repository.getOne((Stan)param);
    }
    
    public Stan getPolaznik(){
        return stan;
    }
}
