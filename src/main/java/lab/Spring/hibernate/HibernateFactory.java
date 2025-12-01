package lab.Spring.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySetting("default", configuration.getProperties());
        return configuration.buildSessionFactory(registryBuilder.build());
    }
}
