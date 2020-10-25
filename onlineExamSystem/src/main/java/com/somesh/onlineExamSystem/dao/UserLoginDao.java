package com.somesh.onlineExamSystem.dao;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.somesh.onlineExamSystem.Entity.UserDetails;

public interface UserLoginDao {

	public UserDetails getUserByEmail(String emailId) throws DataAccessException, SQLException;

	public Boolean addNewUser(UserDetails object);
 
    public Map<String, Object> sendOtpToUser(String object, Map<String, Object> resObject);

	public Boolean verifyOtp(Map<String, Object> reqObject);

	public Boolean resetPassword(Map<String, Object> reqObject);
}
