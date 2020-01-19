/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Model;

/*
 * @author hattaldino
 */
public class Mata_Kuliah {
    String KodeTopik;
    String KodeMK;
    String Kajian;
    String content;

    public Mata_Kuliah(String KodeT, String Kode, String Subjek, String konten) {
        this.KodeTopik = KodeT;
        this.KodeMK = KodeMK;
        this.Kajian = Subjek;
        this.content = konten;
    }

    public String getKodeTopik() {
        return KodeTopik;
    }

    public void setKodeTopik(String KodeTopik) {
        this.KodeTopik = KodeTopik;
    }

    public String getKodeMK() {
        return KodeMK;
    }

    public void setKodeMK(String KodeMK) {
        this.KodeMK = KodeMK;
    }

    public String getKajian() {
        return Kajian;
    }

    public void setKajian(String Kajian) {
        this.Kajian = Kajian;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
    
}
