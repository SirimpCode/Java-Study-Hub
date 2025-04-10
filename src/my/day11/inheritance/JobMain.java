package my.day11.inheritance;

import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import my.day01.MyUtil;
import my.day11.inheritance.controller.CommonController;
import my.day11.inheritance.controller.CompanyController;
import my.day11.inheritance.controller.JobSeekerController;
import my.day11.inheritance.user.CommonMember;
import my.day11.inheritance.user.company.Company;
import my.day11.inheritance.user.jobseeker.JobSeeker;
import my.day11.inheritance.user.jobseeker.JobSeeker.UserFieldEnum;

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
		
//		
//		System.out.println("aasf111231".matches("^[A-Za-z][A-Za-z0-9].{3,9}"));
//		System.out.println("가나다라마바".matches("^[가-힣]{2,6}"));
//		System.out.println(MyUtil.validationUserField(UserFieldEnum.PRIMARY_KEY, "9212122"));
		
		int num = 100;				// 4 3 2 1
		int j = num%2==0 ? num/2-1 : num/2;
		for(int i = 0; i<num; i+=2) {// 1 3 5 7
			System.out.println(" ".repeat(j--)+"*".repeat(i+1));
		}
		j = 1;
		for(int i = num%2==0 ? num-2 : num-1; i>0; i-=2) {//  7 5 3 1
			System.out.println(" ".repeat(j++)+"*".repeat(i-1));
		}		
		
		int starNum  = 10;
		int support = 0;
		for(int i = 1; i<starNum; i+=2) {
			System.out.println(" ".repeat(starNum+3-support++)+"*".repeat(i));
		}
		support = 0;
		for(int i = (starNum-1)*3; i>starNum*2; i-=2) {
			System.out.println(" ".repeat(support++)+"*".repeat(i));
		}
		support = 2;
		int sup = 1;
		//2 11 1 11
		for(int i = starNum; i>0; i-=2 ) {
			System.out.println(" ".repeat(support<0?0:support--)+"*".repeat(i+1)+" ".repeat(sup)+"*".repeat(i+1));
			sup+=5;
		}
		
		
		
		
		final Scanner sc = new Scanner(System.in);
		final JobSeekerController jsc = new JobSeekerController();
		final CommonController commonCtrl = new CommonController();
		final CompanyController companyCtrl = new CompanyController();
		
		
		
		CommonMember loginUser = null;

		main:
		while(true) {
			commonCtrl.mainMenu();
			String select = sc.nextLine().strip();
			
			switch(select.trim()) {
				case "1": //구직자 회원 가입
					jsc.signUp(sc);
					break;
				case "2":  // 구인회사 로직 호출
					companyCtrl.signUp(sc);
					break;
				case "3": // 구직자 로그인
					//성공시 구직자 님 로그인 성공 메세지띄움
					if(loginUser!=null) {
						System.out.println("ID : "+loginUser.getId()+" 계정이 이미 로그인 되어있습니다. 로그아웃 후 이용해주세요.");
						break;
					}
					JobSeeker js = jsc.login(sc);
					if(js != null) {
						System.out.println(js.getName() +" 님 로그인 성공 하였습니다.");
						jsc.loginLogic(sc, js, companyCtrl);//로그인 성공 구직자 전용 메뉴
						System.out.println(js.getName()+" 님 로그아웃 하였습니다.");
					}
					
					break;
				case "4" : 
					Company cp = companyCtrl.login(sc);
					if(cp!=null) {
						System.out.println(cp.getName() +" 님 로그인 성공 하였습니다.");
						companyCtrl.loginLogic(sc, cp, jsc);
						System.out.println(cp.getName()+" 님 로그아웃 하였습니다.");
					}
					break; //구인회사 로그인
				case "5": break main;
				default : System.out.println("잘못 입력됨 1 부터 5 중 입력하세요.");
			}
			
		}
		
		
		
		sc.close();
		System.out.println("프로그램 종료");
	}

}
