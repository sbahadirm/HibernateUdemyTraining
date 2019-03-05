package app;

import entityservice.UrunEntityService;

public class SumApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Long toplamStokMiktari = service.sumUrunStokMiktariByUrunTuruId(1L);

        System.out.println(toplamStokMiktari);

    }
}
