package com.score.domain.vo;

import java.sql.Date;

public class GameReplyVO {
	
	private Integer gameReplyNumber;
	private Integer gameNumber;
	private String userNickName;
	private Integer userNumber;
	private String gameReplyContent;
	private Date gameReplyRegDate;
	private Date gameReplyUpdateDate;
	
	public Integer getGameNumber() {
		return gameNumber;
	}
	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}
	public Integer getGameReplyNumber() {
		return gameReplyNumber;
	}
	public void setGameReplyNumber(Integer gameReplyNumber) {
		this.gameReplyNumber = gameReplyNumber;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public Integer getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}
	public String getGameReplyContent() {
		return gameReplyContent;
	}
	public void setGameReplyContent(String gameReplyContent) {
		this.gameReplyContent = gameReplyContent;
	}
	public Date getGameReplyRegDate() {
		return gameReplyRegDate;
	}
	public void setGameReplyRegDate(Date gameReplyRegDate) {
		this.gameReplyRegDate = gameReplyRegDate;
	}
	public Date getGameReplyUpdateDate() {
		return gameReplyUpdateDate;
	}
	public void setGameReplyUpdateDate(Date gameReplyUpdateDate) {
		this.gameReplyUpdateDate = gameReplyUpdateDate;
	}
	
}
