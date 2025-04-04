package my.day11.inheritance;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import my.day01.MyUtil;
import my.day11.inheritance.JobSeeker.UserFieldEnum;

public class JobMain {

	public static void main(String[] args) {
//		
//		JobSeeker js1 = JobSeeker.builder()
//				.userId(null)
//				.password(null)
//				.name(null)
//				.userPrimaryKey(null)
//				.build();
		
		//정규표현식
		
		
		System.out.println("aasf111231".matches("^[A-Za-z][A-Za-z0-9].{3,9}"));
		System.out.println("가나다라마바".matches("^[가-힣]{2,6}"));
		System.out.println(MyUtil.validationUserField(UserFieldEnum.PRIMARY_KEY, "9212122"));
		
		
		Scanner sc = new Scanner(System.in);
		JobSeekerController jsc = new JobSeekerController();
		
		main:
		while(true) {
			jsc.mainMenu();
			String select = sc.nextLine().trim();
			
			switch(select.trim()) {
				case "1": //구직자 회원가입
					jsc.signUp(sc);
					break;
				case "2":  // 구직자 모두보기
					jsc.getAllUserInfo();
					break;
				case "3": // 검색 하기
					jsc.searchUser(sc);
					break;
				case "5": break main;
				case "4" : jsc.withdrawUser(sc); break;
				default : System.out.println("잘못 입력됨 1 부터 5 중 입력하세요.");
			}
			
		}
		
		
		sc.close();
		System.out.println("프로그램 종료");
	}

}
