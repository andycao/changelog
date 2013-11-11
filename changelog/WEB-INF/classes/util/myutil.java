package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import changelog.User;

public class myutil {

	public static java.util.Date stringToDate(String d) {
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			return df.parse(d);
		}catch(ParseException e){
			System.err.println(e);
			return null;
		}
	}
	/**
	 * get all usr map
	 * @return hashmap of users
	 */
	public static HashMap<Integer,String> getUsers(){
		Session session = HibernateUtil.openSession();
		HashMap<Integer,String> users = new LinkedHashMap<Integer,String>();
		try{
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			for(User user : list){
				users.put(user.getUserID(), user.getName());
			}
			return users;
		}catch(Exception e){
			System.err.println(e);
			return null;
		}finally{
			session.close();
		}
	}
}
