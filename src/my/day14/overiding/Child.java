package my.day14.overiding;

public class Child extends Parent{
	private String id;
	public String abc() {
		return super.info();
	}
	private static String ac = "asdf";
	@Override//오버라이딩시 접근제어자는 상위객체의 제한자와 같거나 더 느슨해야된다.
	//또 리턴타입은 같아야한다.
	protected String info2() {
		return "1. 아이디 : "+super.id+"\n"
				+ "2. 비번 : "+super.password+"\n"
						+ "3. 이름 : "+super.name;
	}
}
