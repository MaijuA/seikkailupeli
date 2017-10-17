import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Huone {
    private int id;
    private String nimi;
    private String kuvaus;
    //    String tavarakuvaus;
    List<Tavara> tavaralista = new ArrayList<>();
    public Huone(int id, String nimi, String kuvaus) {
        this.id = id;
        this.nimi = nimi;
        this.kuvaus = kuvaus;
    }
    public int getId() {
        return id;
    }
    public String getNimi() {
        return nimi;
    }
    public String getKuvaus() {
        return kuvaus;
    }
    public Tavara getTavarakuvaus() {
        return tavaralista.get(0);
    }
    public void otaTavara(String s) {
        for (Iterator<Tavara> it = tavaralista.iterator(); it.hasNext();) {
            Tavara t = it.next();
            if (s.toLowerCase().equals(t.getNimi())) {
                it.remove();
            }
        }
    }
    public String haeTavarat(){
        String tulos = "";
        for (Tavara t:tavaralista) {
            tulos += (t.getNimi() + "\n");
        }
        if (tulos == "") return "Ei ole.";
        return tulos;
    }
    @Override
    public String toString() {
        return  kuvaus + "\n" + "Tavaroita huoneessa:" + "\n" + haeTavarat();
    }
    public StringBuilder haeKartta(String[] nimi){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nimi.length ; i++){
            sb.append(nimi[i] + "\n");}
        return sb;
    }
    String[] eteinen = {
            "****ovi****" ,
            "*         *" ,
            "*    x    *" ,
            "*         *" ,
            "***********"
    };
    String[] olohuone = {
            "********ovi********" ,
            "*                 *" ,
            "o                 o" ,
            "v        x        v" ,
            "i                 i" ,
            "*                 *" ,
            "********ovi********"
    };
    String[] keittiö = {
            "****************" ,
            "*              *" ,
            "*              o" ,
            "*      x       v" ,
            "*              i" ,
            "*              *" ,
            "****************"
    };
    String[] makuuhuone = {
            "*****************" ,
            "*               *" ,
            "*               *" ,
            "*               *" ,
            "*       x       *" ,
            "*               *" ,
            "*               *" ,
            "*               *" ,
            "*******ovi*******"
    };
    String[] wc = {
            "**********" ,
            "o        *" ,
            "v    x   *" ,
            "i        *" ,
            "**********"
    };
}