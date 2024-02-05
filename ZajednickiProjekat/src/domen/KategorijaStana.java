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
public class KategorijaStana implements GenericEntity{
    
    private int kategorijaStanaID;
    private String nazivKategorije;
    private int brSoba;

    public KategorijaStana() {
    }

    public KategorijaStana(int kategorijaStanaID, String nazivKategorije, int brSoba) {
        this.kategorijaStanaID = kategorijaStanaID;
        this.nazivKategorije = nazivKategorije;
        this.brSoba = brSoba;
    }

    public int getBrSoba() {
        return brSoba;
    }

    public void setBrSoba(int brSoba) {
        this.brSoba = brSoba;
    }

    public int getKategorijaStanaID() {
        return kategorijaStanaID;
    }

    public void setKategorijaStanaID(int kategorijaStanaID) {
        this.kategorijaStanaID = kategorijaStanaID;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }

    @Override
    public String getTableName() {
        return "kategorijastana";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "NazivKategorije, BrSoba";
        
    }

    @Override
    public String getInsertValues() {
         StringBuilder sb = new StringBuilder();
        sb.append(kategorijaStanaID).append(",")
                .append("'").append(nazivKategorije).append("',")
                .append(brSoba);
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return " KategorijaStanaID = " + ((KategorijaStana)object).getKategorijaStanaID();
    }

    @Override
    public void setId(int id) {
        setKategorijaStanaID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT KategorijaStanaID, NazivKategorije, BrSoba FROM kategorijastana";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " KategorijaStanaID = " + ((KategorijaStana)object).getKategorijaStanaID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
       KategorijaStana kategorijaStana = (KategorijaStana)object;
    
       return "NazivKategorije: '" + kategorijaStana.getNazivKategorije() +"' , BrSoba: " + kategorijaStana.getBrSoba();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(kategorijaStanaID);
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "KategorijaStanaID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        KategorijaStana ks = new KategorijaStana(rs.getInt("KategorijaStanaID"), 
                rs.getString("NazivKategorije"), rs.getInt("BrSoba"));
        return ks;
    }

    @Override
    public String toString() {
        return nazivKategorije;
    }
    
    
    
}
