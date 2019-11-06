package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    // 1. Configurarea Hibernate se inregistreaza in niste registri (tare rau)
    // 2. Din serviciu de registrii obtin SesionFactory

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .configure(/*"altNumeDeFisierDecatAlaDefault.xml"*/) // configures settings from hibernate.cfg.xml
                        .build();

                // Create session factory
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            } catch (Exception e) {
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }

                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}






