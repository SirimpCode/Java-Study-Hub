package my.day04.a.forrepeat;

import java.util.Scanner;

/*
>> 누적해야할 시작 숫자 => 1
>> 누적해야할 마지막 숫자 => 10
[실행결과] 1+2+3+4+5+6+7+8+9+10=55 

>> 누적해야할 시작 숫자 => 3
>> 누적해야할 마지막 숫자 => 5
[실행결과] 3+4+5=12

>> 누적해야할 시작 숫자 => 똘똘이
[경고] 올바른 정수만 입력하세요!!
>> 누적해야할 시작 숫자 => 3
>> 누적해야할 마지막 숫자 => 345234543643643543
[경고] 올바른 정수만 입력하세요!!
>> 누적해야할 마지막 숫자 => 6
 [실행결과] 3+4+5+6=18
*/
public class ForCalc {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; true; i++) {
			int startNum = 0;
			int endNum = 0;
			try {
				System.out.print("시작 숫자 : ");
				startNum = Integer.parseInt(sc.nextLine());
				System.out.print("마지막 숫자 : ");
				endNum = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				continue;
			}
			String result = "";
			int sum = 0;
			for(int j = startNum; j<=endNum; j++) {
				boolean isLast = j==endNum; 
				sum+=j;
				result += !isLast ? j+"+" : j+"=";
			}
			System.out.println(result+sum);
			break;
		}
	}

}
