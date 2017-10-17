import java.util.Scanner;

public class Peli {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa seikkailutaloon!\nMikä on nimesi? ");
        String nimi = lukija.nextLine();
        Huone eteinen = new Huone(1, "eteinen", "Olet eteisessä. Täällä on....");
        Pelaaja pelaaja = new Pelaaja(nimi, eteinen);
        System.out.println("Moi " + nimi + "! Tavoitteesi on etsiä talosta viisi timanttia ja löytää tie ulos.\n" +
                "Voit liikkua talossa huoneesta huoneeseen komennoilla 'katso ympärillesi', 'eteen', 'taakse', 'oikealle' 'vasemmalle'.\n" +
                "Muut komennot sinun tulee keksiä itse. Onnea matkaan " + nimi + "!");
        Peli peli = new Peli();
        pelaaja.setPelaajanSijainti(eteinen);
        Huone olohuone = new Huone(2, "olohuone", "Kävelit olohuoneeseen. Täällä on....");
        Huone keittiö = new Huone(3, "keittiö", "Saavuit keittiöön. Täällä on....");
        Huone makuuhuone = new Huone(4, "makuuhuone", "Tulit makuuhuoneeseen. Edessäsi on iso sänky, huoneen nurkassa on nojatuoli" +
                " jonka vieressä on pieni pyöreä pöytä. Pöydällä on tavaroita, joita voit käyttää: sakset, suurennuslasi, " +
                " kirja, tulitikut ja köysi.");
        Huone vessa = new Huone(5, "vessa", "Tuliko vessahätä? ...");
        peli.pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
    }

    private void pelaa(Pelaaja pelaaja, Huone eteinen, Huone olohuone, Huone makuuhuone, Huone keittiö, Huone vessa) {
        Scanner lukijaPeli = new Scanner(System.in);
        String syöte = lukijaPeli.nextLine();
        if (syöte.contains("katso")) {
            //System.out.println(eteinen.getKuvaus());
            Huone huonen = pelaaja.getPelaajanSijainti();
            System.out.println(huonen.getKuvaus());
            // tulosta tavaralista
            // tulosta kartta
            pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
        }
        if (pelaaja.getPelaajanSijainti().equals(eteinen)) {
            if (syöte.contains("eteen")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("taakse") || syöte.contains("oikea") || syöte.contains("vase")) {
                System.out.println("Seinä tuli vastaan!");
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            // Tavaran ottaminen
            if (syöte.contains("ota")) {
                eteinen.otaTavara("jotain");
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            } else {
                System.out.println("En ymmärrä!");
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
        }
        if (pelaaja.getPelaajanSijainti().equals(olohuone)) {
            if (syöte.contains("eteen")) {
                pelaaja.setPelaajanSijainti(makuuhuone);
                System.out.println(makuuhuone.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("oikea")) {
                pelaaja.setPelaajanSijainti(vessa);
                System.out.println(vessa.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("vase")) {
                pelaaja.setPelaajanSijainti(keittiö);
                System.out.println(keittiö.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("taakse")) {
                pelaaja.setPelaajanSijainti(eteinen);
                System.out.println(eteinen.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
        }
        if (pelaaja.getPelaajanSijainti().equals(makuuhuone)) {
            if (syöte.contains("eteen") || syöte.contains("oikea") || syöte.contains("vase")) {
                System.out.println("Törmäsit seinään!");
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("taakse")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
        }
        if (pelaaja.getPelaajanSijainti().equals(vessa)) {
            if (syöte.contains("eteen") || syöte.contains("oikea") || syöte.contains("taakse")) {
                System.out.println("Törmäsit seinään!");
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("vasen")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
        }
        if (pelaaja.getPelaajanSijainti().equals(keittiö)) {
            if (syöte.contains("eteen") || syöte.contains("vase") || syöte.contains("taakse")) {
                System.out.println("Törmäsit seinään!");
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
            if (syöte.contains("oikea")) {
                pelaaja.setPelaajanSijainti(olohuone);
                System.out.println(olohuone.getKuvaus());
                pelaa(pelaaja, eteinen, olohuone, makuuhuone, keittiö, vessa);
            }
        }

    }
}
