package dao;

import domain.Urun;
import domain.UrunTuru;
import dto.UrunTuruDto;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

public class UrunTuruDao {

    private SessionFactory sessionFactory;

    public UrunTuruDao(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<UrunTuru> findAll(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urunTuru from UrunTuru urunTuru ");

        return query.list();
    }

    public UrunTuru findById(Long id){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urunTuru from UrunTuru urunTuru " +
                " where  id = :id ");

        query.setParameter("id", id);

        return (UrunTuru) query.uniqueResult();
    }

    public List<UrunTuru> findUrunTuruListByAdi(String adi, MatchMode matchMode){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select urunTuru from UrunTuru urunTuru " +
                " where adi like :adi ");

        switch (matchMode){
            case EXACT:
                query.setParameter("adi", adi);
                break;

            case START:
                query.setParameter("adi", adi + "%");
                break;

            case END:
                query.setParameter("adi", "%" + adi);
                break;

            case ANYWHERE:
                query.setParameter("adi", "%" + adi + "%");
                break;
        }

        return query.list();
    }

    public List<UrunTuru> findUrunTuruListByAdiWithCriteria(String adi, MatchMode matchMode){

        String parameter = "";
        switch (matchMode){
            case EXACT:
                parameter = adi;
                break;

            case START:
                parameter = adi + "%";
                break;

            case END:
                parameter = "%" + adi;
                break;

            case ANYWHERE:
                parameter = "%" + adi + "%";
                break;
        }

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunTuru> query = criteriaBuilder.createQuery(UrunTuru.class);

        Root<UrunTuru> root = query.from(UrunTuru.class);

        query.select(root).where(criteriaBuilder.like(root.<String>get("adi"), parameter));

        return session.createQuery(query).list();
    }

    public List<UrunTuruDto> findAllUrunTuruDto(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery(" select new dto.UrunTuruDto( " +
                " urunTuru.id, " +
                " urunTuru.adi, " +
                " min (urun.fiyat), " +
                " max (urun.fiyat), " +
                " avg (urun.fiyat), " +
                " sum (urun.stokMiktari), " +
                " count (urun.id) " +
                " )" +
                " from Urun urun, UrunTuru urunTuru " +
                " where urun.urunTuru.id = urunTuru.id " +
                " group by urunTuru.id, urunTuru.adi");

        return query.list();
    }

    public List<UrunTuruDto> findAllUrunTuruDtoWithCriteria(){

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<UrunTuruDto> query = criteriaBuilder.createQuery(UrunTuruDto.class);

        Root<Urun> root = query.from(Urun.class);

        root.join("urunTuru", JoinType.INNER);

        query.groupBy(root.get("urunTuru").get("id"));

        query.select(criteriaBuilder.construct(UrunTuruDto.class,
                root.get("urunTuru").get("id"),
                root.get("urunTuru").get("adi"),
                criteriaBuilder.min(root.<Number>get("fiyat")),
                criteriaBuilder.max(root.<Number>get("fiyat")),
                criteriaBuilder.avg(root.<Number>get("fiyat")),
                criteriaBuilder.sum(root.<Number>get("stokMiktari")),
                criteriaBuilder.count(root.get("id"))
                ));

        return session.createQuery(query).list();

    }

}
