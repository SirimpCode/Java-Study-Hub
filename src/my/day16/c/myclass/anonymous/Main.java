package my.day16.c.myclass.anonymous;

public class Main {
	public static void main(String[] args) {
		System.out.println("\n------------- 1. 일반 클래스 사용시 ----");
		Area area1 = new AreaImpl();
		double area1Size = area1.area(10.5, 5.5);
		System.out.println("가로 10.5, 세로 5.5 인 면적은 : " + area1Size);
		// 가로 10.5, 세로 5.5 인 면적은 : 57.75

		Area area2 = new AreaImpl();
		double area2Size = area2.area(20.5, 15.5);
		System.out.println("가로 20.5, 세로 15.5 인 면적은 : " + area2Size);
		// 가로 20.5, 세로 15.5 인 면적은 : 317.75

		System.out.println("\n=========2. 익명 클래스 사용시 ==========");
		Area anonymousArea = new Area() {// 메서드내에서 잠깐 쓰일 익명클래스 만들어버리기
			@Override
			public double area(double x, double y) {
				return x * y;
			};
			@Override
			public double area2(double x, double y) {
				// TODO 자동 생성된 메소드 스텁
				return 0;
			}
		};
		System.out.println("가로 10.5, 세로 5.5 인 면적은 : " + anonymousArea.area(10.5, 5.5));
		

	}

}
