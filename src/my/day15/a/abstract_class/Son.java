package my.day15.a.abstract_class;

public class Son extends Parent {
	String name;

	@Override
	public String info() {
		return "1. 아이디 : " + super.id + "\n" + 
				"2. 비번 : " + super.password+ "\n" +
				 "3. 이름: " + this.name + "\n"+"나는 아들입니다.\n";
	}
}
