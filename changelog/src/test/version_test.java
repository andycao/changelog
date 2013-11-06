package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import changelog.*;

public class version_test {
	public static void main (String args[]){
	/**	Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session se = sf.openSession();
		Transaction ts = se.beginTransaction();
		
		Version therec = new Version();
		therec.setProgramId(1);
		therec.setVersionName("1.0");
		therec.setDetail("firse version of program 1 function ....");
		
		se.save(therec);
		ts.commit();
		se.close();*/
		try{
			ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
			System.out.println(ct.getBean("searcher"));
			
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}
