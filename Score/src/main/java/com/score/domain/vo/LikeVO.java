package com.score.domain.vo;

import java.util.Date;

public class LikeVO {
	
	private Integer likeNumber;
	private Integer boardNumber;
	private Integer userNumber;
	private Date likeRegDate;
	public Integer getlikeNumber() {
		return likeNumber;
	}
	public void setlikeNumber(Integer likeNumber) {
		this.likeNumber = likeNumber;
	}
	public Integer getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(Integer boardNumber) {
		this.boardNumber = boardNumber;
	}
	public Integer getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}
	public Date getlikeRegDate() {
		return likeRegDate;
	}
	public void setlikeRegDate(Date likeRegDate) {
		this.likeRegDate = likeRegDate;
	}

}
