package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserLogin;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("users")
public class LoginController {

	@Autowired
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@PostMapping("/saveUser")
	public ResponseEntity<UserLogin> saveUser(@Valid @RequestBody UserLogin user) {
		return new ResponseEntity<UserLogin>(loginService.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/getUser")
	public List<UserLogin> getUser() {
		return loginService.getUser();
	}

	@GetMapping("/getUserById")
	public UserLogin fetchUserById(@RequestParam(value = "id", required =
			true) int id) {
		return loginService.getUserById(id);
	}

	@PutMapping("/updateUser")
	public UserLogin updateUser(@RequestParam int id, String userNameInput) {
		return loginService.updateUser(id, userNameInput);
	}

	@DeleteMapping("/deleteUser/{id}")
	public UserLogin deleteUser(@PathVariable int id) {
		return loginService.deleteUser(id);
	}
	
	@PutMapping("/forgetPassword")
	public String howForgetPassword(@RequestParam int id, String password) {
		return loginService.forgetPassword(id, password);	
	}
}