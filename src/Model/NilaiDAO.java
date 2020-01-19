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
public class NilaiDAO {
    Connection koneksi;
    
    public NilaiDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistemakademik",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void InsertNilai(Nilai anda) {
        try {
            String sql_insert = "INSERT INTO `nilai`"
                    + "(`nim`, `kodekajian`, `uts`, `uas`, `ratarata`, `nip`) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement statement = koneksi.prepareStatement(sql_insert);
            statement.setString(1, anda.getNIM());
            statement.setString(2, anda.getMK());
            statement.setFloat(3, anda.getUTS());
            statement.setFloat(4, anda.getUAS());
            statement.setFloat(5, anda.getRerata());
            statement.setString(6, anda.getNIP());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Nilai> selectNilai(){
        List<Nilai> ListNilai = new ArrayList<>();
        try{
            String select = "SELECT * FROM nilai";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ListNilai.add(new Nilai(
                        result.getString(1),
                        result.getString(2),
                        result.getFloat(3),
                        result.getFloat(4),
                        result.getString(6)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ListNilai;
    }
    
    public List<Nilai> selectNilaiByMHS(String NIM){
        List<Nilai> ListNilai = new ArrayList<>();
        try{
            String select = "SELECT * FROM nilai WHERE nim = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, NIM);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ListNilai.add(new Nilai(
                        result.getString(1),
                        result.getString(2),
                        result.getFloat(3),
                        result.getFloat(4),
                        result.getString(6)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ListNilai;
    }
    
    public List<Nilai> selectNilaiByMK(String MK){
        List<Nilai> ListNilai = new ArrayList<>();
        try{
            String select = "SELECT * FROM nilai WHERE kodekajian = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, MK);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ListNilai.add(new Nilai(
                        result.getString(1),
                        result.getString(2),
                        result.getFloat(3),
                        result.getFloat(4),
                        result.getString(6)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ListNilai;
    }
    
    public List<Nilai> selectNilaiByDosen(String NIK){
        List<Nilai> ListNilai = new ArrayList<>();
        try{
            String select = "SELECT * FROM nilai WHERE nip = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, NIK);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ListNilai.add(new Nilai(
                        result.getString(1),
                        result.getString(2),
                        result.getFloat(3),
                        result.getFloat(4),
                        result.getString(6)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ListNilai;
    }
}
