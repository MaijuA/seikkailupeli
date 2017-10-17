import java.util.ArrayList;

public class Pelaaja {

    public String nimi;
    public ArrayList<Object> pelaajanTavaralista = new ArrayList<Object>();
    public Object sijainti;
    public int sijaintiID;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
    }

    public ArrayList<Object> katsoTavarat() {
        for (Object tavara : pelaajanTavaralista) {
            System.out.println(tavara.toString());
        }
        return this.pelaajanTavaralista;
    }

    public Object lisääTavaraListalle(Object tavara) {
        pelaajanTavaralista.add(tavara);
        return this.pelaajanTavaralista;
    }

    public Object poistaTavaraListalta(Object tavara) {
        pelaajanTavaralista.remove(tavara);
        return this.pelaajanTavaralista;
    }

    public Object tarkistaSijainti() {
        System.out.println("Oletko eksyksissä? Olet huoneessa: " + sijainti);
        return this.sijainti;
    }


}


