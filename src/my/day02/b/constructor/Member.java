package my.day02.b.constructor;

public class Member {
	private String userId;
	private String password;
	private String name;
	private String email;
	private int age;
	private int point;
	
	private Member(String userId, String password, String name, String email, int age, int point) {
		this.userId= userId;
		this.password = password;
		this.age = age;
		this.name = name;
		this.email = email;
		this.point = point;
	}
	public static Member of (String userId, String password, String name, String email, int age, int point) {
		return new Member(userId, password, name, email, age, point);
	}

}
