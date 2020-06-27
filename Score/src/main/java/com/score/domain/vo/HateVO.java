package com.score.domain.vo;

import java.util.Date;

public class HateVO {
	
	private Integer hateNumber;
	private Integer boardNumber;
	private Integer userNumber;
	private Date hateRegDate;
	public Integer getHateNumber() {
		return hateNumber;
	}
	public void setHateNumber(Integer hateNumber) {
		this.hateNumber = hateNumber;
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
	public Date getHateRegDate() {
		return hateRegDate;
	}
	public void setHateRegDate(Date hateRegDate) {
		this.hateRegDate = hateRegDate;
	}

}
