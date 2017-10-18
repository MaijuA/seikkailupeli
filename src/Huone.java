import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Huone {
    private String nimi;
    private String kuvaus;
    private String[] kartta;
    //    String tavarakuvaus;
    List<Tavara> tavaralista = new ArrayList<>();

    public Huone(String nimi, String kuvaus, String[] kartta) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.kartta = kartta;
    }

    public Huone(String nimi, String kuvaus) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;
    }

    public String getHuoneenNimi() {
        return nimi;
    }

    public String getHuoneenKuvaus() {
        return kuvaus;
    }

    //    public Tavara getTavarakuvaus() {
//        return tavaralista.get(0);
//    }
    public String haeTavarat() {
        String tulos = "";
        for (Tavara t : tavaralista) {
            tulos += (t.getTavaranNimi() + "\n");
        }
        if (tulos == "") return "Ei ole.";
        return tulos;
    }

    @Override
    public String toString() {
        return kuvaus + "\n" + "Tavaroita huoneessa:" + "\n" + haeTavarat() + "\n" + haeKartta();
    }

    public StringBuilder haeKartta() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kartta.length; i++) {
            sb.append(kartta[i] + "\n");
        }
        return sb;
    }

    String[] eteisenKartta = {
            "****ovi****",
            "*         *",
            "*    x    *",
            "*         *",
            "***********"
    };
    String[] olohuoneenKartta = {
            "********ovi********",
            "*                 *",
            "o                 o",
            "v        x        v",
            "i                 i",
            "*                 *",
            "********ovi********"
    };
    String[] keittiönKartta = {
            "****************",
            "*              *",
            "*              o",
            "*      x       v",
            "*              i",
            "*              *",
            "****************"
    };
    String[] makuuhuoneenKartta = {
            "*****************",
            "*               *",
            "*               *",
            "*               *",
            "*       x       *",
            "*               *",
            "*               *",
            "*               *",
            "*******ovi*******"
    };
    String[] wcnKartta = {
            "**********",
            "o        *",
            "v    x   *",
            "i        *",
            "**********"
    };
}
