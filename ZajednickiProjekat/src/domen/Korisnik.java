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
public class Korisnik implements GenericEntity{
    private int korisnikID;
    private String ime;
    private String prezime;
    private String JMBG;
    private boolean status;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, String JMBG, boolean status) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "KorisnikID, Ime, Prezime, JMBG, Status";
    }

    @Override
    public String getInsertValues() {
        
     StringBuilder sb = new StringBuilder();
        sb.append(korisnikID).append(",")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("',")
                .append("'").append(JMBG).append("',")
                .append(status);
        return sb.toString();
    
    }

    @Override
    public String getWhereCondition(Object object) {
       return "KorisnikID: "+ ((Korisnik)object).getKorisnikID();
    }

    @Override
    public void setId(int id) {
        setKorisnikID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT KorisnikID, Ime, Prezime, JMBG, Status FROM korisnik";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
               return " KorisnikID= "+ ((Korisnik)object).getKorisnikID();

    }

    @Override
    public String getUpdateSetValues(Object object) {
        Korisnik korisnik = (Korisnik)object;
        
        return " Ime= '"+ korisnik.getIme() + "' , Prezime= '"+ korisnik.getPrezime() + "' , JMBG= '"+ korisnik.getJMBG() + "', Status= "+korisnik.isStatus()+"";
        
    }

    @Override
    public String getCreateInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(korisnikID);
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "KorisnikID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
       Korisnik k = new Korisnik(rs.getInt("KorisnikID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("JMBG"), rs.getBoolean("Status"));
       return k;
    
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
    
}
