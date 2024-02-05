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
public class TipGrejanja implements GenericEntity{
    
    private int tipGrejanjaID;
    private String nazivGrejanja;

    public TipGrejanja() {
    }

    public TipGrejanja(int tipGrejanjaID, String nazivGrejanja) {
        this.tipGrejanjaID = tipGrejanjaID;
        this.nazivGrejanja = nazivGrejanja;
    }
    
    

    @Override
    public String getTableName() {
        return "tipgrejanja";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivGrejanja";
    }

    @Override
    public String getInsertValues() {
     StringBuilder sb = new StringBuilder();
        sb.append(tipGrejanjaID ).append(",")
                .append("'").append(nazivGrejanja).append("'");
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
       return " TipGrejanjaID = " + ((TipGrejanja)object).getTipGrejanjaID();
    }

    @Override
    public void setId(int id) {
        setTipGrejanjaID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT TipGrejanjaID, NazivGrejanja FROM tipgrejanja";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
         return " TipGrejanjaID = " + ((TipGrejanja)object).getTipGrejanjaID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        TipGrejanja tipGrejanja= (TipGrejanja) object;
    
    return "NazivGrejanja="+"'"+tipGrejanja.getNazivGrejanja()+"'";
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(tipGrejanjaID);
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
       return "TipGrejanjaID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        TipGrejanja tg = new TipGrejanja(rs.getInt("TipGrejanjaID"), rs.getString("NazivGrejanja"));
        return tg;
    
    }

    public int getTipGrejanjaID() {
        return tipGrejanjaID;
    }

    public void setTipGrejanjaID(int tipGrejanjaID) {
        this.tipGrejanjaID = tipGrejanjaID;
    }

    public String getNazivGrejanja() {
        return nazivGrejanja;
    }

    public void setNazivGrejanja(String nazivGrejanja) {
        this.nazivGrejanja = nazivGrejanja;
    }

    @Override
    public String toString() {
        return nazivGrejanja;
    }
    
    
}
