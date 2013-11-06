package actions;
import changelog.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.*;
public class allProgramAction extends ActionSupport{
	private mydbsearcher searcher = new mydbsearcher();
	private List<Program> list;

	/**
	 * return success or error
	 * error for empty results
	 */
	public String execute(){
		setList(searcher.getAllPrograms());
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

	public List<Program> getList() {
		return list;
	}

	public void setList(List<Program> list) {
		this.list = list;
	}
}
