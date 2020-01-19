/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author hattaldino
 */
public class DosenDAO {
    Connection koneksi;
    
    public DosenDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistemakademik",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Dosen> selectDosen(){
        List<Dosen> DosenList = new ArrayList<>();
        try{
            String select = "SELECT * FROM dosen";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                DosenList.add(new Dosen(
                        result.getString(1),
                        result.getString(2)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return DosenList;
    }
    
    public Dosen selectDosenbyNIK(String NIK){
        Dosen DosenList = null;
        try{
            String select = "SELECT * FROM dosen WHERE nip = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, NIK);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                DosenList = new Dosen(
                        result.getString(1),
                        result.getString(2));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return DosenList;
    }
    
    public Dosen selectDosenbyNama(String Nama){
        Dosen DosenList = null;
        try{
            String select = "SELECT * FROM dosen WHERE nama = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, Nama);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                DosenList = new Dosen(
                        result.getString(1),
                        result.getString(2));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return DosenList;
    }
}
