package mydbsearcher;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
		session = getSession();
		session.beginTransaction();
		theProject project = (theProject) session.get(theProject.class, projectid);
		if(date.after(project.getLastChangeTime()) ){
			//set the date for project
			project.setLastChangeTime(date);
			session.update(project);
		}

		//commit
		session.getTransaction().commit();
		//flush the session and save to db
		session.clear();
	}
	public void updateProgramDate(int programid, Date date){
		//set session
		session = getSession();
		session.beginTransaction();
		Program program = (Program) session.get(Program.class, programid);
		if(date.after(program.getLastChangeTime()) ){
		//set the date for project
			program.setLastChangeTime(date);
			session.update(program);
		}

		//commit
		session.getTransaction().commit();
		//flush the session and save to db
		session.clear();
	}
	/**
	 * update the project and program last date by versionid
	 * @param versionid
	 * @param date
	 */
	public void updateUp(int versionid, Date date){
		//set session
		session = getSession();
		session.beginTransaction();
		
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
		session.getTransaction().commit();
		//flush the session and save to db
		session.clear();
	}
	
	public void deleteProject(int prjid) throws HibernateException{
		String hql = "delete theProject where projectId=:prjid";
		//get session
		session = getSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("prjid", prjid);

		query.executeUpdate();

		session.getTransaction().commit();
		session.clear();
	}
	public void deleteProgram(int prmid) throws HibernateException{
		String hql = "delete Program where programId=:prmid";
		//get session
		session = getSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("prmid", prmid);

		query.executeUpdate();

		session.getTransaction().commit();
		session.clear();
	}
	public void deleteVersion (int vrnid) throws HibernateException {
		String hql = "delete Version where versionId=:vrnid";
		//get session
		session = getSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("vrnid", vrnid);

		query.executeUpdate();

		session.getTransaction().commit();
		session.clear();
	}
	/**
	 * open delete other people's change can be deleted as well
	 * @param chgid - int change id
	 * @throws HibernateException - if the change does not exists
	 */
	public void deleteChange (int chgid) throws HibernateException {
		String hql = "delete Change where changeId=:chgid";
		//get session
		session = getSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("chgid", chgid);

		query.executeUpdate();

		session.getTransaction().commit();
		session.clear();
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
		session = getSession();
		session.beginTransaction();
		
		Query query = session.createQuery(hql);
		query.setInteger("chgid", chgid);
		query.setInteger("userid", userid);
		
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.clear();
	}
	
	/**
	 * clear all changes for the version
	 * @param vrnid
	 * @throws HibernateException
	 */
	public void clearChangesByVersionID(int vrnid) throws HibernateException{
		String hql = "delete Change where versionId=:vrnid";
		//get session
		session = getSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger("vrnid", vrnid);

		query.executeUpdate();

		session.getTransaction().commit();
		session.clear();
	}
	
	public void editProject(int projectid,String name, Date startDate,String detail){
		session = getSession();
		session.beginTransaction();
		
		theProject proj = (theProject) session.get(theProject.class, projectid);
		proj.setProjectName(name);
		proj.setStartTime(startDate);
		proj.setProjectDetail(detail);
		
		session.update(proj);
		session.getTransaction().commit();
		session.flush();
		session.clear();
	}
	public void editProgram(int programid,String name, Date startDate,String detail){
		session = getSession();
		session.beginTransaction();
		
		Program prm = (Program) session.get(Program.class, programid);
		prm.setStartTime(startDate);
		prm.setDetail(detail);
		prm.setProgramName(name);
		
		session.update(prm);
		session.getTransaction().commit();
		session.flush();
		session.clear();
	}	
	public void editVersion(int versionid,String name,String detail){
		session = getSession();
		session.beginTransaction();
		
		Version ver = (Version) session.get(Version.class, versionid);
		ver.setVersionName(name);
		ver.setDetail(detail);
		
		session.update(ver);
		session.getTransaction().commit();
		session.flush();
		session.clear();
	}
	public void editChange(int changeid, Date changeDate, String changeFile, String detail){
		session = getSession();
		session.beginTransaction();
		
		Change chg = (Change) session.get(Change.class, changeid);
		chg.setChangeDate(changeDate);
		chg.setChangeFile(changeFile);
		chg.setChangeDetail(detail);
		
		session.update(chg);
		session.getTransaction().commit();
		session.flush();
		session.clear();
	}
	public static void main(String args[]){
		recordUpdater nn = new recordUpdater();
		nn.clearChangesByVersionID(6);
	}
}
