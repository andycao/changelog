package actions;
import util.myutil;
import java.util.Date;
import java.util.List;

import changelog.Program;
import changelog.theProject;

import com.opensymphony.xwork2.ActionSupport;
import mydbsearcher.mydbsearcher;
public class projectActions extends ActionSupport{
	private int projectId;//for getProject action
	private String projectName;
	private Date startTime;
	private String projectDetail;
	private mydbsearcher searcher = new mydbsearcher();
	
	//search result
	private theProject searchResult;
	//programs for the project
	private List<Program> list;
	//add project action
	public String addProject(){
		try{
			//searcher extend the add method from mydb
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+startTime);
			searcher.addProject(projectName, startTime, projectDetail);
			return SUCCESS;
		}catch(Exception e){
			System.err.println(e);
			return ERROR;
		}
	}
	/**
	 * getproject action required to submit the parameter projectId
	 * @return string
	 */
	public String getProject(){
		//get the project from searcer
		setSearchResult(searcher.getProjectByID(projectId));
		//get the program list
		list = searcher.getProgramsByProjectID(projectId);
		
		if(searchResult == null)
			return ERROR;
		return SUCCESS;
	}
	
	public String removeProject(){
		try{
			searcher.deleteProject(projectId);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * to save
	 * @return
	 */
	public String editProject(){
		try{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`"+startTime);
			searcher.editProject(projectId, projectName, startTime, projectDetail);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		System.out.println("setStartTime :" + startTime);
			this.startTime = startTime;
	}
	public String getProjectDetail() {
		return projectDetail;
	}
	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public mydbsearcher getSearcher() {
		return searcher;
	}

	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}

	public theProject getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(theProject searchResult) {
		this.searchResult = searchResult;
	}
	public List<Program> getList() {
		return list;
	}
	public void setList(List<Program> list) {
		this.list = list;
	}
}
