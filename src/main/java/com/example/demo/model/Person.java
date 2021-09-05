package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	@Id
	String id;
	
	String firstName;
	String lastName;
	int    age;
	long mobile;
	
	public Person(String firstName, String lastName, int age,long mobile) {
		this.firstName = firstName;
		this.lastName  = lastName;
		this.age       = age;
		this.mobile    = mobile;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String toString() {
		return "Person First Name:"+firstName+", Last Name:"+lastName+", age:"+age+ ", mobile:"+mobile;
	}
}
