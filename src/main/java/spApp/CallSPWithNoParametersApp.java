package spApp;

import domain.Urun;
import entityservice.UrunEntityService;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class CallSPWithNoParametersApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<Urun> urunList = service.callUrunFindAll();

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi());
        }
    }
}
