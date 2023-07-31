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
import org.hibernate.validator.constraints.UUID;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class PersistenceTest {

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
    public void createCarTest() {
        Car myCar = new Car("station", "focus_1", "cyan");
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(myCar);
            //System.out.println("my Car is:" + session.find(Car.class, 1L));
            //session.find(1);
            tx.commit();
        }
        try (Session session = factory.openSession()) {
            System.out.println("my Car is:" + session.find(Car.class, 1L));
            //session.find(1);
            Car carFromDb = session.find(Car.class, myCar.getId());
            System.out.println("carFromDb : " + carFromDb);
            System.out.println("Id : " + carFromDb.getId() + ", Type : " + carFromDb.getType() +
                    ", Model : " + carFromDb.getModel() + ", Color : " + carFromDb.getColor());
        }
    }

    @Test
    public void createEmployeeTest(){
        Employee myEmployee = new Employee("Ahmet","Catak", Gender.MALE, Job.PROGRAMMER);
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(myEmployee);
            tx.commit();
        }
        try (Session session = factory.openSession()) {
            System.out.println("my Employee is:" + session.find(Employee.class, myEmployee.getId()));
            //session.find(1);
            Car employeeFromDb = session.find(Car.class,myEmployee.getId());
            System.out.println("employeeFromDb : " + employeeFromDb);
        }
    }

}
