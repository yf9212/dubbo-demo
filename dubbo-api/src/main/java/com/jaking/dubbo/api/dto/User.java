package com.jaking.dubbo.api.dto;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 2370687930290311313L;
	
	private String id;

	private String userName;

	private String sex;

	private Integer age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
