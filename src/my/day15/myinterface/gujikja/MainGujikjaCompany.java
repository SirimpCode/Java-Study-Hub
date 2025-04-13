	package my.day15.myinterface.gujikja;

import java.util.Scanner;

public class MainGujikjaCompany {

	public static void main(String[] args) {
		
	 // ================================= //
		CommonMemberAbstract[] cmbr_arr = new CommonMemberAbstract[9];
	
		GujikjaImpl gu1 = new GujikjaImpl();
		gu1.setType(1);
		gu1.setId("eomjh");
		gu1.setPasswd("Qwer1234$");
		gu1.setName("엄정화");
		gu1.setJubun("8610202");
		cmbr_arr[CommonMemberAbstract.count++] = gu1;
		
		GujikjaImpl gu2 = new GujikjaImpl();
		gu2.setType(1);
		gu2.setId("leess"); 
        gu2.setPasswd("Abcd12345$");
        gu2.setName("이순신"); 
        gu2.setJubun("8604011");
        cmbr_arr[CommonMemberAbstract.count++] = gu2;
		
        GujikjaImpl gu3 = new GujikjaImpl();
        gu3.setType(1);
        gu3.setId("chaew"); 
        gu3.setPasswd("Wxyz1234$");
        gu3.setName("차은우"); 
        gu3.setJubun("0106053"); 
        cmbr_arr[CommonMemberAbstract.count++] = gu3;
     // ================================= // 
                
        CompanyImpl cp1 = new CompanyImpl();
        cp1.setType(2);
        cp1.setId("samsung");
        cp1.setPasswd("Abcd1234$");
        cp1.setName("삼성");
        cp1.setBusiness_number("8123456789");
        cp1.setJob_type("제조업");
        cp1.setSeed_money(80000000000L);
        cmbr_arr[CommonMemberAbstract.count++] = cp1;
        
    
        CompanyImpl cp2 = new CompanyImpl();
        cp2.setType(2);
        cp2.setId("lg");
        cp2.setPasswd("Abcd0070$");
        cp2.setName("엘지");
        cp2.setBusiness_number("7123456789");
        cp2.setJob_type("IT");
        cp2.setSeed_money(70000000000L);
        cmbr_arr[CommonMemberAbstract.count++] = cp2;
        
     // ================================= //
        
        RecruitImpl[] rc_arr = new RecruitImpl[10];
     
        RecruitImpl rc1 = new RecruitImpl();
        rc1.setCp(cp1);
        rc1.setSubject("성실한 사무직원을 채용합니다.");
        rc1.setWork_type("정규사무직");
        rc1.setCnt(2);
        rc1.setYearpay(4000);
        rc1.setFinish_day("20250508");
        rc_arr[RecruitImpl.count++] = rc1;
              
        RecruitImpl rc2 = new RecruitImpl();
		rc2.setCp(cp2);
		rc2.setSubject("우수한 기술직원을 채용합니다.");
		rc2.setWork_type("계약직(2년)");
		rc2.setCnt(5);
		rc2.setYearpay(4500);
		rc2.setFinish_day("20250608");
		rc_arr[RecruitImpl.count++] = rc2;
        
        
		RecruitImpl rc3 = new RecruitImpl();
		rc3.setCp(cp2);
		rc3.setSubject("참신한 영업직원을 채용합니다.");
		rc3.setWork_type("정규직");
		rc3.setCnt(10);
		rc3.setYearpay(5000);
		rc3.setFinish_day("20250708");
		rc_arr[RecruitImpl.count++] = rc3;
        
     // ================================= //
	
		RecruitApplyImpl[] rcApply_arr = new RecruitApplyImpl[20];
		
		RecruitApplyImpl rcapply1 = new RecruitApplyImpl();
		rcapply1.setRc(rc1);
		rcapply1.setGu(gu1);
		rcapply1.setApply_motive("엄정화는 사무에 최선을 다합니다.");
		rcApply_arr[RecruitApplyImpl.count++] = rcapply1;
		
		RecruitApplyImpl rcapply2 = new RecruitApplyImpl();
		rcapply2.setRc(rc1);
		rcapply2.setGu(gu2);
		rcapply2.setApply_motive("이순신은 최고의 사무직 인재입니다.");
		rcApply_arr[RecruitApplyImpl.count++] = rcapply2;
	
		RecruitApplyImpl rcapply3 = new RecruitApplyImpl();
		rcapply3.setRc(rc2);
		rcapply3.setGu(gu3);
		rcapply3.setApply_motive("차은우는 최고의 기술을 가진 엔지니어 입니다.");
		rcApply_arr[RecruitApplyImpl.count++] = rcapply3;
			
		RecruitApplyImpl rcapply4 = new RecruitApplyImpl();
		rcapply4.setRc(rc3);
		rcapply4.setGu(gu1);
		rcapply4.setApply_motive("엄정화는 영업의 달인 입니다.");
		rcApply_arr[RecruitApplyImpl.count++] = rcapply4;
		
		RecruitApplyImpl rcapply5 = new RecruitApplyImpl();
		rcapply5.setRc(rc3);
		rcapply5.setGu(gu2);
		rcapply5.setApply_motive("이순신은 판매왕 입니다.");
		rcApply_arr[RecruitApplyImpl.count++] = rcapply5;
		
     // ================================= //	
		
        Scanner sc = new Scanner(System.in);
        CtrlCommon ctrl_common = new CtrlCommonImpl();
        CtrlGujikja ctrl_gu = new CtrlGujikjaImpl();
        CtrlCompany ctrl_cp = new CtrlCompanyImpl();
        
        String str_menuno = "";
        
        do {
        	ctrl_common.main_menu(); // 메인메뉴
        	str_menuno = sc.nextLine();
        	
        	switch (str_menuno) {
				case "1": // 구직자 회원가입
					ctrl_gu.register(sc, cmbr_arr);
					break;
					
				case "2": // 구인회사 회원가입
					ctrl_cp.register(sc, cmbr_arr); 
					break;
					
				case "3": // 구직자 로그인
					GujikjaImpl login_gu = ctrl_gu.login(sc, cmbr_arr);
					
					if(login_gu != null) {
						System.out.println(">> 구직자 " + login_gu.getName() + "님 로그인 성공^^ <<\n");
						
						ctrl_gu.gu_menu(sc, login_gu, cmbr_arr, rc_arr, rcApply_arr); // 구직자 전용메뉴
					}
					else {
						System.out.println(">> 구직자로 로그인 실패 ㅜㅜ <<\n");
					}
					
					break;	
					
				case "4": // 구인회사 로그인
					CompanyImpl login_cp = ctrl_cp.login(sc, cmbr_arr);
					
					if(login_cp != null) {
						System.out.println(">> 구인회사 " + login_cp.getName() + "기업 로그인 성공^^ <<\n");
						
						ctrl_cp.cp_menu(sc, login_cp, cmbr_arr, rc_arr, rcApply_arr); // 구인회사 전용메뉴
					}
					else {
						System.out.println(">> 구인회사 로그인 실패 ㅜㅜ <<\n");
					}
										
					break;	
					
				case "5": // 프로그램 종료
					
					break;	
	
				default:
					System.out.println("[경고] 메뉴에 없는 번호 입니다.\n");
					break;
			}// end of switch (str_menuno)----------------
        	        	
		} while (!("5".equals(str_menuno)));
        // end of do~while----------------
        
        sc.close();
        System.out.println("\n>>> 프로그램 종료 <<<");
        
	}

}
