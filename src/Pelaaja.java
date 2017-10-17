import java.util.ArrayList;
public class Pelaaja {
    private String nimi;
    private ArrayList<Object> pelaajanTavaralista = new ArrayList<Object>();
    private Huone pelaajanSijainti;
    private int pelaajanSijaintiID;
    public Pelaaja(String nimi, Huone sijainti) {
        this.nimi = nimi;
        this.pelaajanSijainti = sijainti;
    }
    public ArrayList<Object> katsoTavarat() {
        for (Object tavara : pelaajanTavaralista) {
            System.out.println(tavara.toString());
        }
        return this.pelaajanTavaralista;
    }
    public void lisääTavaraListalle(Object tavara) {
        pelaajanTavaralista.add(tavara);
    }
    public void poistaTavaraListalta(Object tavara) {
        if (pelaajanTavaralista.contains(tavara)) {
            pelaajanTavaralista.remove(tavara);
        }
    }
    public Object tarkistaSijainti() {
        System.out.println("Oletko eksyksissä? Olet huoneessa: " + pelaajanSijainti);
        return this.pelaajanSijainti;
    }
    public ArrayList<Object> getPelaajanTavaralista() {
        return pelaajanTavaralista;
    }
    public void setPelaajanSijainti(Huone sijainti) {
        this.pelaajanSijainti = sijainti;
    }
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Huone getPelaajanSijainti() {
        return pelaajanSijainti;
    }
}