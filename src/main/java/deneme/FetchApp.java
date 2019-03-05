package deneme;

import dao.UrunDao;
import domain.Urun;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class FetchApp {

    public static void main(String[] args) {

        UrunDao urunDao = new UrunDao();

        List<Urun> urunList = urunDao.findFetch();

        for (Urun urun : urunList) {
            System.out.println(urun);
        }
    }
}
