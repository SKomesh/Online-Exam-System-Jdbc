package com.somesh.onlineExamSystem.Controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.somesh.onlineExamSystem.Entity.UserDetails;
import com.somesh.onlineExamSystem.Service.UserLoginService;

@Controller
public class UserLoginController {
	@Autowired
	UserLoginService userLoginService;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/userRegistration")
	public String showUserRegistrationPage() {
		return "userRegistration";
	}
	
	@GetMapping("/userForgetPassword")
	public String showUserForgetPasswordPage() {
		return "userForgetPassword";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@RequestParam String username,@RequestParam String pass,ModelMap map) throws DataAccessException, SQLException, JsonProcessingException {
		Map<String,Object> reqObject = new HashMap<>();
		Map<String,Object> resObject = new HashMap<>();
		reqObject.put("Username", username);
		reqObject.put("Password", pass);
		resObject = userLoginService.userLogin(reqObject,resObject);
		if(resObject.get("Code")=="0000" && resObject.get("Message")=="Success") {
			return "dashboard";
		}else {
			map.addAttribute("response","Opps..Something Went Wrong..! User login has Failed.");
			return "login";
		}
	}
	
	@PostMapping("/addNewUser")
	public String addNewUser(@ModelAttribute UserDetails userDetails,ModelMap map) {
		Map<String,Object> reqObject = new HashMap<>();
		Map<String,Object> resObject = new HashMap<>();
		reqObject.put("userDetails", userDetails);
		resObject = userLoginService.addNewUser(reqObject,resObject);
		if(resObject.get("Code")=="0000" && resObject.get("Message")=="Success") {
			map.addAttribute("response","User has successfully registration done.");
		}else {
			map.addAttribute("response","Opps..Something Went Wrong..! User Registration has Failed.");
		}
		return "userRegistration";
	}
	
	@PostMapping("/sendOtp")
	public String sendOtpToUser(@RequestParam String emailId,ModelMap map) {
		System.out.println("UserLoginController -->sendOtpToUser() : "+emailId);
		Map<String,Object> reqObject = new HashMap<>();
		Map<String,Object> resObject = new HashMap<>();
		reqObject.put("emailId", emailId);
		resObject = userLoginService.sendOtpToUser(reqObject,resObject);
		if(resObject.get("Code")=="0000" && resObject.get("Message")=="Success") {
			map.addAttribute("userId",resObject.get("userId"));
			map.addAttribute("emailId",emailId);
			return "verifyOtp";
		}else {
			map.addAttribute("response","Opps..Something Went Wrong..! OTP has not send.");
			return "userForgetPassword";
		}
	}
	
	@PostMapping("/verifyOtp")
	public String verifyOtp(@RequestParam String userId,@RequestParam String otp,ModelMap map) {
		System.out.println("UserLoginController -->verifyOtp() : "+userId+ " " +otp);
		Map<String,Object> reqObject = new HashMap<>();
		Map<String,Object> resObject = new HashMap<>();
		reqObject.put("userId", userId);
		reqObject.put("otp", otp);
		resObject = userLoginService.verifyOtp(reqObject,resObject);
		if(resObject.get("Code")=="0000" && resObject.get("Message")=="Success") {
			map.addAttribute("userId",userId);
			return "resetPassword";
		}else {
			map.addAttribute("response","Opps..Something Went Wrong..! Entered OTP not correct.");
			return "userForgetPassword";
		}
	}
	
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String userId,@RequestParam String npass,ModelMap map) {
		Map<String,Object> reqObject = new HashMap<>();
		Map<String,Object> resObject = new HashMap<>();
		reqObject.put("userId", userId);
		reqObject.put("npass", npass);
		resObject = userLoginService.resetPassword(reqObject,resObject);
		if(resObject.get("Code")=="0000" && resObject.get("Message")=="Success") {
			map.addAttribute("userId",userId);
			map.addAttribute("response","Your Password Reset Successfully.");
			return "dashboard";
		}else {
			map.addAttribute("response","Opps..Something Went Wrong..! Your Password not reset.");
			return "resetPassword";
		}	}
}
