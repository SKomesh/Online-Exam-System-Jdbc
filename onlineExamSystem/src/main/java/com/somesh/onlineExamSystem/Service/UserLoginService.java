package com.somesh.onlineExamSystem.Service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.somesh.onlineExamSystem.Entity.UserDetails;
import com.somesh.onlineExamSystem.dao.UserLoginDao;

@Service
public class UserLoginService {
	
	@Autowired
	UserLoginDao userLoginDao; 

	public Map<String, Object> userLogin(Map<String, Object> reqObject,Map<String, Object> resObject) throws DataAccessException, SQLException {
		UserDetails userDetails = userLoginDao.getUserByEmail(reqObject.get("Username").toString());
		if(reqObject.get("Password").toString().equals(userDetails.getPassword())) {
			resObject.put("Code", "0000");
			resObject.put("Message", "Success");
		}else {
			resObject.put("Code", "1111");
			resObject.put("Message", "Fail");
		}
		return resObject;
	}

	public Map<String, Object> addNewUser(Map<String, Object> reqObject, Map<String, Object> resObject) {
		Boolean response = userLoginDao.addNewUser((UserDetails)reqObject.get("userDetails"));
		if(response) {
			resObject.put("Code", "0000");
			resObject.put("Message", "Success");
		}else {
			resObject.put("Code", "1111");
			resObject.put("Message", "Fail");
		}
		return resObject;
	}

}
