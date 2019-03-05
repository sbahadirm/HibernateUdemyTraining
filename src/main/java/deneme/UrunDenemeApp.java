package deneme;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class UrunDenemeApp {

//    public static void main(String[] args) {
//
//        UrunDenemeDao urunDenemeDao  =new UrunDenemeDao();
//
//        UrunDeneme urunDeneme = new UrunDeneme();
//        urunDeneme.setEmail("sbahadir@gmail.com");
//        urunDeneme.setPhone(BigDecimal.valueOf(054));
//        urunDeneme.setSifre("1231231234");
//
//        urunDenemeDao.save(urunDeneme);
//
//        UrunDeneme urunDeneme1 = new UrunDeneme();
//        urunDeneme1.setEmail("ayse@gmail.com");
//        urunDeneme1.setPhone(BigDecimal.valueOf(111));
//        urunDeneme1.setSifre("0000");
//
//        urunDenemeDao.save(urunDeneme1);
//
//        UrunDeneme urunDeneme2 = new UrunDeneme();
//        urunDeneme2.setEmail("fatma@gmail.com");
//        urunDeneme2.setPhone(BigDecimal.valueOf(444));
//        urunDeneme2.setSifre("999");
//
//        urunDenemeDao.save(urunDeneme2);
//    }

    public static void main(String[] args) {

        UrunDenemeDao urunDenemeDao  =new UrunDenemeDao();

        List<UrunDeneme> urunDenemeList = urunDenemeDao.findAll();

        Object o = urunDenemeList.get(0);
        System.out.println(o);

        for (UrunDeneme urunDeneme : urunDenemeList) {
            System.out.println(urunDeneme);
        }
    }
}
