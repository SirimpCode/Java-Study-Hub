package my.day14.overiding;

public class Main {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Parent child = new Child();
		child.info();
		child.id = "Asdf";
		child.password = "asdb";
		child.name = "풍뎅이";
		System.out.println(child.info());
		
		System.out.println(child.info2());
		
		Parent parent = new Parent();
		parent.id = "ㅎㅎ";
		System.out.println(parent.info2());
	}
}
