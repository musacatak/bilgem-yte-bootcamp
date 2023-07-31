import org.example.entities.Car;
import org.example.entities.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class StaffTest {

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
    public void createStaff() {
        Set<String> hash_Set = new HashSet<String>();

        hash_Set.addAll(Arrays.asList(
                new String[]{"555134132",
                        "1324214324"}
        ));
        // Adding elements to the Set
        // using add() method
        hash_Set.add("789652431");
        hash_Set.add("981234561");

        Staff myStaff = new Staff("Cihangir", "Catak", hash_Set);
        myStaff.addPhoneNumber("555");
        myStaff.addPhoneNumber("337");
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(myStaff);
            tx.commit();
        }

        try (Session session = factory.openSession()) {
            Staff staffFromDb = session.find(Staff.class,myStaff.getId());
            assertEquals(staffFromDb.getPhoneNumbers().size(),6);
        }

    }

}
