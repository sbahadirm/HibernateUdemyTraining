package entityservice;

import dao.UrunTuruDao;
import domain.UrunTuru;
import dto.UrunTuruDto;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class UrunTuruEntityService {

    private UrunTuruDao urunTuruDao;

    public UrunTuruEntityService(){
        urunTuruDao = new UrunTuruDao();
    }

    public List<UrunTuru> findAll(){
        return urunTuruDao.findAll();
    }

    public UrunTuru findById(Long id){
        return urunTuruDao.findById(id);
    }

    public List<UrunTuru> findUrunTuruListByAdi(String adi, MatchMode matchMode){
        return urunTuruDao.findUrunTuruListByAdi(adi, matchMode);
    }

    public List<UrunTuruDto> findAllUrunTuruDto(){
        return urunTuruDao.findAllUrunTuruDto();
    }

    public List<UrunTuru> findUrunTuruListByAdiWithCriteria(String adi, MatchMode matchMode){
        return urunTuruDao.findUrunTuruListByAdiWithCriteria(adi, matchMode);
    }

    public List<UrunTuruDto> findAllUrunTuruDtoWithCriteria(){
        return urunTuruDao.findAllUrunTuruDtoWithCriteria();
    }
}
