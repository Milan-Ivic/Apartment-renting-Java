/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Stan implements GenericEntity{
    private int stanID;
    private double kvadratura;
    private double cena;
    private String valuta;
    private String imeVlasnika;
    private String prezimeVlasnika;
    private String kontaktTelefon;
    private int brSpratovaZgrade;
    private int sprat;
    private boolean status;
    private KategorijaStana kategorijaStana;
    private TipGrejanja tipGrejanja;
    private Karakteristika karakteristika;
    private ArrayList<Adresa> adrese;

    public Stan() {
    }

    public Stan(int stanID, double kvadratura, double cena, String valuta, String imeVlasnika, String prezimeVlasnika,
            String kontaktTelefon, int brSpratovaZgrade, int sprat, boolean status, KategorijaStana kategorijaStana, 
            TipGrejanja tipGrejanja, Karakteristika karakteristika) {
        this.stanID = stanID;
        this.kvadratura = kvadratura;
        this.cena = cena;
        this.valuta = valuta;
        this.imeVlasnika = imeVlasnika;
        this.prezimeVlasnika = prezimeVlasnika;
        this.kontaktTelefon = kontaktTelefon;
        this.brSpratovaZgrade = brSpratovaZgrade;
        this.sprat = sprat;
        this.status = status;
        this.kategorijaStana = kategorijaStana;
        this.tipGrejanja = tipGrejanja;
        this.karakteristika = karakteristika;
    }

    public Karakteristika getKarakteristika() {
        return karakteristika;
    }

    public void setKarakteristika(Karakteristika karakteristika) {
        this.karakteristika = karakteristika;
    }

    public ArrayList<Adresa> getAdrese() {
        return adrese;
    }

    public void setAdrese(ArrayList<Adresa> adrese) {
        this.adrese = adrese;
    }

  

    

    public TipGrejanja getTipGrejanja() {
        return tipGrejanja;
    }

    public void setTipGrejanja(TipGrejanja tipGrejanja) {
        this.tipGrejanja = tipGrejanja;
    }

    public int getStanID() {
        return stanID;
    }

    public void setStanID(int stanID) {
        this.stanID = stanID;
    }

    public double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(double kvadratura) {
        this.kvadratura = kvadratura;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getImeVlasnika() {
        return imeVlasnika;
    }

    public void setImeVlasnika(String imeVlasnika) {
        this.imeVlasnika = imeVlasnika;
    }

    public String getPrezimeVlasnika() {
        return prezimeVlasnika;
    }

    public void setPrezimeVlasnika(String prezimeVlasnika) {
        this.prezimeVlasnika = prezimeVlasnika;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public int getBrSpratovaZgrade() {
        return brSpratovaZgrade;
    }

    public void setBrSpratovaZgrade(int brSpratovaZgrade) {
        this.brSpratovaZgrade = brSpratovaZgrade;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public KategorijaStana getKategorijaStana() {
        return kategorijaStana;
    }

    public void setKategorijaStana(KategorijaStana kategorijaStana) {
        this.kategorijaStana = kategorijaStana;
    }

    @Override
    public String getTableName() {
        return "stan";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "StanID, Kvadratura, Cena, Valuta, ImeVlasnika, PrezimeVlasnika, KontaktTelefon, BrSpratovaZgrade, Sprat, Status, KategorijaStanaID, TipGrejanjaID, KarakteristikaID";
    }

    @Override
    public String getInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(stanID).append(",")
                .append(kvadratura).append(",")
                .append(cena).append(",")
                .append("'").append(valuta).append("',")
                .append("'").append(imeVlasnika).append("',")
                .append("'").append(prezimeVlasnika).append("',")
                .append("'").append(kontaktTelefon).append("',")
                .append(brSpratovaZgrade).append(",")
                .append(sprat).append(",")
                .append(status).append(",")
                .append(kategorijaStana.getKategorijaStanaID()).append(",")
                .append(kategorijaStana.getKategorijaStanaID()).append(",")
                .append(karakteristika.getKarakteristikaID());
        return sb.toString();

    
    }

    @Override
    public String getWhereCondition(Object object) {
       return " StanID = " + ((Stan)object).getStanID();
    }

    @Override
    public void setId(int id) {
        setStanID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT s.stanID, s.kvadratura, s.cena, s.valuta, s.imeVlasnika, s.prezimeVlasnika, s.kontaktTelefon, s.brSpratovaZgrade,"
                + " s.sprat, s.status, s.kategorijaStanaID, s.tipGrejanjaID, ks.kategorijaStanaID, ks.nazivKategorije, ks.brSoba,"
                + " tg.tipGrejanjaID, tg.nazivGrejanja, "
                + " kar.karakteristikaID, kar.nazivKarakteristike FROM STAN AS s "
                + " INNER JOIN KATEGORIJASTANA AS ks ON(s.kategorijaStanaID = ks.kategorijaStanaID) "
                + " INNER JOIN TIPGREJANJA AS tg ON(s.tipGrejanjaID = tg.tipGrejanjaID)"
                + " INNER JOIN KARAKTERISTIKA AS kar ON (s.karakteristikaID = kar.karakteristikaID)";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "  StanID = " + ((Stan)object).getStanID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
       Stan stan = (Stan)object;
       
       return "Kvadratura= "+ stan.getKvadratura() + ", Cena= "+stan.getCena() + ", Valuta= '"+stan.getValuta()+"' , ImeVlasnika= '"+stan.getImeVlasnika()+"' ,"
               + " PrezimeVlasnika= '" + stan.getPrezimeVlasnika()+"' , KontaktTelefon = '" + stan.getKontaktTelefon() + "' ,"
               + " BrSpratovaZgrade = "+stan.getBrSpratovaZgrade()+" , Sprat = "+stan.getSprat()+" , Status= "+ stan.isStatus() + " ,"
               + " KategorijaStanaID= "+ stan.getKategorijaStana().getKategorijaStanaID() +", TipGrejanjaID= "+stan.getTipGrejanja().getTipGrejanjaID()+","
               + " KarakteristikaID= "+stan.getKarakteristika().getKarakteristikaID() ;
        
    }

    @Override
    public String getCreateInsertValues() {
       StringBuilder sb = new StringBuilder();
        sb.append(stanID);
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return " StanID";
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
    return s;
    }

    @Override
    public String toString() {
        return imeVlasnika + " " + prezimeVlasnika;
    }
    
    
    
}
