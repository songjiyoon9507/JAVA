package toyproject.mfp.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public class MFP implements Serializable {
	private String userIp; // 인트라넷 ip
	private long userId; // 사번
	private String userPw; // 비밀번호
//	private String dept; // 소속 부서
//	private String job; // 직급
	private Map<String, String> deptList; // 소속 부서, 직급
	private LocalDateTime printDate; // 프린트한 날짜
	
	public MFP() {}

	public MFP(String userIp, long userId, String userPw, Map<String,String> deptList, LocalDateTime printDate) {
		super();
		this.userIp = userIp;
		this.userId = userId;
		this.userPw = userPw;
		this.deptList = deptList;
		this.printDate = printDate;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	

	public LocalDateTime getPrintDate() {
		return printDate;
	}

	public void setPrintDate(LocalDateTime printDate) {
		this.printDate = printDate;
	}



}
