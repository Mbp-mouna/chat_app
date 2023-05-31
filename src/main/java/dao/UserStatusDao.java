package dao;

import conn.HibernateUtil;
import entities.UserStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserStatusDao {

    private SessionFactory sessionFactory;

    public UserStatusDao() {
    }

    public UserStatusDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUserStatus(UserStatus userStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(userStatus);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
