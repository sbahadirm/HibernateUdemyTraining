package deneme;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class UrunDenemeDao {

    private SessionFactory sessionFactory;

    public UrunDenemeDao(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public UrunDeneme save(UrunDeneme urunDeneme){

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        urunDeneme = (UrunDeneme) session.merge(urunDeneme);

        transaction.commit();

        return urunDeneme;
    }

    public List<UrunDeneme> findAll(){

        Session session = sessionFactory.openSession();

        List resultList1 = session.createNamedQuery("User.temp").setParameter("email", "sbahadir@gmail.com").getResultList();

        Object o = resultList1.get(0);
        System.out.println(o);

        Query query = session.createQuery(" select urun from Urun urun ");

        return query.list();
    }
}
