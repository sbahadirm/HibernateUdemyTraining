package criteriaapp;

import dto.UrunDto;
import entityservice.UrunEntityService;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class ProjectionApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<UrunDto> urunDtoList = service.findAllUrunDtoWithCriteria();

        for (UrunDto urunDto : urunDtoList) {
            System.out.println(urunDto);
        }
    }
}
