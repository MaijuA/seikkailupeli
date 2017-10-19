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

    public String getNimi() {
        return nimi;
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
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi())) {
                if (syöte.contains(t.getTavaranNimi()) && t.syötävä && t.onkoTimanttia) {
                    timanttilaskuri++;
                    System.out.println("Oho... mikä kolahti hampaaseen!! Sehän oli timantti!! Hiphurraa!\nTimanttisaldosi on nyt " + timanttilaskuri);
                    it.remove();
                } else if (syöte.contains(t.getTavaranNimi()) && !t.syötävä) {
                    System.out.println("Pyh, se mitä yritit syödä oli " + t + "! Hmm, ehkä tarvitset sitä johonkin muuhun.");
                } else if (syöte.contains(t.getTavaranNimi()) && t.syötävä) {
                    System.out.println("Mmmm..." + t + "! Nam, olipa herkullista.\nNyt jaksan taas etsiä timantteja!");
                    it.remove();
                } else {
                    System.out.println("Oi voi... Sinulla ei ole mitään syötävää.");
                }
            }
        }
    }

    public void avaa(String syöte) {
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi())) {
                if (syöte.contains(t.getTavaranNimi()) && t.avattava && t.onkoTimanttia) {
                    timanttilaskuri++;
                    System.out.println("Jipijee!! Löysit sisältä timantin!!\nTimanttisaldosi on tällä hetkellä " + timanttilaskuri);
                    it.remove();
                } else if (syöte.contains(t.getTavaranNimi()) && t.avattava) {
                    System.out.println("Avasit esineen " + t + ". Voi harmi, ei löytynyt mitään jännää. Jatka  siis timanttien etsimistä!");
                } else {
                    System.out.println("Harminpaikka! Tätä esinettä ei ole mahdollista avata.");
                }
            }
        }
    }

    public void otaTavara(String syöte) {
        for (Iterator<Tavara> it = pelaajanSijainti.tavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi())) {
                pelaajanTavaralista.add(t);
                System.out.println(t.ominaisuudet);
                it.remove();
            }
        }
    }

    public void tutki(String syöte) {
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.contains(t.getTavaranNimi())) {
                if (syöte.contains(t.getTavaranNimi())) {
                    System.out.println(t.ominaisuudet);
                } else {
                    System.out.println("Sinulla ei ole tavaraa " + syöte);
                }
            }
        }
    }

    public void pyydäKomennot() {
        System.out.println("Navigointi:\n\t- eteen\n\t- taakse\n\t- oikea\n\t- vasen\nMuut toiminnot:" +
                "\n\t- ota 'tavara'\n\t- tutki 'tavara'\n\t- syö 'tavara'\n\t- avaa 'tavara'\n\t- kartta\n\t" +
                "- huoneen tavarat\n\t- omat tavarat\n\t ");
    }

    public int getTimanttilaskuri() {
        return timanttilaskuri;
    }
}