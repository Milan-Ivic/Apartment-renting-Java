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
public class Adresa implements GenericEntity{
    
    private int adresaID;
    private Stan stan;
    private String nazivUlice;
    private int brojZgrade;
    private String oznakaStana;
    private String grad;

    public Adresa() {
    }

    public Adresa(int adresaID, Stan stan, String nazivUlice, int brojZgrade, String oznakaStana, String grad) {
        this.adresaID = adresaID;
        this.stan = stan;
        this.nazivUlice = nazivUlice;
        this.brojZgrade = brojZgrade;
        this.oznakaStana = oznakaStana;
        this.grad = grad;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getAdresaID() {
        return adresaID;
    }

    public void setAdresaID(int adresaID) {
        this.adresaID = adresaID;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    public String getNazivUlice() {
        return nazivUlice;
    }

    public void setNazivUlice(String nazivUlice) {
        this.nazivUlice = nazivUlice;
    }

    public int getBrojZgrade() {
        return brojZgrade;
    }

    public void setBrojZgrade(int brojZgrade) {
        this.brojZgrade = brojZgrade;
    }

    public String getOznakaStana() {
        return oznakaStana;
    }

    public void setOznakaStana(String oznakaStana) {
        this.oznakaStana = oznakaStana;
    }

    @Override
    public String getTableName() {
        return "adresa";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "AdresaID, StanID, NazivUlice, BrojZgrade, OznakaStana, Grad";
    }

    @Override
    public String getInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(adresaID).append(",")
        .append(stan.getStanID()).append(",")
                .append("'").append(nazivUlice).append("',")
                .append(brojZgrade).append(",")
                .append("'").append(oznakaStana).append("',")
                .append("'").append(grad).append("'");
        return sb.toString();
    
    }

    @Override
    public String getWhereCondition(Object object) {
         return " StanID = " + ((Adresa)object).getStan().getStanID();
    }

    @Override
    public void setId(int id) {
        setAdresaID(id);
    }

    @Override
    public String getSelectValues() {
       return "SELECT a.adresaID , a.stanID, a.nazivUlice, a.brojZgrade , a.oznakaStana, a.grad,"
               + "  "
               + " s.stanID, s.kvadratura, s.cena, s.valuta, s.imeVlasnika, s.prezimeVlasnika, s.kontaktTelefon, s.brSpratovaZgrade,"
               + " s.sprat, s.status, s.kategorijaStanaID, s.tipGrejanjaID, s.karakteristikaID, "
               + " ks.kategorijaStanaID, ks.nazivKategorije, ks.brSoba,"
               + " tg.tipGrejanjaID, tg.nazivGrejanja, ka.karakteristikaID, ka.nazivKarakteristike "
               + " FROM ADRESA AS a  "
               + " INNER JOIN STAN AS s ON (a.stanID = s.stanID) "
               + " INNER JOIN KATEGORIJASTANA AS ks ON(s.kategorijaStanaID = ks.kategorijaStanaID) "
               + " INNER JOIN TIPGREJANJA AS tg ON(s.tipGrejanjaID = tg.tipGrejanjaID) "
               + " INNER JOIN KARAKTERISTIKA AS ka ON (s.karakteristikaID = ka.karakteristikaID)";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " AdresaID= "+ ((Adresa)object).getAdresaID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Adresa adresa = (Adresa)object;
        
        return "NazivUlice= '"+ adresa.getNazivUlice() + "' , BrojZgrade= "+ adresa.getBrojZgrade() + ", OznakaStana= '"+ adresa.getOznakaStana()+"', "
                + " Grad = '" + adresa.getGrad() + "'";
    }

    @Override
    public String getCreateInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(adresaID).append(",")
                .append(stan.getStanID());
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
       return "AdresaID, StanID";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
         KategorijaStana ks = new KategorijaStana(rs.getInt("KategorijaStanaID"), 
                rs.getString("NazivKategorije"), rs.getInt("BrSoba"));
         
         TipGrejanja tg = new TipGrejanja(rs.getInt("TipGrejanjaID"), rs.getString("NazivGrejanja"));
        
          Karakteristika karak = new Karakteristika(rs.getInt("KarakteristikaID"), rs.getString("NazivKarakteristike"));
         
         
        Stan s = new Stan(rs.getInt("StanID"), rs.getDouble("Kvadratura"), 
                rs.getDouble("Cena"), rs.getString("Valuta"), rs.getString("ImeVlasnika"), 
                rs.getString("PrezimeVlasnika"), rs.getString("KontaktTelefon"), 
                rs.getInt("BrSpratovaZgrade"), rs.getInt("Sprat"), rs.getBoolean("Status"), 
                ks, tg, karak);
        
  
      
         Adresa a = new Adresa(rs.getInt("AdresaID"), s, rs.getString("NazivUlice"), 
                 rs.getInt("BrojZgrade"), rs.getString("OznakaStana"), rs.getString("Grad"));
         return a;
         
    
    }

    @Override
    public String toString() {
        return nazivUlice + " " + brojZgrade;
    }
    
    
    
    
}
