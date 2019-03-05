package app;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class BetweenApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<Urun> urunList = service.findAllUrunListByStokMiktariMinAndMax2(100L, 500L);

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi() + " - " + urun.getStokMiktari());
        }
    }
}
