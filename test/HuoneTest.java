import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 18.10.2017.
 */
public class HuoneTest {
    Pelaaja pelaaja;
    Tavara tavara;
    Tavara uusi;
    Huone eteinen;

    @Before
    public void setUp() throws Exception {
        eteinen = new Huone("eteinen", "kuvaus");
        pelaaja = new Pelaaja("Peikko", eteinen);
        tavara = new Tavara("juusto", "Punainen herkullinen omena", "eteinen", true, false, false, false);
        uusi = new Tavara("sakset", "Vanha nahkareppu", "eteinen", false, false, false, false);
    }

    @Test
    public void testaaHaeTavarat() throws Exception {
        assertEquals("Ei ole.", eteinen.haeTavarat());
        eteinen.tavaralista.add(tavara);
        assertEquals("juusto\n", eteinen.haeTavarat());
    }

    @Test
    public void testaaHaeKartta() throws Exception {
        String[] eteinenkartta = {
                "****ovi****",
                "*         *",
                "*    x    *",
                "*         *",
                "***********"
        };
        //assertEquals(eteinenkartta, eteinen.haeKartta());
    }
}