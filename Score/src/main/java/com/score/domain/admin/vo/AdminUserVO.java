package com.score.domain.admin.vo;

import java.util.Date;

public class AdminUserVO {

	private int adminUserNumber;
	private String adminUserNickName;
	private String adminUserID;
	private String adminUserPassword;
	private String adminUserName;
	private Date adminUserRegDate;
	
	public int getAdminUserNumber() {
		return adminUserNumber;
	}
	public void setAdminUserNumber(int adminUserNumber) {
		this.adminUserNumber = adminUserNumber;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public Date getAdminUserRegDate() {
		return adminUserRegDate;
	}
	public void setAdminUserRegDate(Date adminUserRegDate) {
		this.adminUserRegDate = adminUserRegDate;
	}
	public String getAdminUserNickName() {
		return adminUserNickName;
	}
	public void setAdminUserNickName(String adminUserNickName) {
		this.adminUserNickName = adminUserNickName;
	}
	public String getAdminUserID() {
		return adminUserID;
	}
	public void setAdminUserID(String adminUserID) {
		this.adminUserID = adminUserID;
	}
	public String getAdminUserPassword() {
		return adminUserPassword;
	}
	public void setAdminUserPassword(String adminUserPassword) {
		this.adminUserPassword = adminUserPassword;
	}

}
