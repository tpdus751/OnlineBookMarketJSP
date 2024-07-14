package member;

import java.sql.Date;

public class Member {
	private int no;
	private String userId;
	private String userPwd;
	private String nickname;
	private Date regdate;
	private String mobile;
	private String email;
	private String address;
	
	public Member() {}
	
	
	
	public Member(int no, String userId, String userPwd, String nickname, Date regdate, String mobile, String email,
			String address) {
		this.no = no;
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickname = nickname;
		this.regdate = regdate;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}



	public Member(String userId, String userPwd, String nickname) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickname = nickname;
	}

	public Member(String userId, String userPwd, String nickname, String mobile, String email, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickname = nickname;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", userId=" + userId + ", userPwd=" + userPwd + ", nickname=" + nickname
				+ ", regdate=" + regdate + "]";
	}
	
	
}
