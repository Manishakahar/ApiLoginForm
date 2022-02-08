package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.LoginExceptions;
import com.example.demo.model.UserLogin;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRepo;
	private UserLogin user;

	public LoginServiceImpl(LoginRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}

	@Override
	public UserLogin addUser(UserLogin user) {
		return loginRepo.save(user);
	}

	@Override
	public UserLogin getUserById(int id) {
		return loginRepo.findById(id).orElseThrow(
				() -> new LoginExceptions("No Record Found", LoginExceptions.ExceptionTypes.NO_RECORD_FOUND));
	}

	@Override
	public UserLogin updateUser(int id, String userNamenput) {
		user = getUserById(id);
		user.setUserName(userNamenput);
		return loginRepo.save(user);
	}

	@Override
	public UserLogin deleteUser(int id) {
		user = getUserById(id);
		loginRepo.delete(user);
		return user;
	}

	@Override
	public List<UserLogin> getUser() {
		return loginRepo.findAll();
	}

	@Override
	public String forgetPassword(int id, String password) {
		user = getUserById(id);
		user.setPassword(password);
		loginRepo.save(user);
		return "Password has been reset";
	}
}
