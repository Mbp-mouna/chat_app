package dao;

import conn.HibernateUtil;
import entities.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LogDao {
    private SessionFactory sessionFactory;

    public LogDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveLog(Log log) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(log);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
