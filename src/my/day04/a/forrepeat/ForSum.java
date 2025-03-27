package my.day04.a.forrepeat;

import java.util.Scanner;

public class ForSum {
	/*
	   == 5개의 정수를 입력하세요 ==
	   >> 1번째 정수 입력 : 10
	   >> 2번째 정수 입력 : 20
	   >> 3번째 정수 입력 : 5
	   >> 4번째 정수 입력 : 15
	   >> 5번째 정수 입력 : 30
	   == 입력한 5개 정수의 합계는 80 입니다.
	   
	   
	   == 5개의 정수를 입력하세요 ==
	   >> 1번째 정수 입력 : 10
	   >> 2번째 정수 입력 : 똘똘이
	   [경고] 똘똘이는 올바른 정수가 아닙니다. 올바른 정수를 입력하세요!!
	   >> 2번째 정수 입력 : 20
	   >> 3번째 정수 입력 : 354325325235234532453243242
	   [경고] 354325325235234532453243242는 올바른 정수가 아닙니다. 올바른 정수를 입력하세요!!
	   >> 3번째 정수 입력 : 5
	   >> 4번째 정수 입력 : 15
	   >> 5번째 정수 입력 : 30
	   == 10+20+5+15+30=80 입니다.
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개 입력해");
		
		int sum = 0;
		String str = "";
		for(int i=1;true;i++) {
			System.out.print(i+"번째 정수 입력 : ");
			String inPutStr = sc.nextLine();
			boolean isLast = i==5;
			try {
				int inputInt = Integer.parseInt(inPutStr);
				sum+=inputInt;
				str+= isLast ? inputInt+"=": inputInt+"+";
			} catch(NumberFormatException e) {
				i--;
				System.out.println("\""+inPutStr+"\"는 정수가 아니야 정수로 다시 입력해");
				continue;
			}
			if(isLast) break;
		}
		
		
		sc.close();
		System.out.println("니가입력한 값의 총 합은 => "+str+sum);
		
		
		
		System.out.println("\n");
		int a = 0;
		for(int i=1; i<11; i++) {
			a+=i;
			if(i ==10) System.out.println(a);
		}
		
		a=0;
		for(int i=1; i<11; i++) {
			a+=i;
			if(i==10) {
				System.out.print("+" + i + "="+a);
				break;
			}
			if(i==1) System.out.print(i);
			else System.out.print("+"+i);
		}
	}
}
