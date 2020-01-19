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
public class MahasiswaDAO {
    Connection koneksi;
    
    public MahasiswaDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistemakademik",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Mahasiswa> selectMahasiswa(){
        List<Mahasiswa> MahasiswaList = new ArrayList<>();
        try{
            String select = "SELECT * FROM mahasiswa";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                MahasiswaList.add(new Mahasiswa(
                        result.getString(1),
                        result.getString(2)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return MahasiswaList;
    }
    
    public Mahasiswa selectMahasiswabyNIM(String NIM){
        Mahasiswa MahasiswaList = null;
        try{
            String select = "SELECT * FROM mahasiswa WHERE nim = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, NIM);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                MahasiswaList = new Mahasiswa(
                        result.getString(1),
                        result.getString(2));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return MahasiswaList;
    }
    
    public Mahasiswa selectMahasiswabyNama(String Nama){
        Mahasiswa MahasiswaList = null;
        try{
            String select = "SELECT * FROM mahasiswa WHERE nama = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, Nama);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                MahasiswaList = new Mahasiswa(
                        result.getString(1),
                        result.getString(2));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return MahasiswaList;
    }
}
