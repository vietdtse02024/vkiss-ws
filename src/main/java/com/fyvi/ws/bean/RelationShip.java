package com.fyvi.ws.bean;

import java.util.Date;

public class RelationShip {
	private String id;
	private String accountId;
	private String accountIdFriend;
	private Integer status;
	private Date inputDate;
	private Date updateDate;
	private Integer activeFlg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountIdFriend() {
		return accountIdFriend;
	}
	public void setAccountIdFriend(String accountIdFriend) {
		this.accountIdFriend = accountIdFriend;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getActiveFlg() {
		return activeFlg;
	}
	public void setActiveFlg(Integer activeFlg) {
		this.activeFlg = activeFlg;
	}
}
