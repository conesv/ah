package com.cbsbankui.model;

public class User {

	private long id;
	private String name;
	private String username;
	private String password;
	private String accountType;
	private String securityQuestion;
	private String securityAnswer;
	
	
	//constructors
	public User() {
		super();
	}
	
	public User(String name, String username, String password, String accountType, String securityQuestion,
			String securityAnswer) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	
	//get & set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
}
