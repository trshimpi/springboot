package com.domain;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Customer {
	private Integer id;
	private String name;
	private String email;
	private String mobile;
	

	public Customer(int id, String name, String email, String mobile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setFirstName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
