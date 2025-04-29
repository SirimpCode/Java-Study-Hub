//package my.day18.collection.gujikja.controller;
//
//import java.util.List;
//import java.util.Scanner;
//
//import my.day18.collection.gujikja.GujikjaCompanyMain;
//import my.day18.collection.gujikja.repository.CommonMember;
//import my.day18.collection.gujikja.repository.Company;
//import my.day18.collection.gujikja.repository.Gujikja;
//import my.day18.collection.gujikja.repository.Repository;
//
//public abstract class CommonController  {
//	private Repository repo;
//	private boolean isCompany = false;
//	protected Repository getRepo() {
//		return repo;
//	}
//	
//	protected List<Company> getAllCompany() {
//		return repo.getMbrList().stream()
//				.filter(m -> m instanceof Company)
//				.map(m -> (Company)m)
//				.toList();
//	}
//	protected List<Gujikja> getAllGujikja() {
//		return repo.getMbrList().stream()
//				.filter(m -> m instanceof Gujikja)
//				.map(m -> (Gujikja)m)
//				.toList();
//	}
//	
//	
//	public CommonController(Repository repo, boolean isCompany) {
//		this.repo = repo;
//	}
//	// == 구직자(Gujikja) 객체와 기업회원(Company) 객체를 
//	   //     List<CommonMember> mbr_list 및 Map<String, CommonMember> mbr_map 에 저장시키는 
//	   //    static 메소드 == // 
//	
//	protected CommonMember findById(String id) {
//		return this.repo.getMbrList().stream()
//				.filter(m -> this.isCompany ? m instanceof Company : m instanceof Gujikja && m.getId().equals(id))
//				.findAny().orElse(null);
//	};
//	protected boolean existsId(String id) {
//		return this.repo.getMbrList().stream()
//				.filter(m -> this.isCompany ? m instanceof Company : m instanceof Gujikja && m.getId().equals(id))
//				.findAny().isPresent();
//	};
//	public CommonMember login(Scanner sc) {
//
//		System.out.print(isCompany ? "▷ 구인회사 ID :" : "▷ 구직자 ID :");
//		String id = sc.nextLine();
//
//		System.out.print("▷ 비밀번호 :");
//		String passwd = sc.nextLine();
//		
//		CommonMember mbr = findById(id);
//		if(mbr != null && mbr.getPasswd().equals(passwd))
//			return mbr;
//		return null;
//	}
//	
//	public void addMember(CommonMember mbr) {
//		// 아이디 중복체크하기
//		if(existsId(mbr.getId())) {
//			System.out.println(mbr.getName()+"님 "+(mbr instanceof Gujikja ? "구직자" : "기업회원")+" 가입 실패 아이디 중복입니다.");
//			return;
//		}
//		// 구직자 또는 기업회원 객체를 List<CommonMember> mbr_list 에 추가하기
//		if(mbr.allNotNull()) {
//			this.repo.getMbrList().add(mbr);
//			System.out.println(mbr.getName()+"님 "+(mbr instanceof Gujikja ? "구직자" : "기업회원") + " 회원으로 등록되었습니다.");
//			return;
//		}
//		System.out.println(mbr.getName()+"님 "+(mbr instanceof Gujikja ? "구직자" : "기업회원")+" 가입 실패 정보가 모두 입력되지 않았습니다.");
//	}// end of static void addMember(CommonMember mbr)---------------------
//	
//	
//	protected abstract CommonMember etcInfoSetByRegister(Scanner sc, CommonMember mbr);
//	
//	public void register(Scanner sc) {
//		CommonMember mbr = this.isCompany ? new Company() : new Gujikja();
//		outer: do {
//			System.out.print("1.아이디 : ");
//			String id = sc.nextLine();
//
//			if(existsId(id)) {
//				System.out.println(">> 이미 사용중인 아이디 이므로 다른 아이디값을 입력하세요!! <<\n");
//				continue outer;
//			}
//
//			mbr.setId(id);
//
//		} while (!(mbr.getId() != null));
//		// end of do~while------------------------
//
//		// 비밀번호는 필수 입력사항이면서 비밀번호 조건에 맞을때 까지 반복해야 한다.
//		do {
//			System.out.print("2.비밀번호 : ");
//			String passwd = sc.nextLine();
//
//			mbr.setPasswd(passwd);
//
//		} while (!(mbr.getPasswd() != null));
//		// end of do~while------------------------
//
//		// 회사명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
//		// 회사명은 공백없이 2글자 이상 6글자 이하의 한글로만 되어져야 한다.
//		do {
//			System.out.print(mbr instanceof Company ? "3.회사명 : " : "3.성명 : ");
//			String name = sc.nextLine();
//
//			mbr.setName(name);
//
//		} while (!(mbr.getName() != null));
//		etcInfoSetByRegister(sc, mbr);
//		this.addMember(mbr);
//		System.out.println(">> "+(isCompany?"구인회사":"구직자")+" 회원가입 성공!! <<\n");
//		
//	}
//	
//	
//	
//	
//	// == 시작화면(메인 메뉴)를 보여주는 메소드 생성하기 == //
//	public static void main_menu() {
//		System.out.println("\n === 메인메뉴 ===\n"
//		                + "1.구직자 회원가입   2.구인회사 회원가입   3.구직자 로그인   4.구인회사 로그인\n"
//		                + "5.프로그램 종료\n");  
//		System.out.print("▷ 메뉴번호 선택 : ");
//	}// end of void main_menu()---------------------
//	
//	
//	
//	
//
//	
//}
