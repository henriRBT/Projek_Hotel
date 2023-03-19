package dao;

import connection.DbConnection; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List;
import model.Tamu;
import model.Pegawai;
import model.Reservasi;

public class ReservasiDAO {
    private DbConnection dbCon = new DbConnection(); 
    private Connection con;
    
    public void insertReservasi(Reservasi r){
        con = dbCon.makeConnection(); 
        
        String sql = "INSERT INTO reservasi(id_pegawai, id_tamu, tgl_checkIn, durasi, jumlah_tamu, total_harga, tgl_reservasi) VALUES ('" 
                + r.getPegawai().getId() + "', '" 
                + r.getTamu().getId() + "', '" 
                + r.getTgl_checkIn() + "', '"
                + r.getDurasi() + "', '" 
                + r.getJumlah_tamu() + "', '"
                + r.getTotal_harga() + "', '"
                + r.getTgl_reservasi() + "')"; 
        
        System.out.println("Adding Reservasi...");
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Added " + result + " Reservasi"); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error adding Reservasi..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
    }
    
    public List<Reservasi> showReservasi(String query) { 
        con = dbCon.makeConnection();
        
        String sql = "SELECT r.*, p.*, t.* FROM reservasi as r JOIN pegawai as p ON (r.id_pegawai = p.id) JOIN tamu as t ON (r.id_tamu = t.id) WHERE (r.id LIKE "
                + "'%" + query + "%'"
                + "OR p.id LIKE '%" + query + "%'"
                + "OR t.id LIKE '%" + query + "%'"
                + "OR r.tgl_checkIn LIKE '%" + query + "%'"
                + "OR r.durasi LIKE '%" + query + "%'"
                + "OR r.jumlah_tamu LIKE '%" + query + "%'"
                + "OR r.total_harga LIKE '%" + query + "%'"
                + "OR r.tgl_reservasi LIKE '%" + query + "%')";
        
        System.out.println("Mengambil data Reservasi...");
        
        List<Reservasi> list = new ArrayList();
        
        try { 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql);  
            if (rs != null) { 
                while (rs.next()) { 
                    Pegawai p = new Pegawai(rs.getString("p.id"),  
                            rs.getString("p.nama"),
                            rs.getString("p.role"),
                            rs.getString("p.jenis_kelamin"),
                            rs.getString("p.no_telp"));
                            
                    Tamu t = new Tamu(rs.getInt("t.id"), 
                            rs.getString("t.nama"),
                            rs.getString("t.email"),
                            rs.getString("t.no_ktp"),
                            rs.getString("t.no_telp"));
                    
                    Reservasi r = new Reservasi(rs.getInt("r.id"), 
                            rs.getString("r.tgl_checkIn"), 
                            rs.getInt("r.durasi"),
                            rs.getInt("r.jumlah_tamu"),
                            rs.getFloat("r.total_harga"),
                            rs.getString("r.tgl_reservasi"),p,t); 
                    list.add(r); 
                } 
            } 
            rs.close(); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error reading database..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
        return list; 
    } 
    
    public void updateReservasi(Reservasi r) { 
        con = dbCon.makeConnection();       
        
        String sql = "UPDATE reservasi SET id_pegawai = '" + r.getPegawai().getId()
                + "', id_tamu = '" + r.getTamu().getId()
                + "', tgl_checkIn = '" + r.getTgl_checkIn()
                + "', durasi = '" + r.getDurasi()
                + "', jumlah_tamu = '" + r.getJumlah_tamu()
                + "', total_harga = '" + r.getTotal_harga()
                + "', tgl_reservasi = '" + r.getTgl_reservasi()
                + "' WHERE id = '" + r.getId() + "'"; 
        
        System.out.println("Editing Reservasi...");       
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Edited " + result + " Reservasi " + r.getId()); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error editing Reservasi..."); 
            System.out.println(e); 
        }
        dbCon.closeConnection(); 
    } 
    
    public void deleteReservasi(int id) { 
        con = dbCon.makeConnection();  
        
        String sql = "DELETE FROM reservasi WHERE id = " + id + ""; 
        System.out.println("Deleting Reservasi...");         
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Delete " + result + " Reservasi " + id); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error deleting Reservasi..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
    } 
    
    public List<Reservasi> showListReservasi() { 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM reservasi";
        System.out.println("Mengambil data Reservasi...");
        
        List<Reservasi> list = new ArrayList();
        
        try { 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql);  
            if (rs != null) { 
                while (rs.next()) { 
                    Reservasi r = new Reservasi(rs.getInt("id"), 
                            rs.getString("tgl_checkIn"), 
                            rs.getInt("durasi"),
                            rs.getInt("jumlah_tamu"),
                            rs.getFloat("total_harga"),
                            rs.getString("tgl_reservasi")); 
                    list.add(r);
                } 
            } 
            rs.close(); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error reading database..."
            ); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
        return list; 
    } 
}
