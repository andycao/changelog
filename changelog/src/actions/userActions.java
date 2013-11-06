package actions;
import java.util.List;
import java.util.Map;

import mydbsearcher.mydbsearcher;

import org.hibernate.Query;
import org.hibernate.Session;

import changelog.User;
import changelog.myDb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class userActions extends ActionSupport{
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
		if(!permit.equals("ancs12345678"))
			return ERROR;
		User user = null;
		//check validate
		try{
			//check for multi user
			Session sess = db.getSession();
			Query query = sess.createQuery("from User where name =:name");
			query.setString("name", username);
			List<User> list = query.list();
			if(list.size() == 0){
				user = db.addUser(username, select1[0], password);
				setCurrentUser(user);
				return SUCCESS;
			} else
				return "multiuser";
		}
		catch(Exception e){
			System.err.println(e);
			setCurrentUser(null);
			return ERROR;
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
		Session sess = db.getSession();
		Query query = sess.createQuery("from User where name =:name and password =:pass");
		//for url injection
		query.setString("name", username);
		query.setString("pass", password); 
		//do the search function and return the results as list
		List<User> list = query.list();
		sess.close();//close the session
		if(list.size() == 1){
			setCurrentUser(list.get(0));
			return 	SUCCESS;
		}else if(list.size() > 1){
			return "multiuser";
		}else {
			addActionError(getText("error.login"));
			return ERROR;
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
	private User getCurrentUser(){
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
}
