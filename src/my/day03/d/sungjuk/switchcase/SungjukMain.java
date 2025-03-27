package my.day03.d.sungjuk.switchcase;

import java.util.Scanner;

public class SungjukMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("1. 학번 : ");
		Sungjuk.Builder sungjuk = Sungjuk.building()
				.hakbun(sc.nextLine());
		
		System.out.print("2. 이름 : ");
		sungjuk.name(sc.nextLine());
		
		try {
			System.out.print("3. 나이 : ");
			short age = Short.parseShort(sc.nextLine());
			sungjuk.age(age);
			
			System.out.print("4. 국어 : ");
			byte kor = Byte.parseByte(sc.nextLine());
			sungjuk.kor(kor);
			
			System.out.print("5. 영어 : ");
			byte eng = Byte.parseByte(sc.nextLine());
			sungjuk.eng(eng);
			
			System.out.print("6. 수학 : ");
			byte math = Byte.parseByte(sc.nextLine());
			sungjuk.math(math);
			
			Sungjuk result = sungjuk.build();
			result.toPrint();
			
			
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}
	
}
