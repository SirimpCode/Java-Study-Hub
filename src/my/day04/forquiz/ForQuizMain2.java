package my.day04.forquiz;
//▣ 첫번째 정수 : 2
//▣ 두번째 정수 : 10

import java.util.InputMismatchException;
import java.util.Scanner;

//>> 결과 <<
//2 부터 10 까지의 홀수의 합 : 24
//2 부터 10 까지의 짝수의 합 : 30


//▣ 첫번째 정수 : 2.3453
//[경고] 올바른 정수를 입력하세요!!

//▣ 첫번째 정수 : 1
//▣ 두번째 정수 : 똘똘이
//[경고] 올바른 정수를 입력하세요!!

//▣ 첫번째 정수 : 1
//▣ 두번째 정수 : 10
//>> 결과 <<
//1 부터 10 까지의 홀수의 합 : 25
//1 부터 10 까지의 짝수의 합 : 30
public class ForQuizMain2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startInt = 0;
		int endInt = 0;
		
		for(int i=0; i<=2; i++ ) {
			try {
				System.out.print(i==0?"첫번째 정수 : ":"두번째 정수 : ");
				
				if(i==0) startInt = Integer.parseInt(sc.nextLine());
				else if (i==1) {
					endInt = Integer.parseInt(sc.nextLine());
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println(i+1+"번째 정수 잘못 입력함 [경고] 정수 입력 하라고");
				i--;
			}
		}
		
		int hole = 0;
		int jjak = 0;
		String holeStr = "";
		String jjakStr = "";
		
		for(int i = startInt; i<=endInt; i++) {
			if(i%2==0) {
				jjak+=i;
				jjakStr += i==startInt || i==startInt+1 ? i : "+"+i;
			}
			else {
				hole+=i;
				holeStr += i==startInt || i==startInt+1 ? i : "+"+i;
			}
		}
		
		System.out.println("\n\n!!!결괴!!!!");
		System.out.println(startInt+"부터 "+endInt+"까지 \n홀수의 합 "+holeStr+ " = "+ hole+
				"\n짝수의 합 "+jjakStr+" = "+jjak);
	}
}
