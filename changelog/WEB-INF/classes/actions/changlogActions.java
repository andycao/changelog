package actions;

import java.util.*;

import mydbsearcher.mydbsearcher;

import changelog.Change;
import changelog.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.myutil;
public class changlogActions extends ActionSupport{
	private int versionId;
	private int userId;
	private Date changeDate;
	private String changeDetail;
	private String changeFile;

	private String belongedVersionName;
	//searcher
	private mydbsearcher searcher = new mydbsearcher();
	//getchange obj result
	private Change changeResult;
	//for getchange action
	private int changeId;
	
	public String addChangelog(){
		try{
			//add the change
			searcher.addChange(versionId, userId, changeDate, changeDetail, changeFile);
			//update date
			//searcher.updateUp(versionId, changeDate);
			searcher.updateUp(versionId, changeDate);
		return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	/**
	 * getChange action - by changeId
	 * @return string -success error
	 */
	public String getChange(){
		//get the change object by changeId
		Change result=searcher.getChangeByID(changeId);
		setChangeResult(result);
		if(changeResult == null)
			return ERROR;
		return SUCCESS;
	}
	public String removeChange(){
		try{
			
			Change c = searcher.getChangeByID(changeId);
			this.setVersionId(c.getVersionId());
			
			searcher.deleteChange(changeId);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * requires changeid and userid
	 * @return string success, error
	 */
	public String removeSelfChange(){
		try{
			//get the change and set version id
			Change c = searcher.getChangeByID(changeId);
			this.setVersionId(c.getVersionId());
			
			//get the current userid
			userId = userActions.getCurrentUser().getUserID();
			//delete the change
			searcher.deleteSelfChange(changeId, userId);
			
			//not self can't delete
			if(searcher.getChangeByID(changeId) != null){
				 return "title";
			}
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String editChange(){
		//get the http session user
		User user= this.getCurrentUser();
		if(user.getUserID() != searcher.getChangeByID(changeId).getUserId())
			return "usererror";
		try{
			searcher.editChange(changeId, changeDate, changeFile, changeDetail);
			int vid = searcher.getChangeByID(changeId).getVersionId();
			searcher.updateUp(vid, changeDate);
		}catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public mydbsearcher getSearcher() {
		return searcher;
	}

	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getChangeFile() {
		return changeFile;
	}
	public void setChangeFile(String changeFile) {
		this.changeFile = changeFile;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
//		this.changeDate = myutil.stringToDate(changeDate);
		if(changeDate instanceof Date)
			this.changeDate = (Date) changeDate;
		else
			this.changeDate = new Date();
	}
	public String getChangeDetail() {
		return changeDetail;
	}
	public void setChangeDetail(String changeDetail) {
		this.changeDetail = changeDetail;
	}

	public int getChangeId() {
		return changeId;
	}

	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}

	public Change getChangeResult() {
		return changeResult;
	}

	public void setChangeResult(Change changeResult) {
		//get the version name
		belongedVersionName = searcher.getVersionByID(changeResult.getVersionId()).getVersionName();
		this.changeResult = changeResult;
	}
	
	/**
	 * return the current user object
	 * @return
	 */
	private User getCurrentUser(){
		//get the action context
		ActionContext cxt = ActionContext.getContext();
		//http session, map format
		Map<String,Object> session = cxt.getSession();
		return (User)session.get("user");
	}
	/**
	 * @return the belongedVersionName
	 */
	public String getBelongedVersionName() {
		return belongedVersionName;
	}
	/**
	 * @param belongedVersionName the belongedVersionName to set
	 */
	public void setBelongedVersionName(String belongedVersionName) {
		this.belongedVersionName = belongedVersionName;
	}
	
}
