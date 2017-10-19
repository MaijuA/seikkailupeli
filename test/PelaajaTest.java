import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PelaajaTest {
    Pelaaja pelaaja;
    Tavara tavara;
    Tavara uusi;
    Huone eteinen;

    @Before
    public void setUp() throws Exception {
        eteinen = new Huone("eteinen", "kuvaus");
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


}
