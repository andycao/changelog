package changelog;

import java.util.Date;

public class Change {
	private int changeId;
	private int programId;
	private int userId;
	private int versionId;
	private int projectId;
	private String changeFile;
	private Date changeDate;
	private String changeDetail;
	public Change(){
		
	}
	public int getChangeId() {
		return changeId;
	}
	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getChangeDetail() {
		return changeDetail;
	}
	public void setChangeDetail(String changeDetail) {
		this.changeDetail = changeDetail;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}
