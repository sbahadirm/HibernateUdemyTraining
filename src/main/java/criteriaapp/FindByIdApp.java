package criteriaapp;

import domain.Urun;
import entityservice.UrunEntityService;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class FindByIdApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Urun urun = service.findByIdWithCriteria(1L);

        System.out.println(urun.getAdi());
    }
}
