package entityservice;

import dao.UrunDao;
import domain.Urun;
import dto.UrunBilgiDto;
import dto.UrunDto;
import enums.EnumBirim;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UrunEntityService {

    private UrunDao urunDao;

    public UrunEntityService(){
        urunDao = new UrunDao();
    }

    public List<Urun> findAll(){
        return urunDao.findAll();
    }

    public Urun findById(Long id){
        return urunDao.findById(id);
    }

    public List<Urun> findAllUrunListByStokMiktariMinAndMax(Long minStok, Long maxStok){
        return urunDao.findAllUrunListByStokMiktariMinAndMax(minStok, maxStok);
    }

    public List<Urun> findAllUrunListByStokMiktariMinAndMax2(Long minStok, Long maxStok){
        return urunDao.findAllUrunListByStokMiktariMinAndMax2(minStok, maxStok);
    }

    public List<Urun> findAllWithOrder(){
        return urunDao.findAllWithOrder();
    }

    public List<Urun> findAllWithOrderByLimit(int maxResult){
        return urunDao.findAllWithOrderByLimit(maxResult);
    }

    public List<Urun> findAllUrunListBySonKullanmaTarihiGe(Date sonKullanmaTarihi){
        return urunDao.findAllUrunListBySonKullanmaTarihiGe(sonKullanmaTarihi);
    }

    public Long sumUrunStokMiktariByUrunTuruId(Long urunTuruId){
        return urunDao.sumUrunStokMiktariByUrunTuruId(urunTuruId);
    }

    public Long countUrunByUrunTuruId(Long urunTuruId){
        return urunDao.countUrunByUrunTuruId(urunTuruId);
    }

    public List<EnumBirim> findAllUrunStokBirimi(){
        return urunDao.findAllUrunStokBirimi();
    }

    public Double findOrtalamaStokMiktari(){
        return urunDao.findOrtalamaStokMiktari();
    }

    public List<UrunDto> findAllUrunDto(){
        return urunDao.findAllUrunDto();
    }

    public List<UrunBilgiDto> findAllUrunBilgiDto(){
        return urunDao.findAllUrunBilgiDto();
    }

    public BigDecimal findMinUrunFiyat(){
        return urunDao.findMinUrunFiyat();
    }

    public BigDecimal findMaxUrunFiyat(){
        return urunDao.findMaxUrunFiyat();
    }

    public List<Urun> callUrunFindAll(){
        return urunDao.callUrunFindAll();
    }

    public List<Urun> callFindUrunBetween(BigDecimal min, BigDecimal max){
        return urunDao.callFindUrunBetween(min, max);
    }

    public List<Urun> callUrunFindAll2(){
        return urunDao.callUrunFindAll2();
    }

    public List<Urun> callFindUrunBetween2(BigDecimal min, BigDecimal max){
        return urunDao.callFindUrunBetween2(min, max);
    }

    /** Criteria */

    public List<Urun> findAllWithCriteria(){
        return urunDao.findAllWithCriteria();
    }

    public Urun findByIdWithCriteria(Long id){
        return urunDao.findByIdWithCriteria(id);
    }

    public List<Urun> findAllUrunListByStokMiktariMinAndMaxWithCriteria(Long minStok, Long maxStok){
        return urunDao.findAllUrunListByStokMiktariMinAndMaxWithCriteria(minStok, maxStok);
    }

    public List<Urun> findAllWithOrderWithCriteria(){
        return urunDao.findAllWithOrderWithCriteria();
    }

    public List<Urun> findAllWithOrderByLimitWithCriteria(int maxResult){
        return urunDao.findAllWithOrderByLimitWithCriteria(maxResult);
    }

    public List<Urun> findAllUrunListBySonKullanmaTarihiGeWithCriteria(Date sonKullanmaTarihi){
        return urunDao.findAllUrunListBySonKullanmaTarihiGeWithCriteria(sonKullanmaTarihi);
    }

    public Long sumUrunStokMiktariByUrunTuruIdWithCriteria(){
        return urunDao.sumUrunStokMiktariByUrunTuruIdWithCriteria();
    }

    public Long countUrunByUrunTuruIdWithCriteria(Long urunTuruId){
        return urunDao.countUrunByUrunTuruIdWithCriteria(urunTuruId);
    }

    public BigDecimal findMinUrunFiyatWithCriteria(){
        return urunDao.findMinUrunFiyatWithCriteria();
    }

    public BigDecimal findMaxUrunFiyatWithCriteria(){
        return urunDao.findMaxUrunFiyatWithCriteria();
    }

    public Double findOrtalamaStokMiktariWithCriteria(){
        return urunDao.findOrtalamaStokMiktariWithCriteria();
    }

    public List<UrunDto> findAllUrunDtoWithCriteria(){
        return urunDao.findAllUrunDtoWithCriteria();
    }

    public List<UrunBilgiDto> findAllUrunBilgiDtoWithCriteria(){
        return urunDao.findAllUrunBilgiDtoWithCriteria();
    }
}
