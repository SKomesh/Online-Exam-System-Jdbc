package com.somesh.onlineExamSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.somesh.onlineExamSystem.Entity.UserDetails;
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

}
