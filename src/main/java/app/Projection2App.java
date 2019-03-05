package app;

import dao.UrunDao;
import domain.Urun;
import dto.UrunDto;
import entityservice.UrunEntityService;

import java.util.List;

public class Projection2App {

    public static void main(String[] args) {

        UrunDao service = new UrunDao();

        List<Urun> urunDtoList = service.findAllUrunDto2();

        for (Urun urunDto : urunDtoList) {
            System.out.println(urunDto.getAdi() + " / " + urunDto.getId());
        }
    }
}
