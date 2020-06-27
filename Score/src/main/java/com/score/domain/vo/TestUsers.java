package com.score.domain.vo;

import java.util.Date;

public class TestUsers {
	
	private Integer testUsersNumber;
	private Integer testGameNumber;
	private Integer userNumber;
	private String userNickName;
	private String testUsersStatus;
	private Date testUsersDeadline;
	public Integer getTestUsersNumber() {
		return testUsersNumber;
	}
	public void setTestUsersNumber(Integer testUsersNumber) {
		this.testUsersNumber = testUsersNumber;
	}
	public Integer getTestGameNumber() {
		return testGameNumber;
	}
	public void setTestGameNumber(Integer testGameNumber) {
		this.testGameNumber = testGameNumber;
	}
	public Integer getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getTestUsersStatus() {
		return testUsersStatus;
	}
	public void setTestUsersStatus(String testUsersStatus) {
		this.testUsersStatus = testUsersStatus;
	}
	public Date getTestUsersDeadline() {
		return testUsersDeadline;
	}
	public void setTestUsersDeadline(Date testUsersDeadline) {
		this.testUsersDeadline = testUsersDeadline;
	}
	
}
