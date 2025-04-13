package my.day14.overloading;

public class Member {
	//field
	String id;
	String name;
	int age;
	double height;
	//method
	String info() {
		return "1.아이디 : "+this.id+"\n"
				+ "2. 이름 : "+this.name+"\n"
				+ "3. 나이 : "+this.age+"\n"
				+ "4. 신장 : "+this.height;
	}
	
	String info(String id, String 이름, int 나이, double 키) {
		this.id = id;
		this.name = 이름;
		this.age = 나이;
		this.height = 키;
		return this.info();
	}
}
