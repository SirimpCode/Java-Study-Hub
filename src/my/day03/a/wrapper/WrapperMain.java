package my.day03.a.wrapper;

import java.util.Scanner;

public class WrapperMain {

	public static void main(String[] args) {
		char ch = 'f';
		
		if(ch >= 'A' && ch <= 'Z') System.out.println(ch+ " 는 대문자 입니다.");
		else if(ch >= 'a' && ch <= 'z') System.out.println(ch+" 는 소문자 입니다.");
		else if(ch >= '0' && ch <= '9') System.out.println(ch+" 는 숫자 입니다.");
		else  System.out.println(ch+" 는 특수문자 입니다.");
		
		System.out.println("-----------------------------------------------------");
		if(Character.isUpperCase(ch)) System.out.println(ch+" 는 대문자 입니다.");
		else if(Character.isLowerCase(ch)) System.out.println(ch+" 는 소문자 입니다.");
		else if(Character.isDigit(ch)) System.out.println(ch+" 는 숫자 입니다.");
		else  System.out.println(ch+" 는 특수문자 입니다.");
		
		System.out.println("\n-----------------------------------------------------\n");
		
		String str = "Baby";
		System.out.println(str.charAt(0)); //B
		
		System.out.println("\n-----------------------------------------------------\n");
		
		System.out.print("입력해봐 : ");
		String strInput = new Scanner(System.in).nextLine();
		
		char result = strInput.charAt(0);
		if(Character.isUpperCase(result)) System.out.println(result+" 는 대문자 입니다.");
		else if(Character.isLowerCase(result)) System.out.println(result+" 는 소문자 입니다.");
		else if(Character.isDigit(result)) System.out.println(result+" 는 숫자 입니다.");
		else if(result>='가' && result <= '힣') System.out.println(result+" 는 한글 입니다.");
		else if(result == ' ') System.out.println(result+ " 는 공백입니다.");
		else  System.out.println(result+" 는 특수문자 입니다.");
	}

}
