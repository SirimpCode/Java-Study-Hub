package my.day15.myinterface.gujikja;

import java.util.Scanner;

public interface CtrlCompany {

	// == 구인회사 회원가입 == //
	void register(Scanner sc, CommonMemberAbstract[] cmbr_arr);
	
	// === 구인회사 로그인 === //
	CompanyImpl login(Scanner sc, CommonMemberAbstract[] cmbr_arr);
	
	// === 구인회사 전용메뉴 === //
	void cp_menu(Scanner sc, CompanyImpl login_cp, CommonMemberAbstract[] cmbr_arr, RecruitImpl[] rc_arr, RecruitApplyImpl[] rcApply_arr);
	
}
