package actions;


import java.util.List;
import java.util.Date;
import mydbsearcher.mydbsearcher;
import util.myutil;
import com.opensymphony.xwork2.ActionSupport;

import changelog.Program;
import changelog.Version;

public class programActions extends ActionSupport{
	private String programName;
	private Date startTime;
	private String detail;
	private int projectId;
	private String belongedProjectName;
	
	//searcher
	private mydbsearcher searcher = new mydbsearcher();
	//getprogram action
	private Program programResult;
	//for getProgram action
	private int programId;
	//versions for the program
	private List<Version> list;
	
	public String addProgram(){
		try{
			searcher.addProgram(projectId, programName, startTime, detail);
		return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	/**
	 * get program action
	 * @return string - success and error
 	 */
	public String getProgram(){
		setProgramResult(searcher.getProgramByID(programId));
		//get the version list
		list = searcher.getVersionsByProgramID(programId);
		if(programResult == null)
			return ERROR;
		return SUCCESS;
	}
	public String removeProgram(){
		try{
			//get the program set project id
			Program p = searcher.getProgramByID(programId);
			setProjectId(p.getProjectId());
			//remove program
			searcher.deleteProgram(programId);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	public String editProgram(){
		try{
			searcher.editProgram(programId, programName, startTime, detail);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Program getProgramResult() {
		return programResult;
	}

	public void setProgramResult(Program programResult) {
		int projid = programResult.getProjectId();//get the belonged project id
		this.belongedProjectName = searcher.getProjectByID(projid).getProjectName();//set the project name
		System.out.println(belongedProjectName);
		
		this.programResult = programResult;
	}

	public mydbsearcher getSearcher() {
		return searcher;
	}

	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public List<Version> getList() {
		return list;
	}

	public void setList(List<Version> list) {
		this.list = list;
	}
	/**
	 * @return the belongedProjectName
	 */
	public String getBelongedProjectName() {
		return belongedProjectName;
	}
	/**
	 * @param belongedProjectName the belongedProjectName to set
	 */
	public void setBelongedProjectName(String belongedProjectName) {
		this.belongedProjectName = belongedProjectName;
	}
}
