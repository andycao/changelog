package test;
import java.util.List;

import org.hibernate.Session;

import changelog.User;

import mydbsearcher.mydbsearcher;
public class searchtest {

	public searchtest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mydbsearcher searcher = new mydbsearcher();
		Session session = searcher.getSession();
		List<User>  list = session.createQuery("from User").list();
		System.out.println(list.get(0).getName());
	}

}
