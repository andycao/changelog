package actions;
import java.util.List;
import java.util.Map;

import mydbsearcher.UserManager;
import mydbsearcher.mydbsearcher;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import changelog.User;
import changelog.myDb;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class userActions extends ActionSupport{
	private int userid;
	private User showUser;
	private String username;
	private String password;
	private String[] select1;
	private myDb db  = new mydbsearcher();
	private String permit;
	/**
	 * register.action
	 * @return 
	 */
	public String register(){
		//permit check
		if(!permit.equals(getText("admin.register")))
			return ERROR;
		User user = null;
		//check validate
		try{
			//check for multi user
			Session sess = HibernateUtil.openSession();
			Query query = sess.createQuery("from User where name =:name");
			query.setString("name", username);
			List<User> list = query.list();
			if(list.size() == 0){
				user = db.addUser(username, select1[0], password);
				setCurrentUser(user);
				return Action.SUCCESS;
			} else{
				this.addActionError(getText("error.register"));
				return Action.ERROR;
			}
		}
		catch(Exception e){
			System.err.println(e);
			setCurrentUser(null);
			return Action.ERROR;
		}
	}

	/**
	 * login.action
	 */
	public String login(){
		User user = getCurrentUser();
		//whether has logged in, may be never used
		if(user != null ){
			setUsername(user.getName());
			setPassword(user.getPassword());
		}
		Session sess = HibernateUtil.openSession();
		//database access

		try{
			Query query = sess.createQuery("from User where name =:name and password =:pass");

			//for url injection
			query.setString("name", username);
			query.setString("pass", password); 
			//do the search function and return the results as list
			List<User> list = query.list();
			
			if(list.size() == 1){
				setCurrentUser(list.get(0));
				return 	SUCCESS;
			}else {
				addActionError(getText("error.login"));
				return ERROR;
			}
		}catch(HibernateException e){
			addActionError(getText("error.login"));
			return ERROR;
		}finally{
			sess.close();
		}
	}
	/**
	 * logout.action
	 * @return success
	 */
	public String logout(){
		ActionContext cxt = ActionContext.getContext();
		Map<String,Object> session = cxt.getSession();
		//remove user attribute from http session
		session.remove("user");
		return SUCCESS;
	}
	/**
	 * show use detail, userid first, user name second, current user third, or null
	 * @return success
	 */
	public String showUser(){
		if(userid != 0){
			//use userid
			UserManager um = new UserManager();
			showUser = um.getUser(userid);
			if(showUser != null)
				return Action.SUCCESS;
			else{
				this.addActionError("查询用户错误");
				return Action.ERROR;
			}
		}else if(username != null){
			//use username
			UserManager um = new UserManager();
			showUser = um.getUser(username);
			if(showUser != null)
				return Action.SUCCESS;
			else{
				this.addActionError("查询用户错误");
				return Action.ERROR;
			}
		}else if(getCurrentUser()!= null){
			//use current user
			showUser = getCurrentUser();
			if(showUser != null)
				return Action.SUCCESS;
			else{
				this.addActionError("查询用户错误");
				return Action.ERROR;
			}
		}else{
			return Action.LOGIN;
		}
	}
	/**
	 * delete user
	 * @return string 
	 */
	public String deleteUser(){
		UserManager um = new UserManager();
		boolean del = um.deleteUser(userid);
		if(!del){
			addActionError("用户无法删除，可能是因为其更改记录未清空");
			return Action.ERROR;
		}
		if(getCurrentUser().getUserID() == userid)
			return Action.INPUT;
		else
			return Action.SUCCESS;
	}
	
	public String editPassword(){
		UserManager um = new UserManager();
		User user = getCurrentUser();
		boolean bo = um.editPasswordByID(user.getUserID(), password);
		if(bo)
			return Action.SUCCESS;
		else
			return Action.ERROR;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getSelect1() {
		return select1;
	}
	public void setSelect1(String[] select1) {
		this.select1 = select1;
	}
	/**
	 * set the current login user to this user
	 * @param myuser
	 */
	private void setCurrentUser(User myuser){
		//get the action context
		ActionContext cxt = ActionContext.getContext();
		//http session, map format
		Map<String,Object> session = cxt.getSession();
		//set the user parameter to by the user object
		session.put("user", myuser);
	}
	/**
	 * return the current user object
	 * @return
	 */
	public static User getCurrentUser(){
		//get the action context
		ActionContext cxt = ActionContext.getContext();
		//http session, map format
		Map<String,Object> session = cxt.getSession();
		return (User)session.get("user");
	}
	
	public myDb getDb() {
		return db;
	}
	public void setDb(myDb db) {
		this.db = db;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return the showUser
	 */
	public User getShowUser() {
		return showUser;
	}

	/**
	 * @param showUser the showUser to set
	 */
	public void setShowUser(User showUser) {
		this.showUser = showUser;
	}
}
