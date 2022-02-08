package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LoginForm")
public class UserLogin {
	@Id
	@GeneratedValue
	
	@Column(name = "id")
	private int id;
	
	@NotEmpty(message = "Please enter username")
	@Column(name = "userName")
	private String userName;
	

	@NotEmpty(message="Please enter email id")
	@Column(name = "emailId")
	private String emailId;
	

	@NotEmpty(message = "Please enter your password")
	@Column(name = "password")
	private String password;

	public UserLogin(int id, String userName, String emailId, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}
	
	public UserLogin(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", password=" + password + "]";
	}
}
