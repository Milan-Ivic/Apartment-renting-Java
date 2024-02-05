/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domen.Korisnik;
import domen.Ugovor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModelUgovor extends AbstractTableModel{

    
    ArrayList<Ugovor> ugovori;
    String[] kolone = {"Datum sklapanja", "Datum od", "Datum do", "Cena", "Iznos provizije", "Valuta", "Napomena", "Stan", "Korisnik"};
    
    public TableModelUgovor(){
    
        ugovori = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        return ugovori.size();
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
        Ugovor k = ugovori.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:return sdf.format(k.getDatumSklapanja());
            case 1: return sdf.format(k.getDatumOd());
            case 2: return sdf.format(k.getDatumDo());
            case 3: return k.getCena();
            case 4: return k.getIznosProvizije();
            case 5: return k.getValuta();
            case 6: return k.getNapomena();
            case 7: return k.getStan();
            case 8: return k.getKorisnik();
                
            default:
                throw new AssertionError();
        }
    }
    
    public void dodajListu(ArrayList<Ugovor> kor){
    
        ugovori = kor;
        fireTableDataChanged();
    }
    
    public Ugovor vratiUgovor(int selectedRow){
    
        return ugovori.get(selectedRow);
    }
    
    public void obrisiUgovor(int selectedRow){
    
        ugovori.remove(selectedRow);
        fireTableDataChanged();
    }
    
    public void updateKorisnika(int selectedRow, Ugovor k){
    
        ugovori.set(selectedRow, k);
        fireTableDataChanged();
    }
    
    
}
