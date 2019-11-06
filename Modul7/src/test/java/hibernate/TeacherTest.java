package hibernate;

import hibernate.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class TeacherTest {
    // CRUD

    @Test
    public void createTeacher() {

        // 1. Get SessionFactory
        // 2. Get Session
        Transaction tx = null;
        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            // Pentru a putea face un insert am nevoie de transactie
            tx = session.beginTransaction();

            // creez un profesor
            Teacher teacher = new Teacher();
            teacher.setFirst_name("Alexandru");
            teacher.setLast_name("Popescu");
            teacher.setHire_date(new Date());
            teacher.setSalary(100D);
            // - sau teacher.setSalary(new Double(100));

            // salvez profesorul
            session.save(teacher);

            // commit transaction
            tx.commit();
        } catch (Exception ex) {
            // rollback transaction
            if (null != tx) {
                tx.rollback();
            }
        }
    }
}
