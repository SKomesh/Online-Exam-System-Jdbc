package com.somesh.onlineExamSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.somesh.onlineExamSystem.Entity.UserDetails;
import com.somesh.onlineExamSystem.Entity.UserPin;
import com.somesh.onlineExamSystem.Utils.SqlQueries;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RowMapper<UserDetails> rowMapper = (ResultSet rs,int rowNum)->{
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(rs.getInt(1));
		userDetails.setFirstName(rs.getString(2));
		userDetails.setLastName(rs.getString(3));
		userDetails.setMobileNo(rs.getString(4));
		userDetails.setEmailId(rs.getString(5));
		userDetails.setPassword(rs.getString(6));
		userDetails.setConfirmPassword(rs.getString(7));
		return userDetails;
	};
	
	private RowMapper<UserPin> rowMapper2 = (ResultSet rs,int rowNum)->{
		UserPin userPin = new UserPin();
		userPin.setUserPinId(rs.getInt(1));
		userPin.setUserId(rs.getInt(2));
		userPin.setPin(rs.getString(3));
		userPin.setCreatedOn(rs.getString(4));
		return userPin;
	};
	
	@Override
	public UserDetails getUserByEmail(String emailId) throws DataAccessException, SQLException {
		List<UserDetails> userDetailslist = jdbcTemplate.query("SELECT * FROM userDetails WHERE emailId="+"'"+emailId+"'", rowMapper);
		if(!userDetailslist.isEmpty()) {
		return userDetailslist.get(0);
		}
		return null;
	}

	@Override
	public Boolean addNewUser(UserDetails object) {
		if(jdbcTemplate.update(SqlQueries.ADD_NEW_USER, object.getFirstName(),object.getLastName(),object.getMobileNo(),object.getEmailId(),object.getPassword(),object.getConfirmPassword())>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public  Map<String, Object> sendOtpToUser(String emailId, Map<String, Object> resObject) {
		System.out.println("UserLoginDaoImpl -->sendOtpToUser() : "+emailId);
		List<UserDetails> userDetailslist = jdbcTemplate.query("SELECT * FROM userDetails WHERE emailId="+"'"+emailId+"'", rowMapper);
		if(!userDetailslist.isEmpty()) {
			int userid = userDetailslist.get(0).getUserId();
			Integer pin = 10000 + new Random().nextInt(90000); 
			Date today = Calendar.getInstance().getTime();
			if(jdbcTemplate.update(SqlQueries.SEND_OTP, userid,pin.toString(),today)>0) {
				resObject.put("userId", userid);
				return resObject;
			}else {
				return resObject;
			}
		}else {
			return resObject;
		}
	}

	@Override
	public Boolean verifyOtp(Map<String, Object> reqObject) {
		System.out.println("UserLoginDaoImpl -->verifyOtp() : "+reqObject.get("userId")+ " " +reqObject.get("otp"));
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = formatter.format(today);
		int userid = Integer.parseInt(reqObject.get("userId").toString());
		String otp = (String) reqObject.get("otp");
		List<UserPin> userPinlist = jdbcTemplate.query("SELECT * FROM userPin WHERE pin="+"'"+otp+"'"+"and userId="+userid+" and createdOn="+"'"+createDate+"'"+" ORDER BY userPinId DESC", rowMapper2);
		if(userPinlist.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Boolean resetPassword(Map<String, Object> reqObject) {
		System.out.println("UserLoginDaoImpl -->resetPassword() : "+reqObject.get("userId").toString()+ " " +reqObject.get("npass").toString());
		if(jdbcTemplate.update("UPDATE userDetails SET password=?,confirmPassword=? WHERE userId=?",reqObject.get("npass").toString(),reqObject.get("npass").toString(),Integer.parseInt(reqObject.get("userId").toString()))>0) {
			return true;
		}else {
			return false;
		}
	}

}
