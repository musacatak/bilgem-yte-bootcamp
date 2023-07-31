package lifecycle;

import org.example.entities.Car;
import org.example.entities.Employee;
import org.example.entities.Gender;
import org.example.entities.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeLifeCyclePersistenceTest {

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
    public void changeFieldEmployeeTest() {
        Employee myEmployee = new Employee("Ahmet","Catak", Gender.MALE, Job.PROGRAMMER);
        String newSurname = "Altun";
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(myEmployee);
            myEmployee.setSurname(newSurname);
            tx.commit();
        }

    }
    @Test
    public void deleteEmployeeTest() {
        Employee myEmployee = new Employee("Feyzi","Ctak", Gender.MALE, Job.PROGRAMMER);
        String newSurname = "Hallac";
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(myEmployee);
            myEmployee.setSurname(newSurname);
            session.remove(session.find(Employee.class,myEmployee.getId()));
            tx.commit();
        }

    }


}
