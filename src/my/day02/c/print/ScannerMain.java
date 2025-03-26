package my.day02.c.print;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 => ");
		
//		sc.nextInt();
		String inputStr = sc.nextLine();
		
		
		System.out.println("입력한 정수 "+ inputStr + 10);//문자열이기 때문에 연산이 아닌 결합이 됨 
		
		try {
			int parseInt = Integer.parseInt(inputStr);//int로 변환
			System.out.println("연산된 정수 "+ parseInt+10);// 정수타입으로 변환 되어서 연산됨
		}catch(NumberFormatException n) {
			System.out.println( "예외 잡음 "+ n.getMessage());
		}
		
		Integer parseInt = Integer.valueOf(inputStr); // 이건 랩퍼타입으로 감싸진다 -> Integer
		
		
	}

}
