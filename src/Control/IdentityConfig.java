/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Control;

/*
 * @author hattaldino
 */

import Model.DosenDAO;
import Model.MahasiswaDAO;

public class IdentityConfig {
    
    DosenDAO dosen;
    MahasiswaDAO mhs;
    
    public IdentityConfig(){
        dosen = new DosenDAO();
        mhs = new MahasiswaDAO();
    }
    
    public String getNama(String id, int type){
        if(type == 1)
            return dosen.selectDosenbyNIK(id).getNama();
        else if(type == 2)
            return mhs.selectMahasiswabyNIM(id).getNama();
        else return "";
    }
}
