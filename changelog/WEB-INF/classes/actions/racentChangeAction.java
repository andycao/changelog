package actions;
import changelog.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.*;
public class racentChangeAction extends ActionSupport{
	private mydbsearcher searcher = new mydbsearcher();
	private List<Change> list;

	/**
	 * return success or error
	 * error for empty results
	 */
	public String execute(){
		setList(searcher.getRacentChanges());
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

	public List<Change> getList() {
		return list;
	}

	public void setList(List<Change> list) {
		this.list = list;
	}
}
