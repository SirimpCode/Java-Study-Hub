package my.day15.myinterface.gujikja;

import java.util.Scanner;

public interface CtrlGujikja {

	// == 구직자 회원가입 ==
	void register(Scanner sc, CommonMemberAbstract[] cmbr_arr);
	
	// === 구직자 로그인 === //
	GujikjaImpl login(Scanner sc, CommonMemberAbstract[] cmbr_arr);
	
	// === 구직자 전용메뉴 === //
	void gu_menu(Scanner sc, GujikjaImpl login_gu, CommonMemberAbstract[] cmbr_arr, RecruitImpl[] rc_arr, RecruitApplyImpl[] rcApply_arr);
	
	
	
}
