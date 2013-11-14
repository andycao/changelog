package mydbsearcher;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;

import changelog.User;

import util.HibernateUtil;

public class UserManager {

	public UserManager() {
	}
	/**
	 * get the user name by id
	 * @param userid - int
	 * @return username - string
	 */
	public String getUserNameByID(int userid){
		Session session = HibernateUtil.openSession();
		
		try{
			Query query = session.createQuery("select name from User where UserID =:uid");
			query.setInteger("uid", userid);
			List<String> list = query.list();
			if(list.size() == 1)
				return list.get(0);
			
		}catch(HibernateException e){
			System.err.println("hibernate error at get user name");
			System.err.println(e);
		}finally{
			session.close();
		}
		return "";//error return empty string
	}
	
	/**
	 * get a user's info by userid
	 * @param userid
	 * @return user object
	 */
	public User getUser(int userid){
		Session session = HibernateUtil.openSession();
		try{
			Query query = session.createQuery("from User where userID=:userid");
			query.setInteger("userid", userid);
			List<User> list = query.list();
			if(list.size() == 1)
				return list.get(0);
			else
				return null;
		}catch(HibernateException e){
			System.err.println(e);
			return null;
		}finally{
			session.close();
		}
	}
	/**
	 * get a user's info by user email
	 * @param userid
	 * @return user object
	 */
	public User getUser(String username){
		Session session = HibernateUtil.openSession();
		try{
			Query query = session.createQuery("from User where userName=:username");
			query.setString("username", username);
			List<User> list = query.list();
			if(list.size() == 1)
				return list.get(0);
			else
				return null;
		}catch(HibernateException e){
			System.err.println(e);
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * delete user by userid from database if the user don't has change record
	 * @param userid
	 * @return boolean
	 */
	public boolean deleteUser(int userid){
		Session session = HibernateUtil.openSession();
		try{
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("delete User where userID=:userid");
			query.setInteger("userid", userid);
			
			query.executeUpdate();
			tr.commit();
			
			return true;
		}catch(HibernateException e){
			System.err.println("hibernate exception");
			System.err.println(e);
			return false;
		}finally{
			session.close();
		}
	}
	
	public boolean editPasswordByID(int userid,String password){
		Session session = HibernateUtil.openSession();
		try{
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("update User set Password=:password where UserID=:userid");
			query.setString("password", password);
			query.setInteger("userid", userid);
			
			query.executeUpdate();
			tr.commit();
			return true;
		}catch(HibernateException e){
			System.err.println(e);
			return false;
		}finally{
			session.close();
		}
	}
	
	public boolean editTitleByUserID(int userid, String title){
		Session session = HibernateUtil.openSession();
		try{
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("update User set Title=:title where UserID=:userid");
			query.setString("title", title);
			query.setInteger("userid", userid);
			
			query.executeUpdate();
			tr.commit();
			return true;
		}catch(HibernateException e){
			System.err.println(e);
			return false;
		}finally{
			session.close();
		}
	}
}
