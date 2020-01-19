/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Control;

import Model.Mata_KuliahDAO;
import Model.Mata_Kuliah;
/*
 * @author hattaldino
 */
public class LibraryMNG {
    Mata_KuliahDAO mk;
    
    public LibraryMNG(){
        mk = new Mata_KuliahDAO();
    }
    
    public String getLibrary(String Kode){
        return mk.selectMataKuliahByKode(Kode).getContent();
    }
 
}
