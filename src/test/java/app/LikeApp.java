package app;

import domain.UrunTuru;
import entityservice.UrunTuruEntityService;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class LikeApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();

        List<UrunTuru> urunTuruList = service.findUrunTuruListByAdi("ecek", MatchMode.ANYWHERE);

        for (UrunTuru urunTuru : urunTuruList) {
            System.out.println(urunTuru.getAdi());
        }
    }
}
