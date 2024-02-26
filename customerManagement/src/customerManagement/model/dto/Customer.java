package customerManagement.model.dto;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String address;
	private String phoneNumber;
	private boolean login; // 로그인 여부

	public Customer() {}

	public Customer(String memberId, String memberPw, String memberName, int memberAge, String address,
			String phoneNumber, boolean login) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.login = login;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "[고객 ID] " + memberId + " / [고객 성함] " + memberName
				+ " / [고객 나이] " + memberAge + " / [고객 주소] " + address + " / [고객 전화번호] " + phoneNumber;
	}
	
}
