package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Reservasi;

public class TableReservasi extends AbstractTableModel{
    private List<Reservasi> list;
    
    
    public TableReservasi(List<Reservasi> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 8;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex){ 
            case 0: 
                return list.get(rowIndex).getId();
            case 1: 
                return list.get(rowIndex).getPegawai().getId();
            case 2: 
                return list.get(rowIndex).getTamu().getId();
            case 3: 
                return list.get(rowIndex).getTgl_checkIn();
            case 4:
                return list.get(rowIndex).getDurasi();
            case 5:
                return list.get(rowIndex).getJumlah_tamu();
            case 6:   
                return list.get(rowIndex).getTotal_harga();
            case 7:    
                return list.get(rowIndex).getTgl_reservasi();
            default: 
                return null; 
        } 
    }
    
    public String getColumnName(int column){ 
        switch (column) { 
            case 0: 
                return "ID Kamar"; 
            case 1: 
                return "ID Pegawai"; 
            case 2: 
                return "ID Tamu"; 
            case 3:
                return "Tgl Check In";
            case 4:    
                return "Durasi (hari)";
            case 5:
                return "Jumlah Tamu";
            case 6:
                return "Total Harga";
            case 7:
                return "Tgl Reservasi";
            default: 
                return null; 
        } 
    } 
}
