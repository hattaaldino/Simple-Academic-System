/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Login_DAO {
    Connection koneksi;
    
    public Login_DAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistemakademik",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Login_Cred> selectLoginDosen(){
        List<Login_Cred> credDosen = new ArrayList<>();
        try{
            String select = "SELECT * FROM logindosen";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                credDosen.add(new Login_Cred(
                        result.getString(1),
                        result.getString(2)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return credDosen;
    }
    
    public List<Login_Cred> selectLoginMahasiswa(){
        List<Login_Cred> credMahasiswa = new ArrayList<>();
        try{
            String select = "SELECT * FROM loginmahasiswa";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                credMahasiswa.add(new Login_Cred(
                        result.getString(1),
                        result.getString(2)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return credMahasiswa;
    }
}
