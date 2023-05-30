package dao;

import conn.HibernateUtil;
import entities.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDao {
    private SessionFactory sessionFactory;

    public MessageDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveMessage(Message message) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(message);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Message> getAllMessages() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Message ", Message.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
