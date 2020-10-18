package com.somesh.onlineExamSystem.Entity;

public class UserPin {
	private int userPinId;
	private int userId;
	private String pin;
	private String createdOn;
	public UserPin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPin(int userPinId, int userId, String pin, String createdOn) {
		super();
		this.userPinId = userPinId;
		this.userId = userId;
		this.pin = pin;
		this.createdOn = createdOn;
	}
	public int getUserPinId() {
		return userPinId;
	}
	public void setUserPinId(int userPinId) {
		this.userPinId = userPinId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}