package spApp;

import domain.Urun;
import entityservice.UrunEntityService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class CalSPWithParameters {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        BigDecimal min = BigDecimal.ONE;
        BigDecimal max = new BigDecimal("5");

        List<Urun> urunList = service.callFindUrunBetween(min, max);

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi());
        }
    }
}
