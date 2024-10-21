package litis.vo;

public class Organization {
	private int orgNo;
	private String orgName;
	private int parentOrgNo;
	private String orgNoDelFl;
	
	public Organization() {}
	
	public Organization(int orgNo, String orgName, int parentOrgNo, String orgNoDelFl) {
		super();
		this.orgNo = orgNo;
		this.orgName = orgName;
		this.parentOrgNo = parentOrgNo;
		this.orgNoDelFl = orgNoDelFl;
	}	
	
	public int getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(int orgNo) {
		this.orgNo = orgNo;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getParentOrgNo() {
		return parentOrgNo;
	}

	public void setParentOrgNo(int parentOrgNo) {
		this.parentOrgNo = parentOrgNo;
	}

	public String getOrgNoDelFl() {
		return orgNoDelFl;
	}

	public void setOrgNoDelFl(String orgNoDelFl) {
		this.orgNoDelFl = orgNoDelFl;
	}

	@Override
	public String toString() {
		return "Organization [orgNo=" + orgNo + ", orgName=" + orgName + ", parentOrgNo=" + parentOrgNo
				+ ", orgNoDelFl=" + orgNoDelFl + "]";
	}

}
