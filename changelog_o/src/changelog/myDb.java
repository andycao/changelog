package changelog;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class myDb{
	private Configuration conf = new Configuration().configure();
	private SessionFactory sf = conf.buildSessionFactory();
	
	public myDb(){
	}
	/**
	 * add new user, do not need id as database will generate id automaticly
	 * @param name
	 * @param title
	 * @param password
	 * @return user - user object just been added
	 */
	public User addUser(String name, String title, String password){
		Session se = sf.openSession();
		Transaction ts = se.beginTransaction();
		
		User user = new User();
		user.setName(name);
		user.setTitle(title);
		user.setPassword(password);
		//save the user to db and get the generated identifier
		se.save(user);
		ts.commit();
		se.clear();
		
		//search user obj from database to get the  generated id
		String hql ="from User where name=:name";
		Query query = se.createQuery(hql);
		query.setString("name", name);
		List<User> list = query.list();
		se.clear();
		
		return list.get(0);
	}
	
	/**
	 * add a new project
	 * @param name
	 * @param start
	 * @param detail
	 */
	public void addProject(String name,Date start,String detail){
		Session se = sf.openSession();
		Transaction ts = se.beginTransaction();
		
		theProject therec = new theProject();
		
		therec.setStartTime(start);
		therec.setLastChangeTime(start);
		therec.setProjectName(name);
		therec.setProjectDetail(detail);
		
		se.save(therec);
		ts.commit();
		se.close();
	}
	
	/**
	 * add program record
	 * @param projectid
	 * @param name
	 * @param start
	 * @param detail
	 */
	public void addProgram(int projectid, String name,Date start,String detail){
		Session se = sf.openSession();
		Transaction ts = se.beginTransaction();
		
		Program therec = new Program();
		therec.setProjectId(projectid);
		therec.setStartTime(start);
		therec.setLastChangeTime(start);
		therec.setDetail(detail);
		therec.setProgramName(name);
		
		se.save(therec);
		ts.commit();
		se.close();
	}
	
	/**
	 * add version id
	 * @param versionName - string
	 * @param programId - int, foreign key
	 * @param detail - string
	 */
	public void addVersion(String versionName, int programId, String detail){
		Session se = sf.openSession();
		Transaction ts = se.beginTransaction();
		
		Version therec = new Version();
		therec.setVersionName(versionName);
		therec.setProgramId(programId);
		therec.setDetail(detail);
		
		se.save(therec);
		ts.commit();
		se.close();
	}
	
	/**
	 * add change log record
	 * @param versionid - the version id which the change attached on
	 * @param userid - current user
	 * @param time - changing time
	 * @param detail - changing detail
	 * @param fileUrl - changed files url addresses
	 */
	public void addChange(int versionid, int userid, Date time, String detail, String fileUrl){
		Session se = sf.openSession();
		Transaction ts = se.beginTransaction();
		
		Change therec = new Change();
		therec.setProjectId(getProjectByProgram(getProgramByVersion(versionid)));
		therec.setProgramId(getProgramByVersion(versionid));
		therec.setVersionId(versionid);
		therec.setUserId(userid);
		therec.setChangeDate(time);
		therec.setChangeDetail(detail);
		therec.setChangeFile(fileUrl);
		
		se.save(therec);
		ts.commit();
		se.flush();
		se.clear();
	}
	/**
	 * get the program id by version id
	 * @param versionId - integer
	 * @return program id - integer
	 */
	public int getProgramByVersion(int versionId){
		Session se = sf.openSession();

		Query query = se.createQuery("select programId from Version where VersionID = "+versionId);
		List<Integer> list = query.list();
		se.close();
		if(list.get(0) != null)
			return list.get(0);
		return 0;
	}
	
	/**
	 * get the project id by program id
	 * @param proId - integer
	 * @return projectid - integer
	 */
	public int getProjectByProgram(int proId){
		Session se = sf.openSession();

		Query query = se.createQuery("select projectId from Program where ProgramID = "+proId);
		List<Integer> list = query.list();
		se.close();
		if(list.get(0) != null)
			return list.get(0);
		return 0;
	}
	/**
	 * get session object
	 * @return Session
	 */
	public Session getSession(){
		return sf.openSession();
	}
	
	/* session
	public static void main(String args[]){
		myDb mydb=new myDb();
		System.out.println(mydb.getSession());
	}
	*/
}
