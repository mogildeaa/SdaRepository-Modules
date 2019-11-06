package hibernate;

import hibernate.domain.Address;
import hibernate.domain.Course;
import hibernate.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentTest {

    @Test
    public void createStudent() {

        Transaction tx = null;
        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            tx = session.beginTransaction();

            Student student = new Student();
            student.setFirst_name("Laurentiu");
            student.setLast_name("Mihailescu");
            student.setBirth_date(LocalDate.now());

//            Address address = new Address();
//            address.setCity("Bucuresti");
//            address.setStreet("Ion Mihalache, nr 59");

            Address address = session.load(Address.class, 1l);
            student.setAddress(address);

            Course course = session.load(Course.class, 1l);
            // 1
            Set<Course> courses = new HashSet<>();
            courses.add(course);
            student.setCourses(courses);
            // varianta 2
            // student.setCourses(new HashSet());
            // student.getCourses().add(course);

            session.save(student);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Test
    public void updateStudent() {

        Transaction tx = null;
        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            tx = session.beginTransaction();

            Student student = session.load(Student.class, 1L);
            student.setFirst_name("Inocentiu");

            session.saveOrUpdate(student);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadAllStudents() {

        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            TypedQuery<Student> query = session.createQuery("FROM Student", Student.class);
            List<Student> result = query.getResultList();
            result.stream().forEach(student -> {
                System.out.println("Prenume == " + student.getFirst_name()
                        + " Nume == " + student.getLast_name());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetByLastName() {

        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            TypedQuery<Student> query = session.createQuery("select s from Student as s " +
                    "where s.last_name = :numeFamilie", Student.class);
            query.setParameter("numeFamilie", "Mihailescu");

            List<Student> result = query.getResultList();
            result.stream().forEach(student -> {
                System.out.println("Prenume == " + student.getFirst_name()
                        + " Nume == " + student.getLast_name());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNamedQuery() {

        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            TypedQuery<Student> query = session.createNamedQuery(
                    "Student.getByLastName", Student.class
            );
            query.setParameter("numeFamilie", "Mihailescu");

            List<Student> result = query.getResultList();
            result.stream().forEach(student -> {
                System.out.println("Prenume == " + student.getFirst_name()
                        + " Nume == " + student.getLast_name());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNativeSQL() {
        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
        ) {
            Query query = session.createNativeQuery("" +
                    "select s.first_name, s.last_name, a.street, a.city" +
                    " from student s join address a on a.Id = s.address_id ");

            List<Object[]> result = query.getResultList();

            //forEach == for each row
            result.stream().forEach(object -> {
                System.out.println(" firstname == " + object[0] +
                        " lastname == " + object[1] +
                        " street == " + object[2] +
                        " city == " + object[3]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
