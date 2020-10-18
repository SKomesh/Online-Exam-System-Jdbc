package com.somesh.onlineExamSystem.dao;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.somesh.onlineExamSystem.Entity.UserDetails;

public interface UserLoginDao {

	public UserDetails getUserByEmail(String emailId) throws DataAccessException, SQLException;
}
