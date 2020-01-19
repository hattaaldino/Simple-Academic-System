/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Control;

import Model.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/*
 * @author hattaldino
 */
public class NilaiShow {
    NilaiDAO nilai = new NilaiDAO();
    DosenDAO dosen = new DosenDAO();
    MahasiswaDAO mhs = new MahasiswaDAO();
    Mata_KuliahDAO MK = new Mata_KuliahDAO();
    
    DefaultTableModel ShowNilaiMHS(List<Nilai> Mahasiswa) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "Mata Kuliah", "Nilai", "Dosen"
        });
        for (Nilai mhs : Mahasiswa) {
            tableModel.addRow(new Object[]{
                MK.selectMataKuliahByKode(mhs.getMK()).getKajian(),
                mhs.getRerata(),
                dosen.selectDosenbyNIK(mhs.getNIP()).getNama()
            });
        }
        return tableModel;
    }
    
    DefaultTableModel ShowNilaiDSN(List<Nilai> DSN) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "Nama", "MATA KULIAH","UTS", "UAS", "RERATA"
        });
        for (Nilai ByDosen : DSN) {
            tableModel.addRow(new Object[]{
                mhs.selectMahasiswabyNIM(ByDosen.getNIM()).getNama(),
                MK.selectMataKuliahByKode(ByDosen.getMK()).getKajian(),
                ByDosen.getUTS(),
                ByDosen.getUAS(),
                ByDosen.getRerata()
            });
        }
        return tableModel;
    }

    public DefaultTableModel selectNilaiMHS(String ID){
        return ShowNilaiMHS(nilai.selectNilaiByMHS(ID));
    }
    
    public DefaultTableModel selectNilaiDosen(String ID){
        return ShowNilaiDSN(nilai.selectNilaiByDosen(ID));
    }
    
    public DefaultTableModel InputNilai(String mhs, String mk, float uts, float uas, String dsn){
        Nilai baru = new Nilai(mhs, mk, uts, uas, dsn);
        nilai.InsertNilai(baru);
        return ShowNilaiDSN(nilai.selectNilaiByDosen(dsn));
    }
    
}
