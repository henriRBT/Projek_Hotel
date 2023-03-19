package control;

import dao.TamuDAO;
import java.util.List;
import model.Tamu;

public class TamuControl {
    private TamuDAO tDao = new TamuDAO();
    
    public List<Tamu> showListTamu(){
        List<Tamu> dataTamu = tDao.showListTamu();
        return dataTamu;
    }
}
