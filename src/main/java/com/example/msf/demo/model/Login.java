package com.example.msf.demo.model;
import org.springframework.data.annotation.Id;
public class Login {
  
	@Id
	private String Id;
	private String name;
	private String password;
	public Login() {
	}
	public Login(String id, String name, String password) {
		super();
		Id = id;
		this.name = name;
		this.password = password;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
