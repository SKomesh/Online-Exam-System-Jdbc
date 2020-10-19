package com.somesh.onlineExamSystem.Utils;

public class SqlQueries {

	public static final String GET_USER_BY_EMAILID = "SELECT * FROM userDetails WHERE emailId=?";
	public static final String ADD_NEW_USER = "INSERT INTO userDetails(firstName,lastName,mobileNo,emailId,password,confirmPassword) values(?,?,?,?,?,?)";
}
