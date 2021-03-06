package changelog;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class myDb {
	public myDb() {
	}

	/**
	 * add new user, do not need id as database will generate id automaticly
	 * 
	 * @param name
	 * @param title
	 * @param password
	 * @return user - user object just been added
	 */
	public User addUser(String name, String title, String password) {
		Session se = HibernateUtil.openSession();
		Transaction ts = se.beginTransaction();

		User user = new User();
		user.setName(name);
		user.setTitle(title);
		user.setPassword(password);
		// save the user to db and get the generated identifier
		se.save(user);
		ts.commit();
		se.clear();

		// search user obj from database to get the user obj
		String hql = "from User where name=:name";
		Query query = se.createQuery(hql);
		query.setString("name", name);
		List<User> list = query.list();
		se.clear();
		// close the session
		se.close();
		// return the created user obj
		return list.get(0);
	}

	/**
	 * add a new project
	 * 
	 * @param name
	 * @param start
	 * @param detail
	 */
	public Serializable addProject(String name, Date start, String detail) {
		Session se = HibernateUtil.openSession();
		try {
			Transaction ts = se.beginTransaction();

			theProject therec = new theProject();

			therec.setStartTime(start);
			therec.setLastChangeTime(start);
			therec.setProjectName(name);
			therec.setProjectDetail(detail);

			Serializable id = se.save(therec);
			ts.commit();
			return id;

		} catch (HibernateException e) {
			System.err.println("Hibernate Exception");
			System.err.println(e);
			return null;
		} finally {
			se.close();
		}

	}

	/**
	 * add program record
	 * 
	 * @param projectid
	 * @param name
	 * @param start
	 * @param detail
	 */
	public Serializable addProgram(int projectid, String name, Date start,
			String detail) {
		Session se = HibernateUtil.openSession();
		try {

			Transaction ts = se.beginTransaction();

			Program therec = new Program();
			therec.setProjectId(projectid);
			therec.setStartTime(start);
			therec.setLastChangeTime(start);
			therec.setDetail(detail);
			therec.setProgramName(name);

			Serializable id = se.save(therec);

			ts.commit();
			return id;
		} catch (HibernateException e) {
			System.err.println("Hibernate Exception");
			System.err.println(e);
			return null;
		} finally {
			se.close();
		}
	}

	/**
	 * add version id
	 * 
	 * @param versionName
	 *            - string
	 * @param programId
	 *            - int, foreign key
	 * @param detail
	 *            - string
	 */
	public Serializable addVersion(String versionName, int programId,
			String detail) {
		Session se = HibernateUtil.openSession();
		try {
			Transaction ts = se.beginTransaction();

			Version therec = new Version();
			therec.setVersionName(versionName);
			therec.setProgramId(programId);
			therec.setDetail(detail);

			Serializable id = se.save(therec);
			ts.commit();
			return id;
		} catch (HibernateException e) {
			System.err.println("Hibernate Exception");
			System.err.println(e);
			return null;
		} finally {
			se.close();
		}
	}

	/**
	 * add change log record
	 * 
	 * @param versionid
	 *            - the version id which the change attached on
	 * @param userid
	 *            - current user
	 * @param time
	 *            - changing time
	 * @param detail
	 *            - changing detail
	 * @param fileUrl
	 *            - changed files url addresses
	 */
	public Serializable addChange(int versionid, int userid, Date time,
			String detail, String fileUrl) {
		Session se = HibernateUtil.openSession();
		try {
			Transaction ts = se.beginTransaction();

			Change therec = new Change();
			therec.setProjectId(getProjectByProgram(getProgramByVersion(versionid)));
			therec.setProgramId(getProgramByVersion(versionid));
			therec.setVersionId(versionid);
			therec.setUserId(userid);
			therec.setChangeDate(time);
			therec.setChangeDetail(detail);
			therec.setChangeFile(fileUrl);

			Serializable id = se.save(therec);
			ts.commit();
			return id;
		} catch (HibernateException e) {
			System.err.println("Hibernate Exception");
			System.err.println(e);
			return null;
		} finally {
			// se.flush();
			// se.clear();
			se.close();
		}

	}

	/**
	 * get the program id by version id
	 * 
	 * @param versionId
	 *            - integer
	 * @return program id - integer
	 */
	public int getProgramByVersion(int versionId) {
		Session se = HibernateUtil.openSession();

		Query query = se
				.createQuery("select programId from Version where VersionID = "
						+ versionId);
		List<Integer> list = query.list();
		se.close();
		if (list.get(0) != null)
			return list.get(0);
		return 0;
	}

	/**
	 * get the project id by program id
	 * 
	 * @param proId
	 *            - integer
	 * @return projectid - integer
	 */
	public int getProjectByProgram(int proId) {
		Session se = HibernateUtil.openSession();

		Query query = se
				.createQuery("select projectId from Program where ProgramID = "
						+ proId);
		List<Integer> list = query.list();
		se.close();
		if (list.get(0) != null)
			return list.get(0);
		return 0;
	}
	/*
	 * session public static void main(String args[]){ myDb mydb=new myDb();
	 * System.out.println(mydb.getSession()); }
	 */
}
