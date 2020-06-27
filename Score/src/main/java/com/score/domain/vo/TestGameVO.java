package com.score.domain.vo;

import java.util.Date;

public class TestGameVO {
	
	private Integer testGameNumber;
	private String testGameTitle;
	private String testGameImg;
	private String testGameDeveloper;
	private Integer userNumber;
	private String userNickName;
	private String testGameStatus;
	private Date testGameDeadline;
	public Integer getTestGameNumber() {
		return testGameNumber;
	}
	public void setTestGameNumber(Integer testGameNumber) {
		this.testGameNumber = testGameNumber;
	}
	public String getTestGameTitle() {
		return testGameTitle;
	}
	public void setTestGameTitle(String testGameTitle) {
		this.testGameTitle = testGameTitle;
	}
	public String getTestGameImg() {
		return testGameImg;
	}
	public void setTestGameImg(String testGameImg) {
		this.testGameImg = testGameImg;
	}
	public String getTestGameDeveloper() {
		return testGameDeveloper;
	}
	public void setTestGameDeveloper(String testGameDeveloper) {
		this.testGameDeveloper = testGameDeveloper;
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
	public String getTestGameStatus() {
		return testGameStatus;
	}
	public void setTestGameStatus(String testGameStatus) {
		this.testGameStatus = testGameStatus;
	}
	public Date getTestGameDeadline() {
		return testGameDeadline;
	}
	public void setTestGameDeadline(Date testGameDeadline) {
		this.testGameDeadline = testGameDeadline;
	}

}
