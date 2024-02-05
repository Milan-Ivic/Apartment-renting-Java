/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domen.Korisnik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class TableModelKorisnik extends AbstractTableModel{

    ArrayList<Korisnik> korisnici;
    String[] kolone = {"Ime", "Prezime", "JMBG", "Status"};
    
    public TableModelKorisnik(){
    
        korisnici = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = korisnici.get(rowIndex);
        
        switch (columnIndex) {
            case 0:return k.getIme();
            case 1: return k.getPrezime();
            case 2: return k.getJMBG();
            case 3: return k.isStatus();
                
            default:
                throw new AssertionError();
        }
    }
    
    public void dodajListu(ArrayList<Korisnik> kor){
    
        korisnici = kor;
        fireTableDataChanged();
    }
    
    public Korisnik vratiKorisnika(int selectedRow){
    
        return korisnici.get(selectedRow);
    }
    
    public void obrisiKorisnika(int selectedRow){
    
        korisnici.remove(selectedRow);
        fireTableDataChanged();
    }
    
    public void updateKorisnika(int selectedRow, Korisnik k){
    
        korisnici.set(selectedRow, k);
        fireTableDataChanged();
    }
    
}
