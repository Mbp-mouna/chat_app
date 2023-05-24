package dao;
import conn.HibernateUtil;
import entities.User;
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


