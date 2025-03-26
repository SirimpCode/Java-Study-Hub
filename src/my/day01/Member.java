package my.day01;

import java.util.EnumSet;

public class Member {
	private String id;
	private String password;
	private String name;
	private Gender gender;
	private String job;
	
	private Member(String id, String password, String name, String gender, String job) {
		this.id = id;
		this.password = password;
		this.name = name; 
		this.gender = Gender.fromKor(gender);
		this.job = job;
	}
	
	public static Member of(String id, String password, String name, String gender, String job) {
		return new Member(id, password, name, gender, job);
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public static void printFirst() {
		System.out.println("아이디\t이름\t성별\t직업");
	}
	
	public String toString() {
		return "아이디: "+this.id + ", 이름: "+this.name+", 성별: "+this.gender.getKor()+ ", 직업: "+this.job;
	}
	public String toStringJr() {
		return this.id+"\t"+this.name+"\t"+this.gender + "\t" + this.job;
	}
	
	public void printMethod() {
		System.out.println(this.toStringJr());
	}

}
