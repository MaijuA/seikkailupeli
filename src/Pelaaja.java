import java.util.ArrayList;
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
        System.out.println("Eksyitkö? " + getPelaajanSijainti());
    }

    public void setPelaajanSijainti(Huone sijainti) {
        this.pelaajanSijainti = sijainti;
    }

    public Huone getPelaajanSijainti() {
        return pelaajanSijainti;
    }


    public void syö(String syöte) {
        Tavara tavara = null;
        if (pelaajanTavaralista.isEmpty()) {
            System.out.println("Sinulla ei ole mitään syötävää!");
        } else {
            for (Tavara t : pelaajanTavaralista) {
                if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                    tavara = t;
                }
            }
            if (tavara == null) {
                System.out.println("Sinulla ei ole tällaista syötävää");
            } else {
                if (tavara.syötävä && tavara.onkoTimanttia) {
                    timanttilaskuri++;
                    System.out.println("Oho... mikä kolahti hampaaseen!! Sehän oli timantti!! Hiphurraa!\nTimanttisaldosi on nyt " + timanttilaskuri);
                    pelaajanTavaralista.remove(tavara);
                } else if (tavara.syötävä) {
                    System.out.println("Mmmm..." + tavara + "! Nam, olipa herkullista.\nNyt jaksan taas etsiä timantteja!");
                    pelaajanTavaralista.remove(tavara);
                } else {
                    System.out.println("Pyh, se mitä yritit syödä oli " + tavara + "! Hmm, ehkä tarvitset sitä johonkin muuhun.");
                }
            }
        }
    }

    public void avaa(String syöte) {
        Tavara tavara = null;
        if (pelaajanTavaralista.isEmpty()) {
            System.out.println("Sinulla ei ole mitään avattavaa!");
        } else {
            for (Tavara t : pelaajanTavaralista) {
                if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                    tavara = t;
                }
            }
            if (tavara == null) {
                System.out.println("Sinulla ei ole tällaista avattavaa");
            } else {
                if (tavara.avattava && tavara.onkoTimanttia) {
                    timanttilaskuri++;
                    System.out.println("Jipijee!! Löysit sisältä timantin!!\nTimanttisaldosi on tällä hetkellä " + timanttilaskuri);
                    tavara.onkoTimanttia = false;
                } else if (tavara.avattava) {
                    System.out.println("Avasit esineen " + tavara + ". Voi harmi, ei löytynyt mitään jännää. Jatka  siis timanttien etsimistä!");
                } else {
                    System.out.println("Harminpaikka! Tätä esinettä ei ole mahdollista avata.");
                }
            }
        }
    }

    public void otaTavara(String syöte) {
        Tavara tavara = null;
        if (pelaajanSijainti.tavaralista.isEmpty()) {
            System.out.println("Oho! Tässä huoneessa ei olekaan enää tavaroita!");
        } else {
            for (Tavara t : pelaajanSijainti.tavaralista) {
                if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                    tavara = t;
                }
            }
            if (tavara != null) {
                if (tavara.poistaTimantti && timanttilaskuri > 0) {
                    pelaajanTavaralista.add(tavara);
                    System.out.println(tavara.ominaisuudet);
                    pelaajanSijainti.tavaralista.remove(tavara);
                    System.out.println("Mutta voi voi, " + tavara + " teki taskuun reiän ja yksi timantti katosi!!");
                    timanttilaskuri--;
                    System.out.println("Timanttisaldosi on nyt " + timanttilaskuri);
                } else {
                    pelaajanTavaralista.add(tavara);
                    System.out.println(tavara.ominaisuudet);
                    pelaajanSijainti.tavaralista.remove(tavara);
                }
            } else {
                System.out.println("Hups! Ei olekaan tällaista tavaraa huoneessa!");
            }
        }
    }
    public void tutki(String syöte) {
        int eiole = 0;
        for (int i = 0; i < pelaajanTavaralista.size(); i++) {
            Tavara t = pelaajanTavaralista.get(i);
            if (syöte.toLowerCase().contains(t.getTavaranNimi())) {
                System.out.println(t.ominaisuudet);
            } else {
                eiole++;
            }
        }
        if (eiole == pelaajanTavaralista.size()) {
            System.out.println("Sinulla ei ole tavaraa mitä haluat tutkia.");
        }
    }


    public void pyydäKomennot() {
        System.out.println("Navigointi:\n\t- eteen\n\t- taakse\n\t- oikea\n\t- vasen\n\t- kartta\n\t- missä\nMuut toiminnot:" +
                "\n\t- ota 'tavara'\n\t- tutki 'tavara'\n\t- syö 'tavara'\n\t- avaa 'tavara'\n\t" +
                "- huoneen tavarat\n\t- omat tavarat\n\t- nuku\n\t- lopeta");
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