package app;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

public class OrderApp {

    public static void main(String[] args) {
        UrunEntityService service = new UrunEntityService();

        List<Urun> urunList = service.findAllWithOrder();

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi() + " - " + urun.getStokMiktari());
        }
    }
}
