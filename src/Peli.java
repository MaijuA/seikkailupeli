import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class Peli {
    private static String[] eteisenKartta = {
            "****ovi****",
            "*         *",
            "*    x    *",
            "*         *",
            "***********"
    };
    private static String[] olohuoneenKartta = {
            "********ovi********",
            "*                 *",
            "o                 o",
            "v        x        v",
            "i                 i",
            "*                 *",
            "********ovi********"
    };
    private static String[] keittiönKartta = {
            "****************",
            "*              *",
            "*              o",
            "*      x       v",
            "*              i",
            "*              *",
            "****************"
    };
    private static String[] makuuhuoneenKartta = {
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
    private static String[] wcnKartta = {
            "**********",
            "o        *",
            "v    x   *",
            "i        *",
            "**********"
    };

    private Huone eteinen;
    private Huone olohuone;
    private Huone keittiö;
    private Huone vessa;
    private Huone makuuhuone;
    private Pelaaja pelaaja;

    public static void main(String[] args) {
        Peli peli = new Peli();
        peli.alustaPeli();
        peli.pelaa();
    }

    private void alustaPeli() {
        // Luodaan huone-oliot ja niihin tavara-oliot
        eteinen = new Huone("eteinen", "Olet eteisessä. Eteinen on vain pieni ahdas tuulikaappi, jonka lattialla lojuu kenkiä sikin sokin. Kenkien seassa näkyy muitakin esineitä:", eteisenKartta);
        eteinen.tavaralista.add(new Tavara("omena", "Punainen herkullinen omena, jonka voinee syödä.", "eteinen", true, false, false));
        eteinen.tavaralista.add(new Tavara("reppu", "Vanha nahkareppu.", "eteinen", false, true, false));
        eteinen.tavaralista.add(new Tavara("sateenvarjo", "Hieno sateenvarjo, jota ei tohdi sisällä avata.", "eteinen", false, false, false));
        eteinen.tavaralista.add(new Tavara("vasara", "Vanha vasara, jota koodarina et tietenkään osaa käyttää.", "eteinen", false, false, false));
        olohuone = new Huone("olohuone", "Saavuit olohuoneeseen. Olohuoneessa on suuri punainen sohva ja vanha putkitelevisio. Huoneessa ei ole siivottu aikoihin. Sohvalla lojuu tavaroita:", olohuoneenKartta);
        olohuone.tavaralista.add(new Tavara("avain", "Random avain, ei tietoa mihin lukkoon se käy.", "eteinen", false, false, false));
        olohuone.tavaralista.add(new Tavara("kynä", "Lyijykynä. Kärki poikki. Ei voi kirjoittaa.", "eteinen", false, false, false));
        olohuone.tavaralista.add(new Tavara("juomapullo", "Juomapullo.", "eteinen", false, true, true));
        olohuone.tavaralista.add(new Tavara("sukka", "Vanha, hikinen sukka.", "eteinen", false, false, false));
        keittiö = new Huone("keittiö", "Tulit keittiöön. Keittiössä on pieni ruokailuryhmä ja suuri jääkaappi.Huoneessa on todella kylmä. Jääkaapin ovi on jäänyt auki. Jääkaapissa on pilaantunutta ruokaa sekä:", keittiönKartta);
        keittiö.tavaralista.add(new Tavara("juusto", "Herkullisen hajuinen juusto. Melkein tekisi mieli maistaa.", "eteinen", true, false, false));
        keittiö.tavaralista.add(new Tavara("sakset", "Sakset, joilla äitisi kielsi leikkimästä.", "eteinen", false, false, false));
        keittiö.tavaralista.add(new Tavara("avokado", "Avokado. Ovat kuulema terveellisiä.", "eteinen", true, false, true));
        keittiö.tavaralista.add(new Tavara("viilipurkki", "Viilipurkki. Herkkua.", "eteinen", true, true, false));
        makuuhuone = new Huone("makuuhuone", "Kuljit makuuhuoneeseen. Hämyisessä huoneessa on iso laverisänky vanhalla kulahtaneella patjalla. Patjassa on painaumia ja näyttää siltä, että siinä on juuri nukuttu. Sängyn alta pilkottaa:", makuuhuoneenKartta);
        makuuhuone.tavaralista.add(new Tavara("veitsi", "Ruosteinen voiveitsi.", "eteinen", false, false, false));
        makuuhuone.tavaralista.add(new Tavara("kirja", "Paksu opus. Kannessa ei ole mitään tekstiä.", "eteinen", false, true, false));
        makuuhuone.tavaralista.add(new Tavara("suklaapatukka", "Nam! Suklaapatukka. Parasta ennen päiväys näyttää kyllä menneen umpeen, mutta kai tämän voisi syödä.", "eteinen", true, false, true));
        makuuhuone.tavaralista.add(new Tavara("salkku", "Vanha nahkainen salkku... voisikohan tämän avata?", "eteinen", false, true, false));
        vessa = new Huone("vessa", "Tuliko vessahätä? Vessanpönttö on vetämättä ja haju ahtaassa vessassa on kuvottava. Lattialla lojuu:", wcnKartta);
        vessa.tavaralista.add(new Tavara("hiuspinni", "Hiuspinnillä hiukset pysyvät pois silmiltä, mutta tämä pinni näyttäisi olevan rikki.", "eteinen", false, false, false));
        vessa.tavaralista.add(new Tavara("saippua", "Vanha kuivunut palasaippua.", "eteinen", false, false, true));
        vessa.tavaralista.add(new Tavara("kampa", "Tällä harvalla kammalla ei enää juurikaan hiuksia kammata.", "eteinen", false, false, false));
        vessa.tavaralista.add(new Tavara("kurkkupastilli", "Onko kurkku kipeä? Tämän syömällä ainakin henki raikastuu.", "eteinen", true, false, false));

        // Luodaan pelaaja
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa seikkailutaloon!\nMikä on nimesi? ");
        String nimi = lukija.nextLine();
        pelaaja = new Pelaaja(nimi, eteinen);
        System.out.println("Moi " + nimi + "!\nTavoitteesi on etsiä talosta kolme timanttia ja löytää tie ulos.\n" +
                "Voit liikkua talossa huoneesta huoneeseen komennoilla 'eteen', 'taakse', 'oikea', 'vasen'.\n" +
                "Muut komennot voit katsoa kirjoittamalla 'komennot' jos et itse niitä keksi.\n\n" +
                "Aloita peli komennolla 'aloita'.\n" +
                " Onnea matkaan " + nimi + "!");
        String seuraava = lukija.nextLine();
        while (!(seuraava.contains("aloita"))){
            seuraava = lukija.nextLine();
        }
        pelaaja.setPelaajanSijainti(eteinen);
        System.out.println(eteinen);
    }

    // pelaa
    private void pelaa() {
        if (pelaaja.getTimanttilaskuri() == 3) {
            System.out.println("");
            System.out.println("******* JEEE!! *******");
            System.out.println("LÖYSIT KOLME TIMANTTIA");
            System.out.println("**** PÄÄSIT LÄPI!! ****");
            System.out.println("******* ONNEA" + pelaaja.getNimi()+ "!!*******");
        }
        Scanner lukijaPeli = new Scanner(System.in);
        String syöte = lukijaPeli.nextLine();


        // katso komennot
        if (syöte.contains("komennot")) {
            pelaaja.pyydäKomennot();
            pelaa();
        }

        // ota tavara huoneesta pelaajalle
        else if (syöte.contains("ota")) {
            pelaaja.otaTavara(syöte);
            pelaa();
        }

        // syö tavara
        else if (syöte.contains("syö")) {
            pelaaja.syö(syöte);
            pelaa();
        }

        // avaa tavara
        else if (syöte.contains("avaa")) {
            pelaaja.avaa(syöte);
            pelaa();
        }

        // tutki tavara
        else if (syöte.contains("tutki")) {
            pelaaja.tutki(syöte);
            pelaa();
        }
        // katso kartta
        else if (syöte.contains("kartta")){
            System.out.println(pelaaja.getPelaajanSijainti().haeKartta());
            pelaa();
        }
        //listaa omat tavarat
        else if (syöte.contains("omat tavar")){
            System.out.println(pelaaja.katsoTavarat());
            pelaa();
        }
        //listaa huoneen tavarat
        else if (syöte.contains("huoneen tavar")){
            System.out.println("Huoneessa on:\n" + pelaaja.getPelaajanSijainti().haeTavarat());
            pelaa();
        }

        // liikkuminen huoneesta toiseen
        // Jos pelaaja eteisessä
        else if (pelaaja.getPelaajanSijainti().equals(eteinen)) {
            if (syöte.contains("eteen")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone);
            } else if (syöte.contains("taakse") || syöte.contains("oikea") || syöte.contains("vase")) {
                System.out.println("Seinä tuli vastaan!");
            } else {
                System.out.println("En ymmärrä!");
            }
            pelaa();
        }
        // Jos pelaaja olohuoneessa
        else if (pelaaja.getPelaajanSijainti().equals(olohuone)) {
            if (syöte.contains("eteen")) {
                pelaaja.setPelaajanSijainti(makuuhuone);
                System.out.println(makuuhuone);
            } else if (syöte.contains("oikea")) {
                pelaaja.setPelaajanSijainti(vessa);
                System.out.println(vessa);
            } else if (syöte.contains("vase")) {
                pelaaja.setPelaajanSijainti(keittiö);
                System.out.println(keittiö);
            } else if (syöte.contains("taakse")) {
                pelaaja.setPelaajanSijainti(eteinen);
                System.out.println(eteinen);
            } else {
                System.out.println("En ymmärrä!");
            }
            pelaa();
        }
        // Jos pelaaja makuuhuoneessa
        else if (pelaaja.getPelaajanSijainti().equals(makuuhuone)) {
            if (syöte.contains("eteen") || syöte.contains("oikea") || syöte.contains("vase")) {
                System.out.println("Törmäsit seinään!");
            }
            if (syöte.contains("taakse")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone);
            }
            pelaa();
        }
        // Jos pelaaja vessassa
        else if (pelaaja.getPelaajanSijainti().equals(vessa)) {
            if (syöte.contains("eteen") || syöte.contains("oikea") || syöte.contains("taakse")) {
                System.out.println("Törmäsit seinään!");
            }
            if (syöte.contains("vase")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone);

            }
            pelaa();
        }
        // Jos pelaaja keittiössä
        else if (pelaaja.getPelaajanSijainti().equals(keittiö)) {
            if (syöte.contains("eteen") || syöte.contains("vase") || syöte.contains("taakse")) {
                System.out.println("Törmäsit seinään!");
            }
            if (syöte.contains("oikea")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone);
            }
            pelaa();
        } else {
            System.out.println("Olet eksyksissä!");
        }
    }
}




