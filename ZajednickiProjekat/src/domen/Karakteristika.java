/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Karakteristika implements GenericEntity{
    private int karakteristikaID;
    private String nazivKarakteristike;

    public Karakteristika() {
    }

    public Karakteristika(int karakteristikaID, String nazivKarakteristike) {
        this.karakteristikaID = karakteristikaID;
        this.nazivKarakteristike = nazivKarakteristike;
    }

    public String getNazivKarakteristike() {
        return nazivKarakteristike;
    }

    public void setNazivKarakteristike(String nazivKarakteristike) {
        this.nazivKarakteristike = nazivKarakteristike;
    }

    public int getKarakteristikaID() {
        return karakteristikaID;
    }

    public void setKarakteristikaID(int karakteristikaID) {
        this.karakteristikaID = karakteristikaID;
    }

    @Override
    public String getTableName() {
        return "karakteristika";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivKarakteristike";
    }

    @Override
    public String getInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(karakteristikaID).append(",")
                .append("'").append(nazivKarakteristike).append("'");
        return sb.toString();
    
    }

    @Override
    public String getWhereCondition(Object object) {
       return " KarakteristikaID = " + ((Karakteristika)object).getKarakteristikaID();
    }

    @Override
    public void setId(int id) {
        setKarakteristikaID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT KarakteristikaID, NazivKarakteristike FROM karakteristika";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " KarakteristikaID = " + ((Karakteristika)object).getKarakteristikaID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Karakteristika karakteristika = (Karakteristika)object;
        
        return "NazivKarakteristike: '"+karakteristika.getNazivKarakteristike()+"'";
    
    }

    @Override
    public String getCreateInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(karakteristikaID);
                
        return sb.toString();
    
    }

    @Override
    public String getColumnNamesForCreate() {
        return "KarakteristikaID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
       Karakteristika k = new Karakteristika(rs.getInt("KarakteristikaID"), rs.getString("NazivKarakteristike"));
       return k;
    }

    @Override
    public String toString() {
        return nazivKarakteristike;
    }
    
    
    
}
