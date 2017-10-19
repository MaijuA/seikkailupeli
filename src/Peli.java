
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
        eteinen = new Huone("eteinen", "Olet eteisessä. Eteinen on vain pieni ahdas tuulikaappi, jonka lattialla lojuu kenkiä sikin sokin. \nKenkien seassa näkyy muitakin esineitä:", eteisenKartta);
        eteinen.tavaralista.add(new Tavara("omena", "Punainen herkullinen omena, jonka voinee syödä.", "eteinen", true, false, true, false));
        eteinen.tavaralista.add(new Tavara("reppu", "Vanha nahkareppu.", "eteinen", false, true, false, false));
        eteinen.tavaralista.add(new Tavara("sateenvarjo", "Hieno sateenvarjo, jota ei tohdi sisällä avata.", "eteinen", false, false, false, false));
        eteinen.tavaralista.add(new Tavara("vasara", "Vanha vasara, jota koodarina et tietenkään osaa käyttää.", "eteinen", false, false, false, false));

        olohuone = new Huone("olohuone", "Saavuit olohuoneeseen. Olohuoneessa on suuri punainen sohva ja vanha putkitelevisio. Huoneessa ei ole siivottu aikoihin. \nSohvalla lojuu tavaroita:", olohuoneenKartta);
        olohuone.tavaralista.add(new Tavara("avain", "Random avain, ei tietoa mihin lukkoon se käy.", "eteinen", false, false, false, true));
        olohuone.tavaralista.add(new Tavara("kynä", "Lyijykynä. Kärki poikki. Ei voi kirjoittaa.", "eteinen", false, false, false, true));
        olohuone.tavaralista.add(new Tavara("juomapullo", "Juomapullo. Onkohan siellä jotain?", "eteinen", false, true, true, false));
        olohuone.tavaralista.add(new Tavara("sukka", "Vanha, hikinen sukka.", "eteinen", false, false, false, false));

        keittiö = new Huone("keittiö", "Tulit keittiöön. Keittiössä on pieni ruokailuryhmä ja suuri jääkaappi. Huoneessa on todella kylmä. Jääkaapin ovi on jäänyt auki. \nJääkaapissa on pilaantunutta ruokaa sekä:", keittiönKartta);
        keittiö.tavaralista.add(new Tavara("juusto", "Herkullisen hajuinen juusto. Melkein tekisi mieli maistaa.", "eteinen", true, false, false, false));
        keittiö.tavaralista.add(new Tavara("sakset", "Sakset, joilla äitisi kielsi leikkimästä.", "eteinen", false, false, false, true));
        keittiö.tavaralista.add(new Tavara("avokado", "Avokado. Ovat kuulema terveellisiä.", "eteinen", true, false, true, false));
        keittiö.tavaralista.add(new Tavara("viilipurkki", "Viilipurkki. Herkkua.", "eteinen", true, true, false, false));

        makuuhuone = new Huone("makuuhuone", "Kuljit makuuhuoneeseen. Hämyisessä huoneessa on iso laverisänky vanhalla kulahtaneella patjalla. Patjassa on painaumia ja näyttää siltä, että siinä on juuri nukuttu. \nSängyn alta pilkottaa:", makuuhuoneenKartta);
        makuuhuone.tavaralista.add(new Tavara("veitsi", "Ruosteinen voiveitsi.", "eteinen", false, false, false, true));
        makuuhuone.tavaralista.add(new Tavara("kirja", "Paksu opus. Kannessa ei ole mitään tekstiä.", "eteinen", false, true, true, false));
        makuuhuone.tavaralista.add(new Tavara("suklaapatukka", "Nam! Suklaapatukka. Parasta ennen päiväys näyttää kyllä menneen umpeen, mutta kai tämän voisi syödä.", "eteinen", true, false, true, false));
        makuuhuone.tavaralista.add(new Tavara("salkku", "Vanha nahkainen salkku... voisikohan tämän avata?", "eteinen", false, true, true, false));

        vessa = new Huone("vessa", "Tuliko vessahätä? Vessanpönttö on vetämättä ja haju ahtaassa vessassa on kuvottava. \nLattialla lojuu:", wcnKartta);
        vessa.tavaralista.add(new Tavara("hiuspinni", "Hiuspinnillä hiukset pysyvät pois silmiltä, mutta tämä pinni näyttäisi olevan rikki.", "eteinen", false, false, false, false));
        vessa.tavaralista.add(new Tavara("saippua", "Vanha kuivunut palasaippua.", "eteinen", true, false, true, false));
        vessa.tavaralista.add(new Tavara("kampa", "Tällä harvalla kammalla ei enää juurikaan hiuksia kammata.", "eteinen", false, false, false, false));
        vessa.tavaralista.add(new Tavara("kurkkupastilli", "Onko kurkku kipeä? Tämän syömällä ainakin henki raikastuu.", "eteinen", true, false, false, false));

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
        while (!(seuraava.toLowerCase().contains("alo"))) {
            System.out.println("'Aloita' aloittaa pelin");
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
            System.out.println("**** PÄÄSIT LÄPI!! ***");
            System.out.println("\n*ONNEA " + pelaaja.getNimi() + "!!*");
        } else {

            Scanner lukijaPeli = new Scanner(System.in);
            String syöte = lukijaPeli.nextLine();

            // katso komennot
            if (syöte.toLowerCase().contains("komennot")) {
                pelaaja.pyydäKomennot();
                pelaa();
            }

            // lopeta peli
            else if (syöte.toLowerCase().contains("lopeta")) {
                System.out.println("Lopetit pelin.");
            }

            // ota tavara huoneesta pelaajalle
            else if (syöte.toLowerCase().contains("ota")) {
                pelaaja.otaTavara(syöte);
                pelaa();
            }

            // syö tavara
            else if (syöte.toLowerCase().contains("syö")) {
                pelaaja.syö(syöte);
                pelaa();
            }

            // avaa tavara
            else if (syöte.toLowerCase().contains("avaa")) {
                pelaaja.avaa(syöte);
                pelaa();
            }

            // tutki tavara
            else if (syöte.toLowerCase().contains("tutki")) {
                pelaaja.tutki(syöte);
                pelaa();
            }
            // katso kartta
            else if (syöte.toLowerCase().contains("kartta")) {
                System.out.println(pelaaja.getPelaajanSijainti().haeKartta());
                pelaa();
            }
            // listaa omat tavarat
            else if (syöte.toLowerCase().contains("omat tavar")) {
                System.out.println(pelaaja.katsoTavarat());
                pelaa();
            }
            //listaa huoneen tavarat
            else if (syöte.toLowerCase().contains("huoneen tavar")) {
                System.out.println("Huoneessa on:\n" + pelaaja.getPelaajanSijainti().haeTavarat());
                pelaa();
            } else if (syöte.toLowerCase().contains("nuku")) {
                if (pelaaja.getPelaajanSijainti().equals(makuuhuone)) {
                    System.out.println("Zzzzz.....Zzzzz........\nOlipa makoisat nokoset!");
                } else {
                    System.out.println("Ei lattialla viitti..");
                }
                pelaa();
            }

            // liikkuminen huoneesta toiseen
            // vasemmalle
            else if (syöte.toLowerCase().contains("vase")) {
                pelaaja.vasemmalle(eteinen, olohuone, makuuhuone, keittiö, vessa);
                pelaa();
            }
            // oikealle
            else if (syöte.toLowerCase().contains("oikea")) {
                pelaaja.oikealle(eteinen, olohuone, makuuhuone, keittiö, vessa);
                pelaa();
            }
            // eteen
            else if (syöte.toLowerCase().contains("eteen")) {
                pelaaja.eteen(eteinen, olohuone, makuuhuone, keittiö, vessa);
                pelaa();
            }
            // taakse
            else if (syöte.toLowerCase().contains("taakse")) {
                pelaaja.taakse(eteinen, olohuone, makuuhuone, keittiö, vessa);
                pelaa();
            }

            // sijainnin kysyminen
            else if (syöte.toLowerCase().contains("missä")) {
                pelaaja.tarkistaSijainti();
                pelaa();
            }

            // syöte jotain ihan muuta
            else {
                System.out.println("En ymmärrä!");
                pelaa();
            }
        }
    }
}



