package control;

import dao.PegawaiDAO;
import java.util.List;
import model.Pegawai;

public class PegawaiControl {
    private PegawaiDAO pDao = new PegawaiDAO();
    
    public void insertDataPegawai(Pegawai p){
        pDao.insertPegawai(p);
    }
    
    public String showDataPegawai(){
        List<Pegawai> dataPegawai = pDao.showPegawai();
        
        String pegawaiString = "";
        for (int i=0; i<dataPegawai.size(); i++){
            pegawaiString = pegawaiString + dataPegawai.get(i).showDataPegawai() + "\n";
        }
        return pegawaiString;
    }
    
    public Pegawai searchPegawai(String id){
        Pegawai p = null;
        p = pDao.searchPegawai(id);
        return p;
    }
    
    public void updateDataPegawai(Pegawai p, String id){
        pDao.updatePegawai(p, id);
    }
    
    public void deleteDataPegawai(String id){
        pDao.deletePegawai(id);
    }
    
    public List<Pegawai> showListPegawai(){
        List<Pegawai> dataPegawai = pDao.showPegawai();
        return dataPegawai;
    }
    
//    public List<Pegawai> showListPegawaiReservasi(){
//        List<Pegawai> dataPegawai = pDao.showPegawai();
//        
//        String pegawaiReservasi = "";
//        for (int i=0; i<dataPegawai.size(); i++){
//            if(dataPegawai.get(i).getId().contains("CS-")){
//                dataPegawai = 
//            }
//        }
//        return dataPegawai;
//    }
    
}
