package com.computech.entity;

public class Student {

	private String id;
	private String name;
	private String age;
	private String clazz;
	private String birth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Student(String id, String name, String age, String clazz, String birth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.clazz = clazz;
		this.birth = birth;
	}
	public Student() {
		super();
	}
	
}
