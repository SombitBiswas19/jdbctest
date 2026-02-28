package model;

public class Student {
	private String name;
	private String email;
	private int age;
	private long mobile_number;
	
	public Student(String name, String email, int age, long mobile_number) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.mobile_number = mobile_number;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
	
	
}
