package app;

import entityservice.UrunEntityService;
import enums.EnumBirim;

import java.util.List;

public class DistinctApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<EnumBirim> birimList = service.findAllUrunStokBirimi();

        for (EnumBirim enumBirim : birimList) {
            System.out.println(enumBirim.getBirim());
        }
    }
}
