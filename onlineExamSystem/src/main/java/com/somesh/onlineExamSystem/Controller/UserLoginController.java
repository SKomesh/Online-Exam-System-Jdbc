package com.somesh.onlineExamSystem.Controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.somesh.onlineExamSystem.Service.UserLoginService;

@Controller
public class UserLoginController {
	@Autowired
	UserLoginService userLoginService;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@RequestParam String username,@RequestParam String pass,ModelMap modelmap) throws DataAccessException, SQLException, JsonProcessingException {
		Map<String,Object> reqObject = new HashMap<>();
		Map<String,Object> resObject = new HashMap<>();
		reqObject.put("Username", username);
		reqObject.put("Password", pass);
		resObject = userLoginService.userLogin(reqObject,resObject);
		if(resObject.get("Code")=="0000" && resObject.get("Message")=="Success") {
			return "dashboard";
		}
		return "loginError";
	}
}
