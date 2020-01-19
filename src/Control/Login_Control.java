/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Control;

import Model.Login_DAO;
import Model.Login_Cred;
import java.util.List;
/*
 * @author hattaldino
 */
public class Login_Control {
    String nama;
    Login_DAO cred;
    List<Login_Cred> IDall;
    
    public Login_Control(){
        cred = new Login_DAO();
    }
    
    public String Verifikasi(String ID, String Pass, int which){
        Login_Cred check = null;
        if(which == 1){
            IDall = cred.selectLoginDosen();
            for(Login_Cred curr : IDall){
                if(ID.equals(curr.getID()) && Pass.equals(curr.getPass())){
                    return curr.getID();
                    }
                
            }
        }
        else if(which == 2){
            IDall = cred.selectLoginMahasiswa();
            for(Login_Cred curr : IDall){
                if(ID.equals(curr.getID()) && Pass.equals(curr.getPass())){
                    return curr.getID();
                }
            }
        }
        
        return "";
    }
    
    
}
