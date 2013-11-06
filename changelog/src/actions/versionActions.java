package actions;

import java.util.List;

import mydbsearcher.mydbsearcher;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import changelog.Change;
import changelog.Program;
import changelog.Version;
import changelog.myDb;

import com.opensymphony.xwork2.ActionSupport;

public class versionActions extends ActionSupport{
	private int programId;
	private String detail;
	private String versionName;
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
			searcher.addVersion(versionName, programId, detail);
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
}
