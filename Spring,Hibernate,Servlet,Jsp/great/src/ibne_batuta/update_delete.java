package ibne_batuta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import create.hibernate.Produce;

import org.hibernate.Query;

public class update_delete {

	public static void main(String[] args) {
		Configuration con=new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory s=con.buildSessionFactory();
		Session session=s.openSession();
		Transaction tx=session.beginTransaction();
		//Update Query1
		/*Query query=session.createQuery("update Produce set pname= :n where price= :i");
        query.setParameter("n", "Bycycle");
        query.setParameter("i", 600000);
        int result=query.executeUpdate();*/
		//Update Query2
		/*Produce prod=(Produce) session.get(Produce.class, 2);
		prod.setPrice(540000);
        session.update(prod);*/
		//Delete Query1
		/*Query query=session.createQuery("delete from Produce where price= :i");
        query.setParameter("i", 600000);
        int result=query.executeUpdate();
        System.out.println("Student data Update Status="+result);*/
        //Delete Query2
      		Produce prod=(Produce) session.get(Produce.class, 2);
      		prod.setPrice(540000);
              session.delete(prod);
		tx.commit();
		session.close();
		System.out.println("object inserted successfully");
		s.close();
	}

}
