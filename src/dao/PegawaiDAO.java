package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List;
import model.Pegawai;

public class PegawaiDAO {
    private DbConnection dbCon = new DbConnection(); 
    private Connection con;
    
    public void insertPegawai(Pegawai p) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO pegawai(id, nama, role, jenis_kelamin, no_telp) VALUES ('" 
                + p.getId()+ "', '" 
                + p.getNama()+ "', '"
                + p.getRole() + "', '"
                + p.getJenis_kelamin() + "', '"
                + p.getNo_telp() + "')"; 
        
        System.out.println("Adding Pegawai...");
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Added " + result + " Pegawai"); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error adding Pegawai..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
    }
    
    public List<Pegawai> showPegawai() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pegawai";
        System.out.println("Mengambil data Pegawai...");
        
        List<Pegawai> list = new ArrayList();
        
        try { 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql);  
            if (rs != null) { 
                while (rs.next()) { 
                    Pegawai p = new Pegawai(
                            rs.getString("id"),  
                            rs.getString("nama"),
                            rs.getString("role"),
                            rs.getString("jenis_kelamin"),
                            rs.getString("no_telp")
                    ); 
                    list.add(p); 
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
    
    public Pegawai searchPegawai(String id) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pegawai WHERE id = '" + id + "'";
        System.out.println("Searching Pegawai...");
        Pegawai p = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    p = new Pegawai(
                        rs.getString("id"),  
                            rs.getString("nama"),
                            rs.getString("role"),
                            rs.getString("jenis_kelamin"),
                            rs.getString("no_telp")
                    );  
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return p;
    }
    
    public void updatePegawai(Pegawai p, String id) { 
        con = dbCon.makeConnection();       
        
        String sql = "UPDATE pegawai SET nama = '" + p.getNama() + "', "
                + "role = '" + p.getRole() + "', "
                + "jenis_kelamin = '" + p.getJenis_kelamin() + "', "
                + "no_telp = '" + p.getNo_telp() + "' "
                + "WHERE id = '" + id + "'";
                
        System.out.println("Editing Pegawai...");       
        
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Edited " + result + " Pegawai " + id); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error editing Pegawai..."); 
            System.out.println(e); 
        }
        dbCon.closeConnection(); 
    } 
    
    public void deletePegawai(String id) { 
        con = dbCon.makeConnection();  
        
        String sql = "DELETE FROM pegawai WHERE id = '" + id + "'"; 
        System.out.println("Deleting Pegawai...");         
        try { 
            Statement statement = con.createStatement(); 
            int result = statement.executeUpdate(sql); 
            System.out.println("Delete " + result + " Pegawai " + id); 
            statement.close(); 
        } catch (Exception e) { 
            System.out.println("Error deleting Pegawai..."); 
            System.out.println(e); 
        } 
        dbCon.closeConnection(); 
    } 
}
