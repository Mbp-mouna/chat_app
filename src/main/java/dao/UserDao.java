package dao;

import conn.HibernateUtil;
import entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {
    public UserDao() {
    }

    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveUser(User user){
        Transaction tr=null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            tr=session.beginTransaction();
            session.save(user);
            tr.commit();}
        catch(Exception e){if(tr!=null){tr.rollback();}
            e.printStackTrace();}}
    public User getUserById(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public User getUserByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean validate(String userName, String password){
        Transaction tr =null;
        User user=null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            tr=session.beginTransaction();
            user=(User) session.createQuery("FROM User u where u.username=:userName").setParameter("userName",userName).uniqueResult();
            if(user!=null && user.getPassword().equals(password)){return true;}
            tr.commit();}
        catch(Exception e){if(tr!=null) {tr.rollback();}e.printStackTrace();}
        return false;

    }

}
