package mydbsearcher;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import changelog.Change;
import changelog.Program;
import changelog.Version;
import changelog.myDb;
import changelog.theProject;

public class recordUpdater extends myDb{
	private Session session;
	/**
	 * update project last changed date
	 * @param projectid
	 * @param date
	 */
	public void updateProjectDate(int projectid, Date date){
		//set session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		theProject project = (theProject) session.get(theProject.class, projectid);
		if(date.after(project.getLastChangeTime()) ){
			//set the date for project
			project.setLastChangeTime(date);
			session.update(project);
		}

		//commit
		tr.commit();
		//flush the session and save to db
		session.clear();
		session.close();
	}
	public void updateProgramDate(int programid, Date date){
		//set session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		Program program = (Program) session.get(Program.class, programid);
		if(date.after(program.getLastChangeTime()) ){
		//set the date for project
			program.setLastChangeTime(date);
			session.update(program);
		}

		//commit
		tr.commit();
		//flush the session and save to db
		session.clear();
		session.close();
	}
	/**
	 * update the project and program last date by versionid
	 * @param versionid
	 * @param date
	 */
	public void updateUp(int versionid, Date date){
		//set session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		
		Version version = (Version) session.get(Version.class, versionid);
		Program program = (Program) session.get(Program.class, version.getProgramId());
		theProject project = (theProject) session.get(theProject.class, program.getProjectId());
		
		if(date.after(project.getLastChangeTime()) ){
			//set the date for project
			project.setLastChangeTime(date);
			session.update(project);
		}
		if(date.after(program.getLastChangeTime()) ){
		//set the date for project
			program.setLastChangeTime(date);
			session.update(program);
		}
		//commit
		tr.commit();
		//flush the session and save to db
		session.clear();
		session.close();
	}
	
	public void deleteProject(int prjid) throws HibernateException{
		String hql = "delete theProject where projectId=:prjid";
		//get session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("prjid", prjid);

		query.executeUpdate();

		tr.commit();
		session.clear();
		session.close();
	}
	public void deleteProgram(int prmid) throws HibernateException{
		String hql = "delete Program where programId=:prmid";
		//get session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("prmid", prmid);

		query.executeUpdate();

		tr.commit();
		session.clear();
		session.close();
	}
	public void deleteVersion (int vrnid) throws HibernateException {
		String hql = "delete Version where versionId=:vrnid";
		//get session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("vrnid", vrnid);

		query.executeUpdate();

		tr.commit();
		session.clear();
		session.close();
	}
	/**
	 * open delete other people's change can be deleted as well
	 * @param chgid - int change id
	 * @throws HibernateException - if the change does not exists
	 */
	public void deleteChange (int chgid) throws HibernateException {
		String hql = "delete Change where changeId=:chgid";
		//get session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("chgid", chgid);

		query.executeUpdate();

		tr.commit();
		session.clear();
		session.close();
	}
	/**
	 * delete the change by change id and user id, the deleted change must be created by the same user
	 * @param chgid - int change id
	 * @param userid - int user id 
	 * @throws HibernateException - if the change does not exists
	 */
	public void deleteSelfChange(int chgid, int userid) throws HibernateException{
		String hql = "delete Change where changeId=:chgid and userId=:userid";
		//get session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery(hql);
		query.setInteger("chgid", chgid);
		query.setInteger("userid", userid);
		
		query.executeUpdate();
		
		tr.commit();
		session.clear();
		session.close();
	}
	/**
	 * delete one user's all change record
	 * @param userid - int userid
	 * @return boolean
	 */
	public boolean deleteUserAllChange(int userid){
		Session session = HibernateUtil.openSession();
		try{
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("delete Change where userId=:userid");
			query.setInteger("userid", userid);
			query.executeUpdate();
			
			tr.commit();
			return true;
		}catch(HibernateException e){
			System.err.println("Hibernate Exception");
			System.err.println(e);
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * clear all changes for the version
	 * @param vrnid
	 * @throws HibernateException
	 */
	public void clearChangesByVersionID(int vrnid) throws HibernateException{
		String hql = "delete Change where versionId=:vrnid";
		//get session
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("vrnid", vrnid);

		query.executeUpdate();

		tr.commit();
		session.clear();
		session.close();
	}
	
	public void editProject(int projectid,String name, Date startDate,String detail){
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		
		theProject proj = (theProject) session.get(theProject.class, projectid);
		proj.setProjectName(name);
		proj.setStartTime(startDate);
		proj.setProjectDetail(detail);
		
		session.update(proj);
		tr.commit();
		session.flush();
		session.clear();
		session.close();
	}
	public void editProgram(int programid,String name, Date startDate,String detail){
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		
		Program prm = (Program) session.get(Program.class, programid);
		prm.setStartTime(startDate);
		prm.setDetail(detail);
		prm.setProgramName(name);
		
		session.update(prm);
		tr.commit();
		session.flush();
		session.clear();
		session.close();
	}	
	public void editVersion(int versionid,String name,String detail){
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		
		Version ver = (Version) session.get(Version.class, versionid);
		ver.setVersionName(name);
		ver.setDetail(detail);
		
		session.update(ver);
		tr.commit();
		session.flush();
		session.clear();
		session.close();
	}
	public void editChange(int changeid, Date changeDate, String changeFile, String detail){
		session = HibernateUtil.openSession();
		Transaction tr = session.beginTransaction();
		
		Change chg = (Change) session.get(Change.class, changeid);
		chg.setChangeDate(changeDate);
		chg.setChangeFile(changeFile);
		chg.setChangeDetail(detail);
		
		session.update(chg);
		tr.commit();
		session.flush();
		session.clear();
		session.close();
	}
	/**
	public static void main(String args[]){
		recordUpdater nn = new recordUpdater();
		nn.clearChangesByVersionID(6);
	}
	*/
}
