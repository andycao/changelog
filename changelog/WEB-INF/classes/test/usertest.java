package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import changelog.User;

public class usertest {
	public static void main (String args[]){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session se = sf.openSession();
		
		Transaction ts = se.beginTransaction();
		
		User user1 = new User();
		user1.setName("wow");
		user1.setTitle("编辑");
		user1.setPassword("hehe");
		user1.setUserID(2);
		se.save(user1);
		ts.commit();
		se.close();
	}
}
