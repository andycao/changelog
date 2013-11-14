package actions;
import changelog.*;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.*;
public class allMyChangeAction extends ActionSupport{
	private mydbsearcher searcher = new mydbsearcher();
	private List<Change> list;
	//user manager
	/**
	 * return success or error
	 * error for empty results
	 */
	public String execute(){
		//get the current user
		ActionContext cxt = ActionContext.getContext();
		Map<String,Object> session = cxt.getSession();
		User user = (User) session.get("user");
		//if the user is empty
		if(user == null)
			return LOGIN;
		setList(searcher.getChangesByUserID(user.getUserID()));
		if(list.size() > 0)
			return SUCCESS;
		else
			return ERROR;	
	}
	
	public String clearAllMyChanges(){
		recordUpdater updater = new recordUpdater();
		int userid = userActions.getCurrentUser().getUserID();
		boolean bo = updater.deleteUserAllChange(userid);
		
		if(bo)
			return Action.SUCCESS;
		else{
			addActionError("删除错误");
			return Action.ERROR;
		}
	}
	
	/**
	 * get all changes 
	 * @return list of all changes
	 */
	public String getAllChange(){
		setList(searcher.allChanges());
		return SUCCESS;
	}
	
	public mydbsearcher getSearcher() {
		return searcher;
	}

	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}

	public List<Change> getList() {
		return list;
	}

	/*
	 * set the result list
	 */
	public void setList(List<Change> list) {
		this.list = list;
	}
	
}
