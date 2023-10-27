package com.example.beans.dto;

public class QueryProfile {
	private int contactProfileId;
	private String contactName;
	private int contactWalletId;
	
	public QueryProfile(int contactProfileId, String contactName, int contactWalletId) {
		super();
		this.contactProfileId = contactProfileId;
		this.contactName = contactName;
		this.contactWalletId = contactWalletId;
	}
	public QueryProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getContactProfileId() {
		return contactProfileId;
	}
	public void setContactProfileId(int contactProfileId) {
		this.contactProfileId = contactProfileId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public int getContactWalletId() {
		return contactWalletId;
	}
	public void setContactWalletId(int contactWalletId) {
		this.contactWalletId = contactWalletId;
	}
	
}
