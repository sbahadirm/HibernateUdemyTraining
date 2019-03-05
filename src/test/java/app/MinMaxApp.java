package app;

import entityservice.UrunEntityService;

import java.math.BigDecimal;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class MinMaxApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        BigDecimal minUrunFiyat = service.findMinUrunFiyat();

        BigDecimal maxUrunFiyat = service.findMaxUrunFiyat();

        System.out.println("Min: -> " + minUrunFiyat);

        System.out.println("Max: -> " + maxUrunFiyat);
    }
}
