package control;

import dao.ReservasiDAO;
import java.util.List;
import model.Reservasi;
import table.TableReservasi;

public class ReservasiControl {
    private ReservasiDAO rDao = new ReservasiDAO();
    
    public void insertDataReservasi(Reservasi r){
        rDao.insertReservasi(r);
    }
    
    public TableReservasi showReservasi(String query){
        List<Reservasi> dataReservasi = rDao.showReservasi(query);
        TableReservasi tableReservasi = new TableReservasi(dataReservasi);
        return tableReservasi;
    }
    
    public void updateDataReservasi(Reservasi r){
        rDao.updateReservasi(r);
    }
    
    public void deleteDataReservasi(int id){
        rDao.deleteReservasi(id);
    }
    
    public List<Reservasi> showListReservasi(){
        List<Reservasi> dataReservasi = rDao.showListReservasi();
        return dataReservasi;
    }
}
