package com.mart.vibe.api.Pojoclass;

public class CreateAccountPojo {
	private String fullName;
	private String emailAddress;
	private String contactNo;
	private String password;
	private String confirmPass;
	public CreateAccountPojo(String fullName, String emailAddress, String contactNo, String password,
			String confirmPass) {
		super();
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.password = password;
		this.confirmPass = confirmPass;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	
}
