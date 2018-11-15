package create.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Prroduce_Details {

	public static void main(String[] args) {
		
		Configuration con=new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory s=con.buildSessionFactory();
		Session session=s.openSession();
		Transaction tx=session.beginTransaction();
		Produce p=new Produce();
		//p.setId(1);
		p.setPname("Bycycle");
		p.setPrice(657000);
		session.save(p);
		tx.commit();
		session.close();
		System.out.println("object inserted successfully");
		s.close();
	}

}
