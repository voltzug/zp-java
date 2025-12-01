package lab.Spring.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Nine {
    public static void main(String[] args) {
        SpringApplication.run(Nine.class, args);

        /*var fac = new HibernateFactory();
        try (var sessionFactory = fac.getSessionFactory()) {
            EntityManager em = sessionFactory.createEntityManager();
            em.getTransaction().begin();

            Student s = new Student();
            em.persist(s);

            em.getTransaction().commit();
            em.close();
        }*/
    }
}
