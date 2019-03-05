package app;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class LimitApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<Urun> urunList = service.findAllWithOrderByLimit(3);

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi() + " - " + urun.getStokMiktari());
        }
    }
}
