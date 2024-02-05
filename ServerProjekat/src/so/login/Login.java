/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import domen.Zaposleni;
import java.util.List;
import operation.AbstractGenericOperation;
import so.zaposleni.GetAllZaposleni;

/**
 *
 * @author Admin
 */
public class Login extends AbstractGenericOperation{
    private Object login;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Zaposleni user = (Zaposleni)param;
        
            
            AbstractGenericOperation ago = new GetAllZaposleni();
            ago.execute(new Zaposleni());
            List<Zaposleni> zaposleni = ((GetAllZaposleni)ago).getZaposleni();

            if(!zaposleni.isEmpty()){
            for(Zaposleni zap:zaposleni){
                

                if(zap.getUsername().equals(user.getUsername()) && zap.getLoznika().equals(user.getLoznika())){
                    login = zap;
                    break;
                }
                else{
                    login = null;
                }
            }
            }
            
            
              
    }
    
    public Object getLogin(){
        return login;
    }
    
}
