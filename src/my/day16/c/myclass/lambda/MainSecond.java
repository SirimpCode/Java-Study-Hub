package my.day16.c.myclass.lambda;

import java.util.Arrays;

public class MainSecond {

	public static void main(String[] args) {
		System.out.println("=== 람다식(Lambda)을 사용하지 않은 것[무명(익명)클래스를 사용한 것]");
		FunctionalAreaFirst notLambda = new FunctionalAreaFirst() {
			@Override
			public void area(double x, double y, int type) {
				switch (type) {
				case 1:
					System.out.println("가로 " + x + ", 세로 " + y + "인 사각형 면적은 : " + (x * y));
					break;
				case 2:
					System.out.println("가로 " + x + ", 세로 " + y + "인 삼각형 면적은 : " + (x * y / 2));
					break;
				case 3:
					System.out.println("장축의 반지름 " + x + ", 단축의 반지름 " + y + "인 사각형 면적은 : " + (3.141592 * x * y));
					break;
				default:
					System.out.println("세번째 파라미터는 1 또는 2 또는 3 만 가능");
					break;
				}
			}
		};
		notLambda.area(3d, 4d, 1);

		System.out.println("=== 람다식(Lambda)을 사용한 것[무명(익명)클래스를 사용한 것]");

		/*
		 * 람다(Lambda) 함수는 프로그래밍 언어에서 사용되는 개념으로 익명 함수(Anonymous functions)를 지칭하는 용어이다. 현재
		 * 사용되고 있는 람다의 근간은 수학과 기초 컴퓨터과학 분야에서의 람다 대수이다. 람다 대수는 간단히 말하자면 수학에서 사용하는 함수를 보다
		 * 단순하게 표현하는 방법이다.
		 * 
		 * 람다 대수는 이름을 가질 필요가 없다. 즉, 익명 함수 (Anonymous functions)이다. 람다식(Lambda)은
		 * 익명함수(anonymous function)을 생성하기 위한 식으로서 객체 지향 언어보다 함수 지향 언어에 가깝다.
		 * 
		 * 자바에서 람다식의 사용 목적은 인터페이스에 정의된 메소드를 구현시 코딩양을 확 줄여서 간편하게 사용하는 것이 목적이다.
		 * 
		 * 자바에서는 함수 단독으로는 사용할 수 없고 객체를 통해서만 사용이 가능한 형태이므로 자바에서 람다를 실행하려면 전제조건으로 먼저
		 * FunctionalInterface(함수형 인터페이스)를 구현한 익명(무명)클래스 객체가 생성되어져 있어야만 한다. 람다는
		 * FunctionalInterface(함수형 인터페이스)를 구현한 익명(무명)클래스 객체의 메소드로 동작하게 된다. 여기서 주의할 점은
		 * FunctionalInterface(함수형 인터페이스)는 오로지 딱 한개만의 추상메소드로 이루어져야 한다는 것이다. 만약에
		 * FunctionalInterface(함수형 인터페이스)에 두 개 이상의 메소드가 선언되면 자바 컴파일러는 오류를 발생시킨다. 함수형
		 * 인터페이스를 만드려면 @FunctionalInterface 어노테이션을 사용하면 된다.
		 */

		FunctionalAreaFirst lambda = (x, y, type) -> {
			switch (type) {
			case 1 -> System.out.println("가로 " + x + ", 세로 " + y + "인 사각형 면적은 : " + (x * y));
			case 2 -> System.out.println("가로 " + x + ", 세로 " + y + "인 삼각형 면적은 : " + (x * y / 2));
			case 3 -> System.out.println("장축의 반지름 " + x + ", 단축의 반지름 " + y + "인 사각형 면적은 : " + (3.141592 * x * y));
			default -> System.out.println("세번째 파라미터는 1 또는 2 또는 3 만 가능");
			}
		};
		lambda.area(3d, 4d, 1);

		int test = 2;
		System.out.println(// 파라미터에 스위치문을 활용가능
				switch (test) {
				case 1 -> "잡힘";
				default -> "안잡힘";
				});

		System.out.println("\n~~~~~~~~~~~~ 람다식 표기방법 ~~~~~~~~~~~~~~\n");
		FunctionalOperator3 anonymousOp1 = (a,b,c) -> {//파라미터가 여러개일땐 소괄호 () 필수
			return switch(c) {
			case "+" -> a+b;
			case "-" -> a+b;
			case "*" ->  a*b;
			case "/" ->  a/b;
			default ->  0d;
			};
		};
		System.out.println(anonymousOp1.operator(6, 2, "*"));
		FunctionalOperator3 opTest = new FunctionalOperator3() {
			@Override
			public double operator(double a, double b, String type) {
				return 0;
			}
		};
		System.out.println(opTest.operator(test, test, null));
		//3.  실행문이 1개라면 {} 생략
		FunctionalSearch4 lambdaSearch = (str) -> System.out.println("회원들중 \"" + str + "\"님을 조회합니다.");
		lambdaSearch.search("에");
		//4. 파라미터가 1개라면 () 도 생략
		FunctionalSearch4 lambdaSearch2 = str -> System.out.println("회원들중 \"" + str + "\"님을 조회합니다.");
		lambdaSearch2.search("엄정화");
		
		//5. 파라미터가 없는 람다식은 무조건 소괄호를 기제해야한다.
		FunctionalSearch5 allSearch = ()-> System.out.println("모든 회원 조회");
		allSearch.searchAll();
		//6. 실행명령문이 1개 이더라도 return 이 있을 경우에는 반드시 {} 를 써야하지 생략할 수 없다.
		FunctionalOperator3 anonymousOp2 = (a,b,c) -> {return 0;};
		FunctionalPlus6 lambdaPlus = (a,b) -> {return a+b;};
		System.out.println(lambdaPlus.plus(10, 20));
		//7. return 문만 있는 단일 코드인 경우에는 {}; 및 return을 생략할수있다.
		FunctionalOperator3 anonymousOp3 = (a, b, c) -> switch (c) {
				case "+" -> a + b;
				case "-" -> a + b;
				case "*" -> a * b;
				case "/" -> a / b;
				default -> {
					System.out.println("연산기호 제대로 입력해");
					yield 0d;
				}
			};
		System.out.println("화살표 스위치"+anonymousOp3.operator(2, 3, "*"));
		FunctionalPlus6 lambdaPlus2 = (a,b) -> a+b;
		System.out.println(lambdaPlus2.plus(5, 6));

		// java 14 이후부터는 switch 문에서 -> 표기방식을 사용가능하다. switch expression 을 사용할 수 있게되었다.
		int point = 85;
		String grade = switch (point / 10) {
			case 10, 9 -> "A";
			case 8 -> "B";
			case 7 -> "C";
			case 6 -> "D";
			default -> {
				System.out.println("공부해라");
				yield "F";
			}
		};
		System.out.println("학점 : "+grade);
		
		String test3 = switch ((int)(Math.random() * 10) - 1) {
		case 1:
			yield "One";
		case 2:
			yield "Two";
		default:
			yield "Any";
		};
		
		Calculator7 calc = (a,b,op) -> switch(op) {
			case ADD -> a+b;
			case MINUS -> a-b;
			case MULTIPLY -> a*b;
			case DIVIDE -> {
				if(b==0) {
					System.out.println("분모가 0으로 나눌수없습니다.");
					yield 0d;
				}
				yield a/b;
			}
		};
		System.out.println(calc.calculate(10, 0, Operator.DIVIDE));
	}
	
}
