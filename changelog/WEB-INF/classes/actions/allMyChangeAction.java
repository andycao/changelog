package actions;
import changelog.*;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.*;
public class allMyChangeAction extends ActionSupport{
	private mydbsearcher searcher = new mydbsearcher();
	private List<Change> list;

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

	public void setList(List<Change> list) {
		this.list = list;
	}
}
