/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Model;

/*
 * @author hattaldino
 */
public class Login_Cred {
    String ID = "";
    String Pass = "";
    
    public Login_Cred(String id, String pass){
        this.ID = id;
        this.Pass = pass;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
    
}
