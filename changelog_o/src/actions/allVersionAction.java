package actions;
import changelog.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.*;
public class allVersionAction extends ActionSupport{
	private mydbsearcher searcher;
	private List<Version> list;

	/**
	 * return success or error
	 * error for empty results
	 */
	public String execute(){
		setList(searcher.getAllVersions());
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

	public List<Version> getList() {
		return list;
	}

	public void setList(List<Version> list) {
		this.list = list;
	}
}
