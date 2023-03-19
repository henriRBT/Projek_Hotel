package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

public class TableTransaksi extends AbstractTableModel{
    private List<Transaksi> list;
    
    public TableTransaksi(List<Transaksi> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 6;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex){ 
            case 0: 
                return list.get(rowIndex).getId();
            case 1: 
                return list.get(rowIndex).getPegawai().getId();
            case 2: 
                return list.get(rowIndex).getReservasi().getId();
            case 3: 
                return list.get(rowIndex).getReservasi().getTotal_harga();
            case 4:    
                return list.get(rowIndex).getMetode_pembayaran();
            case 5:   
                return list.get(rowIndex).getStatus();
            default: 
                return null; 
        } 
    }
    
    public String getColumnName(int column){ 
        switch (column) { 
            case 0: 
                return "ID Transaksi"; 
            case 1: 
                return "ID Pegawai";
            case 2: 
                return "ID Kamar";
            case 3:
                return "Total Harga";
            case 4:   
                return "Metode Pembayaran";
            case 5:
                return "Status";
            default: 
                return null; 
        } 
    } 
}
