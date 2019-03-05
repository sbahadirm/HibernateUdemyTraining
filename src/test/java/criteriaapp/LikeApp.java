package criteriaapp;

import domain.UrunTuru;
import entityservice.UrunTuruEntityService;
import org.hibernate.criterion.MatchMode;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class LikeApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();

        List<UrunTuru> turuList = service.findUrunTuruListByAdiWithCriteria("Y", MatchMode.START);

        for (UrunTuru urunTuru : turuList) {
            System.out.println(urunTuru.getAdi());
        }
    }
}
