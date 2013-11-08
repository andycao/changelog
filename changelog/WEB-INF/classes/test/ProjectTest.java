package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import changelog.theProject;

public class ProjectTest {
	public static void main (String args[]){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session se = sf.openSession();
		
		Transaction ts = se.beginTransaction();
		
		theProject therec = new theProject();
		therec.setStartTime(new Date(0));
		therec.setLastChangeTime(new Date(99999));
		therec.setProjectName("Starhaha");
		therec.setProjectDetail("details are details");
		
		se.save(therec);
		ts.commit();
		se.close();
	}
	
	public void addProjectOld(){
		
	}
}
