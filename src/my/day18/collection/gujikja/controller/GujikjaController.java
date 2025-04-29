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
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//public class GujikjaController extends CommonController {
//	public GujikjaController(Repository repo) {
//		super(repo, false);
//	}
//
//	@Override
//	protected CommonMember etcInfoSetByRegister(Scanner sc, CommonMember mbr) {
//		// 주민번호는 필수 입력사항이므로 주민번호 조건에 맞을때 까지 반복해야 한다.
//		Gujikja gu = (Gujikja) mbr;
//		do {
//			System.out.print("4.주민번호 : ");
//			String jubun = sc.nextLine();
//
//			gu.setJubun(jubun);
//
//		} while (!(gu.getJubun() != null));
//		return gu;
//	}
//
//
//
//	// === 구직자 전용메뉴 ===
//	public void gu_menu(Gujikja login_gu, Scanner sc) {
//
//		String str_menuno = "";
//
//		do {
//			System.out.println("\n === 구직자 전용메뉴(" + login_gu.getName() + "님 로그인중) ===\n"
//					+ "1.내정보 보기   2.내정보 수정   3.모든구인회사 조회   4.구인회사검색하기\n"
//					+ "5.모든채용공고조회   6.채용공고상세보기   7.채용응모하기   8.채용응모한것조회\n" + "9.채용응모한것수정하기    10.로그아웃\n");
//			System.out.print("▷ 메뉴번호 선택 : ");
//			str_menuno = sc.nextLine();
//
//			switch (str_menuno) {
//			case "1": // 내정보 보기
//				view_myInfo(login_gu);
//				break;
//
//			case "2": // 내정보 수정
//				update_myInfo(sc, login_gu);
//				break;
//
//			case "3": // 모든구인회사 조회
//				view_all_company_info();
//				break;
//
//			case "4": // 구인회사검색하기
//				search_company(sc);
//				break;
//
//			case "5": // 모든채용공고조회(현재 채용이 진행중인 것만 조회)
//				view_all_recruit_info();
//				break;
//
//			case "6": // 채용공고상세보기
//				view_detail_one_recruit_info(sc, rc_arr);
//				break;
//
//			case "7": // 채용응모하기
//				input_recruitApply(sc, login_gu, rc_arr, rcApply_arr);
//				break;
//
//			case "8": // 채용응모한것조회
//				view_my_recruitApply(login_gu, rcApply_arr);
//				break;
//
//			case "9": // 채용응모한것수정하기
//				update_my_recruitApply(sc, login_gu, rcApply_arr);
//				break;
//
//			case "10": // 로그아웃
//
//				break;
//
//			default:
//				System.out.println(">>[경고] 선택하신 번호는 메뉴에 없습니다. <<\n");
//				break;
//			}// end of switch (key)----------------
//
//		} while (!"10".equals(str_menuno));
//		// end of do~while---------------------
//
//		System.out.println(">> 로그아웃 되었습니다. <<\n");
//
//	}// end of public void gu_menu(Scanner sc, Gujikja_imple login_gu,
//		// CommonMember_abstract[] cmbr_arr, Recruit_imple[] rc_arr,
//		// RecruitApply_imple[] rcApply_arr)-------------------
//
//	// === 내정보 보기 ===
//	private void view_myInfo(Gujikja login_gu) {
//		/*
//		 * >>> 엄정화님의 정보 <<<
//		 * -----------------------------------------------------------------------------
//		 * ---- 아이디 비밀번호 성명 생년월일 성별 현재만나이 가입일자
//		 * -----------------------------------------------------------------------------
//		 * ---- eomjh Qwer1234$ 엄정화 1986-10-20 여 38 2025-04-04 10:07:05
//		 * -----------------------------------------------------------------------------
//		 * -----
//		 */
//
//		System.out.println(">>> " + login_gu.getName() + "님의 정보 <<<");
//		title_gujikja();
//		System.out.println(login_gu.getMyInfo());
//
//	}// end of private void view_myInfo(Gujikja login_gu)-------
//
//	// === 내정보 수정 ===
//	private void update_myInfo(Scanner sc, Gujikja login_gu) {
//
//		view_myInfo(login_gu);
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
//				if (new_passwd.equals(login_gu.getPasswd())) { // 입력한 비밀번호가 기존 비밀번호와 같을 경우
//					System.out.println(">> 기존 비밀번호와 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 비밀번호가 기존 비밀번호와 다를 경우
//					login_gu.setPasswd(new_passwd); // abcd Qwer0070$
//
//					if (login_gu.getPasswd().equals(new_passwd)) { // 비밀번호 정책에 맞는 경우
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
//			System.out.print("2.성명 : ");
//			String new_name = sc.nextLine(); // 기존성명인 엄정화 를 정화엄 으로 변경하려고 한다. --> 정상
//												// 기존성명인 엄정화 를 엄정화 으로 변경하려고 한다. --> "기존 성명과 동일하므로 변경이 불가합니다." 라는 메시지
//												// 출력한다. 비정상.
//												// 기존성명인 엄정화 를 엄JH 으로 변경하려고 한다. --> 성명 정책에 맞지 않으므로 비정상.
//												// 그냥 엔터하면 성명 변경이 없어야 한다.
//
//			if (!new_name.equals("")) { // 입력한 성명이 그냥 엔터가 아닐 경우
//
//				if (new_name.equals(login_gu.getName())) { // 입력한 성명이 기존 성명과 같을 경우
//					System.out.println(">> 기존 성명과 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 성명이 기존 성명과 다를 경우
//					login_gu.setName(new_name);
//
//					if (login_gu.getName().equals(new_name)) { // 성명 정책에 맞는 경우
//						exit_ok = true;
//					}
//				}
//
//			}
//
//			else { // 입력한 성명이 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		exit_ok = false;
//		do {
//			// ================================================== //
//			System.out.print("3.주민번호 : ");
//			String new_jubun = sc.nextLine();
//
//			if (!new_jubun.equals("")) { // 입력한 주민번호가 그냥 엔터가 아닐 경우
//
//				if (new_jubun.equals(login_gu.getJubun())) { // 입력한 주민번호가 기존 주민번호와 같을 경우
//					System.out.println(">> 기존 주민번호와 동일하므로 변경이 불가합니다. <<\n");
//				} else { // 입력한 주민번호가 기존 주민번호와 다를 경우
//					login_gu.setJubun(new_jubun);
//
//					if (login_gu.getJubun().equals(new_jubun)) { // 주민번호 정책에 맞는 경우
//						exit_ok = true;
//					}
//				}
//
//			}
//
//			else { // 입력한 주민번호가 그냥 엔터일 경우
//				exit_ok = true;
//			}
//			// ================================================== //
//		} while (!exit_ok);
//		// end of do~while------------------------
//
//		System.out.println(">> 구직자 정보 수정 완료!! <<\n");
//
//	}// end of private void update_myInfo(Scanner sc, Gujikja login_gu)-----------
//
//	// === 모든구인회사 조회 ===
//	private void view_all_company_info() {
//		List<Company> companyList = super.getAllCompany();
//		if (!companyList.isEmpty()) {
//			companyList.forEach(company -> {
//				System.out.println(company.getInfo());
//			});
//			return;
//		}
//		System.out.println(">> 구인회사로 등록된 회사가 한개도 없습니다. <<\n");
//	}// end of private void view_all_company_info(CommonMember_abstract[]
//		// cmbr_arr)----------------
//
//	// 타이틀
//	private void title_gujikja() {
//		System.out.println(
//				"-".repeat(70) + "\n" + " 아이디   비밀번호       성명      생년월일       성별   현재만나이   가입일자 \n" + "-".repeat(70));
//	}// end of void title_gujikja()------------------------------
//
//	// 타이틀
//	private void title_company() {
//		System.out.println("-".repeat(50) + "\n" + " 회사명   업종  사업자등록번호  자본금 \n" + "-".repeat(50));
//	}// end of void title_company()------------------------------
//
//	// === 구인회사검색하기 ===
//	private void search_company(Scanner sc) {
//		List<Company> companyList = super.getAllCompany();
//		if (companyList.isEmpty()) {
//			System.out.println(">> 구인회사로 등록된 회사가 한개도 없습니다. <<\n");
//			return;
//		}
//		String str_menuno = "";
//		do {
//			System.out.println(">>> 구인회사 검색메뉴 <<<\n" + "1. 업종검색    2.자본금검색    3.구직자 전용메뉴로 돌아가기");
//			System.out.print("▷ 검색메뉴번호 입력 : ");
//			str_menuno = sc.nextLine();
//
//			switch (str_menuno) {
//			case "1": // 업종검색
//				search_jobtype_company(sc, companyList);
//				break;
//
//			case "2": // 자본금검색
//				search_seedmoney_company(sc, companyList);
//				break;
//
//			case "3": // 구직자 전용메뉴로 돌아가기
////
//				break;
//
//			default:
//				System.out.println(">>[경고] 구인회사 검색메뉴에 없는 번호 입니다.<< \n");
//				break;
//			}// end of switch (str_menuno)--------------------------------
//
//		} while (!"3".equals(str_menuno));
//
//	}// end of private void search_company(Scanner sc, CommonMember_abstract[]
//		// cmbr_arr)----------
//
//	// === 업종검색 === //
//	private void search_jobtype_company(Scanner sc, List<Company> companyList) {
//
//		System.out.print("▷ 업종명 : "); // "IT" "it" "It" "iT" " it " " i t "
//										// "제조업" "제조" " 제조 " "제 조 업"
//		String job_type_name = String.join("", sc.nextLine().toLowerCase().split("\\ "));
//		// "it" "제조업" "제조"
//
//		List<Company> searchList = companyList.stream()
//				.filter(company -> company.getJob_type().toLowerCase().contains(job_type_name)).toList();
//		if(!searchList.isEmpty()) {
//			StringBuilder sb = new StringBuilder();
//			searchList.forEach(company -> {
//				sb.append(company.getInfo() + "\n");
//			});
//			title_company();
//			System.out.println(sb.toString());
//			return;
//		}
//		System.out.println(">> 검색하시려는 " + job_type_name + "업종에 해당하는 회사는 없습니다.!!\n");
//	}// end of private void search_jobtype_company(Scanner sc, Company[]
//		// cp_arr)------
//
//	// === 자본금검색 ===
//	private void search_seedmoney_company(Scanner sc, List<Company> companyList) {
//
//		System.out.print("▷ 자본금 : "); // "500000000" ==> 정상
//										// "500,000,000" ==> 정상
//										// " 500000000" ==> 정상
//										// " 5 0 000000 0 " ==> 정상
//										// "50억" ==> 비정상
//
//		try {
//			long search_seed_money = Long.parseLong(String.join("", sc.nextLine().split("[, ]")));
//			
//			List<Company> searchList = companyList.stream()
//					.filter(company -> company.getSeed_money() >= search_seed_money).toList();
//			if(!searchList.isEmpty()) {
//				StringBuilder sb = new StringBuilder();
//				searchList.forEach(company -> {
//					sb.append(company.getInfo() + "\n");
//				});
//				title_company();
//				System.out.println(sb.toString());
//				return;
//			}
//			
//			System.out.println(">> 검색하시려는 자본금이 " + new DecimalFormat("#,###").format(search_seed_money)
//					+ "원 이상인 회사는 없습니다.!!\n");
//		} catch (NumberFormatException e) {
//			System.out.println(">>[경고] 자본금은 정수로만 입력하세요!!<<\n");
//		}
//
//	}// end of private void search_seedmoney_company(Scanner sc, Company[]
//		// cp_arr)------
//
//	// === 모든채용공고조회(현재 채용이 진행중인 것만 조회) ===
//	private void view_all_recruit_info() {
//		List<Recruit> recruitList = super.getAllRecruit();
//		if (RecruitImpl.count == 0) {
//			System.out.println(">> 채용공고가 1개도 없습니다.<<\n");
//		} else {
//			// 채용마감일자가 현재일보다 이전인 것이 몇개인지 알아오기
//			// 채용마감일자가 현재일과 같든지 또는 이후인 것을 알아오기
//
//			StringBuilder sb = new StringBuilder();
//
//			// === 날짜 비교하기 === //
//			/*
//			 * >> Date 클래스에서 제공하는 compareTo() 메소드 <<
//			 * 
//			 * date1.compareTo(date2);
//			 * 
//			 * date1 날짜와 date2 날짜가 동일하면 0을 반환하고, date1 날짜가 date2 날짜 보다 이전 날짜인 경우 -1을 반환하고,
//			 * 반대로 date1 날짜가 date2 날짜 보다 이후 날짜인 경우 경우 1을 반환한다.
//			 */
//			Date now = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
//			String str_now = sdf.format(now); // "20250408"
//
//			int cnt_before = 0; // 채용마감일자가 현재일 보다 이전인 경우의 개수 누적용도
//			for (int i = 0; i < RecruitImpl.count; i++) {
//
//				try {
//					now = sdf.parse(str_now);
//					Date finish_day = sdf.parse(rc_arr[i].getFinish_day());
//					int result = finish_day.compareTo(now);
//					// -1 ==> finish_day 가 now 보다 이전일 때
//					// 0 ==> finish_day 와 now 가 같을 때
//					// 1 ==> finish_day 가 now 보다 이후일 때
//					if (result == -1) { // 채용마감일자가 현재일 보다 이전인 경우
//						cnt_before++;
//					} else { // 채용마감일자가 현재일과 같거나 이후인 경우
//						sb.append(rc_arr[i].recruit_info() + "\n");
//					}
//				} catch (ParseException e) {
//				}
//
//			} // end of for---------------------
//
//			if (RecruitImpl.count == cnt_before) {
//				System.out.println(">> 현재 진행중인 채용공고가 1개도 없습니다.<<\n");
//			} else {
//				System.out.println(sb.toString());
//				System.out.println("[현재 진행중인 채용공고가 " + (RecruitImpl.count - cnt_before) + "건이 있습니다.]\n");
//			}
//		}
//
//	}// end of private void view_all_recruit_info(Recruit[] rc_arr)---------
//
//	// === 채용공고상세보기 ===
//	private void view_detail_one_recruit_info(Scanner sc, RecruitImpl[] rc_arr) {
//
//		if (RecruitImpl.count == 0) {
//			System.out.println(">> 채용공고가 1개도 없습니다.<<\n");
//		} else {
//			System.out.print("▷ 채용공고번호 : ");
//			String str_recruit_no = sc.nextLine(); // "1001" "1002" "1003" "1004"(없는것)
//													// "강아지"(없는것)
//			RecruitImpl rc = null;
//
//			Date now = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
//			String str_now = sdf.format(now); // "20250408"
//
//			try {
//				now = sdf.parse(str_now);
//
//				for (int i = 0; i < RecruitImpl.count; i++) {
//
//					Date finish_day = sdf.parse(rc_arr[i].getFinish_day());
//
//					if (!finish_day.before(now) && str_recruit_no.equals(String.valueOf(rc_arr[i].getRecruit_no()))) {
//						// int 를 String 타입으로 변경 ==> String.valueOf(int값)
//						rc = rc_arr[i];
//					}
//				} // end of for--------------------------
//
//			} catch (ParseException e) {
//			}
//
//			if (rc != null) {
//				System.out.println(rc.detail_recruit_info());
//			} else {
//				System.out.println(">> 조회하신 채용번호 " + str_recruit_no + "은 존재하지 않거나 채용이 마감된 공고번호 입니다.");
//			}
//
//		}
//
//	}// end of private void view_detail_one_recruit_info(Scanner sc, Recruit[]
//		// rc_arr)-----
//
//	// === 채용응모한것조회(채용마감일자가 오늘 포함 이후인것만 보여지도록 한다) ===
//	private void view_my_recruitApply(GujikjaImpl login_gu, RecruitApplyImpl[] rcApply_arr) {
//
//		String str_today = new SimpleDateFormat("yyyyMMdd").format(new Date());
//
//		StringBuilder sb = new StringBuilder();
//		boolean is_existence = false;
//
//		for (int i = 0; i < RecruitApplyImpl.count; i++) {
//
//			String finish_day = rcApply_arr[i].getRc().getFinish_day();
//
//			int n = MyUtil.dateCompareTo(finish_day, str_today);
//			// -1 , 0 , 1 , 2
//
//			if ((n == 0 || n == 1) && login_gu.getId().equals(rcApply_arr[i].getGu().getId())) {
//
//				is_existence = true;
//
//				sb.append("\n▣ 지원번호 : " + rcApply_arr[i].getRecruitApply_no() + "\n");
//				sb.append(rcApply_arr[i].getRc().detail_recruit_info());
//				sb.append("▣ 지원동기 : " + rcApply_arr[i].getApply_motive() + "\n");
//
//				String register_day = rcApply_arr[i].getRegister_day();
//				sb.append("▣ 지원일자 : " + register_day.substring(0, 4) + "-" + register_day.substring(4, 6) + "-"
//						+ register_day.substring(6) + "\n\n");
//			}
//
//		} // end of for----------------------
//
//		if (is_existence) {
//			System.out.println(sb.toString());
//		} else {
//			System.out.println(">> 현재 모집이 진행중인 채용공고에 응모한 내역이 없습니다. <<\n");
//		}
//
//	}// end of private void view_my_recruitApply(Gujikja login_gu, RecruitApply[]
//		// rcApply_arr)-------
//
//	// === 채용응모하기 ===
//	private void input_recruitApply(Scanner sc, GujikjaImpl login_gu, RecruitImpl[] rc_arr,
//			RecruitApplyImpl[] rcApply_arr) {
//
//		if (RecruitApplyImpl.count >= rcApply_arr.length) {
//			System.out.println(">> 구직응모 정원마감으로 더이상 구직응모가 불가합니다.!! <<\n");
//		} else {
//			// 채용마감일자가 오늘 포함 오늘 이후로 되어진 것만 응모해야 한다.
//
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//			String str_today = sdf.format(new Date());
//
//			StringBuilder sb = new StringBuilder();
//			DecimalFormat dcf = new DecimalFormat("#,###");
//
//			boolean is_existence = false;
//
//			int[] recruit_no_arr = new int[RecruitImpl.count]; // "채용공고순번" 만 저장하는 용도
//
//			for (int i = 0; i < RecruitImpl.count; i++) {
//
//				String finish_day = rc_arr[i].getFinish_day();
//
//				int n = MyUtil.dateCompareTo(finish_day, str_today);
//				// -1 , 0 , 1 , 2
//
//				if (n == 0 || n == 1) {
//					is_existence = true;
//
//					recruit_no_arr[i] = rc_arr[i].getRecruit_no(); // "채용공고순번" 저장시킴
//
//					finish_day = rc_arr[i].getFinish_day();
//
//					sb.append(rc_arr[i].getRecruit_no() + "\t" + rc_arr[i].getCp().getName() + "\t"
//							+ rc_arr[i].getSubject() + "\t" + rc_arr[i].getWork_type() + "\t\t" + rc_arr[i].getCnt()
//							+ "\t" + dcf.format(rc_arr[i].getYearpay()) + "만원\t" + finish_day.substring(0, 4) + "-"
//							+ finish_day.substring(4, 6) + "-" + finish_day.substring(6) + "\n");
//				}
//
//			} // end of for------------------------------------
//
//			if (is_existence) {
//				System.out.println("-".repeat(70));
//				System.out.println(" 채용공고번호  회사명   채용제목   채용분야(근무형태)  채용인원   연봉  채용마감일자");
//				System.out.println("-".repeat(70));
//
//				System.out.println(sb.toString());
//
//				System.out.print("▷ 응모하고자 하는 채용공고번호 : ");
//				// 엄정화 기준으로 보면 1001 --> 이미 응모한 번호
//				// 엄정화 기준으로 보면 1002 --> 응모가 가능한 번호
//				// 엄정화 기준으로 보면 1003 --> 이미 응모한 번호
//				// 9001 --> 존재하지 않는 번호
//				// 강아지
//				String str_recruit_no = sc.nextLine();
//
//				is_existence = false;
//				for (int i = 0; i < RecruitApplyImpl.count; i++) {
//
//					if (str_recruit_no.equals(String.valueOf(rcApply_arr[i].getRc().getRecruit_no()))) {
//						// 입력한 번호가 채용응모 저장소에 존재하는 것이라면
//						is_existence = true;
//
//						if (login_gu.getId().equals(rcApply_arr[i].getGu().getId())) {
//							// 입력한 번호가 채용응모 저장소에 존재하면서, 이미 응모한 번호 이라면
//							System.out.println(">>> 입력하신 채용공고번호 " + str_recruit_no + "번은 이미 응모하신 번호 입니다.<<<");
//							return;
//						}
//					}
//				} // end of for----------------------
//
//				// 입력한 번호가 채용응모 저장소에 존재하지 않는 것 이라면 (9001 강아지)
//				if (!is_existence) {
//					System.out.println(">>> 입력하신 채용공고번호 " + str_recruit_no + "번은 채용공고에 존재하지 않습니다.!!<<<\n");
//					return;
//				}
//
//				// 응모가능한 번호 이라면
//				RecruitApplyImpl rcapply = new RecruitApplyImpl();
//
//				do {
//					System.out.print("▷ 지원동기 : ");
//					rcapply.setApply_motive(sc.nextLine());
//				} while (!(rcapply.getApply_motive() != null));
//
//				/*
//				 * Recruit rc = null; for(int i=0; i<Recruit.count; i++) {
//				 * if(str_recruit_no.equals( String.valueOf(rc_arr[i].getRecruit_no()) ) ) { rc
//				 * = rc_arr[i]; break; } }// end of for-----------------
//				 * 
//				 * rcapply.setRc(rc);
//				 */
//				// 또는
//				for (int i = 0; i < RecruitImpl.count; i++) {
//					if (str_recruit_no.equals(String.valueOf(rc_arr[i].getRecruit_no()))) {
//						rcapply.setRc(rc_arr[i]);
//						break;
//					}
//				} // end of for-----------------
//
//				rcapply.setGu(login_gu);
//
//				rcApply_arr[RecruitApplyImpl.count++] = rcapply;
//				System.out.println(">>> 채용공고번호 " + str_recruit_no + "번에 응모 완료 했습니다.!!\n");
//
//			} else {
//				System.out.println(">> 현재 진행중인 채용공고는 없습니다.<<\n");
//			} // end of if~else----------------------------------
//
//		} // end of if~else-----------------------------------------
//
//	}// end of private void input_recruitApply(Scanner sc, Gujikja login_gu,
//		// Recruit[] rc_arr, RecruitApply[] rcApply_arr)--------
//
//	// === 채용응모한것 수정하기 ===
//	private void update_my_recruitApply(Scanner sc, GujikjaImpl login_gu, RecruitApplyImpl[] rcApply_arr) {
//
//		// 내가 응모한 내역을 보여주기
//		view_my_recruitApply(login_gu, rcApply_arr);
//
//		System.out.print("▷ 수정해야할 지원번호 : "); // 2001(엄정화꺼) 2004(엄정화꺼)
//												// 2002(이순신꺼) 2003(차은우꺼) 2005(이순신꺼)
//												// 3001(존재하지 않음)
//		String str_recruitApply_no = sc.nextLine();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		String str_today = sdf.format(new Date());
//
//		boolean is_exists_recruit_no = false;
//		boolean is_others_recruit_no = false;
//
//		for (int i = 0; i < RecruitApplyImpl.count; i++) {
//
//			if (str_recruitApply_no.equals(String.valueOf(rcApply_arr[i].getRecruitApply_no()))) {
//				is_exists_recruit_no = true;
//
//				if (login_gu.getId().equals(rcApply_arr[i].getGu().getId())) {
//
//					int n = MyUtil.dateCompareTo(rcApply_arr[i].getRc().getFinish_day(), str_today);
//					// -1, 0, 1, 2
//
//					if (!(n == 0 || n == 1)) {
//						System.out.println(">> 채용마감일자가 지난것이므로 수정이 불가합니다.!! <<\n");
//						return;
//					} else { // 채용마감일자가 오늘 이거나 내일 이후인 것
//						do {
//							System.out.print("▷ 지원동기 내용 : ");
//							rcApply_arr[i].setApply_motive(sc.nextLine());
//						} while (!(rcApply_arr[i].getApply_motive() != null));
//
//						System.out.println(">> 입사지원서중 지원동기 수정완료!! <<\n");
//						break; // for 문의 break; 이다.
//					}
//				}
//
//				else {
//					// 다른 구직자의 채용응모인 경우
//					is_others_recruit_no = true;
//				}
//
//			} // end of if-------------------
//
//		} // end of for----------------------
//
//		if (is_others_recruit_no) {
//			System.out.println(">> 수정하려고 하시는 지원번호 " + str_recruitApply_no + "번은 다른 구직자의 것이므로 수정이 불가합니다.<<\n");
//		}
//
//		if (!is_exists_recruit_no) {
//			System.out.println(">> 수정하려고 하시는 채용번호 " + str_recruitApply_no + "번은 존재하지 않습니다.<<\n");
//		}
//
//	}// end of private void update_my_recruitApply(Scanner sc, Gujikja login_gu,
//		// RecruitApply[] rcApply_arr)-------
//
//}
