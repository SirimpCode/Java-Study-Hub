//	package my.day18.collection.gujikja;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import my.day18.collection.gujikja.controller.CommonController;
//import my.day18.collection.gujikja.controller.CompanyController;
//import my.day18.collection.gujikja.controller.GujikjaController;
//import my.day18.collection.gujikja.repository.CommonMember;
//import my.day18.collection.gujikja.repository.Company;
//import my.day18.collection.gujikja.repository.Gujikja;
//import my.day18.collection.gujikja.repository.Recruit;
//import my.day18.collection.gujikja.repository.RecruitApply;
//import my.day18.collection.gujikja.repository.Repository;
//
//public class GujikjaCompanyMain {
//	public static void main(String[] args) {
//
//		//스캐너와 저장소
//		final Scanner SC = new Scanner(System.in);
//		final Repository repository = new Repository();
//        final GujikjaController ctrl_gu = new GujikjaController(repository);
//        final CompanyController ctrl_cp = new CompanyController(repository);
//        
//        String str_menuno = "";
//        
//        do {
//        	CommonController.main_menu(); // 메인메뉴
//        	str_menuno = SC.nextLine();
//        	
//        	switch (str_menuno) {
//				case "1": // 구직자 회원가입
//					ctrl_gu.register(SC);
//					break;
//					
//				case "2": // 구인회사 회원가입
//					ctrl_cp.register(SC); 
//					break;
//					
//				case "3": // 구직자 로그인
//					Gujikja login_gu = (Gujikja) ctrl_gu.login(SC);
//					
//					if(login_gu != null) {
//						System.out.println(">> 구직자 " + login_gu.getName() + "님 로그인 성공^^ <<\n");
//						
//						ctrl_gu.gu_menu(login_gu, cmbr_arr, rc_arr, rcApply_arr); // 구직자 전용메뉴
//					}
//					else {
//						System.out.println(">> 구직자로 로그인 실패 ㅜㅜ <<\n");
//					}
//					
//					break;	
//					
//				case "4": // 구인회사 로그인
//					Company login_cp = (Company) ctrl_cp.login(SC);
//					
//					if(login_cp != null) {
//						System.out.println(">> 구인회사 " + login_cp.getName() + "기업 로그인 성공^^ <<\n");
//						
//						ctrl_cp.cp_menu(sc, login_cp, cmbr_arr, rc_arr, rcApply_arr); // 구인회사 전용메뉴
//					}
//					else {
//						System.out.println(">> 구인회사 로그인 실패 ㅜㅜ <<\n");
//					}
//										
//					break;	
//					
//				case "5": // 프로그램 종료
//					
//					break;	
//	
//				default:
//					System.out.println("[경고] 메뉴에 없는 번호 입니다.\n");
//					break;
//			}// end of switch (str_menuno)----------------
//        	        	
//		} while (!("5".equals(str_menuno)));
//        // end of do~while----------------
//        
//        sc.close();
//        System.out.println("\n>>> 프로그램 종료 <<<");
//        
//	}
//	
//	//오라클 겔렉트문
//	// 주번 값이 1 또는 3 이면 남 2또는4는 여
//	// select substr(jubun, 7, 1) as 주번
//	// from employee
//	// select substr(jubun, 7, 1) as 주번// 주번값이 1 또는 3 이면 남 2또는4는 여 
//	
//	
//	
//	select substr(jubun, 7, 1) as 주번
//	from employee
//}
