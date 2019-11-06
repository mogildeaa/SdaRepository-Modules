package hibernate;

import hibernate.domain.Course;
import hibernate.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class CourseTest {

    @Test
    public void createCourse() {

        Transaction tx = null;
        try (
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession()
        ) {
            tx = session.beginTransaction();

            Course course = new Course();
            course.setCode("JAV_123");
            course.setDescription("Java fundamentals");

            Teacher teacher = session.load(Teacher.class, 1l);//id teacher de tip long: "1l"
            course.setTeacher(teacher);

            session.save(course);

            tx.commit();
        } catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
        }
    }
}
