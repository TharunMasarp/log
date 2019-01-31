package com.app.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="USER_DETAILS")
@SuppressWarnings("serial")
public class UserEntity implements Serializable{
	
	@Column(name="NAME")
	@NotNull
	private String name;
	@Column(name="USERID")
	@Id
	@GeneratedValue(generator="generatedId")
	@GenericGenerator(name="generatedId", strategy="com.app.idgenerator.IdGenerators")
	private String userId;
	@Column(name="EMAILID")
	private String emailId;
	@Column(name="PASSWORD")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
}
