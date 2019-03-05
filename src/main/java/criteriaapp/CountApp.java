package criteriaapp;

import entityservice.UrunEntityService;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class CountApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Long toplamUrunSayisi = service.countUrunByUrunTuruIdWithCriteria(1L);

        System.out.println(toplamUrunSayisi);
    }
}
