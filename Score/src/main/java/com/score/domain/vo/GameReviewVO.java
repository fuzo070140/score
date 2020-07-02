package com.score.domain.vo;

import java.sql.Date;

public class GameReviewVO {

	private Integer gameReviewNumber;
	private Integer gameNumber;
	private Integer userNumber;
	private Integer userNickName;
	private Integer gameReviewScore;
	private String gameReviewTitle;
	private String gameReviewContent;
	private Date gameReviewDate;

	public Integer getGameReviewNumber() {
		return gameReviewNumber;
	}

	public void setGameReviewNumber(Integer gameReviewNumber) {
		this.gameReviewNumber = gameReviewNumber;
	}

	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public Integer getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(Integer userNickName) {
		this.userNickName = userNickName;
	}

	public Date getGameReviewDate() {
		return gameReviewDate;
	}

	public void setGameReviewDate(Date gameReviewDate) {
		this.gameReviewDate = gameReviewDate;
	}

	public String getGameReviewTitle() {
		return gameReviewTitle;
	}

	public void setGameReviewTitle(String gameReviewTitle) {
		this.gameReviewTitle = gameReviewTitle;
	}

	public String getGameReviewContent() {
		return gameReviewContent;
	}

	public void setGameReviewContent(String gameReviewContent) {
		this.gameReviewContent = gameReviewContent;
	}

	public Integer getGameReviewScore() {
		return gameReviewScore;
	}

	public void setGameReviewScore(Integer gameReviewScore) {
		this.gameReviewScore = gameReviewScore;
	}
	
}
