package com.score.domain.vo;

import java.util.Date;

public class TestGameReviewVO {
	
	private Integer testGameReviewNumber;
	private Integer testGameNuber;
	private Integer userNumber;
	private String userNickName;
	private String testGameReviewScore;
	private String testGameReviewContent;
	private Date testGameReviewDate;
	public Integer getTestGameReviewNumber() {
		return testGameReviewNumber;
	}
	public void setTestGameReviewNumber(Integer testGameReviewNumber) {
		this.testGameReviewNumber = testGameReviewNumber;
	}
	public Integer getTestGameNuber() {
		return testGameNuber;
	}
	public void setTestGameNuber(Integer testGameNuber) {
		this.testGameNuber = testGameNuber;
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
	public String getTestGameReviewScore() {
		return testGameReviewScore;
	}
	public void setTestGameReviewScore(String testGameReviewScore) {
		this.testGameReviewScore = testGameReviewScore;
	}
	public String getTestGameReviewContent() {
		return testGameReviewContent;
	}
	public void setTestGameReviewContent(String testGameReviewContent) {
		this.testGameReviewContent = testGameReviewContent;
	}
	public Date getTestGameReviewDate() {
		return testGameReviewDate;
	}
	public void setTestGameReviewDate(Date testGameReviewDate) {
		this.testGameReviewDate = testGameReviewDate;
	}

}
