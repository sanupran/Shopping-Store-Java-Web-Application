package com.anupran.model;

public class LoginTo {
private String name;
private String email;
private String dob;
private String raddr;
private String caddr;
private long mob;
private String username;
private String password;
public void setMob(long mob) {
	this.mob = mob;
}public LoginTo() {
	// TODO Auto-generated constructor stub
}
public long getMob() {
	return mob;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getRaddr() {
	return raddr;
}
public void setRaddr(String raddr) {
	this.raddr = raddr;
}
public String getCaddr() {
	return caddr;
}
public void setCaddr(String caddr) {
	this.caddr = caddr;
}
/*public int getMob() {
	return mob;
}
public void setMob(int mob) {
	this.mob = mob;
}*/
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
}
