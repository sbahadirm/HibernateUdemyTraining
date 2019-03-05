package criteriaapp;

import dto.UrunBilgiDto;
import entityservice.UrunEntityService;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class JoinApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<UrunBilgiDto> urunBilgiDtoList = service.findAllUrunBilgiDtoWithCriteria();

        for (UrunBilgiDto urunBilgiDto : urunBilgiDtoList) {
            System.out.println(urunBilgiDto);
        }
    }
}
