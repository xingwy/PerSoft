package com.example.persoft;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
public class Users implements java.io.Serializable {

	
	private Integer id;
	private String username;
	private String password;
	private String phoneNumber;
	private String memo1;
	private String memo2;
	private String memo3;
	private String memo4;	
	
	// Constructors

	/** default constructor */
	public Users() {
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", memo1="
				+ memo1 + ", memo2=" + memo2 + ", memo3=" + memo3 + ", memo4="
				+ memo4 + "]";
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memo1 == null) ? 0 : memo1.hashCode());
		result = prime * result + ((memo2 == null) ? 0 : memo2.hashCode());
		result = prime * result + ((memo3 == null) ? 0 : memo3.hashCode());
		result = prime * result + ((memo4 == null) ? 0 : memo4.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memo1 == null) {
			if (other.memo1 != null)
				return false;
		} else if (!memo1.equals(other.memo1))
			return false;
		if (memo2 == null) {
			if (other.memo2 != null)
				return false;
		} else if (!memo2.equals(other.memo2))
			return false;
		if (memo3 == null) {
			if (other.memo3 != null)
				return false;
		} else if (!memo3.equals(other.memo3))
			return false;
		if (memo4 == null) {
			if (other.memo4 != null)
				return false;
		} else if (!memo4.equals(other.memo4))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getMemo3() {
		return memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	public String getMemo4() {
		return memo4;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	/** minimal constructor */
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Users(String username, String password, String phoneNumber,
			String memo1, String memo2, String memo3, String memo4) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.memo1 = memo1;
		this.memo2 = memo2;
		this.memo3 = memo3;
		this.memo4 = memo4;
		
	}

}
