package test;


import java.io.FileNotFoundException;
import java.util.Formatter;

import org.hibernate.Session;

import changelog.User;

import util.HibernateUtil;
public class Test extends junit.framework.TestCase{

	public void test() throws FileNotFoundException{
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			User user1 = (User) session.get(User.class, 1);
			System.out.println(user1.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}  
}
