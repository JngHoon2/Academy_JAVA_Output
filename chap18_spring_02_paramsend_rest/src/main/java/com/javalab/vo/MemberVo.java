package com.javalab.vo;

public class MemberVo {

	private String id;
	private String pwd;
	private String name;
	private int age;
	private int grade;

	public MemberVo() {
		super();
	}

	public MemberVo(String id, String pwd, String name, int age) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + "]";
	}

}
