/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domen.GenericEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.DBRepository;
import repository.DatabaseFactoryRepository;

/**
 *
 * @author Admin
 */
public class RepositoryDBGeneric implements DBRepository<GenericEntity>{
     @Override
    public GenericEntity create(GenericEntity entity) {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                int id = rsKey.getInt(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
            
            return entity;
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             return null;
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;        
        }
    }

    @Override
    public boolean update(GenericEntity entity) {
         try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ").append(entity.getUpdateSetValues(entity))
                    .append(" WHERE ").append(entity.getDeleteAndUpdateCondition(entity));
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean add(GenericEntity entity) {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                int id = rsKey.getInt(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
            return true;
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             return false;
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(GenericEntity entity) {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ").append(entity.getDeleteAndUpdateCondition(entity));
            Statement statement = connection.createStatement();
            String query = sb.toString();
            System.out.println(query);
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity entity) {
         List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValues());
            String query = sb.toString();
            System.out.println(query);
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                entities.add(entity.getNewObject(rs));
            }
            
            return entities;
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public GenericEntity getOne(GenericEntity entity) {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValues())
                    .append(" WHERE ").append(entity.getWhereCondition(entity));
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            if(rs.next()){
                return entity.getNewObject(rs);
            }
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
}
