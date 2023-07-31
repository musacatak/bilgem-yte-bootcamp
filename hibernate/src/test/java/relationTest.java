import org.example.entities.*;
import org.example.entities.many2many.Course;
import org.example.entities.many2many.Student;
import org.example.entities.onetomany.Customer;
import org.example.entities.onetomany.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.testng.AssertJUnit.assertNotNull;

public class relationTest {

    private SessionFactory factory = null;

    @BeforeClass
    public void setup() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void relationW2ETest() {
        Country ct = new Country("Turkey");
        Capital cpt = new Capital("Ankara", ct);
        ct.setCapital(cpt);
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ct);
            session.persist(cpt);
            tx.commit();
        }

    }

    @Test
    public void one2ManyRelationTest() {
        Customer customer1 = new Customer("Mahmut", "mahmut@com", "adddressofMahmut");

        Order orders1 = new Order(UUID.randomUUID());
        Order orders2 = new Order(UUID.randomUUID());
        Order orders3 = new Order(UUID.randomUUID());

        customer1.AddOrder(orders1);
        customer1.AddOrder(orders2);
        customer1.AddOrder(orders3);

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(orders1);
            session.persist(orders2);
            session.persist(orders3);
            session.persist(customer1);

            tx.commit();
        }

    }

    @Test
    public void many2manyRelationTest() {
        Student student = new Student("Musa","Catak");
        Student student2 = new Student("Mahmut","Cınar");
        Student student3 = new Student("Mehmet","Catak");
        Course course = new Course("Hibernate Class","Ezgi Turk",6);
        Course course2 = new Course("Database Class","Berkan",4);

        Course course3 = new Course("Netwokr Class","Turkog",4);


        course.addStudent(student);
        course.addStudent(student2);
        course2.addStudent(student);
        course3.addStudent(student2);
        course.addStudent(student3);


        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            //session.persist(student);
            //session.persist(student2);
            //session.persist(student3);
            session.persist(course);
            session.persist(course2);
            session.persist(course3);
            tx.commit();
        }
    }
}


