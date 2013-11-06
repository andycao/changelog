package preaddactions;

import java.util.Date;

import mydbsearcher.mydbsearcher;

import changelog.Change;
import changelog.Program;
import changelog.Version;
import changelog.theProject;

import com.opensymphony.xwork2.ActionSupport;
import util.myutil;
public class preEditAction extends ActionSupport{
	private int projectId;
	private int programId;
	private String programName;
	private String projectName;
	private int versionId;
	private String versionName;
	private int changeId;
	private String changeFile;
	private Date changeDate;
	private Date projectStartTime;
	private Date programStartTime;
	private mydbsearcher searcher;
	private String projectDetail;
	private String programDetail;
	private String changeDetail;
	private String versionDetail;
	public String preEditProject(){
		theProject proj = searcher.getProjectByID(projectId);
		this.setProjectName(proj.getProjectName());
		this.setProjectStartTime(proj.getStartTime());
		this.setProjectDetail(proj.getProjectDetail());
		return SUCCESS;
	}
	public String preEditProgram(){
		Program prom = searcher.getProgramByID(programId);
		this.setProgramName(prom.getProgramName());
		this.setProgramStartTime(prom.getStartTime());
		this.setProgramDetail(prom.getDetail());
		return SUCCESS;
	}
	public String preEditVersion(){
		Version version = searcher.getVersionByID(versionId);
		this.setVersionName(version.getVersionName());
		this.setVersionDetail(version.getDetail());
		return SUCCESS;
	}
	public String preEditChange(){
		Change change = searcher.getChangeByID(changeId);
		this.setChangeDate(change.getChangeDate());
		this.setChangeFile(change.getChangeFile());
		this.setChangeDetail(change.getChangeDetail());
		return SUCCESS;
	}

	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public int getChangeId() {
		return changeId;
	}
	public void setChangeId(int changeId) {
		this.changeId = changeId;
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
		this.changeDate = changeDate;
	}
	public Date getProjectStartTime() {
		return projectStartTime;
	}
	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}
	public Date getProgramStartTime() {
		return programStartTime;
	}
	public void setProgramStartTime(Date programStartTime) {
		this.programStartTime = programStartTime;
	}
	public mydbsearcher getSearcher() {
		return searcher;
	}
	public void setSearcher(mydbsearcher searcher) {
		this.searcher = searcher;
	}
	public String getProjectDetail() {
		return projectDetail;
	}
	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}
	public String getProgramDetail() {
		return programDetail;
	}
	public void setProgramDetail(String programDetail) {
		this.programDetail = programDetail;
	}
	public String getChangeDetail() {
		return changeDetail;
	}
	public void setChangeDetail(String changeDetail) {
		this.changeDetail = changeDetail;
	}
	public String getVersionDetail() {
		return versionDetail;
	}
	public void setVersionDetail(String versionDetail) {
		this.versionDetail = versionDetail;
	}
}
