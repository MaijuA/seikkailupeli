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
    Huone eteinen;

    @Before
    public void setUp() throws Exception {
        eteinen = new Huone("eteinen", "kuvaus");
        pelaaja = new Pelaaja("Peikko", eteinen);
        tavara = new Tavara("juusto", "Punainen herkullinen omena", "eteinen", true, false, false);
    }

    @Test
    public void testaaTavaranLisäys() throws Exception {
        pelaaja.otaTavara("tavara");
        int listanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Tavaroiden määrä: ", 1, listanKoko);
    }

    @Test
    public void testaaTavaranPoisto() throws Exception {
        Tavara uusi = new Tavara("sakset", "Vanha nahkareppu", "eteinen", false, false, false);
        pelaaja.otaTavara("uusi");
        pelaaja.otaTavara("tavara");
        pelaaja.poistaTavaraListalta(tavara);
        int listanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Tavaroiden määrä: ", 1, listanKoko);
    }

    @Test
    public void testaaSijainninTarkistus() throws Exception {
        Huone olohuone = new Huone("olohuone", "kuvaus");
        pelaaja.setPelaajanSijainti(olohuone);
        assertEquals("Sijainti: ", "olohuone", olohuone.getHuoneenNimi());
    }

    @Test
    public void testaaTavaranOttaminen() throws Exception {
        pelaaja.otaTavara("timanttii");
        int pelaajanTavaralistanKoko = pelaaja.getPelaajanTavaralista().size();
        assertEquals("Pelaajan tavaramäärä", 1, pelaajanTavaralistanKoko);
        int huoneenTavaralistanKoko = eteinen.tavaralista.size();
        assertEquals("Huoneen tavaramäärä", 0, huoneenTavaralistanKoko );
    }


}
