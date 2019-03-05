package criteriaapp;

import entityservice.UrunEntityService;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class AvgApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Double ortalamaStokMiktariWithCriteria = service.findOrtalamaStokMiktariWithCriteria();

        System.out.println(ortalamaStokMiktariWithCriteria);

    }
}
