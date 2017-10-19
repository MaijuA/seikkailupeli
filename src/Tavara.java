public class Tavara {

    String tavaranNimi;
    String ominaisuudet;
    boolean syötävä;
    boolean avattava;
    boolean onkoTimanttia;
    boolean poistaTimantti;
    String tavaranSijainti;

    public Tavara(String tavaranNimi, String ominaisuudet, String tavaranSijainti, boolean syötävä, boolean avattava, boolean onkoTimanttia, boolean poistaTimantti) {
        this.tavaranNimi = tavaranNimi;
        this.ominaisuudet = ominaisuudet;
        this.tavaranSijainti = tavaranSijainti;
        this.syötävä = syötävä;
        this.avattava = avattava;
        this.onkoTimanttia = onkoTimanttia;
        this.poistaTimantti = poistaTimantti;
    }
    public String getTavaranNimi() {
        return tavaranNimi;
    }
    public String getTavaranSijainti() {
        return tavaranSijainti;
    }

    @Override
    public String toString() {
        return tavaranNimi;
    }
}