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
        if (pelaajanTavaralista.isEmpty()) {
            System.out.println("Hups! Sinulla ei olekaan tällaista syötävää!");
        }
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                if (t.syötävä && t.onkoTimanttia) {
                    timanttilaskuri++;
                    System.out.println("Oho... mikä kolahti hampaaseen!! Sehän oli timantti!! Hiphurraa!\nTimanttisaldosi on nyt " + timanttilaskuri);
                    it.remove();
                } else if (!t.syötävä) {
                    System.out.println("Pyh, se mitä yritit syödä oli " + t + "! Hmm, ehkä tarvitset sitä johonkin muuhun.");
                } else if (t.syötävä) {
                    System.out.println("Mmmm..." + t + "! Nam, olipa herkullista.\nNyt jaksan taas etsiä timantteja!");
                    it.remove();
                } else {
                    System.out.println("Oi voi... Sinulla ei ole mitään syötävää.");
                }
            } else {
                System.out.println("Hups! Sinulla ei olekaan tällaista syötävää!");
            }
        }
    }

    public void avaa(String syöte) {
        if (pelaajanTavaralista.isEmpty()) {
            System.out.println("Hups! Sinulla ei olekaan tällaista avattavaa!");
        }
        for (Iterator<Tavara> it = pelaajanTavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                if (t.avattava && t.onkoTimanttia) {
                    timanttilaskuri++;
                    System.out.println("Jipijee!! Löysit sisältä timantin!!\nTimanttisaldosi on tällä hetkellä " + timanttilaskuri);
                    it.remove();
                } else if (t.avattava) {
                    System.out.println("Avasit esineen " + t + ". Voi harmi, ei löytynyt mitään jännää. Jatka  siis timanttien etsimistä!");
                } else {
                    System.out.println("Harminpaikka! Tätä esinettä ei ole mahdollista avata.");
                }
            } else {
                System.out.println("Hups! Sinulla ei olekaan tällaista avattavaa!");
            }
        }
    }

    public void otaTavara(String syöte) {
        if (pelaajanSijainti.tavaralista.isEmpty()) {
            System.out.println("Oho! Tässä huoneessa ei olekaan enää tavaroita!");
        }
        for (Iterator<Tavara> it = pelaajanSijainti.tavaralista.iterator(); it.hasNext(); ) {
            Tavara t = it.next();
            if (syöte.toLowerCase().contains(t.getTavaranNimi()) && t.poistaTimantti && timanttilaskuri > 0) {
                pelaajanTavaralista.add(t);
                System.out.println(t.ominaisuudet);
                it.remove();
                System.out.println("Mutta voi voi, " + t + " teki taskuun reiän ja yksi timantti katosi!!");
                timanttilaskuri--;
                System.out.println("Timanttisaldosi on nyt " + timanttilaskuri);
            } else if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                pelaajanTavaralista.add(t);
                System.out.println(t.ominaisuudet);
                it.remove();
            }
        }
    }

    public void tutki(String syöte) {
        int eiole = 0;
        for (int i = 0; i < pelaajanTavaralista.size(); i ++) {
            Tavara t = pelaajanTavaralista.get(i);
            if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                System.out.println(t.ominaisuudet);
            } else {
                eiole++;
            }
        } if (eiole == pelaajanTavaralista.size()){
            System.out.println("Sinulla ei ole tavaraa mitä haluat tutkia.");
        }
    }


    public void pyydäKomennot() {
        System.out.println("Navigointi:\n\t- eteen\n\t- taakse\n\t- oikea\n\t- vasen\nMuut toiminnot:" +
                "\n\t- ota 'tavara'\n\t- tutki 'tavara'\n\t- syö 'tavara'\n\t- avaa 'tavara'\n\t- kartta\n\t" +
                "- huoneen tavarat\n\t- omat tavarat\n\t \n\t nuku");
    }

    public int getTimanttilaskuri() {
        return timanttilaskuri;
    }

    public void vasemmalle(Huone eteinen, Huone olohuone, Huone makuuhuone, Huone keittiö, Huone vessa) {
        if (pelaajanSijainti.equals(eteinen) || pelaajanSijainti.equals(keittiö) || pelaajanSijainti.equals(makuuhuone)) {
            System.out.println("Törmäsit seinään!");
        } else if (pelaajanSijainti.equals(olohuone)) {
            setPelaajanSijainti(keittiö);
            System.out.println(keittiö);
        } else {
            setPelaajanSijainti(olohuone);
            System.out.println(olohuone);
        }
    }

    public void oikealle(Huone eteinen, Huone olohuone, Huone makuuhuone, Huone keittiö, Huone vessa) {
        if (pelaajanSijainti.equals(eteinen) || pelaajanSijainti.equals(vessa) || pelaajanSijainti.equals(makuuhuone)) {
            System.out.println("Törmäsit seinään!");
        } else if (pelaajanSijainti.equals(olohuone)) {
            setPelaajanSijainti(vessa);
            System.out.println(vessa);
        } else {
            setPelaajanSijainti(olohuone);
            System.out.println(olohuone);
        }
    }

    public void eteen(Huone eteinen, Huone olohuone, Huone makuuhuone, Huone keittiö, Huone vessa) {
        if (pelaajanSijainti.equals(keittiö) || pelaajanSijainti.equals(makuuhuone) || pelaajanSijainti.equals(vessa)) {
            System.out.println("Törmäsit seinään!");
        } else if (pelaajanSijainti.equals(olohuone)) {
            setPelaajanSijainti(makuuhuone);
            System.out.println(makuuhuone);
        } else {
            setPelaajanSijainti(olohuone);
            System.out.println(olohuone);
        }
    }

    public void taakse(Huone eteinen, Huone olohuone, Huone makuuhuone, Huone keittiö, Huone vessa) {
        if (pelaajanSijainti.equals(keittiö) || pelaajanSijainti.equals(eteinen) || pelaajanSijainti.equals(vessa)) {
            System.out.println("Törmäsit seinään!");
        } else if (pelaajanSijainti.equals(olohuone)) {
            setPelaajanSijainti(eteinen);
            System.out.println(eteinen);
        } else {
            setPelaajanSijainti(olohuone);
            System.out.println(olohuone);
        }
    }
}