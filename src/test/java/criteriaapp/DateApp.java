package criteriaapp;

import domain.Urun;
import entityservice.UrunEntityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class DateApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date sonKullanmaTarihi = null;
        try {
            sonKullanmaTarihi = format.parse("2020-12-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Urun> urunList = service.findAllUrunListBySonKullanmaTarihiGeWithCriteria(sonKullanmaTarihi);

        for (Urun urun : urunList) {
            System.out.println(urun.getAdi() + " - " + format.format(urun.getSonKullanmaTarihi()));
        }
    }
}
