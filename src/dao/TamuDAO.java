package dao;

import connection.DbConnection; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List;
import model.Tamu;

public class TamuDAO {
    private DbConnection dbCon = new DbConnection(); 
    private Connection con;
    
    public List<Tamu> showListTamu() { 
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM tamu";
        System.out.println("Mengambil data Tamu...");
        
        List<Tamu> list = new ArrayList();
        
        try { 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql);  
            if (rs != null) { 
                while (rs.next()) { 
                    Tamu t = new Tamu(
                            rs.getInt("id"), 
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("no_ktp"),
                            rs.getString("no_telp"));
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
}
