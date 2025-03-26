package my.day02.c.print;

import java.util.Scanner;

public class ScannerMain2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String strInput = null;
		
		
		try {
			System.out.print("1. 첫번째 정수 입력 : ");
			strInput = sc.nextLine();
			int num1 = Integer.parseInt(strInput);

			System.out.print("2. 두번째 정수 입력 : ");
			strInput = sc.nextLine();
			int num2 = Integer.parseInt(strInput);
	
			System.out.println(num1+" + "+num2+" = "+(num1+num2));
		}catch(NumberFormatException e) {
			System.out.println(strInput+" 에러잡음 정수가 아님 "+e.getLocalizedMessage());
		}
		sc.close();
	}
	
	
	

}
