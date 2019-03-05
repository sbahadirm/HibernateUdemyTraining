package criteriaapp;

import entityservice.UrunEntityService;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class SumApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Long stokMiktari = service.sumUrunStokMiktariByUrunTuruIdWithCriteria();

        System.out.println(stokMiktari);
    }
}
