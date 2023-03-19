package dao;

import connection.DbConnection; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List;
import model.Pegawai;
import model.Reservasi;
import model.Transaksi;

public class TransaksiDAO {
    private DbConnection dbCon = new DbConnection(); 
    private Connection con;
    
    public void insertTransaksi(Transaksi t){
        con = dbCon.makeConnection(); 
        
        String sql = "INSERT INTO transaksi(id_pegawai, id_reservasi, metode_pembayaran, status) VALUES ('" 
                + t.getPegawai().getId() + "', '" 
                + t.getReservasi().getId() + "', '" 
                + t.getMetode_pembayaran() + "', '"
                + t.getStatus() + "')"; 
        
        System.out.println("Adding Transaksi...");
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Added " + result + " Transaksi"); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error adding Transaksi..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
    }
    
    public void updateTransaksi(Transaksi t) { 
        con = dbCon.makeConnection();       
        
        String sql = "UPDATE transaksi SET id_pegawai = '" + t.getPegawai().getId()
                + "', id_reservasi = '" + t.getReservasi().getId()
                + "', metode_pembayaran = '" + t.getMetode_pembayaran()
                + "', status = '" + t.getStatus()
                + "' WHERE id = '" + t.getId() + "'"; 
        
        System.out.println("Editing Transaksi...");       
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Edited " + result + " Transaksi " + t.getId()); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error editing Transaksi..."); 
            System.out.println(e); 
        }
        dbCon.closeConnection(); 
    } 
    
    public List<Transaksi> showTransaksi(String query) { 
        con = dbCon.makeConnection();
        
        String sql = "SELECT t.*, p.*, r.* FROM transaksi as t JOIN pegawai as p ON (t.id_pegawai = p.id) JOIN reservasi as r ON (t.id_reservasi = r.id) WHERE (t.id LIKE "
                + "'%" + query + "%'"
                + "OR p.id LIKE '%" + query + "%'"
                + "OR r.id LIKE '%" + query + "%'"
                + "OR r.total_harga LIKE '%" + query + "%'"
                + "OR t.metode_pembayaran LIKE '%" + query + "%'"
                + "OR t.status LIKE '%" + query + "%')";
        
        System.out.println("Mengambil data Transaksi...");
        
        List<Transaksi> list = new ArrayList();
        
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
                            
                    Reservasi r = new Reservasi(rs.getInt("r.id"), 
                            rs.getString("r.tgl_checkIn"), 
                            rs.getInt("r.durasi"),
                            rs.getInt("r.jumlah_tamu"),
                            rs.getFloat("r.total_harga"),
                            rs.getString("r.tgl_reservasi"));
                    
                    Transaksi t = new Transaksi(rs.getInt("t.id"), 
                            rs.getString("t.metode_pembayaran"), 
                            rs.getString("t.status"),p,r); 
                    list.add(t); 
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
    
    public void deleteTransaksi(int id) { 
        con = dbCon.makeConnection();  
        
        String sql = "DELETE FROM transaksi WHERE id = " + id + ""; 
        System.out.println("Deleting Transaksi...");         
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Delete " + result + " Transaksi " + id); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error deleting Transaksi..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
    } 
    
}
