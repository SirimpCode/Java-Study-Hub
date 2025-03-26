package my.day02.c.print;

import java.util.Scanner;

public class PrintMain {

	public static void main(String[] args) {
		// System.in 은 입력장치(키보드)를 말한다.
		// System.out 은 출력장치(모니터)를 말한다.

		Scanner sc = new Scanner(System.in);
		// Scanner sc 는 키보드에서 입력된 문자열을 읽어들이는 객체이다.

		System.out.print("1.문장을 입력하세요 => ");
		String inputStr = sc.nextLine();
		

		sc.nextLine(); //은 키보드로 부터 입력받은 문장을 읽어들이는 것인데,
		//엔터(종결신호)까지 모두 읽어들인 후 스캐너 버퍼에 아무것도 남기지 않는다.
		
		System.out.println("입력한 문장 =>"+ inputStr);
		
		System.out.print("2.정수를 입력하세여 => ");
		byte inputNum1 = sc.nextByte();
		System.out.println("입력한 정수 =>"+ inputNum1);
		
	


	}

}
