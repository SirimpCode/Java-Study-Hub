package my.day06.a.random;

import java.util.Random;
import java.util.Scanner;

/*
============= 메뉴 ==============
1.가위  2.바위  3.보  4.게임종료
================================
>> 선택하세요 => 5엔터
[경고] 메뉴에 존재하지 않는 번호입니다!!

>> 선택하세요 => 똘똘이엔터
[경고] 정수로만 입력하세요!!

>> 선택하세요 => 2
>> 사용자님이 이겼습니다!!^^   이긴경우
>> 사용자님이 졌습니다ㅜㅜ     진경우
>> 비겼습니다~~             비긴경우

============= 메뉴 ==============
1.가위 2.바위 3.보 4.게임종료
================================
>> 선택하세요 => 4

>> 프로그램 종료 <<
*/
public class RockScissorsPaperMain {
	
	private static int getRandomResult (Random random) {
		return random.nextInt(3-1+1)+1;
	}
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		boolean myExit = false;
		int userInput = 0;
		do {
			System.out.println("=================메뉴==============\n"
					+ "1.가위\t2.바위\t3.보\t4.게임종료\n"
					+ "==================================");
			System.out.print("입력해 [1 ~ 4] : ");
			
			try {
				userInput = Integer.parseInt(sc.nextLine());
				if( !(userInput>=1&&userInput<=4) ) throw new NumberFormatException();
			}catch(NumberFormatException e) {
				System.out.println("메뉴에 없는 번호임 1 부터 4까지만 입력해");
				continue;
			}
			
			int computerResult = getRandomResult(random);
			if(userInput == 4) {
				myExit = true;
				break;
			}
			
			int result = computerResult - userInput;
			String resultStr = null;
			if(result == 0 ) resultStr = "비김";
			else if (result == -1||result == 2) resultStr = "이김";
			else if (result == -2||result == 1) resultStr = "짐";
			
			String c = switch(computerResult) {
			case 1 -> "가위"; case 2 -> "바위"; case 3 -> "보"; default -> null;
			};
			String u = switch(userInput) {
			case 1 -> "가위"; case 2 -> "바위"; case 3 -> "보"; default -> null;
			};

			System.out.printf("\n=============결과 : %s ============\n"
					+ "\t컴퓨터 : %s, 유저 : %s\n\n", resultStr, c, u);
			
			
		
		}while(!myExit);
		sc.close();
		System.out.println("==================종료===============");
		
	}
}
