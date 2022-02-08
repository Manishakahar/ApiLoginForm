package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserLogin;

public interface LoginService {

	UserLogin addUser(UserLogin user);

	List<UserLogin> getUser();

	UserLogin getUserById(int id);

	UserLogin updateUser(int id, String lastNameInput);

	UserLogin deleteUser(int id);

	String forgetPassword(int id, String password);
}
