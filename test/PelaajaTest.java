import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class PelaajaTest {
    Pelaaja pelaaja;
    Tavara tavara;
    Tavara uusi;

    @Before
    public void setUp() throws Exception {
        pelaaja = new Pelaaja("Peikko");
        tavara = new Tavara("timantti");
    }

    @Test
    public void testaaTavaranLisäys() throws Exception {
        pelaaja.lisääTavaraListalle(tavara);
        int listanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Tavaroiden määrä: ", 1, listanKoko);
    }

    @Test
    public void testaaTavaranPoisto() throws Exception {
        Tavara uusi = new Tavara("raha");
        pelaaja.lisääTavaraListalle(uusi);
        pelaaja.lisääTavaraListalle(tavara);
        pelaaja.poistaTavaraListalta(tavara);
        int listanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Tavaroiden määrä: ", 1, listanKoko);
    }

    @Test
    public void testaaSijainninTarkistus() throws Exception {
        Huone olohuone = new Huone(1, "olohuone", "kuvaus");
        pelaaja.setPelaajanSijainti(olohuone);
        assertEquals("Sijainti: ", "olohuone", olohuone.getNimi());
    }

}
