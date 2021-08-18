package DemoHib1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {

	public static void main(String[] args)
	{
		Laptop laptop = new Laptop();
		laptop.setLid(105);
		laptop.setLname("MAC Book");
		
		Student s = new Student();
		s.setName("sakthi");
		s.setRollno(5);
		s.setMarks(90);
		s.getLaptop().add(laptop);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(laptop);
		session.save(s);
		session.getTransaction().commit();
		
		}

}
