/*
 * Hi Hatta's here!! Enjoy my code!
 * Feel free to Approach me if you have anything to ask
 * hattaldino@gmail.com
 */

package Model;

/*
 * @author hattaldino
 */
public class Nilai {
    String NIM;
    String MK;
    float UTS;
    float UAS;
    float rerata;
    String NIP;

    public Nilai(String NIM, String MK, float UTS, float UAS, String NIP) {
        this.NIM = NIM;
        this.MK = MK;
        this.UTS = UTS;
        this.UAS = UAS;
        this.rerata = (UTS+UAS)/2;
        this.NIP = NIP;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public float getUTS() {
        return UTS;
    }

    public void setUTS(float UTS) {
        this.UTS = UTS;
    }

    public float getUAS() {
        return UAS;
    }

    public void setUAS(float UAS) {
        this.UAS = UAS;
    }

    public float getRerata() {
        return rerata;
    }

    public void setRerata(float rerata) {
        this.rerata = rerata;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    
    
    
    
    
}
