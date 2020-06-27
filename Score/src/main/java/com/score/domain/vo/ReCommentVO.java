package com.score.domain.vo;

import java.util.Date;

public class ReCommentVO {
	
	private Integer reCommentNumber;
	private Integer commentNumber;
	private Integer userNumber;
	private String userNickName;
	private String reCommentContent;
	private Date reCommentRegDate;
	
	public Integer getReCommentNumber() {
		return reCommentNumber;
	}
	public void setReCommentNumber(Integer reCommentNumber) {
		this.reCommentNumber = reCommentNumber;
	}
	public Integer getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
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
	public String getReCommentContent() {
		return reCommentContent;
	}
	public void setReCommentContent(String reCommentContent) {
		this.reCommentContent = reCommentContent;
	}
	public Date getReCommentRegDate() {
		return reCommentRegDate;
	}
	public void setReCommentRegDate(Date reCommentRegDate) {
		this.reCommentRegDate = reCommentRegDate;
	}
	
}
