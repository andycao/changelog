package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import changelog.*;

public class Programtest {
	public static void main (String args[]){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session se = sf.openSession();
		
		Transaction ts = se.beginTransaction();
		
		Program therec = new Program();
		therec.setProjectId(2);
		therec.setStartTime(new Date(0));
		therec.setLastChangeTime(new Date(99999222));
		therec.setDetail("changes here there where");
		therec.setProgramName("Ploto Program");
		
		se.save(therec);
		ts.commit();
		se.close();
	}
}
