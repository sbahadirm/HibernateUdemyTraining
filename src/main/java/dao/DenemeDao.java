package dao;

import domain.UrunTuru;
import dto.UrunDto;
import hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class DenemeDao {

    private SessionFactory sessionFactory;

    public DenemeDao(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

//    public UrunTuru findDis(){
//
//        Session session = sessionFactory.openSession();
//
//        Criteria criteria = session.createCriteria(UrunTuru.class);
//
////        criteria.add(Restrictions.or(
////           Restrictions.eq()
////        ));
//    }
}
