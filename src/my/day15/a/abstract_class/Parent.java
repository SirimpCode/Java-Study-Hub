package my.day15.a.abstract_class;

public abstract class Parent {
	String id;
	String password;
	
	public abstract String info();
	
	public static Son of(String id, String pw, String name) {
		Son son = new Son();
		son.id = id;
		son.password = pw;
		son.name = name;
		return son;
	}
	public static Daughter of(String id, String pw, int age) {
		Daughter son = new Daughter();
		son.id = id;
		son.password = pw;
		son.age = age;
		return son;
	}
}
