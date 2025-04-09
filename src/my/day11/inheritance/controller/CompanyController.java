package my.day11.inheritance.controller;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.management.InstanceNotFoundException;
import javax.management.RuntimeErrorException;
import javax.management.relation.RelationNotFoundException;

import my.day01.MyUtil;
import my.day11.inheritance.user.RequestJoined;
import my.day11.inheritance.user.company.Company;
import my.day11.inheritance.user.company.Company.CompanyFieldEnum;
import my.day11.inheritance.user.company.RecruitPost;
import my.day11.inheritance.user.jobseeker.JobSeeker;
import my.day11.inheritance.user.jobseeker.JobSeeker.UserFieldEnum;

public class CompanyController {
	// 구인회사 회원가입

	private List<Company> companyList = new ArrayList<>();
	private List<RecruitPost> postList = new ArrayList<>();
	
	
	public List<Company> getCompanyList (){
		return this.companyList;
	}
	
	public CompanyController() {
		companyList.addAll( createDefaultCompany() );
		postList.addAll( createDefaultCompany( this.companyList ) );
	}
	private List<RecruitPost> createDefaultCompany(List<Company> comp){
		RecruitPost rp1 = RecruitPost.fromBuilder()
				.company(comp.get(0))
				.title("아무나 다뽑습니다.")
				.workType("정규직")
				.cnt(5)
				.salGrade(3000)
				.finishDay("20250427")
				.build();
		RecruitPost rp2 = RecruitPost.fromBuilder()
				.company(comp.get(1))
				.title("대기업 들어올 사람")
				.workType("정규직")
				.cnt(3)
				.salGrade(5000)
				.finishDay("20250522")
				.build();
		RecruitPost rp3 = RecruitPost.fromBuilder()
				.company(comp.get(2))
				.title("채용공고 제목이야")
				.workType("계약직")
				.cnt(10)
				.salGrade(2000)
				.finishDay("20250827")
				.build();
		RecruitPost rp4 = RecruitPost.fromBuilder()
				.company(comp.get(2))
				.title("마감기한 지났져")
				.workType("계약직")
				.cnt(10)
				.salGrade(2000)
				.finishDay("20240827")
				.build();
		RecruitPost rp5 = RecruitPost.fromBuilder()
				.company(comp.get(0))
				.title("아무나 다뽑습니다.길게작성해보기")
				.workType("정규직")
				.cnt(5)
				.salGrade(3000)
				.finishDay("20250727")
				.build();
		return List.of(rp1,rp2,rp3,rp4,rp5);
	}
	
	private List<Company> createDefaultCompany(){
		Company comp1 = Company.builder()
				.withId("comp1")
				.withName("서브마스")
				.withPassword("12341234a!")
				.businessNum("1200520005")
				.seedMoney(1000000000L)
				.jobType("서비스업")
				.build();
		Company comp2 = Company.builder()
				.withId("comp2")
				.withName("켄싱턴호텔")
				.withPassword("12341234a!")
				.businessNum("1345526005")
				.seedMoney(6000000000L)
				.jobType("서비스업")
				.build();
		
		Company comp3 = Company.builder()
				.withId("comp3")
				.withName("빕스")
				.withPassword("12341234a!")
				.businessNum("1230531005")
				.seedMoney(700000000L)
				.jobType("서비스업")
				.build();
		return List.of(comp1,comp2,comp3);
	}
	
	//구인회사검색
	public void searchCompany(Scanner sc) {
		while(true) {
			if(companyList.isEmpty()) {
				System.out.println("가입된 구인회사가 없습니다."); return;
			}
			System.out.println("1.업종타입 검색\t2.회사명 검색\t3.아이디 검색\t4.자본금 검색\t5.이전 메뉴로 돌아가기");
			String select = sc.nextLine().trim();
			switch(select) {
				case "1" : searchCompanyByJobType(sc); break;
				case "2" : searchCompanyByName(sc); break;
				case "3" : searchCompanyById(sc); break;
				case "4" : searchCompanyBySeedMoney(sc); break;
				case "5" : return;
				default : System.out.println("잘못 입력됨 1 부터 5 중에 입력 해주세요.");
			}
		}
		
		
	}
	public void printPostInfo(List<RecruitPost> posts) {
		printPostInfoGuide();
		posts.stream().forEach(post->System.out.println(post.getPostInfo()));
		printEndGuide();
	}
	
	private void printCompanyInfo(List<Company> cl) {
		printCompanyInfoGuide();
		cl.stream().forEach(c->System.out.println(c.getMyInfo(true)));
		printEndGuide();
	}
	private void searchCompanyBySeedMoney(Scanner sc) {
		System.out.println("얼마 이상의 자본금을 보유한 회사를 검색할지 입력해주세요.");
		String input = inputRepeat(sc,CompanyFieldEnum.SEED_MONEY, false);
		long seedMoney = Long.parseLong(input);
		List<Company> resultList = findCompanyBySeedMoney(seedMoney);
		
		if( !resultList.isEmpty() ) printCompanyInfo(resultList);
		else System.out.println("["+new DecimalFormat("#,###").format(seedMoney)+"원] 이상의 자본금을 보유한 회사가 없습니다.");
	}
	
	private void searchCompanyByName(Scanner sc) {
		System.out.println("검색어에 포함될 회사명을 공백 없이 한글로만 입력해주세요.");
		String input = inputRepeat(sc, CompanyFieldEnum.NAME, false);
		List<Company> resultList = findCompanyByName(input);
		
		if( !resultList.isEmpty() ) printCompanyInfo(resultList);
		else System.out.println("회사명에 ["+input+"] 이 포함된 회사가 없습니다.");
	}
	private void searchCompanyByJobType(Scanner sc) {
		System.out.println("검색어에 포함될 업종명을 공백 없이 한글로만 입력해주세요.");
		String input = inputRepeat(sc, CompanyFieldEnum.JOB_TYPE, false);
		String jobType =  String.join("", input.toUpperCase().split("\\ "));//공백제거 대문자변경
		List<Company> resultList = findCompanyByJobType(jobType);
		
		if( !resultList.isEmpty() ) printCompanyInfo(resultList);
		else System.out.println("["+jobType+"] 업종의 회사가 없습니다.");
	}
	private List<Company> findCompanyByName(String name){
		System.out.println("회사명에 ["+name+"] 이 포함된 회사를 검색합니다.");
		return companyList.stream().filter(cl->cl.getName().contains(name)).toList();
	}
	
	private List<Company> findCompanyByJobType(String jobType) {
		System.out.println("["+jobType+"] 관련 업종의 회사를 검색 합니다.");
		return companyList.stream().filter((cl)->cl.getJobType().contains(jobType)).toList();
	}
	private List<Company> findCompanyBySeedMoney(long seedMoney){
		System.out.println("["+new DecimalFormat("#,###").format(seedMoney)+"원] 이상의 자본금을 보유한 회사를 검색합니다.");
		return companyList.stream().filter((cl)->cl.getSeedMoney()>=seedMoney).toList();
	}

		//구인회사전용메뉴
	public void loginLogic(Scanner sc, Company loginUser, JobSeekerController jsc) {
		
		main:
		while(true) {
			
			loginMenu(loginUser.getName());
			String select = sc.nextLine().trim();
			
			
			switch(select.trim()) {
				case "1": //회사 정보 보기
					System.out.println(">> "+loginUser.getName()+" 의 정보");
					printCompanyInfoGuide();
					System.out.println(loginUser.getMyInfo(false));
					printEndGuide();
					break;
				case "2":  //회사 정보 수정 비번, 회사명 , 사업자번호, 직종, 자본금
					modifyMyInfo(loginUser,sc);
					break;
				case "3": // 모든구직자 조회
					jsc.printAllUserInfo();
					break;
				
				case "4" ://구직자 검색 하기
					jsc.searchJobSeeker(sc);
					break;
				case "5" ://채용공고입력하기
					createRecruitPost(sc,loginUser);
					break;
				case "6" ://우리회사 채용공고 조회
					searchMyCompanyPost(sc, loginUser);
					break;
				case "7" ://우리회사 채용공고 지원자 조회
					RecruitPost rp = selectMyPost(loginUser,sc);
					jsc.searchMyCompanyJoinUser(rp);
					break;
				case "8": 
					break main; //로그아웃
				
				default : System.out.println("잘못 입력됨 1 부터 10 중 입력하세요.");
			}
		}
			
	}
		
	
	
	private RecruitPost selectMyPost(Company loginUser, Scanner sc) {
		List<RecruitPost> myPosts =  findPostByCompany(loginUser);
		printPostInfo(myPosts);
		while(true) {
			System.out.println("지원자를 조회할 채용공고 아이디를 입력해주세요.");
			int postId = getPostIdRepeat(sc);
			Optional<RecruitPost> opRp = myPosts.stream().filter((rp)-> rp.getPostId() == postId).findFirst();
			if(opRp.isPresent()) return opRp.get();
			System.out.println("위 목록에 있는 채용공고 아이디를 입력해주세요.");
			continue;
		}
	}

	

	//구인회사 로그인
	public Company login(Scanner sc) {
		String id = inputRepeat(sc,Company.CompanyFieldEnum.ID,false);
		String password = inputRepeat(sc,Company.CompanyFieldEnum.PASSWORD,false);
		Optional<Company> userOp = findCompanyById(id);
		if(userOp.isEmpty()) {
			System.out.println("해당 아이디로 가입된 구인회사가 없습니다.");
			return null;
		}
		Company user = userOp.get();
		if(!user.getPassword().equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return null;
		}
		return user;
	}
		
	//구인회사 전용메뉴
	private void loginMenu(String name) {
		System.out.println("\n"+"=".repeat(30)+" 구인회사메뉴 "+name+" 로그인중 "+"=".repeat(30)+"\n"
				+ "1.회사 정보 보기   2.회사 정보 수정   3.모든구직자 조회   4.구직자검색하기\n"
                + "5.채용공고입력하기   6.우리회사 채용공고 조회   7.우리회사 채용공고 지원자 조회   8.로그아웃\n"
				);
		System.out.print("👉🏻 메뉴번호 선택 : ");
			
	}
	
	

	//메인메뉴 출력
//	public void mainMenu() {
//		System.out.println("\n"+"=".repeat(40)+" 메인메뉴 "+"=".repeat(40)+"\n"
//				+ "1. 구인회사 회원가입\t\t2.구인회사 모두보기\t\t3.검색하기"+"\t\t4.탈퇴하기"+"\n\t\t\t\t5.프로그램 종료\n"
//				);
//		System.out.print("👉🏻 메뉴번호 선택 : ");
//		
//	}

	//회원 가입
	public void signUp(Scanner sc) {
		if (companyList.size()==10) {
			System.out.println("정원이 가득 차 가입이 불가능 합니다.");
			return;
		}
			
		String id = inputRepeat(sc, Company.CompanyFieldEnum.ID , true);
		String password = inputRepeat(sc, Company.CompanyFieldEnum.PASSWORD,true);
		String name = inputRepeat(sc, Company.CompanyFieldEnum.NAME,true);
		String businessNum = inputRepeat(sc, Company.CompanyFieldEnum.BUSINESS_NUM,true);
		String seedStr = inputRepeat(sc, Company.CompanyFieldEnum.SEED_MONEY, true);
		
		
		
		companyList.add(
				Company.builder()
					.withId(id)
					.withPassword(password)
					.businessNum(businessNum)
					.withName(name)
					.seedMoney(Integer.parseInt(seedStr))
					.build()
		);
		System.out.println("구인 회사 회원가입 완료 [ "+ name + " ] 환영합니다.");
	}
	
	//내정보수정
		private void modifyMyInfo(Company loginUser, Scanner sc) {
			

			printCompanyInfoGuide();
			System.out.println(loginUser.getMyInfo(false));
			printEndGuide();
			
			Company originalUser = Company.builder()
					.withId(loginUser.getId())
					.withName(loginUser.getName())
					.withPassword(loginUser.getPassword())
					.businessNum(loginUser.getBusinessNum())
					.jobType(loginUser.getJobType())
					.seedMoney(loginUser.getSeedMoney())
					.build();
			
			main:
			while(true) {
				

				System.out.println("\n"+"=".repeat(30)+" 수정할 정보를 선택해 주세요. "+"=".repeat(30)+"\n"
						+ "1.아이디\t\t2.비밀번호\t\t3.회사명\t\t4.사업자등록번호\n5.직종타입\t\t6.자본금\t\t7.수정저장\t\t8.취소및뒤로가기"
						);
				System.out.print("👉🏻 메뉴번호 선택 : ");
				String select = sc.nextLine().strip();
				switch(select) {
				case "1": 
					String beforeId = loginUser.getId();
					String modifyId = inputRepeat(sc, CompanyFieldEnum.ID, true);
					if(beforeId.equals(modifyId)) {
						System.out.println("입력한 아이디가 기존의 아이디와 동일합니다.");
						break;
					}
					
					loginUser.setId(modifyId);
					System.out.println("아이디 수정 성공 "+beforeId+"를 "+loginUser.getId()+"로 수정하였습니다.");
					break;
				case "2":
					String beforePw = loginUser.getPassword();
					String modifyPw = inputRepeat(sc, CompanyFieldEnum.PASSWORD, true);
					if(beforePw.equals(modifyPw)) {
						System.out.println("입력한 비밀번호가 기존의 비밀번호와 동일합니다.");
						break;
					}
					
					loginUser.setPassword(modifyPw);
					System.out.println("비밀번호 수정 성공 "+beforePw+"를 "+loginUser.getPassword()+"로 수정하였습니다.");
					break;
				case "3": 
					String beforeName = loginUser.getName();
					String modifyName = inputRepeat(sc, CompanyFieldEnum.NAME, true);
					if(beforeName.equals(modifyName)) {
						System.out.println("입력한 이름이 기존의 이름과 동일합니다.");
						break;
					}
					loginUser.setName(modifyName);
					System.out.println("이름 수정 성공 "+beforeName+"를 "+loginUser.getName()+"로 수정하였습니다.");
					break;
				case "4":
					String beforeNum = loginUser.getBusinessNum();
					String modifyNum = inputRepeat(sc,CompanyFieldEnum.BUSINESS_NUM, true);
					if(beforeNum.equals(modifyNum)) {
						System.out.println("입력한 사업자 등록번호가 기존과 동일합니다.");
						break;
					}
					loginUser.setBusinessNum(modifyNum);
					System.out.println("사업자등록번호 수정 성공 : "+beforeNum+"를 "+loginUser.getBusinessNum()+"로 수정 하였습니다");
					break;
				case "5":
					String beforeJob = loginUser.getJobType();
					String modifyJob = inputRepeat(sc, CompanyFieldEnum.JOB_TYPE, true);
					if(beforeJob.equals(modifyJob)) {
						System.out.println("입력한 직종 타입이 기존과 동일합니다.");
						break;
					}
					loginUser.setJobType(modifyJob);
					System.out.println("직종 수정 성공 : "+beforeJob+"을 "+loginUser.getJobType()+"으로 수정 하였습니다.");
					break;
				case "6":
					long beforeMoney = loginUser.getSeedMoney();
					String modifyMoneyStr = inputRepeat(sc,CompanyFieldEnum.SEED_MONEY, true);
					long modifyMoney = Long.parseLong(modifyMoneyStr);
					if(beforeMoney == modifyMoney) {
						System.out.println("입력한 자본금이 기존과 동일합니다.");
						break;
					}
					loginUser.setSeedMoney(modifyMoney);
					System.out.println("자본금 수정 성공 : "+new DecimalFormat("#,###").format(beforeMoney)+"원 에서 "+loginUser.parsingSeedMoney()+"원으로 수정하였습니다.");
					break;
				case "7":
					System.out.println("수정 내역을 저장 합니다.");
					break main;
				case "8": 
					System.out.println("수정 내역을 취소 합니다.");
					loginUser.setId(originalUser.getId());
					loginUser.setName(originalUser.getName());
					loginUser.setPassword(originalUser.getPassword());
					loginUser.setJobType(originalUser.getJobType());
					loginUser.setBusinessNum(originalUser.getBusinessNum());
					loginUser.setSeedMoney(originalUser.getSeedMoney());
					break main;
				default : System.out.println("잘못입력됨 1 부터 8 중에 입력해주세요.");
				}
			}
		}
		
	
	
	
	//유저의 입력을 반복 시켜주기 위한 메서드
	private String inputRepeat(Scanner sc, Company.CompanyFieldEnum iv, boolean isSignUp) {
		return switch(iv) {
			case ID -> {
				while(true) {
					System.out.print("아이디 : ");
					try {
						yield validId(sc.nextLine().strip(), isSignUp);
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case PASSWORD -> {
				while(true) {
					System.out.print("패스워드 : ");
					try {
						yield validPassword(sc.nextLine().strip(), isSignUp);
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case NAME -> {
				while(true) {
					System.out.print("회사명 : ");
					try {
						yield validName(sc.nextLine().strip());
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case BUSINESS_NUM -> {
				while(true) {
					System.out.print("사업자 등록번호 : ");
					try {
						yield validBusiNum(sc.nextLine().strip());
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case JOB_TYPE ->{
				while(true) {
					System.out.print("회사 직종 : ");
					try {
						yield validName(sc.nextLine().strip());
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case SEED_MONEY -> {
				while(true) {
					System.out.print("자본금 : ");
					try {
						yield validSeedMoney(sc.nextLine().trim());
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
		};
	}
	
	
	
	private String validBusiNum(String pk) {
		if(!pk.matches("^[1-9][0-9]{9}$"))
			throw new RuntimeException("사업자 등록번호 유효성 검사 실패 => 0이 아닌 숫자로 시작하며 총 10자리의 숫자로 구성되어야합니다.");
		return pk;			
	}
	private String validSeedMoney(String seedMoney) {
		seedMoney = String.join("", seedMoney.split("\\,"));
		try {
			if(Long.parseLong(seedMoney)<=0)
				throw new RuntimeException("자본금은 0보다 커야 합니다.");
		}catch(NumberFormatException e) {
			throw new RuntimeException("숫자만 입력해주세요");
		}
		return seedMoney;
		
	}

	private String validName(String name) {
		if(name.length()<2||name.length()>8)
			throw new StringIndexOutOfBoundsException("2자 이상 8자 이하여야 합니다.");
		for(char ch : name.toCharArray()) {
			if(ch>='가'&&ch<='힣') continue;
			throw new IllegalArgumentException("한글로만 작성해주세요.");
		}
		
		return name;
	}

	private String validPassword(String pw, boolean isSignUp) {
		if(pw.isBlank()||pw.contains(" "))
			throw new IllegalArgumentException("비밀번호에는 공백이 들어갈 수 없습니다.");
		if(isSignUp&&!pw.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).{8,16}$"))
			throw new StringIndexOutOfBoundsException("비밀번호는 8자 이상 16자 이하 영문, 숫자, 특수문자 조합이어야 합니다.");
		return pw;
	}

	
	private String validId(String id, boolean isSignUp) {
		
		if(id.isBlank())
			throw new IllegalArgumentException("아이디를 입력해주세요.");
		
		char firstStr = id.charAt(0);
		if(!(firstStr>='a'&&firstStr<='z'))
			throw new StringIndexOutOfBoundsException("아이디의 첫글자는 소문자로 시작하여야 합니다.");
		if(id.length()<4||id.length()>8)
			throw new StringIndexOutOfBoundsException("아이디는 4자 이상 8자 이하여야 합니다.");
		if(existUserId(id) && isSignUp)
			throw new DuplicateFormatFlagsException("이미 사용중인 아이디 입니다.");
		
		
		for(char ch : id.toCharArray()) {
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9'))
				continue;
			throw new IllegalArgumentException("아이디는 영문자 대문자, 소문자 또는 숫자로만 구성되야 합니다.");
		}
		return id;
	}
	
	
	public void printAllCompanyInfo() {
		
		if(companyList.isEmpty()) {
			System.out.println("가입된 구인회사가 없습니다.");
			return;
		}
		System.out.println("=".repeat(40)+" 모든 회사 조회 결과 "+"=".repeat(40));
		printCompanyInfoGuide();
		companyList.stream().forEach(
				cl-> System.out.println(cl.getMyInfo(true))
		);
		printEndGuide();
	}
	public void printAllPostInfo(Scanner sc) {
		
		if(postList.isEmpty()) {
			System.out.println("존재하는 채용공고가 없습니다.");
			return;
		}
		System.out.println("결과에 마감 기한이 지난 게시물을 포함 시킬지 선택 해주세요.");
		boolean isBefore = userSelectYesOrNo(sc);
				
		if(!isBefore) System.out.println("채용 마감 기한이 지난 게시물을 제외한 게시물을 조회합니다.");
		else System.out.println("모든 게시물을 조회합니다.");
		
		List<RecruitPost> validList = isBefore ? this.postList : getValidPost();
		if(validList.isEmpty()) {
			System.out.println("진행중인 채용 공고가 없습니다."); return;
		}
		
		System.out.println("=".repeat(40)+" 채용 공고 조회 결과 "+"=".repeat(40));
		System.out.println("조회된 게시물 : " + validList.size() + "개"+(!isBefore?"　　　　　기간이 지난 게시물 : " + (postList.size()-validList.size())+"개":""));
		
		printPostInfo(validList);
	}
	private List<RecruitPost> getValidPost(){
		return postList.stream().filter(p->
			LocalDate.parse(p.getFinishDay()).plusDays(1).isAfter(LocalDate.now())).toList();
	}
	private void printPostInfoGuide() {
		System.out.println("-".repeat(112));
		System.out.println("게시물번호\t제목\t\t\t\t회사명\t채용방식\t채용인원\t연봉\t마감일\t\t등록일");
		System.out.println("-".repeat(112));
	}
	private void printCompanyInfoGuide() {
		System.out.println("-".repeat(112));
		System.out.println("아이디\t비밀번호\t\t회사명\t\t사업자등록번호\t\t직종타입\t자본금\t\t가입날짜");
		System.out.println("-".repeat(112));
	}
	private void printEndGuide() {
		System.out.println("-".repeat(112));
	}

	private boolean existUserId(String id) {
		return companyList.stream().filter(js-> js.getId().equals(id))
				.findFirst().isPresent();
	}
	private void searchCompanyById(Scanner sc) {
		
		System.out.println("구인회사의 고유 아이디를 입력해주세요.");
		String input = inputRepeat(sc, CompanyFieldEnum.ID, false);

		System.out.println("["+input+"] 아이디의 회사를 검색합니다.");
		Optional<Company> result= findCompanyById(input);
		
		if( result.isPresent() ) printCompanyInfo(List.of(result.get()));
		else System.out.println("구인회사 아이디 ["+input+"] 로 검색된 회사가 없습니다.");
	}
	
	private Optional<Company> findCompanyById(String id) {
		return companyList.stream().filter(js->js.getId().equals(id))
				.findFirst();
	}

	public void withdrawUser(Scanner sc) {
		String id = inputRepeat(sc,Company.CompanyFieldEnum.ID,false);
		String password = inputRepeat(sc,Company.CompanyFieldEnum.PASSWORD,false);
		Optional<Company> userOp = findCompanyById(id);
		if(userOp.isEmpty()) {
			System.out.println("해당 아이디로 가입된 유저가 없습니다.");
			return;
		}
		Company user = userOp.get();
		if(!user.getPassword().equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		if(companyList.remove(user))
			System.out.println("유저 탈퇴 성공");;
		
	}
	
	
	
	
	//채용공고
	private List<RecruitPost> findPostByCompany(Company company){
		return postList.stream().filter(p->p.getCompany().equals(company)).toList();
	}
	private void searchMyCompanyPost(Scanner sc, Company loginUser) {
		System.out.println("우리 회사 정보로 게시물을 조회 합니다.");
		List<RecruitPost> myPost = findPostByCompany(loginUser);
		if(myPost.isEmpty()) {
			System.out.println("우리 회사의 작성된 채용 공고가 없습니다.");
			return;
		}
		printPostInfo(myPost);
	}


	private void createRecruitPost(Scanner sc, Company loginUser) {
		System.out.println("=".repeat(10)+" "+loginUser.getName()+" 채용공고 등록 "+"=".repeat(10));
		
		System.out.println("4자 ~ 20자 사이의 게시물 제목을 입력해주세요.");
		String title = getTitleRepeat(sc);
		System.out.println("2자 ~ 10자 사이의 근무 형태를 입력해주세요.");
		String workType= getWorkTypeRepeat(sc);
		System.out.println("1명 이상의 채용 인원을 입력해주세요.");
		int cnt = getCntRepeat(sc);
		System.out.println("1000 ~ 90000 사이의 연봉을 입력해주세요. (만원 단위)");
		int salGrade = getSalGradeRepeat(sc);
		System.out.println("마감일을 yyyyMMdd 형식으로 입력해주세요. ex) 20250101");
		String finishDay = getFinishDayRepeat(sc);
		
		RecruitPost newPost = RecruitPost.fromBuilder()
				.company(loginUser)
				.title(title)
				.workType(workType)
				.cnt(cnt)
				.salGrade(salGrade)
				.finishDay(finishDay)
				.build();
		postList.add(newPost);
		System.out.println("성공적으로 채용 공고 게시물을 생성하였습니다.");
	}
	private int getPostIdRepeat(Scanner sc) {
		while(true) {
			System.out.print("게시물 번호 : ");
			String input = sc.nextLine();
			if(input.matches("^[1-9][0-9]{3}$")) return Integer.parseInt(input);
			System.out.println("0이 아닌 숫자로 시작하는 4자리의 숫자를 입력해주세요.");
		}
	}

	public void searchPostDetails(Scanner sc) {
		System.out.println("조회할 게시물 번호 숫자 네자리를 입력하세요.");
		int postId = getPostIdRepeat(sc);
		Optional<RecruitPost> postOp = findPostById(postId);
		if(postOp.isPresent()) {
			printPostDetails(postOp.get());
			return;
		}
		System.out.println("게시물 번호가 ["+postId+"] 인 게시물이 없습니다.");
	}
	public Optional<RecruitPost> findPostById(int postId){
		return postList.stream().filter(p->p.getPostId()==postId).findFirst();
	}
	private String getTitleRepeat(Scanner sc) {
		while(true) {
			System.out.println("게시물 제목 : ");
			String input = sc.nextLine().strip();
			if(input.length()<=20&&input.length()>=4) return input; 
			System.out.println("게시물 제목은 4자 이상 20자 이하여야합니다.");	
		}
	}
	private String getWorkTypeRepeat(Scanner sc) {
		while(true) {
			System.out.println("근무형태 : ");
			String input = sc.nextLine().strip();
			if(input.length()<=10&&input.length()>=2) return input; 
			System.out.println("근무형태는 2자 이상 10자 이하여야합니다.");	
		}
	}
	private int getCntRepeat(Scanner sc) {
		while(true) {
			System.out.println("채용인원 : ");
			String input = sc.nextLine().strip();
			try {
				int cnt = Integer.parseInt(input);
				if(cnt>0) return cnt;
			}catch(NumberFormatException e){
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			System.out.println("채용인원은 0명 초과여야 합니다.");	
		}
	}
	private int getSalGradeRepeat(Scanner sc) {
		while(true) {
			System.out.println("연봉 : ");
			String input = sc.nextLine();
			try {
				int pay = Integer.parseInt(String.join("",input.split("[ ,]")));
				if(pay>=1000&&pay<=90000) return pay;
			}catch(NumberFormatException e){
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			System.out.println("연봉은 1000 이상 90000 이하로 입력해주세요.");	
		}
	}
	
	private String getFinishDayRepeat(Scanner sc) {
		while(true) {
			System.out.println("마감일 : ");
			String input = sc.nextLine().strip();
			if(input.length()==8&&input.matches("^[2][0-9]{7}$")) {
				String year = input.substring(0,4);
				String month = input.substring(4,6);
				String day = input.substring(6,8);				
				try {
					LocalDate finishDay = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
					if(finishDay.isAfter(LocalDate.now())) return input;
					System.out.println("오늘 이후의 날짜를 입력해주세요.");
					continue;
				}catch(DateTimeException e) {
					System.out.println("존재 하지 않는 날짜 입니다.");
					continue;
				}
			}
			System.out.println("2로 시작하는 8자리의 숫자만 입력해주세요. ex)20250508");	
		}
	}
	private void printPostDetails(RecruitPost post) {
		StringBuilder sb = new StringBuilder();
		sb.append("=".repeat(50)+"\n");
		//채용 번호 채용제목 분야 인원 연봉 등록일자 채용마감일자 회사명 업종 자본금
		sb.append("1. 게시물번호 : "+post.getPostId()+"\n");
		sb.append("2. 제목 : "+post.getTitle()+"\n");
		sb.append("3. 근무형태 : "+post.getWorkType()+"\n");
		sb.append("4. 채용인원 : "+post.getCnt()+"명\n");
		sb.append("5. 연봉 : "+post.getSalGrade()+"만원\n");
		sb.append("6. 마감일 : "+post.getFinishDay()+"\n");
		sb.append("7. 등록일 : "+post.getCreatedAt()+"\n");
		sb.append("8. 회사명 : "+post.getCompany().getName()+"\n");
		sb.append("9. 업종 : "+post.getCompany().getJobType()+"\n");
		sb.append("10. 자본금 : "+new DecimalFormat("#,###").format(post.getCompany().getSeedMoney())+"원");
		System.out.print(sb);
	}
	private boolean userSelectYesOrNo(Scanner sc) {
		while(true) {
			System.out.print("yes 또는 no 를 입력해주세요 : ");
			String input = sc.nextLine();
			switch(input.toUpperCase()) {
				case "YES" : return true;
				case "NO" : return false;
				default : 
					System.out.println("잘못 입력 됐습니다.");
					continue;	
			}
		}
	}
	public RequestJoined userJoinCompany(Scanner sc, JobSeeker loginUser)  {
		int postId = getPostIdRepeat(sc);
		RecruitPost post = findPostById(postId)
				.orElseThrow(()->new RuntimeException("["+postId+"] 번호의 채용 공고가 존재하지 않습니다."));
		if(LocalDate.now().isAfter(LocalDate.parse(post.getFinishDay())))
			throw new RuntimeException("채용 마감 일자가 지났습니다. 채용 마감일자 : ["+post.getFinishDay()+"]");
		
		return RequestJoined.of(post, loginUser);		
	}
	
	
	
	
}
