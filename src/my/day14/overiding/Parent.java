package my.day14.overiding;

public class Parent {
	String id;
	String password;
	String name;
	protected String info() {
		return id+" , "+password;
	}
	
	protected String info2() {
		return "아이디 "+id+" , 비밀번호 : "+password+", 성명: "+name;
	}
}
