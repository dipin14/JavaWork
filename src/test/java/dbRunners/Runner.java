package dbRunners;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import com.dipin.hibernate.eclipse.postgresql.Car;
 
public class Runner {
     
    @Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
         
        create(session);
        read(session);
         
        //update(session);
        //read(session);
         
        //delete(session);
        //read(session);
         
        session.close();
    }
     
    private void delete(Session session) {
        System.out.println("Deleting alto record...");
        Car alto = (Car) session.get(Car.class, "alto");
         
        session.beginTransaction();
        session.delete(alto);
        session.getTransaction().commit();
    }
     
    private void update(Session session) {
        System.out.println("Updating swift price...");
        Car swift = (Car) session.get(Car.class, "swift");
        swift.setModel("swift");
        swift.setPrice("₹7,00,000");
         
        session.beginTransaction();
        session.saveOrUpdate(swift);
        session.getTransaction().commit();
    }
 
    private void create(Session session) {
        System.out.println("Creating car records...");
        Car swift = new Car();
        swift.setModel("swift");
        swift.setPrice("₹5,25,000");
         
        Car alto = new Car();
        alto.setModel("alto");
        alto.setPrice("₹2,25,000");
         
        session.beginTransaction();
        session.save(swift);
        session.save(alto);
        session.getTransaction().commit();
    }
     
    private void read(Session session) {
        Query q = session.createQuery("select _car from Car _car");
         
        List<Car> cars = q.list();
         
        System.out.println("Reading car records...");
        System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
        for (Car c : cars) {
            System.out.printf("%-30.30s  %-30.30s%n", c.getModel(), c.getPrice());
        }
    }
}