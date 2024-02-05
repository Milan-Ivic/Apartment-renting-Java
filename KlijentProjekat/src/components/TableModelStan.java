/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domen.Korisnik;
import domen.Stan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelStan extends AbstractTableModel{

    ArrayList<Stan> stanovi;
    String[] kolone = {"Kvadratura", "Cena", "Valuta", "Ime vlasnika", "Prezime vlasnika", "Kontakt telefon", "Broj spratova zgrade", "Sprat", 
    "Status", "Kategorija", "Tip grejanja", "Karakteristika"};
    
    public TableModelStan(){
    
        stanovi = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return stanovi.size();
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
        Stan k = stanovi.get(rowIndex);
        
        switch (columnIndex) {
            case 0:return k.getKvadratura();
            case 1: return k.getCena();
            case 2: return k.getValuta();
            case 3: return k.getImeVlasnika();
            case 4: return k.getPrezimeVlasnika();
            case 5: return k.getKontaktTelefon();
            case 6: return k.getBrSpratovaZgrade();
            case 7: return k.getSprat();
            case 8: return k.isStatus();
            case 9: return k.getKategorijaStana();
            case 10: return k.getTipGrejanja();
            case 11: return k.getKarakteristika();
                
            default:
                throw new AssertionError();
        }
    }
    
    public void dodajListu(ArrayList<Stan> stan){
    
        stanovi = stan;
        fireTableDataChanged();
    }
    
    public Stan vratiStan(int selectedRow){
    
        return stanovi.get(selectedRow);
    }
    
    public void obrisiStan(int selectedRow){
    
        stanovi.remove(selectedRow);
        fireTableDataChanged();
    }
    
    public void updateStan(int selectedRow, Stan k){
    
        stanovi.set(selectedRow, k);
        fireTableDataChanged();
    }
}
