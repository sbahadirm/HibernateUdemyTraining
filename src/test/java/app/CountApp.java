package app;

import entityservice.UrunEntityService;

public class CountApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Long urunSayisi = service.countUrunByUrunTuruId(1L);

        System.out.println(urunSayisi);
    }
}
