package com.score.domain.vo;

import java.util.Date;

public class UserNoticeVO {
	
	private Integer userNoticeNumber;
	private Integer userNoticeReceiveNumber;
	private String userNoticeReceiveNickName;
	private Integer userNoticeSendNumber;
	private String userNoticeSendNickName;
	private String userNoticeCategory;
	private Date userNoticeRegDate;
	private String userNoticeReadBoolean;
	private Integer boardNumber;
	private Integer commentNumber;
	private Integer reCommentNumber;
	private Integer testGameNumber;
	public Integer getUserNoticeNumber() {
		return userNoticeNumber;
	}
	public void setUserNoticeNumber(Integer userNoticeNumber) {
		this.userNoticeNumber = userNoticeNumber;
	}
	public Integer getUserNoticeReceiveNumber() {
		return userNoticeReceiveNumber;
	}
	public void setUserNoticeReceiveNumber(Integer userNoticeReceiveNumber) {
		this.userNoticeReceiveNumber = userNoticeReceiveNumber;
	}
	public String getUserNoticeReceiveNickName() {
		return userNoticeReceiveNickName;
	}
	public void setUserNoticeReceiveNickName(String userNoticeReceiveNickName) {
		this.userNoticeReceiveNickName = userNoticeReceiveNickName;
	}
	public Integer getUserNoticeSendNumber() {
		return userNoticeSendNumber;
	}
	public void setUserNoticeSendNumber(Integer userNoticeSendNumber) {
		this.userNoticeSendNumber = userNoticeSendNumber;
	}
	public String getUserNoticeSendNickName() {
		return userNoticeSendNickName;
	}
	public void setUserNoticeSendNickName(String userNoticeSendNickName) {
		this.userNoticeSendNickName = userNoticeSendNickName;
	}
	public String getUserNoticeCategory() {
		return userNoticeCategory;
	}
	public void setUserNoticeCategory(String userNoticeCategory) {
		this.userNoticeCategory = userNoticeCategory;
	}
	public Date getUserNoticeRegDate() {
		return userNoticeRegDate;
	}
	public void setUserNoticeRegDate(Date userNoticeRegDate) {
		this.userNoticeRegDate = userNoticeRegDate;
	}
	public String getUserNoticeReadBoolean() {
		return userNoticeReadBoolean;
	}
	public void setUserNoticeReadBoolean(String userNoticeReadBoolean) {
		this.userNoticeReadBoolean = userNoticeReadBoolean;
	}
	public Integer getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(Integer boardNumber) {
		this.boardNumber = boardNumber;
	}
	public Integer getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}
	public Integer getReCommentNumber() {
		return reCommentNumber;
	}
	public void setReCommentNumber(Integer reCommentNumber) {
		this.reCommentNumber = reCommentNumber;
	}
	public Integer getTestGameNumber() {
		return testGameNumber;
	}
	public void setTestGameNumber(Integer testGameNumber) {
		this.testGameNumber = testGameNumber;
	}
	
}
