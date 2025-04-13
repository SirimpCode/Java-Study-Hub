package my.day15.a.abstract_class;

public class Main {

	public static void main(String[] args) {
		Parent[] users = {
				Parent.of("son", "Qwer1234$", "아들"),
				Parent.of("daughter", "12341234a!", 25),
				Parent.of("sihu", "12341234a!", 25),
				Parent.of("sihu", "12341234a!", "이시후")
				};
		for(Parent user: users) 
			printInfo(user);
	}
	private static void printInfo(Parent user) {
		System.out.println(user.info());
	}

}
