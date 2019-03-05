package criteriaapp;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class BetweenApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<Urun> urunList = service.findAllUrunListByStokMiktariMinAndMaxWithCriteria(100L, 500L);

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi() + " - " + urun.getStokMiktari());
        }
    }
}
