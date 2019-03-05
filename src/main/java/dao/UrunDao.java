package dao;

import domain.Urun;
import domain.UrunTuru;
import dto.UrunBilgiDto;
import dto.UrunDto;
import enums.EnumBirim;
import hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UrunDao {

    private SessionFactory sessionFactory;

    public UrunDao(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Urun> findAll(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun ");

        return query.list();
    }

    public List<Urun> findAllWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        query.from(Urun.class);

        return session.createQuery(query).getResultList();
    }

    public Urun findById(Long id){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun " +
                " where  id = :id ");

        query.setParameter("id", id);

        return (Urun) query.uniqueResult();
    }

    public Urun findByIdWithCriteria(Long id){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root).where(
                criteriaBuilder.equal(root.get("id"), id)
        );

        return session.createQuery(query).uniqueResult();
    }

    public List<Urun> findAllUrunListByStokMiktariMinAndMax(Long minStok, Long maxStok){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun " +
                " where stokMiktari <= :maksimumStok " +
                " and  stokMiktari >= :minimumStok ");

        query.setParameter("maksimumStok", maxStok);
        query.setParameter("minimumStok", minStok);

        return query.list();

    }

    public List<Urun> findAllUrunListByStokMiktariMinAndMax2(Long minStok, Long maxStok){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun " +
                " where stokMiktari between :minimumStok and :maksimumStok ");

        query.setParameter("maksimumStok", maxStok);
        query.setParameter("minimumStok", minStok);

        return query.list();
    }

    public List<Urun> findAllUrunListByStokMiktariMinAndMaxWithCriteria(Long minStok, Long maxStok){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root).where(
                criteriaBuilder.between(root.<Comparable>get("stokMiktari"), minStok, maxStok)
        );

        return session.createQuery(query).list();
    }

    public List<Urun> findAllWithOrder(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun " +
                " order by stokMiktari, adi ");

        return query.list();
    }

    public List<Urun> findAllWithOrderWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root);

        // tekli
//        query.orderBy(criteriaBuilder.asc(root.get("stokMiktari")));

//        Order stokMiktari = criteriaBuilder.asc(root.get("stokMiktari"));
//        Order adi = criteriaBuilder.asc(root.get("adi"));
//        query.orderBy(stokMiktari, adi);

        List<Order> orderList = new ArrayList<Order>();
        orderList.add(criteriaBuilder.asc(root.get("stokMiktari")));
        orderList.add(criteriaBuilder.asc(root.get("adi")));
        query.orderBy(orderList);

        return session.createQuery(query).list();
    }

    public List<Urun> findAllWithOrderByLimit(int maxResult){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun " +
                " order by stokMiktari desc , adi asc ");

        query.setMaxResults(maxResult);

        return query.list();
    }

    public List<Urun> findAllWithOrderByLimitWithCriteria(int maxResult){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(root);

        query.orderBy(criteriaBuilder.asc(root.get("id")));

        return session.createQuery(query).setMaxResults(maxResult).list();
    }

    public List<Urun> findAllUrunListBySonKullanmaTarihiGe(Date sonKullanmaTarihi){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urun from Urun urun " +
                " where sonKullanmaTarihi >= :sonKullanmaTarihi ");

        query.setParameter("sonKullanmaTarihi", sonKullanmaTarihi);

        return query.list();
    }

    public List<Urun> findAllUrunListBySonKullanmaTarihiGeWithCriteria(Date sonKullanmaTarihi){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);

        Root<Urun> root = query.from(Urun.class);

        ParameterExpression<Date> parameter = criteriaBuilder.parameter(Date.class);

        Predicate tarih = criteriaBuilder.greaterThanOrEqualTo(root.<Comparable>get("sonKullanmaTarihi").as(Date.class), parameter);

        query.where(tarih);

        return session.createQuery(query).setParameter(parameter, sonKullanmaTarihi, TemporalType.DATE).list();
    }

    public Long sumUrunStokMiktariByUrunTuruId(Long urunTuruId){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select sum( stokMiktari) from Urun urun " +
                " where urunTuru.id = :urunTuruId ");

        query.setParameter("urunTuruId", urunTuruId);

        return (Long) query.uniqueResult();

    }

    public Long sumUrunStokMiktariByUrunTuruIdWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.sumAsLong(root.<Integer>get("stokMiktari")));

        return session.createQuery(query).uniqueResult();
    }

    public Long countUrunByUrunTuruId(Long urunTuruId){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select count (urun) from Urun urun " +
                " where urunTuru.id = :urunTuruId ");

        query.setParameter("urunTuruId", urunTuruId);

        return (Long) query.uniqueResult();
    }

    public Long countUrunByUrunTuruIdWithCriteria(Long urunTuruId){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.count(root.get("id")));

        query.where(criteriaBuilder.equal(
                root.get("urunTuru").get("id"), urunTuruId
        ));

        return session.createQuery(query).uniqueResult();
    }

    public List<EnumBirim> findAllUrunStokBirimi(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select distinct (stokBirimi) from Urun urun");

        return query.list();
    }

    public Double findOrtalamaStokMiktari(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select avg (stokMiktari) from Urun urun");

        return (Double) query.uniqueResult();
    }

    public Double findOrtalamaStokMiktariWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.avg(root.<Number>get("stokMiktari")));

        return session.createQuery(query).uniqueResult();

    }

    public List<UrunDto> findAllUrunDto(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select " +
                "  new dto.UrunDto( urun.id, urun.adi, urun.fiyat ) " +
                " from Urun urun ");

        return query.list();
    }

    public List<Urun> findAllUrunDto2(){

        Session session = sessionFactory.openSession();

        Urun urun = new Urun();
        urun.setAdi("Ekmek");


        Example example = Example.create(urun)
                .excludeProperty("ADI");

        List results = session.createCriteria(Urun.class)
                .add(example)
                .list();

        return results;


//        Example example = Example.create(Urun.class).excludeProperty("adi");
//
//        Criteria criteria = session.createCriteria(Urun.class);
//        criteria.add(example);

//        return criteria.list();
    }

    public List<UrunDto> findAllUrunDtoWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunDto> query = criteriaBuilder.createQuery(UrunDto.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.construct(UrunDto.class,
                root.get("id"),
                root.get("adi"),
                root.get("fiyat")
                ));

        return session.createQuery(query).list();
    }

    public List<UrunBilgiDto> findAllUrunBilgiDto(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select " +
                " new dto.UrunBilgiDto( urun.id, urun.adi, urun.fiyat, urunTuru.adi, urunTuru.urunTuru ) " +
                " from Urun urun, UrunTuru urunTuru " +
                " where urun.urunTuru.id = urunTuru.id " );

        return query.list();

    }

    public List<Urun> findFetch(){

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Urun.class);

        criteria.setFetchMode("urunTuru", FetchMode.JOIN);

        return criteria.list();
    }

    public List<UrunBilgiDto> findAllUrunBilgiDtoWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunBilgiDto> query = criteriaBuilder.createQuery(UrunBilgiDto.class);

        Root<Urun> root = query.from(Urun.class);

        root.join("urunTuru", JoinType.INNER);

        query.select(criteriaBuilder.construct(
           UrunBilgiDto.class,
                root.get("id"),
                root.get("adi"),
                root.get("fiyat"),
                root.get("urunTuru").get("adi"),
                root.get("urunTuru").get("urunTuru")
        ));

        return session.createQuery(query).list();
    }

    public BigDecimal findMinUrunFiyat(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select min(urun.fiyat) from Urun urun");

        return (BigDecimal) query.uniqueResult();
    }

    public BigDecimal findMaxUrunFiyat(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select max(urun.fiyat) from Urun urun");

        return (BigDecimal) query.uniqueResult();
    }

    public BigDecimal findMinUrunFiyatWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.min(root.<BigDecimal>get("fiyat")));

        return session.createQuery(query).uniqueResult();

    }

    public BigDecimal findMaxUrunFiyatWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);

        Root<Urun> root = query.from(Urun.class);

        query.select(criteriaBuilder.max(root.<BigDecimal>get("fiyat")));

        return session.createQuery(query).uniqueResult();
    }

    public List<Urun> callUrunFindAll(){

        Session session = sessionFactory.openSession();

        NativeQuery<Urun> nativeQuery = session.createNativeQuery(" {call urun_findAll()}", Urun.class);

        return nativeQuery.list();
    }

    public List<Urun> callFindUrunBetween(BigDecimal min, BigDecimal max){

        Session session = sessionFactory.openSession();

        NativeQuery<Urun> nativeQuery = session.createNativeQuery(" { call find_urun_between(:minimum, :maksimum)} ", Urun.class);

        nativeQuery.setParameter("minimum", min);
        nativeQuery.setParameter("maksimum", max);

        return nativeQuery.list();

    }

    public List<Urun> callUrunFindAll2(){

        Session session = sessionFactory.openSession();

        StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery(" urun_findAll", Urun.class);

        return storedProcedureQuery.getResultList();
    }

    public List<Urun> callFindUrunBetween2(BigDecimal min, BigDecimal max){

        Session session = sessionFactory.openSession();

        StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery("find_urun_between", Urun.class);

        storedProcedureQuery.registerStoredProcedureParameter("minimum", BigDecimal.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("maksimum", BigDecimal.class, ParameterMode.IN);

        storedProcedureQuery.setParameter("minimum", min);
        storedProcedureQuery.setParameter("maksimum", max);

        return storedProcedureQuery.getResultList();

    }

}
