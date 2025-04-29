//package my.day18.collection.gujikja.controller;
//
//import my.day01.MyUtil;
//import my.day18.collection.gujikja.GujikjaCompanyMain;
//import my.day18.collection.gujikja.repository.CommonMember;
//import my.day18.collection.gujikja.repository.Company;
//import my.day18.collection.gujikja.repository.Gujikja;
//import my.day18.collection.gujikja.repository.Repository;
//
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//
//public class CompanyController extends CommonController {
//	public CompanyController(Repository repo) {
//		super(repo,true);
//		// TODO 자동 생성된 생성자 스텁
//	}
//
//	private final Scanner sc = GujikjaCompanyMain.sc;
//
//	
//	// == 구인회사 회원가입 ==
//	/*
//	 * 구인회사(Company) 신규 회원가입시 Company 클래스의 field 의 요구사항에 모두 맞으면 Company[] cp_arr 에
//	 * 저장시켜주는 메소드 생성하기
//	 */
//	@Override
//	public CommonMember etcInfoSetByRegister(Scanner sc, CommonMember mbr) {
//		Company cp = (Company) mbr;
//		// 사업자등록번호는 필수 입력사항이므로 사업자등록번호 조건에 맞을때 까지 반복해야 한다.
//		do {
//			System.out.print("4.사업자등록번호 : ");
//			String business_number = sc.nextLine();
//
//			cp.setBusiness_number(business_number);
//
//		} while (!(cp.getBusiness_number() != null));
//
//		// 회사직종타입은 필수 입력사항이므로 조건에 맞을때 까지 반복해야 한다.
//		do {
//			System.out.print("5.회사직종타입 : ");
//			String job_type = sc.nextLine();
//
//			cp.setJob_type(job_type);
//
//		} while (!(cp.getJob_type() != null));
//
//		// 자본금은 필수 입력사항이므로 조건에 맞을때 까지 반복해야 한다.
//		do {
//			System.out.print("6.자본금 : ");
//			long seed_money = 0;
//			try {
//				seed_money = Long.parseLong(sc.nextLine());
//			} catch (NumberFormatException e) {
//				System.out.println("[경고] 자본금은 숫자로만 입력하세요!!\n");
//				continue;
//			}
//
//			cp.setSeed_money(seed_money);
//
//		} while (!(cp.getSeed_money() > 0));
//
//		return cp;
//	};
//	
//		// cmbr_arr)---------------------
//
//	// === 구인회사 전용메뉴 ===
//	@Override
//	public void cp_menu(Company login_cp) {
//
//		String str_menuno = "";
//
//		do {
//			System.out.println("\n === 구인회사 전용메뉴(" + login_cp.getName() + "기업 로그인중) ===\n"
//					+ "1.우리회사정보 보기   2.우리회사정보 수정   3.모든구직자 조회   4.구직자검색하기\n"
//					+ "5.채용공고입력하기   6.우리회사 채용공고 조회   7.우리회사 채용공고 지원자 조회  8.로그아웃\n");
//			System.out.print("▷ 메뉴번호 선택 : ");
//			str_menuno = sc.nextLine();
//
//			switch (str_menuno) {
//			case "1": // 우리회사정보 보기
//				view_myInfo(login_cp);
//				break;
//
//			case "2": // 우리회사정보 수정
//				update_myInfo(sc, login_cp);
//				break;
//
//			case "3": // 모든구직자 조회
//				view_all_gujikja_info(cmbr_arr);
//				break;
//
//			case "4": // 구직자검색하기
//				search_gujikja(sc, cmbr_arr);
//				break;
//
//			case "5": // 채용공고입력하기
//				register_recruit(sc, login_cp, rc_arr);
//				break;
//
//			case "6": // 우리회사 채용공고 조회
//				view_recruit_mycompany(login_cp, rc_arr);
//				break;
//
//			case "7": // 우리회사 채용공고 지원자 조회
//				view_gujikja_my_recruitApply(login_cp, rcApply_arr);
//				break;
//
//			case "8": // 로그아웃
//
//				break;
//
//			default:
//				System.out.println(">>[경고] 선택하신 번호는 메뉴에 없습니다. <<\n");
//				break;
//			}// end of switch (key)----------------
//
//		} while (!"8".equals(str_menuno));
//		// end of do~while---------------------
//
//		System.out.println(">> 로그아웃 되었습니다. <<\n");
//
//	}// end of public void cp_menu(Scanner sc, Company_imple login_cp,
//		// CommonMember_abstract[] cmbr_arr, Recruit_imple[] rc_arr,
//		// RecruitApply_imple[] rcApply_arr)-----------------------
//
//	// === 우리회사정보 보기 ===
//	private void view_myInfo(CompanyImpl login_cp) {
//
//		/*
//		 * 
//		 * >>> 삼성 기업의 정보 <<<
//		 * -----------------------------------------------------------------------------
//		 * ----- 아이디 비밀번호 회사명 가입일자 사업자등록번호 직종타입 자본금
//		 * -----------------------------------------------------------------------------
//		 * ----- samsung Abcd1234$ 삼성 2025-04-07 8123456789 제조업 8,000,000,000원
//		 */
//		System.out.println("\n>>> " + login_cp.getName() + " 기업의 정보 <<<");
//		System.out.println("-".repeat(80));
//		System.out.println(" 아이디     비밀번호      회사명   가입일자      사업자등록번호  직종타입   자본금");
//		System.out.println("-".repeat(80));
//		System.out.println(login_cp.getId() + "\t" + login_cp.getPasswd() + "\t" + login_cp.getName() + "\t"
//				+ login_cp.getRegister_day().substring(0, 10) + "\t" + login_cp.getBusiness_number() + "\t"
//				+ login_cp.getJob_type() + "\t" + new DecimalFormat("#,###").format(login_cp.getSeed_money()) + "원\n");
//
//	}// end of private void view_myInfo(Company login_cp)----------------------------
//
//	// === 우리회사정보 수정 ===
//	private void update_myInfo(Scanner sc, CompanyImpl login_cp) {
//
//		view_myInfo(login_cp);
//
//		System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!\n");
//
//		boolean exit_ok = false;
//
//		do {
//			// ================================================== //
//			System.out.print("1.비밀번호 : ");
//			String new_passwd = sc.nextLine(); // 기존비밀번호인 Qwer1234$ 을 Qwer0070$ 으로 변경하려고 한다. --> 정상
//												// 기존비밀번호인 Qwer1234$ 을 Qwer1234$ 으로 변경하려고 한다. --> "기존 비밀번호와 동일하므로 변경이
//												// 불가합니다." 라는 메시지 출력한다. 비정상.
//												// 기존비밀번호인 Qwer1234$ 을 Qwer00700 으로 변경하려고 한다. --> 비밀번호 정책에 맞지 않으므로 비정상.
//												// 그냥 엔터하면 비밀번호 변경이 없어야 한다.
//
//			if (!new_passwd.equals("")) { // 입력한 비밀번호가 그냥 엔터가 아닐 경우
//
//				if (new_passwd.equals(login_cp.getPasswd())) { // 입력한 비밀번호가 기존 비밀번호와 같을 경우
//					System.out.println(">> 기존 비밀번호와 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 비밀번호가 기존 비밀번호와 다를 경우
//					login_cp.setPasswd(new_passwd); // abcd Qwer0070$
//
//					if (login_cp.getPasswd().equals(new_passwd)) { // 비밀번호 정책에 맞는 경우
//						exit_ok = true;
//					}
//				}
//
//			}
//
//			else { // 입력한 비밀번호가 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		exit_ok = false;
//		do {
//			// ================================================== //
//			System.out.print("2.회사명 : ");
//			String new_name = sc.nextLine();
//
//			if (!new_name.equals("")) { // 입력한 회사명이 그냥 엔터가 아닐 경우
//
//				if (new_name.equals(login_cp.getName())) { // 입력한 회사명이 기존 회사명과 같을 경우
//					System.out.println(">> 기존 회사명과 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 회사명이 기존 회사명과 다를 경우
//					login_cp.setName(new_name);
//
//					if (login_cp.getName().equals(new_name)) { // 회사명 정책에 맞는 경우
//						exit_ok = true;
//					}
//				}
//
//			}
//
//			else { // 입력한 회사명이 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		exit_ok = false;
//		do {
//			// ================================================== //
//			System.out.print("3.사업자등록번호 : ");
//			String new_business_number = sc.nextLine();
//
//			if (!new_business_number.equals("")) { // 입력한 사업자등록번호가 그냥 엔터가 아닐 경우
//
//				if (new_business_number.equals(login_cp.getBusiness_number())) { // 입력한 사업자등록번호가 기존 사업자등록번호와 같을 경우
//					System.out.println(">> 기존 사업자등록번호와 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 사업자등록번호가 기존 사업자등록번호와 다를 경우
//					login_cp.setBusiness_number(new_business_number);
//
//					if (login_cp.getBusiness_number().equals(new_business_number)) { // 사업자등록번호 정책에 맞는 경우
//						exit_ok = true;
//					}
//				}
//
//			}
//
//			else { // 입력한 사업자등록번호가 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		exit_ok = false;
//		do {
//			// ================================================== //
//			System.out.print("4.회사직종타입 : ");
//			String new_job_type = sc.nextLine();
//
//			if (!new_job_type.equals("")) { // 입력한 회사직종타입이 그냥 엔터가 아닐 경우
//
//				if (new_job_type.equals(login_cp.getJob_type())) { // 입력한 회사직종타입이 기존 회사직종타입과 같을 경우
//					System.out.println(">> 기존 직종타입과 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 회사직종타입이 기존 회사직종타입과 다를 경우
//					login_cp.setJob_type(new_job_type);
//
//					if (login_cp.getJob_type().equals(new_job_type)) { // 회사직종타입 정책에 맞는 경우
//						exit_ok = true;
//					}
//				}
//
//			}
//
//			else { // 입력한 회사직종타입이 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		exit_ok = false;
//		do {
//			// ================================================== //
//			System.out.print("5.자본금 : "); // "90,000,000,000"
//			String str_new_seed_money = sc.nextLine();
//
//			if (!str_new_seed_money.equals("")) { // 입력한 자본금이 그냥 엔터가 아닐 경우
//
//				try {
//
//					long new_seed_money = Long.parseLong(String.join("", str_new_seed_money.split("[,]")));
//					// "90000000000" ==> 90000000000
//
//					if (login_cp.getSeed_money() == new_seed_money) { // 입력한 자본금이 기존 자본금과 같을 경우
//						System.out.println(">> 기존 자본금과 동일하므로 변경이 불가합니다. <<\n");
//					} else { // 입력한 자본금이 기존 자본금과 다를 경우
//						login_cp.setSeed_money(new_seed_money);
//
//						if (login_cp.getSeed_money() == new_seed_money) { // 자본금 정책에 맞는 경우
//							exit_ok = true;
//						}
//					}
//				} catch (NumberFormatException e) {
//					System.out.println(">> [경고] 자본금은 정수로만 입력하셔야 합니다.!!\n");
//				}
//			}
//
//			else { // 입력한 자본금이 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		System.out.println(">> 구인회사 정보 수정 완료!! <<\n");
//
//	}// end of private void update_myInfo(Scanner sc, Company login_cp)------------
//
//	// 타이틀
//	private void title_gujikja() {
//		System.out.println(
//				"-".repeat(70) + "\n" + " 아이디   비밀번호       성명      생년월일       성별   현재만나이   가입일자 \n" + "-".repeat(70));
//	}// end of void title_gujikja()------------------------------
//
//	// === 모든구직자 조회 ===
//	private void view_all_gujikja_info(CommonMemberAbstract[] cmbr_arr) {
//
//		boolean is_exists_gujikja = false;
//		for (int i = 0; i < CommonMemberAbstract.count; i++) {
//			if (cmbr_arr[i].getType() == 1) {
//				is_exists_gujikja = true;
//				break;
//			}
//		} // end of for----------------------------
//
//		if (!is_exists_gujikja) {
//			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
//		}
//
//		else {
//			title_gujikja();
//
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; i < CommonMemberAbstract.count; i++) {
//				if (cmbr_arr[i].getType() == 1) {
//					sb.append(cmbr_arr[i].getInfo() + "\n");
//				}
//			} // end of for---------------------
//
//			System.out.println(sb.toString());
//		}
//
//	}// end of private void view_all_gujikja_info(CommonMember_abstract[]
//		// cmbr_arr)------
//
//	// === 구직자검색하기 ===
//	private void search_gujikja(Scanner sc, CommonMemberAbstract[] cmbr_arr) {
//
//		String str_menuno = "";
//
//		do {
//			System.out.println(">>> 구직자 검색메뉴 <<<\n" + "1.성별검색    2.연령대검색     3.구직자 연령대 및 성별검색     4.구인회사 전용메뉴로 돌아가기");
//			System.out.print("▷ 검색메뉴번호 입력 : ");
//
//			str_menuno = sc.nextLine();
//
//			switch (str_menuno) {
//			case "1": // 성별검색
//				search_gender_gujikja(sc, cmbr_arr);
//				break;
//
//			case "2": // 연령대검색
//				search_ageline_gujikja(sc, cmbr_arr);
//				break;
//
//			case "3": // 구직자 연령대 및 성별검색
//				search_ageline_gender_gujikja(sc, cmbr_arr);
//				break;
//
//			case "4": // 구인회사 전용메뉴로 돌아가기
//
//				break;
//
//			default:
//				System.out.println(">>[경고] 구직자 검색메뉴에 없는 번호 입니다.<<\n");
//				break;
//			}// end of switch (str_menuno)--------------------
//
//		} while (!"4".equals(str_menuno));
//
//	}// end of private void search_gujikja(Scanner sc, CommonMember_abstract[]
//		// cmbr_arr)------------
//
//	// === 성별검색 ===
//	private void search_gender_gujikja(Scanner sc, CommonMemberAbstract[] cmbr_arr) {
//
//		boolean is_exists_gujikja = false;
//		for (int i = 0; i < CommonMemberAbstract.count; i++) {
//			if (cmbr_arr[i].getType() == 1) {
//				is_exists_gujikja = true;
//				break;
//			}
//		} // end of for----------------------------
//
//		if (!is_exists_gujikja) {
//			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
//		}
//
//		else { // 구직자가 있는 경우
//			String input_gender = "";
//			boolean isUse_input_gender = false;
//
//			do {
//				System.out.print("▷ 검색하고자 하는 성별[남/여] => ");
//				input_gender = sc.nextLine().trim(); // "남" "여" " 남 " " 여 " ==> 정상
//														// "" " " "강아지" ==> 비정상
//				switch (input_gender) {
//				case "남":
//				case "여":
//					isUse_input_gender = true;
//					break;
//
//				default:
//					System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
//					break;
//				}// end of switch (input_gender)----------------
//
//			} while (!isUse_input_gender);
//			// end of do~while----------------------------
//
//			// === 입력받은 성별에 해당하는 구직자 찾기 === //
//			StringBuilder sb = new StringBuilder();
//			boolean isFind = false;
//
//			for (int i = 0; i < CommonMemberAbstract.count; i++) {
//				if (cmbr_arr[i].getType() == 1 && ((GujikjaImpl) cmbr_arr[i]).gender().equals(input_gender)) {
//					isFind = true;
//					sb.append(cmbr_arr[i].getInfo() + "\n");
//				}
//			} // end of for--------------------
//
//			if (isFind) {
//				title_gujikja();
//				System.out.println(sb.toString());
//			} else {
//				System.out.println("[검색결과 성별 " + input_gender + "자 구직자는 없습니다]\n");
//			}
//		}
//
//	}// end of private void search_gender_gujikja(Scanner sc, CommonMember_abstract[]
//		// cmbr_arr)------
//
//	// === 연령대검색 ===
//	private void search_ageline_gujikja(Scanner sc, CommonMemberAbstract[] cmbr_arr) {
//
//		boolean is_exists_gujikja = false;
//		for (int i = 0; i < CommonMemberAbstract.count; i++) {
//			if (cmbr_arr[i].getType() == 1) {
//				is_exists_gujikja = true;
//				break;
//			}
//		} // end of for----------------------------
//
//		if (!is_exists_gujikja) {
//			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
//		}
//
//		else { // 구직자가 있는 경우
//			String input_ageline = "";
//			boolean isUse_input_ageline = false;
//
//			do {
//				System.out.print("▷ 검색하고자 하는 연령대[예: 20] => ");
//				input_ageline = sc.nextLine().trim(); // "0" "10" "20" "30" ~~ "80" ==> 정상
//														// "25" " " "강아지" ==> 비정상
//				switch (input_ageline) {
//				case "0":
//				case "10":
//				case "20":
//				case "30":
//				case "40":
//				case "50":
//				case "60":
//				case "70":
//				case "80":
//					isUse_input_ageline = true;
//					break;
//
//				default:
//					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
//					break;
//				}// end of switch (input_ageline)----------------
//
//			} while (!isUse_input_ageline);
//			// end of do~while----------------------------
//
//			// === 입력받은 연령대에 해당하는 구직자 찾기 === //
//			StringBuilder sb = new StringBuilder();
//			boolean isFind = false;
//
//			for (int i = 0; i < CommonMemberAbstract.count; i++) {
//				try {
//					if (cmbr_arr[i].getType() == 1 && MyUtil.getAge(((GujikjaImpl) cmbr_arr[i]).getJubun()) / 10
//							* 10 == Integer.parseInt(input_ageline)) {
//						isFind = true;
//						sb.append(cmbr_arr[i].getInfo() + "\n");
//					}
//				} catch (Exception e) {
//				}
//			} // end of for--------------------
//
//			if (isFind) {
//				title_gujikja();
//				System.out.println(sb.toString());
//			} else {
//				System.out.println("[검색결과 연령대 " + input_ageline + "대인 구직자는 없습니다]\n");
//			}
//		}
//
//	}// end of private void search_ageline_gujikja(Scanner sc,
//		// CommonMember_abstract[] cmbr_arr)-----
//
//	// 구직자 연령대 및 성별검색
//	private void search_ageline_gender_gujikja(Scanner sc, CommonMemberAbstract[] cmbr_arr) {
//
//		boolean is_exists_gujikja = false;
//		for (int i = 0; i < CommonMemberAbstract.count; i++) {
//			if (cmbr_arr[i].getType() == 1) {
//				is_exists_gujikja = true;
//				break;
//			}
//		} // end of for----------------------------
//
//		if (!is_exists_gujikja) {
//			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
//			return; // 해당 메소드(지금은 search_ageline_gender_gujikja())를 종료하는 것이다.
//		}
//
//		else { // 구직자가 있는 경우
//			String input_ageline = "";
//			boolean isUse_input_ageline = false;
//
//			do {
//				System.out.print("▷ 검색하고자 하는 연령대[예: 20] => ");
//				input_ageline = sc.nextLine().trim(); // "0" "10" "20" "30" ~~ "80" ==> 정상
//														// "25" " " "강아지" ==> 비정상
//				switch (input_ageline) {
//				case "0":
//				case "10":
//				case "20":
//				case "30":
//				case "40":
//				case "50":
//				case "60":
//				case "70":
//				case "80":
//					isUse_input_ageline = true;
//					break;
//
//				default:
//					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
//					break;
//				}// end of switch (input_ageline)----------------
//
//			} while (!isUse_input_ageline);
//			// end of do~while----------------------------
//
//			// === 입력받은 연령대에 해당하는 구직자 찾기 === //
//			boolean isFind = false;
//
//			for (int i = 0; i < CommonMemberAbstract.count; i++) {
//				try {
//					if (cmbr_arr[i].getType() == 1 && MyUtil.getAge(((GujikjaImpl) cmbr_arr[i]).getJubun()) / 10
//							* 10 == Integer.parseInt(input_ageline)) {
//						isFind = true;
//						break;
//					}
//				} catch (Exception e) {
//				}
//			} // end of for--------------------
//
//			if (!isFind) {
//				System.out.println("[검색결과 연령대 " + input_ageline + "대인 구직자는 없습니다]\n");
//				return; // 해당 메소드(지금은 search_ageline_gender_gujikja())를 종료하는 것이다.
//			}
//
//			// ======= 성별 검색 시작 ======== //
//			String input_gender = "";
//			boolean isUse_input_gender = false;
//
//			do {
//				System.out.print("▷ 검색하고자 하는 성별[남/여] => ");
//				input_gender = sc.nextLine().trim(); // "남" "여" " 남 " " 여 " ==> 정상
//														// "" " " "강아지" ==> 비정상
//				switch (input_gender) {
//				case "남":
//				case "여":
//					isUse_input_gender = true;
//					break;
//
//				default:
//					System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
//					break;
//				}// end of switch (input_gender)----------------
//
//			} while (!isUse_input_gender);
//			// end of do~while----------------------------
//
//			// === 입력받은 연령대 및 성별에 해당하는 구직자 찾기 === //
//			StringBuilder sb = new StringBuilder();
//			isFind = false;
//
//			for (int i = 0; i < CommonMemberAbstract.count; i++) {
//				try {
//					if (cmbr_arr[i].getType() == 1
//							&& MyUtil.getAge(((GujikjaImpl) cmbr_arr[i]).getJubun()) / 10 * 10 == Integer
//									.parseInt(input_ageline)
//							&& ((GujikjaImpl) cmbr_arr[i]).gender().equals(input_gender)) {
//						isFind = true;
//						sb.append(cmbr_arr[i].getInfo() + "\n");
//					}
//				} catch (Exception e) {
//				}
//			} // end of for--------------------
//
//			if (isFind) {
//				title_gujikja();
//				System.out.println(sb.toString());
//			} else {
//				System.out.println("[검색결과 연령대 " + input_ageline + "대인 " + input_gender + "자 구직자는 없습니다]\n");
//			}
//
//		}
//
//	}// end of private void search_ageline_gender_gujikja(Scanner sc,
//		// CommonMember_abstract[] cmbr_arr)-----
//
//	// === 채용공고입력하기 ===
//	private void register_recruit(Scanner sc, CompanyImpl login_cp, RecruitImpl[] rc_arr) {
//
//		System.out.println("====== " + login_cp.getName() + " 채용공고 등록 ======");
//
//		RecruitImpl rc = new RecruitImpl();
//
//		do {
//			System.out.print("1.채용제목 : ");
//			rc.setSubject(sc.nextLine());
//		} while (!(rc.getSubject() != null));
//
//		do {
//			System.out.print("2.채용분야[예: 정규사무직/계약직] : ");
//			rc.setWork_type(sc.nextLine());
//		} while (!(rc.getWork_type() != null));
//
//		do {
//			System.out.print("3.채용인원 : ");
//
//			try {
//				rc.setCnt(Integer.parseInt(sc.nextLine()));
//			} catch (NumberFormatException e) {
//				System.out.println("[경고] 정수로만 입력하세요!!\n");
//			}
//
//		} while (!(rc.getCnt() > 0));
//
//		do {
//			System.out.print("4.연봉[단위 만원] : "); // 5000 또는 5,000
//
//			try {
//				rc.setYearpay(Integer.parseInt(String.join("", sc.nextLine().split("[, ]"))));
//			} catch (NumberFormatException e) {
//				System.out.println("[경고] 정수로만 입력하세요!!\n");
//			}
//
//		} while (!(rc.getYearpay() > 0));
//
//		do {
//			System.out.print("5.채용마감일자[예: 20250510]");
//			rc.setFinish_day(sc.nextLine());
//		} while (!(rc.getFinish_day() != null));
//
//		rc.setCp(login_cp);
//
//		rc_arr[RecruitImpl.count++] = rc;
//
//		System.out.println("\n채용공고 등록완료!! \n");
//
//	}// end of private void register_recruit(Scanner sc, Company login_cp, Recruit[]
//		// rc_arr)------
//
//	// === 우리회사 채용공고 조회(채용마감일자가 지난것이 아니라 진행중인 것만 조회한다). ===
//	private void view_recruit_mycompany(CompanyImpl login_cp, RecruitImpl[] rc_arr) {
//
//		boolean is_existence = false;
//
//		for (int i = 0; i < RecruitImpl.count; i++) {
//
//			if (login_cp.getId().equals(rc_arr[i].getCp().getId())) {
//
//				String str_finish_day = rc_arr[i].getFinish_day();
//
//				/*
//				 * Date now = new Date(); SimpleDateFormat sdf = new
//				 * SimpleDateFormat("yyyyMMdd"); String str_now_day = sdf.format(now); //
//				 * "20250409"
//				 * 
//				 * MyUtil.date_comparison(str_finish_day, str_now_day);
//				 */
//				// 또는
//				int n = MyUtil.dateCompareTo(str_finish_day, new SimpleDateFormat("yyyyMMdd").format(new Date()));
//				// n 은 -1 , 0 , 1, 2
//
//				if (n == 0 || n == 1) { // 채용마감일자가 오늘 이거나 내일 이후인 것.
//					is_existence = true;
//					System.out.println(rc_arr[i].recruit_info());
//				}
//			}
//		} // end of for--------------------
//
//		if (!is_existence) {
//			System.out.println(">> 현재 진행중인 채용공고가 없습니다. <<\n");
//		}
//
//	}// end of private void view_recruit_mycompany(Company login_cp, Recruit[]
//		// rc_arr)-----
//
//	// === 우리회사 채용공고 지원자 조회 ===
//	private void view_gujikja_my_recruitApply(CompanyImpl login_cp, RecruitApplyImpl[] rcApply_arr) {
//
//		StringBuilder sb = new StringBuilder();
//		boolean is_existence = false;
//
//		try {
//			for (int i = 0; i < RecruitApplyImpl.count; i++) {
//
//				if (login_cp.getId().equals(rcApply_arr[i].getRc().getCp().getId())) {
//					is_existence = true;
//					sb.append(rcApply_arr[i].getRc().getRecruit_no() + "\t" + rcApply_arr[i].getRc().getSubject() + "\t"
//							+ rcApply_arr[i].getGu().getName() + "\t" + rcApply_arr[i].getGu().gender() + "\t"
//							+ MyUtil.getAge(rcApply_arr[i].getGu().getJubun()) + "\t" + rcApply_arr[i].getApply_motive()
//							+ "\n");
//				}
//
//			} // end of for-----------------------------------
//
//			/*
//			 * =============================================================================
//			 * == 채용공고번호 채용제목 지원자명 성별 나이 지원동기
//			 * =============================================================================
//			 * ==
//			 */
//
//			if (is_existence) {
//				System.out.println("=".repeat(100));
//				System.out.println(" 채용공고번호   채용제목                  지원자명    성별    나이     지원동기");
//				System.out.println("=".repeat(100));
//				System.out.println(sb.toString());
//			}
//
//			else {
//				System.out.println(">> 채용공고에 지원자가 없습니다. <<\n");
//			}
//
//		} catch (Exception e) {
//		}
//
//	}// end of private void view_gujikja_my_recruitApply(Company login_cp, Recruit[]
//		// rc_arr)------
//
//}
