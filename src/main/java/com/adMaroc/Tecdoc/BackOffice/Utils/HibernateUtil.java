package com.adMaroc.Tecdoc.BackOffice.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
public class HibernateUtil
{
//    @PersistenceContext
//    private EntityManager em;
//    @Autowired
//    private Environment env;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private static String driver;
//    @Value("${spring.datasource.url}")
//    private static String datasourceUrl;
//    @Value("${spring.datasource.username}")
//    private static String username;
//    @Value("${spring.datasourceX3.password}")
//    private static String password;
//    @Value("${spring.jpa.properties.hibernate.dialect}")
//    private static String dialect;
//    @Value("${spring.jpa.show-sql}")
//    private static String sql;

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {

//                System.out.println(driver);
//                Map<String, String> settings = new HashMap<>();
//                settings.put("connection.driver_class", driver);
//                settings.put("dialect", dialect);
//                settings.put("hibernate.connection.url",datasourceUrl);
//                settings.put("hibernate.connection.username", username);
//                settings.put("hibernate.connection.password", password);
//                settings.put("hibernate.current_session_context_class", "thread");
//                settings.put("hibernate.show_sql", "true");
//                settings.put("hibernate.format_sql", "true");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();

                MetadataSources metadataSources = new MetadataSources(serviceRegistry);
                // metadataSources.addAnnotatedClass(Player.class);
                Metadata metadata = metadataSources.buildMetadata();

                // here we build the SessionFactory (Hibernate 5.4)
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                Session session = sessionFactory.getCurrentSession();


            return sessionFactory;
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}