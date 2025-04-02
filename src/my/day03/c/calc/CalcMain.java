package my.day03.c.calc;

import java.util.Scanner;

public class CalcMain {
	/*
	   ▣ 첫번째 정수 입력 => 10   100000000000    똘똘이
	   ▣ 두번째 정수 입력 => 4    500000000000    헤헤헤
	   ▣ 사칙연산을 선택하세요(+ - * /) : + - * /   # 우하하 7 
	   10 + 4 = 14
	   10 - 4 = 6
	   10 * 4 = 40
	   10 / 4 = 2.5
	   10 / 0 
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = null;
		try {
			System.out.print("첫번째 정수 입력 : ");
			str = sc.nextLine();
			int firstInt = Integer.parseInt(str);
			
			System.out.print("두번째 정수 입력 : ");
			str = sc.nextLine();
			int secondInt = Integer.parseInt(str);
			
			System.out.print("사칙연산 입력 : ");
			str = sc.nextLine();
			
			
			
			
			double result = 
					switch(str) {
						case "+" -> firstInt+secondInt ;
						case "-" -> firstInt-secondInt ;
						case "*" -> firstInt*secondInt ;
						case "/" -> firstInt/(double)secondInt ; 
						default -> throw new IllegalArgumentException("유효하지 않은 연산자: " + str);
					};

			boolean test = result % 1 == 0;
			System.out.println(
					"결과 값은 => " +
					(str.equals("/") && !test ? 
							result : String.valueOf((int) result))
					);
			
		}catch(NumberFormatException e){
			System.out.println(str + " 잘못입력됨");
			sc.close();
		}catch(Exception e) {
			System.out.println(str + " 유효하지 않은 연산자");
			sc.close();
		}
		sc.close();
		
	}
}
