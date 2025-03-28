package my.day05.b.dowhile;

import java.util.Scanner;

public class CodingTestFactorialMain {
	 // === 입사문제 === //
    /*
       ▣ 알고 싶은 팩토리얼 수 입력 => 5엔터
       >> 결과 : 5! = 120 
       >> 또 할래?[Y/N] => y
       
       5! ==> 5*4*3*2*1
       7! ==> 7*6*5*4*3*2*1
       
       ▣ 알고 싶은 팩토리얼 수 입력 => 0엔터
       >> [경고] 자연수만 입력하세요!!
       
       ▣ 알고 싶은 팩토리얼 수 입력 => -5엔터
       >> [경고] 자연수만 입력하세요!!
       
       ▣ 알고 싶은 팩토리얼 수 입력 => 1.25엔터
       >> [경고] 정수만 입력하세요!!
       
       ▣ 알고 싶은 팩토리얼 수 입력 => 똘똘이엔터
       >> [경고] 정수만 입력하세요!!
       
       ▣ 알고 싶은 팩토리얼 수 입력 => 4엔터
       >> 결과 : 4! = 24
       >> 또 할래?[Y/N] => s엔터
       >> [경고] Y 또는 N 만 입력하세요!!
       >> 또 할래?[Y/N] => n엔터
       
       >>> 프로그램 종료 <<<
    */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//while문 활용
		while(true) {
			System.out.print("알고 싶은 팩토리얼 수 입력 => ");
			int input = 0;
			try {
				input = Integer.parseInt(sc.nextLine());
				if(input <2) throw new NumberFormatException();
			}catch(NumberFormatException e) {
				System.out.println("2이상 정수 입력해 바보야");
				continue;
			}
			
			long result = 1;
			
			while(input>0) {
				if(input==1) {
					System.out.print(input+"="); break;
				}
				System.out.print(input+"*");
				result *= input;
				input--;
				
			}
			System.out.println(result);
			break;
		}
		System.out.println("종료");
		
		//for문 활용
		while(true) {
			int input = 0;
			try {
				System.out.print("두번째 팩토리얼 => ");
				input = Integer.parseInt(sc.nextLine());
				if(input <2) throw new NumberFormatException();
			}catch(NumberFormatException e) {
				System.out.println("2이상 정수 입력해 바보야");
				continue;
			}
			long result = 1;
			System.out.print(input);
			for(int i=input; i>1; i--) {
				System.out.print("*"+(i-1));
				result *= i;
			}
			System.out.println("="+result);
			break;
			
		}
		System.out.println("진짜 종료");

		sc.close();
		
	}
}
