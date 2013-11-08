package mydbsearcher;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;
import changelog.*;
public class mydbsearcher extends recordUpdater{
	private Session session;
	private static final long onemonth = (long)1000 * 60 * 60 * 24 * 30;
	public mydbsearcher(){
	}
	
	/**
	 * select all projects
	 * @return list<project>
	 */
	public List<theProject> getAllProjects(){
		session = HibernateUtil.openSession();
		//select all projects
		Query query = session.createQuery("from theProject order by lastChangeTime DESC");
		List<theProject> list = query.list();
		session.clear();//close the session
		session.close();
		return list;
	}
	
	/**
	 * get all the programs
	 * @return list<Program>
	 */
	public List<Program> getAllPrograms(){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Program order by lastChangeTime DESC");
		List<Program> list = query.list();
		session.clear();
		session.close();
		return list;
	}
	
	/**
	 * get all versions
	 * @return list<Version>
	 */
	public List<Version> getAllVersions(){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Version order by versionId DESC");
		List<Version> list = query.list();
		session.clear();
		session.close();
		return list;
	}
	/**
	 * get all programs by project id
	 * @return list<program>
	 */
	public List<Program> getProgramsByProjectID(int projectID){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Program where projectId=:projid order by programId DESC");
		query.setInteger("projid", projectID);
		List<Program> list = query.list();
		session.clear();//close the session
		session.close();
		return list;
	}
	
	/**
	 * get versions by program id
	 * @return list<versions>
	 */
	public List<Version> getVersionsByProgramID(int programID){
		session = HibernateUtil.openSession();
		//select all projects
		Query query = session.createQuery("from Version where programId=:programID order by versionId DESC");
		query.setInteger("programID", programID);
		List<Version> list = query.list();
		session.clear();//close the session
		session.close();
		return list;
	}
	
	/**
	 * get all changes
	 * @return list<change>
	 */
	public List<Change> allChanges(){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Change order by changeDate DESC");
		List<Change> list = query.list();
		session.clear();
		session.close();
		return list;
	}
	
	/**
	 * get the change list by version id
	 * @param versionID
	 * @return
	 */
	public List<Change> getChangeByVersionID(int versionID){
		session = HibernateUtil.openSession();
		//select all projects
		Query query = session.createQuery("from Change where versionId=:versionID order by changeId DESC");
		query.setInteger("versionID", versionID);
		List<Change> list = query.list();
		session.clear();//close the session
		session.close();
		return list;
	}
	
	/**
	 * get the user's change by his uid
	 * @param userid int
	 * @return list<change>
	 */
	public List<Change> getChangesByUserID(int userid){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Change where userId =:user order by changeDate DESC");
		query.setInteger("user", userid);
		List<Change> list = query.list();
		session.clear();
		session.close();
		return list;
	}
	
	/**
	 * get racent 30 day's changes
	 * @return list<change>
	 */
	public List<Change> getRacentChanges(){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Change where changeDate>=:cdate and changeDate<=:now order by changeId DESC");
		Date myd = new Date();
		long nows = myd.getTime();
		myd.setTime(nows - onemonth);
		query.setDate("cdate", myd);
		query.setDate("now", new Date());
		List<Change> list = query.list();
		session.clear();
		session.close();
		return list;
	}
	
	/**
	 * get the project by its projectid
	 * @param pid - int projectid
	 * @return project object
	 */
	public theProject getProjectByID(int pid){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from theProject where projectid=:id");
		query.setInteger("id", pid);
		List<theProject> list = query.list();
		session.clear();//close the session
		session.close();
		if(list.size()==1)
			return list.get(0);
		else
			return null;
	}
	public Program getProgramByID(int pid){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Program where programid=:id");
		query.setInteger("id", pid);
		List<Program> list = query.list();
		session.clear();//close the session
		session.close();
		if(list.size()==1)
			return list.get(0);
		else
			return null;
	}
	public Version getVersionByID(int vid){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Version where versionid=:id");
		query.setInteger("id", vid);
		List<Version> list = query.list();
		session.clear();//close the session
		session.close();
		if(list.size()==1)
			return list.get(0);
		else
			return null;
	}
	public Change getChangeByID(int cid){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from Change where changeid=:id");
		query.setInteger("id", cid);
		List<Change> list = query.list();
		session.clear();//close the session
		session.close();
		if(list.size()==1)
			return list.get(0);
		else
			return null;
	}

	/**
	 * for test use only
	 * @param args
	public static void main(String args[]){
		mydbsearcher ser = new mydbsearcher();
		Change p = ser.getChangeByID(1);
		System.out.println(p.getChangeDate());
	}
	*/
}
