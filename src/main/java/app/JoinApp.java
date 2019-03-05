package app;

import dto.UrunBilgiDto;
import entityservice.UrunEntityService;

import java.util.List;

public class JoinApp {

    public static void main(String[] args) {

        UrunEntityService service = new UrunEntityService();

        List<UrunBilgiDto> urunBilgiDtoList = service.findAllUrunBilgiDto();

        for (UrunBilgiDto urunBilgiDto : urunBilgiDtoList) {
            System.out.println(urunBilgiDto);
        }
    }
}
