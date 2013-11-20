package actions;

import java.io.Serializable;
import java.util.List;

import mydbsearcher.mydbsearcher;
import changelog.Change;
import changelog.Version;

import com.opensymphony.xwork2.ActionSupport;

public class versionActions extends ActionSupport{
	private int programId;
	private String detail;
	private String versionName;
	
	private String belongedProgramName;
	//searcher
	private mydbsearcher searcher = new mydbsearcher();
	//getversion result
	private Version versionResult;
	//for getVersion action
	private int versionId;
	//changes for the version
	private List<Change> list;
	
	/**
	 * addVersion action
	 * @return string - success or error
	 */
	public String addVersion(){
		try{
			Serializable id = searcher.addVersion(versionName, programId, detail);
			this.setVersionId((Integer)id);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	/**
	 * get version action
	 * @return string - success - error
	 */
	public String getVersion(){
		setVersionResult(searcher.getVersionByID(versionId));
		//get the change list
		list = searcher.getChangeByVersionID(versionId);
		if(versionResult == null)
			return ERROR;
		return SUCCESS;
	}
	
	public String removeVersion(){
		try{
			//get the version
			Version v = searcher.getVersionByID(versionId);
			this.setProgramId(v.getProgramId());
			
			//delete the version
			searcher.deleteVersion(versionId);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String removeAllChanges(){
		try{
			searcher.clearChangesByVersionID(versionId);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	public String editVersion(){
		try{
			searcher.editVersion(versionId,versionName,detail);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getVersionName() {
		return versionName;
	}


	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public mydbsearcher getSearcher() {
		return searcher;
	}
	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}

	public Version getVersionResult() {
		return versionResult;
	}

	public void setVersionResult(Version versionResult) {
		int progid = versionResult.getProgramId();
		belongedProgramName = searcher.getProgramByID(progid).getProgramName();//get the program name
		this.versionResult = versionResult;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public List<Change> getList() {
		return list;
	}

	public void setList(List<Change> list) {
		this.list = list;
	}
	/**
	 * @return the belongedProgramName
	 */
	public String getBelongedProgramName() {
		return belongedProgramName;
	}
	/**
	 * @param belongedProgramName the belongedProgramName to set
	 */
	public void setBelongedProgramName(String belongedProgramName) {
		this.belongedProgramName = belongedProgramName;
	}
}
