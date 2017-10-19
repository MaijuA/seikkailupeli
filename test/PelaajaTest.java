import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PelaajaTest {
    Pelaaja pelaaja;
    Tavara tavara;
    Tavara uusi;
    Huone eteinen;
    Huone olohuone;
    Huone vessa;
    Huone makuuhuone;
    Huone keittiö;

    @Before
    public void setUp() throws Exception {
        eteinen = new Huone("eteinen", "kuvaus");
        olohuone = new Huone("eteinen", "kuvaus");
        vessa = new Huone("eteinen", "kuvaus");
        keittiö = new Huone("eteinen", "kuvaus");
        makuuhuone = new Huone("eteinen", "kuvaus");
        pelaaja = new Pelaaja("Peikko", eteinen);
        tavara = new Tavara("juusto", "Punainen herkullinen omena", "eteinen", true, false, false, false);
        eteinen.tavaralista.add(tavara);
    }

    @Test
    public void testaaTavaranLisäys() throws Exception {
        pelaaja.otaTavara("juusto");
        int listanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Tavaroiden määrä: ", 1, listanKoko);
    }


    @Test
    public void testaaTutki() throws Exception {
        eteinen.tavaralista.add(tavara);
        pelaaja.otaTavara("juusto");
        assertEquals("Tuleeko ominaisuusteksti", "Punainen herkullinen omena", tavara.ominaisuudet );
    }

    @Test
    public void testaaSijainninTarkistus() throws Exception {
        Huone olohuone = new Huone("olohuone", "kuvaus");
        pelaaja.setPelaajanSijainti(olohuone);
        assertEquals("Sijainti: ", "olohuone", olohuone.getHuoneenNimi());
    }

    @Test
    public void testaaTavaranOttaminen() throws Exception {
        pelaaja.otaTavara("juusto");
        int pelaajanTavaralistanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Pelaajan tavaramäärä", 1, pelaajanTavaralistanKoko);
        int huoneenTavaralistanKoko = eteinen.tavaralista.size();
        assertEquals("Huoneen tavaramäärä", 0, huoneenTavaralistanKoko );
    }

    @Test
    public void liikuEteen() throws Exception {
        pelaaja.setPelaajanSijainti(eteinen);
        pelaaja.eteen(eteinen, olohuone, makuuhuone, keittiö, vessa);
        assertEquals(olohuone, pelaaja.getPelaajanSijainti());
    }

    @Test
    public void liikuVasemmalle() throws Exception {
        pelaaja.setPelaajanSijainti(eteinen);
        pelaaja.vasemmalle(eteinen, olohuone, makuuhuone, keittiö, vessa);
        assertEquals(eteinen, pelaaja.getPelaajanSijainti());
    }

    @Test
    public void liikuOikealle() throws Exception {
        pelaaja.setPelaajanSijainti(keittiö);
        pelaaja.oikealle(eteinen, olohuone, makuuhuone, keittiö, vessa);
        assertEquals(olohuone, pelaaja.getPelaajanSijainti());
    }

    @Test
    public void liikuTaakse() throws Exception {
        pelaaja.setPelaajanSijainti(makuuhuone);
        pelaaja.taakse(eteinen, olohuone, makuuhuone, keittiö, vessa);
        assertEquals(olohuone, pelaaja.getPelaajanSijainti());
    }



}
