package com.jbk.oes.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User 
{

	@Id
	String username;
	String password;
	String mobno;
	String emailid;
	
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", mobileno=" + mobno + ", emailid="
				+ emailid + "]";
	}

	
}
