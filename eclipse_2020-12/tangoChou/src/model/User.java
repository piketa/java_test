package model;

import java.io.Serializable;

public class User implements Serializable{
	private String email;
	private String pass;

	public User() {}
	public User(String email, String password) {
		this.email = email;
		this.pass = password;
	}

	public String getEmail() {return email;}
	public String getPass() {return pass;}
}
