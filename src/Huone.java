import java.util.ArrayList;
import java.util.List;

public class Huone {
    private int id;
    private String nimi;
    private String kuvaus;
//    String tavarakuvaus;

    List<Tavara> tavaralista = new ArrayList<Tavara>();



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
}