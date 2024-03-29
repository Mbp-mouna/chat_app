package conn;

import entities.Log;
import entities.Message;
import entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3307/chat?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Message.class);
                configuration.addAnnotatedClass(Log.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();


            }


        }
        return sessionFactory;
    }}

