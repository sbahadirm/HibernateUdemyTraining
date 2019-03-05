package app;

import entityservice.UrunEntityService;

public class AvgApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        Double ortalamaStokMiktari = service.findOrtalamaStokMiktari();

        System.out.println(ortalamaStokMiktari);
    }
}
