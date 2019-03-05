package app;

import domain.Urun;
import entityservice.UrunEntityService;

public class FindByIdApp {

    public static void main(String[] args) {

        UrunEntityService urunEntityService = new UrunEntityService();

        Urun urun1 = urunEntityService.findById(1L);

        System.out.println(urun1.getAdi());

    }
}

