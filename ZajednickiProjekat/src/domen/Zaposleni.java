/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class Zaposleni implements GenericEntity{
    
    private int ZaposleniID;
    private String ime;
    private String prezime;
    private String username;
    private String loznika;

    public Zaposleni() {
    }

    public Zaposleni(int ZaposleniID, String username, String loznika, String ime, String prezime) {
        this.ZaposleniID = ZaposleniID;
        this.username = username;
        this.loznika = loznika;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getZaposleniID() {
        return ZaposleniID;
    }

    public void setZaposleniID(int ZaposleniID) {
        this.ZaposleniID = ZaposleniID;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoznika() {
        return loznika;
    }

    public void setLoznika(String loznika) {
        this.loznika = loznika;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    
    
    

    @Override
    public String getTableName() {
        return "zaposleni";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " ime, prezime, username, lozinka ";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("'").append(ime).append("'").append(",")
                .append("'").append(prezime).append("'").append(",")
                .append("'").append(username).append("'").append(",")
                .append("'").append(loznika).append("'");
                
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return " zaposleniID = " + ((Zaposleni)object).getZaposleniID();
    }

    @Override
    public void setId(int id) {
        setZaposleniID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT zaposleniID, ime, prezime, username, lozinka FROM zaposleni";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
         return " zaposleniID = " + ((Zaposleni)object).getZaposleniID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Zaposleni zap = (Zaposleni)object;
        return "username = '" + zap.getUsername() + "' , lozinka = '" + zap.getLoznika() + "', ime = '" + zap.getIme() + "', prezime = '" + zap.getPrezime() + "'";
    }

    @Override
    public String getCreateInsertValues() {
        return ZaposleniID + "";
    }

    @Override
    public String getColumnNamesForCreate() {
        return "zaposleniID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Zaposleni z = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("username"), rs.getString("lozinka"), 
        rs.getString("ime"), rs.getString("prezime"));
        return z;
    }
    
    
    
}
