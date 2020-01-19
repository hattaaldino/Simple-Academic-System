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
public class Mata_KuliahDAO {
    Connection koneksi;
    
    public Mata_KuliahDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sistemakademik",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<RanahTopik> selectRanahTopik(){
        List<RanahTopik> RTList = new ArrayList<>();
        try{
            String select = "SELECT * FROM ranahtopik";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                RTList.add(new RanahTopik(
                        result.getString(1),
                        result.getString(2)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return RTList;
    }
        
    public List<Mata_Kuliah> selectMataKuliah(){
        List<Mata_Kuliah> MKList = new ArrayList<>();
        try{
            String select = "SELECT * FROM kajian";
            PreparedStatement statement = koneksi.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                MKList.add(new Mata_Kuliah(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return MKList;
    }
    
    public List<Mata_Kuliah> selectMataKuliahByRT(RanahTopik subjek){
        List<Mata_Kuliah> MKList = new ArrayList<>();
        try{
            String select = "SELECT * FROM kajian WHERE kodeRT = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, subjek.getKode());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                MKList.add(new Mata_Kuliah(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return MKList;
    }
    
    public Mata_Kuliah selectMataKuliahByKode(String Kode){
        Mata_Kuliah MKList = null;
        try{
            String select = "SELECT * FROM kajian WHERE kodekajian = ?";
            PreparedStatement statement = koneksi.prepareStatement(select);
            statement.setString(1, Kode);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                MKList = new Mata_Kuliah(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4));
            }            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return MKList;
    }
    
    public void InsertMK(Mata_Kuliah anda) {
        try {
            String sql_insert = "INSERT INTO `kajian`"
                    + "(`kodeRT`, `kodekajian`, `kajian`, `Content`) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement statement = koneksi.prepareStatement(sql_insert);
            statement.setString(1, anda.getKodeTopik());
            statement.setString(2, anda.getKodeMK());
            statement.setString(3, anda.getKajian());
            statement.setString(4, anda.getContent());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
