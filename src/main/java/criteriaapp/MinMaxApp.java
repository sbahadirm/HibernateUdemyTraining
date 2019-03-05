package criteriaapp;

import entityservice.UrunEntityService;

import java.math.BigDecimal;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class MinMaxApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        BigDecimal minUrunFiyatWithCriteria = service.findMinUrunFiyatWithCriteria();

        BigDecimal maxUrunFiyatWithCriteria = service.findMaxUrunFiyatWithCriteria();

        System.out.println(minUrunFiyatWithCriteria);

        System.out.println(maxUrunFiyatWithCriteria);

    }
}
