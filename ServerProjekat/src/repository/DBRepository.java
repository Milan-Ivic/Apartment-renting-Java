/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface DBRepository<T> extends Repository<T>{
     default public void connect() throws Exception{
        DatabaseFactoryRepository.getInstance().getConnection();
    }
    
    default public void disconnect() throws Exception{
        DatabaseFactoryRepository.getInstance().getConnection().close();
    }
    
    default public void commit() throws Exception{
        DatabaseFactoryRepository.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws Exception{
        DatabaseFactoryRepository.getInstance().getConnection().rollback();
    }
}
