import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Pelaaja {
    private int timanttilaskuri = 0;
    private String nimi;
    private List<Tavara> pelaajanTavaralista = new ArrayList<>();
    private Huone pelaajanSijainti;
    public Pelaaja(String nimi, Huone sijainti) {
        this.nimi = nimi;
        this.pelaajanSijainti = sijainti;
    }
    public String katsoTavarat() {
        String lista = "";
        for (Tavara tavara : pelaajanTavaralista) {
            lista += "- " + tavara.getTavaranNimi() + '\n';
        }
        if (lista.isEmpty()) {
            return "Sinulla ei ole yhtään tavaraa...";
        } else {
            return "Sinulla on mukanasi:\n" + lista;
        }
    }
    public List<Tavara> getPelaajanTavaralista() {
        return pelaajanTavaralista;
    }
    public void poistaTavaraListalta(Tavara tavara) {
        if (pelaajanTavaralista.contains(tavara)) {
            pelaajanTavaralista.remove(tavara);
        }
    }
    public void tarkistaSijainti() {
        System.out.println("Eksyitkö? " + pelaajanSijainti);
    }
    public void setPelaajanSijainti(Huone sijainti) {
        this.pelaajanSijainti = sijainti;
    }
    public Huone getPelaajanSijainti() {
        return pelaajanSijainti;
    }
    public void syö(String syöte) {
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext();) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi()) && t.syötävä && t.onkoTimanttia) {
                timanttilaskuri++;
                System.out.println("Hiphurraa! Löysit timantin!!!\nTimanttisaldosi on nyt " + timanttilaskuri);
                it.remove();
                break;
            } else if (syöte.contains(t.getTavaranNimi()) && !t.syötävä) {
                System.out.println("Pyh, se mitä yritit syödä oli " + t + "! Hmm, ehkä tarvitset sitä johonkin muuhun.");
                break;
            } else if (syöte.contains(t.getTavaranNimi()) && t.syötävä) {
                System.out.println("Mmmm..." + t + "! Nam, olipa herkullista.\nNyt jaksan taas etsiä timantteja!");
                it.remove();
                break;
            } else {
                System.out.println("Oi voi... Sinulla ei ole mitään syötävää.");
            }
        }
    }
    public void avaa(String syöte) {
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext();) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi()) && t.avattava && t.onkoTimanttia) {
                timanttilaskuri++;
                System.out.println("Jipijee!! Löysit timantin!!\nTimanttisaldosi on tällä hetkellä " + timanttilaskuri);
                it.remove();
                break;
            } else if (syöte.contains(t.getTavaranNimi()) && t.avattava) {
                System.out.println("Avasit esineen " + t + ". Voi harmi, ei löytynyt mitään jännää. Jatka  siis timanttien etsimistä!");
                break;
            } else {
                System.out.println("Harminpaikka! Tätä esinettä ei ole mahdollista avata.");
            }
        }
    }
    public void otaTavara(String syöte){
        for (Iterator<Tavara> it = pelaajanSijainti.tavaralista.iterator(); it.hasNext();) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi())) {
                pelaajanTavaralista.add(t);
                it.remove();
            }
        }
        System.out.println(katsoTavarat());
    }

    public void tutki(String syöte){
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext();) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi())) {
                System.out.println(t.ominaisuudet);
            } else {
                System.out.println("Sinulla ei ole tavaraa " + syöte);
            }
        }
    }
    public int getTimanttilaskuri() {
        return timanttilaskuri;
    }
}