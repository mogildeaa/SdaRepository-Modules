package hibernate;

import hibernate.domain.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class AddressTest {

    @Test
    public void createAddress() {

        Transaction tx = null;
        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession()
        ) {
            tx = session.beginTransaction();
            Address address = new Address();
            address.setStreet("Lalelelor, nr 5");
            address.setCity("New York");

            session.save(address);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
