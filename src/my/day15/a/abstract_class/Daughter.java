package my.day15.a.abstract_class;

public class Daughter extends Parent{
	int age;
	

	@Override
	public String info() {
		return "1. 아이디 : " + super.id + "\n" + 
				"2. 비번 : " + super.password+ "\n" +
				 "3. 나이: " + this.age + "\n"+"나는 딸입니다. \n";
	}
}
