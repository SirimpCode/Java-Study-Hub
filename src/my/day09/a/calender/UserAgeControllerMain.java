package my.day09.a.calender;

import java.time.DateTimeException;
import java.util.Scanner;

import my.day01.MyUtil;

public class UserAgeControllerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.print("계속 하시려면 아무키나 입력해주세요 (종료는 exit 입력) => ");
			if(sc.nextLine().toLowerCase().equals("exit")) break;
			System.out.print("주민번호 앞 6자리와 뒤 1자리를 입력해 주세요. => ");
			String userInput = sc.nextLine();
			if(userInput.toLowerCase().equals("exit")) break;
			try {
				int age = MyUtil.getAge(userInput);
				System.out.println(age);
			
			}catch(DateTimeException e) {
				System.out.println("존재하지 않는 날짜를 입력 하였습니다. => "+e.getLocalizedMessage());
				continue;
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;				
			}
			continue;
		}
		sc.close();
	}
}
