package actions;
import changelog.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.*;
public class allProjectsAction extends ActionSupport{
	private mydbsearcher searcher;
	private List<theProject> list;

	/**
	 * return success or error
	 * error for empty results
	 */
	public String execute(){
		setList(searcher.getAllProjects());
		if(list != null)
			return SUCCESS;
		else
			return ERROR;	
	}
	
	public mydbsearcher getSearcher() {
		return searcher;
	}

	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}

	public List<theProject> getList() {
		return list;
	}

	public void setList(List<theProject> list) {
		this.list = list;
	}
}
