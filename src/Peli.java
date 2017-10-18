import java.util.ArrayList;
import java.util.Scanner;

public class Peli {
    public static void main(String[] args) {
        // Luodaan huone-oliot ja niihin tavara-oliot
        Huone eteinen = new Huone("eteinen", "Olet eteisessä. Eteinen on vain pieni ahdas tuulikaappi, jonka lattialla lojuu kenkiä sikin sokin. Kenkien seassa näkyy muitakin esineitä:");
        eteinen.tavaralista.add(new Tavara("omena", "Punainen herkullinen omena", "eteinen", true, false, false));
        eteinen.tavaralista.add(new Tavara("reppu", "Vanha nahkareppu", "eteinen", false, true, false));
        eteinen.tavaralista.add(new Tavara("sateenvarjo", "Punainen herkullinen omena", "eteinen", false, false, false));
        eteinen.tavaralista.add(new Tavara("vasara", "Vanha nahkareppu", "eteinen", false, false, false));
        Huone olohuone = new Huone("olohuone", "Saavuit olohuoneeseen. Olohuoneessa on suuri punainen sohva ja vanha putkitelevisio. Huoneessa ei ole siivottu aikoihin. Sohvalla lojuu tavaroita:");
        olohuone.tavaralista.add(new Tavara("avain", "Punainen herkullinen omena", "eteinen", false, false, false));
        olohuone.tavaralista.add(new Tavara("kynä", "Vanha nahkareppu", "eteinen", false, false, false));
        olohuone.tavaralista.add(new Tavara("juomapullo", "Punainen herkullinen omena", "eteinen", true, true, true));
        olohuone.tavaralista.add(new Tavara("sukka", "Vanha nahkareppu", "eteinen", false, false, false));
        Huone keittiö = new Huone("keittiö", "Tulit keittiöön. Keittiössä on pieni ruokailuryhmä ja suuri jääkaappi.Huoneessa on todella kylmä. Jääkaapin ovi on jäänyt auki. Jääkaapissa on pilaantunutta ruokaa sekä:");
        keittiö.tavaralista.add(new Tavara("juusto", "Punainen herkullinen omena", "eteinen", true, false, false));
        keittiö.tavaralista.add(new Tavara("sakset", "Vanha nahkareppu", "eteinen", false, false, false));
        keittiö.tavaralista.add(new Tavara("avokado", "Punainen herkullinen omena", "eteinen", true, false, true));
        keittiö.tavaralista.add(new Tavara("viilipurkki", "Vanha nahkareppu", "eteinen", true, true, false));
        Huone makuuhuone = new Huone("makuuhuone", "Kuljit makuuhuoneeseen. Hämyisessä huoneessa on iso laverisänky vanhalla kulahtaneella patjalla. Patjassa on painaumia ja näyttää siltä, että siinä on juuri nukkuttu. Sängyn alta pilkottaa:");
        makuuhuone.tavaralista.add(new Tavara("veitsi", "Punainen herkullinen omena", "eteinen", false, false, false));
        makuuhuone.tavaralista.add(new Tavara("kirja", "Vanha nahkareppu", "eteinen", false, true, false));
        makuuhuone.tavaralista.add(new Tavara("kinder-muna", "Punainen herkullinen omena", "eteinen", true, true, true));
        makuuhuone.tavaralista.add(new Tavara("salkku", "Vanha nahkareppu", "eteinen", false, true, false));
        Huone vessa = new Huone("vessa", "Tuliko vessahätä? Vessanpönttö on vetämättä ja haju ahtaassa vessassa on kuvottava. Lattialla lojuu:");
        vessa.tavaralista.add(new Tavara("hiuspinni", "Punainen herkullinen omena", "eteinen", false, false, false));
        vessa.tavaralista.add(new Tavara("saippua", "Vanha nahkareppu", "eteinen", false, false, true));
        vessa.tavaralista.add(new Tavara("kampa", "Punainen herkullinen omena", "eteinen", false, false, false));
        vessa.tavaralista.add(new Tavara("kurkkupastilli", "Vanha nahkareppu", "eteinen", true, false, false));

        // Luodaan pelaaja
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa seikkailutaloon!\nMikä on nimesi? ");
        String nimi = lukija.nextLine();
        Pelaaja pelaaja = new Pelaaja(nimi, eteinen);
        System.out.println("Moi " + nimi + "! Tavoitteesi on etsiä talosta viisi timanttia ja löytää tie ulos.\n" +
                "Voit liikkua talossa huoneesta huoneeseen komennoilla 'katso ympärillesi', 'eteen', 'taakse', 'oikealle' 'vasemmalle'.\n" +
                "Muut komennot sinun tulee keksiä itse. Onnea matkaan " + nimi + "!");

        // Luodaan peli
        Peli peli = new Peli();
        pelaaja.setPelaajanSijainti(eteinen);
        peli.pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
    }

    // pelaa
    private void pelaa(Pelaaja pelaaja, Huone eteinen, Huone olohuone, Huone makuuhuone, Huone keittiö, Huone vessa) {
        // if (pelaaja.getTimantit() == 3) {
        //     System.out.println("Pääsit läpi!");
        // }
        Scanner lukijaPeli = new Scanner(System.in);
        String syöte = lukijaPeli.nextLine();

        // hae huoneen kuvaus
        if (syöte.contains("katso")) {
            //System.out.println(eteinen.getKuvaus());
            Huone huone = pelaaja.getPelaajanSijainti();
            System.out.println(huone.getHuoneenKuvaus());
            // tulosta tavaralista
            // tulosta kartta
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }

        // ota tavara huoneesta pelaajalle
        else if (syöte.contains("ota")) {
            //pelaaja.otaTavara(syöte);
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }

        // syö tavara
        else if (syöte.contains("syö")) {
//pelaaja.syö(syöte);
        }

        // avaa tavara
        else if (syöte.contains("avaa")) {
// pelaaja.avaa(syöte);
        }

        // tutki tavara
        else if (syöte.contains("tutki")) {
            pelaaja.tutki(syöte);
        }

        // liikkuminen huoneesta toiseen
        // Jos pelaaja eteisessä
        else if (pelaaja.getPelaajanSijainti().equals(eteinen)) {
            if (syöte.contains("eteen")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getHuoneenKuvaus());
            } else if (syöte.contains("taakse") || syöte.contains("oikea") || syöte.contains("vase")) {
                System.out.println("Seinä tuli vastaan!");
            } else {
                System.out.println("En ymmärrä!");
            }
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }
        // Jos pelaaja olohuoneessa
        else if (pelaaja.getPelaajanSijainti().equals(olohuone)) {
            if (syöte.contains("eteen")) {
                pelaaja.setPelaajanSijainti(makuuhuone);
                System.out.println(makuuhuone.getHuoneenKuvaus());
            } else if (syöte.contains("oikea")) {
                pelaaja.setPelaajanSijainti(vessa);
                System.out.println(vessa.getHuoneenKuvaus());
            } else if (syöte.contains("vase")) {
                pelaaja.setPelaajanSijainti(keittiö);
                System.out.println(keittiö.getHuoneenKuvaus());
            } else if (syöte.contains("taakse")) {
                pelaaja.setPelaajanSijainti(eteinen);
                System.out.println(eteinen.getHuoneenKuvaus());
            } else {
                System.out.println("En ymmärrä!");
            }
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }
        // Jos pelaaja makuuhuoneessa
        else if (pelaaja.getPelaajanSijainti().equals(makuuhuone)) {
            if (syöte.contains("eteen") || syöte.contains("oikea") || syöte.contains("vase")) {
                System.out.println("Törmäsit seinään!");
            }
            if (syöte.contains("taakse")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getHuoneenKuvaus());
            }
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }
        // Jos pelaaja vessassa
        else if (pelaaja.getPelaajanSijainti().equals(vessa)) {
            if (syöte.contains("eteen") || syöte.contains("oikea") || syöte.contains("taakse")) {
                System.out.println("Törmäsit seinään!");
            }
            if (syöte.contains("vase")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getHuoneenKuvaus());

            }
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }
        // Jos pelaaja keittiössä
        else if (pelaaja.getPelaajanSijainti().equals(keittiö)) {
            if (syöte.contains("eteen") || syöte.contains("vase") || syöte.contains("taakse")) {
                System.out.println("Törmäsit seinään!");
            }
            if (syöte.contains("oikea")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getHuoneenKuvaus());
            } else {
                System.out.println("Olet eksyksissä!");
            }
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }
    }
}




