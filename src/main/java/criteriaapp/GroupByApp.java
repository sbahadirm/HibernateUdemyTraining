package criteriaapp;

import dto.UrunTuruDto;
import entityservice.UrunTuruEntityService;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class GroupByApp {

    public static void main(String[] args) {

        UrunTuruEntityService service = new UrunTuruEntityService();

        List<UrunTuruDto> urunTuruDtoList = service.findAllUrunTuruDtoWithCriteria();

        for (UrunTuruDto urunTuruDto : urunTuruDtoList) {
            System.out.println(urunTuruDto);
        }
    }
}
