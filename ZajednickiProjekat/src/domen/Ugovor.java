/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Ugovor implements GenericEntity{
    private int ugovorID;
    private Date datumSklapanja;
    private Date datumOd;
    private Date datumDo;
    private double cena;
    private double iznosProvizije;
    private String valuta;
    private String napomena;
    private Stan stan;
    private Korisnik korisnik;

    public Ugovor() {
    }

    public Ugovor(int ugovorID, Date datumSklapanja, Date datumOd, Date datumDo, double cena, 
            double iznosProvizije, String valuta, String napomena, Stan stan, Korisnik korisnik) {
        this.ugovorID = ugovorID;
        this.datumSklapanja = datumSklapanja;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.cena = cena;
        this.iznosProvizije = iznosProvizije;
        this.valuta = valuta;
        this.napomena = napomena;
        this.stan = stan;
        this.korisnik = korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getUgovorID() {
        return ugovorID;
    }

    public void setUgovorID(int ugovorID) {
        this.ugovorID = ugovorID;
    }

    public Date getDatumSklapanja() {
        return datumSklapanja;
    }

    public void setDatumSklapanja(Date datumSklapanja) {
        this.datumSklapanja = datumSklapanja;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getIznosProvizije() {
        return iznosProvizije;
    }

    public void setIznosProvizije(double iznosProvizije) {
        this.iznosProvizije = iznosProvizije;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    @Override
    public String getTableName() {
        
        return "ugovor";
    }

    @Override
    public String getColumnNamesForInsert() {
       return "DatumSklapanja, DatumOd, DatumDo, Cena, IznosProvizije, Valuta, Napomena, StanID, KorisnikID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("'").append((new java.sql.Date(datumSklapanja.getTime())).toString()).append("'").append(",")
                .append("'").append((new java.sql.Date(datumOd.getTime())).toString()).append("'").append(",")
                .append("'").append((new java.sql.Date(datumDo.getTime())).toString()).append("'").append(",")
                .append(cena).append(",")
                .append(iznosProvizije).append(",")
                .append("'").append(valuta).append("',")
                .append("'").append(napomena).append("',")
                .append(stan.getStanID()).append(",")
                .append(korisnik.getKorisnikID());
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return "  UgovorID = " + ((Ugovor)object).getUgovorID();
    }

    @Override
    public void setId(int id) {
        setUgovorID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT u.ugovorID, u.datumSklapanja, u.datumOd, u.datumDo, u.cena, u.iznosProvizije, u.valuta,"
                + " u.napomena, u.stanID, u.korisnikID,"
                + " k.korisnikID, k.ime, k.prezime, k.JMBG, k.status,"
                + " s.stanID, s.kvadratura, s.cena, s.valuta, s.imeVlasnika, s.prezimeVlasnika, s.kontaktTelefon, s.brSpratovaZgrade,"
               + " s.sprat, s.status, s.kategorijaStanaID, s.tipGrejanjaID, s.karakteristikaID, "
               + " ks.kategorijaStanaID, ks.nazivKategorije, ks.brSoba,"
               + " tg.tipGrejanjaID, tg.nazivGrejanja, ka.karakteristikaID, ka.nazivKarakteristike "
                + " FROM UGOVOR AS u "
                + " INNER JOIN KORISNIK AS k ON (u.korisnikID = k.korisnikID) "
                + " INNER JOIN STAN AS s ON(u.stanID= s.stanID) "
                + " INNER JOIN KATEGORIJASTANA AS ks ON(s.kategorijaStanaID = ks.kategorijaStanaID) "
                + " INNER JOIN TIPGREJANJA AS tg ON(s.tipGrejanjaID = tg.tipGrejanjaID) "
                + " INNER JOIN KARAKTERISTIKA AS ka ON (s.karakteristikaID = ka.karakteristikaID)";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return " UgovorID = " + ((Ugovor)object).getUgovorID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Ugovor ugovor = (Ugovor)object;
        
        return " DatumSklapanja= '" + (new java.sql.Date(ugovor.getDatumSklapanja().getTime())).toString() + "' ,"
                + " DatumOd= '"+ (new java.sql.Date(ugovor.getDatumOd().getTime())).toString() + "' ,"
                + " DatumDo= '"+ (new java.sql.Date(ugovor.getDatumDo().getTime())).toString() + "' ,"
                + " Cena=" + ugovor.getCena() + ", IznosProvizije="+ugovor.getIznosProvizije() + ", "
                + " Valuta= '"+ugovor.getValuta()+"' , Napomena= '"+ ugovor.getNapomena()+"' , "
                + " StanID= "+ugovor.getStan().getStanID() + ", KorisnikID= "+ ugovor.getKorisnik().getKorisnikID();
        
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(ugovorID).append(",")
                .append("'").append(datumSklapanja.toString()).append("'")
                .append("'").append(datumOd.toString()).append("'")
                .append("'").append(datumDo.toString()).append("'");
                
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "UgovorID, DatumSklapanja, DatumOd, DatumDo";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
         Korisnik k = new Korisnik(rs.getInt("KorisnikID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("JMBG"), rs.getBoolean("Status"));
         KategorijaStana ks = new KategorijaStana(rs.getInt("KategorijaStanaID"), 
                rs.getString("NazivKategorije"), rs.getInt("BrSoba"));
         
         TipGrejanja tg = new TipGrejanja(rs.getInt("TipGrejanjaID"), rs.getString("NazivGrejanja"));
        
          Karakteristika karak = new Karakteristika(rs.getInt("KarakteristikaID"), rs.getString("NazivKarakteristike"));
         
         
          Stan s = new Stan(rs.getInt("StanID"), rs.getDouble("Kvadratura"), 
                rs.getDouble("Cena"), rs.getString("Valuta"), rs.getString("ImeVlasnika"), 
                rs.getString("PrezimeVlasnika"), rs.getString("KontaktTelefon"), 
                rs.getInt("BrSpratovaZgrade"), rs.getInt("Sprat"), rs.getBoolean("Status"), 
                ks, tg, karak);
   
        
        Ugovor u = new Ugovor(rs.getInt("UgovorID"), rs.getDate("DatumSklapanja"),
                rs.getDate("DatumOd"), rs.getDate("DatumDo"), rs.getDouble("Cena"),
                rs.getDouble("IznosProvizije"), rs.getString("Valuta"), rs.getString("Napomena"),
                s, k);
        return u;
    }
    
    
            
    
}
