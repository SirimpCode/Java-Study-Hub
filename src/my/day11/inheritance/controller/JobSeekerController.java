package my.day11.inheritance.controller;

import java.text.DecimalFormat;
import java.time.DateTimeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.naming.NameNotFoundException;
import javax.swing.text.DateFormatter;

import my.day01.MyUtil;
import my.day11.inheritance.user.RequestJoined;
import my.day11.inheritance.user.company.Company;
import my.day11.inheritance.user.company.Company.CompanyFieldEnum;
import my.day11.inheritance.user.company.RecruitPost;
import my.day11.inheritance.user.jobseeker.Gender;
import my.day11.inheritance.user.jobseeker.JobSeeker;
import my.day11.inheritance.user.jobseeker.JobSeeker.UserFieldEnum;

public class JobSeekerController {
	//유저 저장소
	private List<JobSeeker> jobSeekerList = new ArrayList<>();
	private List<RequestJoined> requestJoinedList = new ArrayList<>();//입사지원
	public List<JobSeeker> getJobSeekerList(){
		return this.jobSeekerList;
	}
	
	private List<JobSeeker> createStartJobSeeker(){
		JobSeeker js1 = JobSeeker.builder()
				.withId("abcd")
				.withName("일유저")
				.withPassword("12341234a!")
				.userPrimaryKey("9912051")
				.build();
		JobSeeker js2 = JobSeeker.builder()
				.withId("abcd1")
				.withName("이유저")
				.withPassword("12341234a!")
				.userPrimaryKey("9612051")
				.build();
		JobSeeker js3 = JobSeeker.builder()
				.withId("abcd2")
				.withName("삼유저")
				.withPassword("12341234a!")
				.userPrimaryKey("0012053")
				.build();
		return	List.of(js1, js2, js3);
	}
	

	public JobSeekerController() {
		jobSeekerList.addAll( createStartJobSeeker() );
	}
	//구직자 로그인
	public JobSeeker login(Scanner sc) {
		String id = inputRepeat(sc,JobSeeker.UserFieldEnum.ID,false);
		String password = inputRepeat(sc,JobSeeker.UserFieldEnum.PASSWORD,false);
		Optional<JobSeeker> userOp = findUserById(id);
		if(userOp.isEmpty()) {
			System.out.println("해당 아이디로 가입된 구직자가 없습니다.");
			return null;
		}
		JobSeeker user = userOp.get();
		if(!user.getPassword().equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return null;
		}
		return user;
	}
	
	//구직자 전용메뉴
	private void loginMenu(String name) {
		System.out.println("\n"+"=".repeat(30)+" 구직자 메뉴 "+name+"님 로그인중 "+"=".repeat(30)+"\n"
				+ "1.내정보 보기   2.내정보 수정   3.모든구인회사 조회   4.구인회사검색하기\n"
                + "5.모든채용공고조회   6.채용공고상세보기   7.채용응모하기   8.채용응모한것조회\n"
                + "9.채용응모한것수정하기    10.로그아웃\n"
				);
		System.out.print("👉🏻 메뉴번호 선택 : ");
		
	}
	
	//내정보수정
	private void modifyMyInfo(JobSeeker loginUser, Scanner sc) {
		

		printUserInfoGuide();
		System.out.println(loginUser.getMyInfo(false));
		printEndGuide();
		
		JobSeeker originalUser = JobSeeker.builder()
				.withId(loginUser.getId())
				.withName(loginUser.getName())
				.withPassword(loginUser.getPassword())
				.userPrimaryKey(loginUser.getUserPrimaryKey())
				.build();
		
		main:
		while(true) {
			

			System.out.println("\n"+"=".repeat(30)+" 수정할 정보를 선택해 주세요. "+"=".repeat(30)+"\n"
					+ "1.아이디   2.비밀번호   3.이름	4.주민번호		5.수정저장		6.취소및뒤로가기"
					);
			System.out.print("👉🏻 메뉴번호 선택 : ");
			String select = sc.nextLine().strip();
			switch(select) {
			case "1": 
				String beforeId = loginUser.getId();
				String modifyId = inputRepeat(sc, UserFieldEnum.ID, true);
				if(beforeId.equals(modifyId)) {
					System.out.println("입력한 아이디가 기존의 아이디와 동일합니다.");
					break;
				}
				
				loginUser.setId(modifyId);
				System.out.println("아이디 수정 성공 "+beforeId+"를 "+loginUser.getId()+"로 수정하였습니다.");
				break;
			case "2":
				String beforePw = loginUser.getPassword();
				String modifyPw = inputRepeat(sc, UserFieldEnum.PASSWORD, true);
				if(beforePw.equals(modifyPw)) {
					System.out.println("입력한 비밀번호가 기존의 비밀번호와 동일합니다.");
					break;
				}
				
				loginUser.setPassword(modifyPw);
				System.out.println("비밀번호 수정 성공 "+beforePw+"를 "+loginUser.getPassword()+"로 수정하였습니다.");
				break;
			case "3": 
				String beforeName = loginUser.getName();
				String modifyName = inputRepeat(sc, UserFieldEnum.NAME, true);
				if(beforeName.equals(modifyName)) {
					System.out.println("입력한 이름이 기존의 이름과 동일합니다.");
					break;
				}
				loginUser.setName(modifyName);
				System.out.println("이름 수정 성공 "+beforeName+"를 "+loginUser.getName()+"로 수정하였습니다.");
				break;
			case "4":
				String beforePk = loginUser.getUserPrimaryKey();
				String modifyPk = inputRepeat(sc,UserFieldEnum.PRIMARY_KEY, true);
				if(beforePk.equals(modifyPk)) {
					System.out.println("입력한 주민번호가 기존의 주민번호와 동일합니다.");
					break;
				}
				loginUser.setUserPrimaryKey(modifyPk.substring(2));
				System.out.println("주민번호 수정 성공 : "+beforePk+"를 "+loginUser.getUserPrimaryKey()+"로 수정 하였습니다");
				break;
			case "5":
				System.out.println("수정 내역을 저장 합니다.");
				break main;
			case "6": 
				System.out.println("수정 내역을 취소 합니다.");
				loginUser.setId(originalUser.getId());
				loginUser.setName(originalUser.getName());
				loginUser.setPassword(originalUser.getPassword());
				loginUser.setUserPrimaryKey(originalUser.getUserPrimaryKey());
				break main;
			default : System.out.println("잘못입력됨 1 부터 5 중에 입력해주세요.");
			}
		}
	}
	
	//구직자전용메뉴
	public void loginLogic(Scanner sc, JobSeeker loginUser, CompanyController cc) {
		
		main:
		while(true) {
			
			loginMenu(loginUser.getName());
			String select = sc.nextLine().trim();
			
			
			switch(select.trim()) {
				case "1": //내정보 보기
					System.out.println(">> "+loginUser.getName()+"님의 정보");
					printUserInfoGuide();
					System.out.println(loginUser.getMyInfo(false));
					printEndGuide();
					break;
				case "2":  // 내정보 수정
					modifyMyInfo(loginUser, sc);
					break;
				case "3": // 모든구인회사 조회
					cc.printAllCompanyInfo();
					break;
				
				case "4" ://구인회사 검색
					cc.searchCompany(sc);
					break;
				case "5" ://모든채용공고조회
					cc.printAllPostInfo(sc);
					break;
				case "6" ://채용공고상세
					cc.searchPostDetails(sc);
					break;
				case "7" ://채용응모하기
					try {
						RequestJoined join = cc.userJoinCompany(sc,loginUser, requestJoinedList);
						requestJoinedList.add(join);
						System.out.println("["+join.getRecruitPost().getCompany().getName()+"]의 ["+join.getRecruitPost().getTitle()+"] 에 채용공고에 지원하였습니다.");
					}catch(RuntimeException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "8" ://채용응모한것조회
					List<RecruitPost> postList = searchMyJoinPost(loginUser);
					if ( !postList.isEmpty() ) {
						System.out.println("내가 지원한 채용 공고들");
						cc.printPostInfo(postList);
						break;
					}
					System.out.println("내가 지원한 채용 공고문이 없습니다.");
					break;
				case "9" ://채용응모수정
					List<RecruitPost> postList2 = searchMyJoinPost(loginUser);
					if ( !postList2.isEmpty() ) {
						System.out.println("내가 지원한 채용 공고들");
						cc.printPostInfo(postList2);

						modifyJoin(loginUser, sc);
						break;
					}
					System.out.println("내가 지원한 채용 공고문이 없습니다.");
					break;
				
				case "10": 
					break main; //로그아웃
				case "11" : //채용마감일자 오늘 포함 오늘이후것들 가져오기 (강사님버전)
					System.out.println();
					cc.printPostMission();
					break;
				
				default : System.out.println("잘못 입력됨 1 부터 10 중 입력하세요.");
			}
		}
		
	}
	private List<RecruitPost> searchMyJoinPost(JobSeeker js) {
		List<RequestJoined> myRj = findRequestJoinedByUser(js);
		List<RecruitPost> postList = myRj.stream().map(rj-> rj.getRecruitPost()).toList();
		if ( !myRj.isEmpty() ) {
			return postList;
		}
		return null;
	}
	private void modifyJoin(JobSeeker loginUser, Scanner sc) {
		List<RequestJoined> myRj = findRequestJoinedByUser(loginUser); 
		while(true) {
			System.out.print("수정할 채용공고 번호를 입력해주세요. => ");
			String str = sc.nextLine();
			try {
				RequestJoined myJoin = myRj.stream().filter(rj->rj.getRecruitPost().getPostId() == Integer.parseInt(str)).findAny()
						.orElseThrow(()-> new RuntimeException("못찾음"));
				System.out.println("수정할 지원동기 입력 => ");
				String dongi = sc.nextLine();
				myJoin.setMotive(dongi);
				System.out.println("지원동기 수정완료");		
				return;
			}catch(Exception e) {
				System.out.println("수정할 채용공고 번호를 위 목록을 참고하여 입력해주세요.");
				continue;
			}
		}
		
	}

	private List<RequestJoined> findRequestJoinedByUser(JobSeeker loginUser){
		return requestJoinedList.stream().filter(rj->rj.getJobSeeker().equals(loginUser)).toList();
	}

	//메인메뉴 출력
	private void mainMenu() {
		System.out.println("\n"+"=".repeat(40)+" 메인메뉴 "+"=".repeat(40)+"\n"
				+ "1. 구직자 회원가입\t\t2.구직자 모두보기\t\t3.검색하기"+"\t\t4.탈퇴하기"+"\n\t\t\t\t5.메인메뉴 이동\n"
				);
		System.out.print("👉🏻 메뉴번호 선택 : ");
		
	}
	public void mainLogic(Scanner sc) {

		main:
		while(true) {
			mainMenu();
			String select = sc.nextLine().trim();
			
			switch(select.trim()) {
				case "1": //구직자 회원가입
					signUp(sc);
					break;
				case "2":  // 구직자 모두보기
//					getAllUserInfo();
					break;
				case "3": // 검색 하기
					searchJobSeeker(sc);
					break;
				case "4" : withdrawUser(sc); break;
				case "5": break main;
				default : System.out.println("잘못 입력됨 1 부터 5 중 입력하세요.");
			}
			
		}
	}
	

	//회원 가입
	public void signUp(Scanner sc) {
		if (jobSeekerList.size()==10) {
			System.out.println("정원이 가득 차 가입이 불가능 합니다.");
			return;
		}
			
		String id = inputRepeat(sc, JobSeeker.UserFieldEnum.ID,true);
		String password = inputRepeat(sc, JobSeeker.UserFieldEnum.PASSWORD,true);
		String name = inputRepeat(sc, JobSeeker.UserFieldEnum.NAME,true);
		String userPk = inputRepeat(sc, JobSeeker.UserFieldEnum.PRIMARY_KEY,true);
		
		jobSeekerList.add(
				JobSeeker.builder()
					.withId(id)
					.withPassword(password)
					.userPrimaryKey(userPk.substring(2))
					.withName(name)
					.build()
		);
		System.out.println("회원가입 완료 "+ name + "님 환영합니다.");
	}
	
	
	
	
	
	//유저의 입력을 반복 시켜주기 위한 메서드
	private String inputRepeat(Scanner sc, JobSeeker.UserFieldEnum iv, boolean isSignUp) {
		return switch(iv) {
			case ID -> {
				while(true) {
					System.out.print("아이디 : ");
					try {
						yield validId(sc.nextLine().trim(), isSignUp);
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
						yield validPassword(sc.nextLine().trim(),isSignUp);
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case NAME -> {
				while(true) {
					System.out.print("이름 : ");
					try {
						yield validName(sc.nextLine().trim());
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			case PRIMARY_KEY -> {
				while(true) {
					System.out.print("주민번호 앞 6자리와 뒤 1자리 : ");
					try {
						yield validPk(sc.nextLine().trim());
					}catch(Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
		};
	}
	
	private void userPkDateValid(String pk) {
		int year = Integer.parseInt(pk.substring(0,4));
		int month = Integer.parseInt(pk.substring(4,6));
		int day = Integer.parseInt(pk.substring(6,8));
		LocalDate.of(year, month, day);
	}
	
	private String validPk(String pk) {
		if(pk.length() != 7)
			throw new StringIndexOutOfBoundsException("주민등록번호 앞 6자리와 뒤 1자리 총 7자리 숫자만 입력해주세요.");
		try {
			switch(pk.substring(pk.length()-1)) {
				case "1","2" :  pk = String.join("", new String[] {"19",pk}); break;
				case "3","4" :  pk = String.join("", new String[] {"20",pk}); break;
				default : throw new IllegalAccessError("주민등록번호 뒷번호 앞자리는 1, 2, 3, 4 값중 하나여야 합니다.");
			}
			userPkDateValid(pk);
			return pk;	
		}catch(Exception e){
			if(e instanceof NumberFormatException)
				throw new NumberFormatException("주민등록번호는 숫자만 입력해주세요.");
			if(e instanceof DateTimeException) 
				throw new IllegalArgumentException("생년월일이 존재하지 않는 날짜 입니다.");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		
		}
	}

	private String validName(String name) {
		if(name.length()<2||name.length()>8)
			throw new StringIndexOutOfBoundsException("이름은 2자 이상 8자 이하여야 합니다.");
		for(char ch : name.toCharArray()) {
			if(ch>='가'&&ch<='힣') continue;
			throw new IllegalArgumentException("이름은 한글로만 작성해주세요.");
		}
		
		return name;
	}

	private String validPassword(String pw,boolean isSignUp) {
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
	
	

	public void printAllUserInfo() {
		if(jobSeekerList.isEmpty()) {
			System.out.println("가입 구직자가 없습니다.");
			return;
		}
		System.out.println("=".repeat(40)+" 모든 구직자 조회 결과 "+"=".repeat(40));
		printUserInfoGuide();
		jobSeekerList.forEach(
				js-> System.out.println(js.getMyInfo(true))
		);
		printEndGuide();
	}
	
	
	public void printUserInfoGuide() {
		System.out.println("-".repeat(96));
		System.out.println("아이디\t비밀번호\t\t이름\t주민번호\t\t\t만나이\t성별\t가입날짜");
		System.out.println("-".repeat(96));
	}
	public void printEndGuide() {
		System.out.println("-".repeat(96));
	}

	private boolean existUserId(String id) {
		return jobSeekerList.stream().filter(js-> js.getId().equals(id))
				.findFirst().isPresent();
	}
	private Optional<JobSeeker> findUserById(String id) {
		return jobSeekerList.stream().filter(js->js.getId().equals(id))
				.findFirst();
	}

	public void withdrawUser(Scanner sc) {
		String id = inputRepeat(sc,JobSeeker.UserFieldEnum.ID,false);
		String password = inputRepeat(sc,JobSeeker.UserFieldEnum.PASSWORD,false);
		Optional<JobSeeker> userOp = findUserById(id);
		if(userOp.isEmpty()) {
			System.out.println("해당 아이디로 가입된 구직자가 없습니다.");
			return;
		}
		JobSeeker user = userOp.get();
		if(!user.getPassword().equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		if(jobSeekerList.remove(user))
			System.out.println("구직자 탈퇴 성공");;
		
	}

	public void searchJobSeeker(Scanner sc) {
		while(true) {
			if(jobSeekerList.isEmpty()) {
				System.out.println("가입된 구직자가 없습니다."); return;
			}
			System.out.println("1.연령대 검색\t2.성별 검색\t3.아이디 검색\t4.나이와 성별로 검색\t5.이전 메뉴로 돌아가기");
			String select = sc.nextLine().trim();
			switch(select) {
				case "1" : searchJobSeekerByAge(sc); break;
				case "2" : searchJobSeekerByGender(sc); break;
				case "3" : searchJobSeekerById(sc); break;
				case "4" : searchJobSeekerByAgeAndGender(sc); break;
				case "5" : return;
				default : System.out.println("잘못 입력됨 1 부터 5 중에 입력 해주세요.");
			}
		}
	}
	private void printJobSeekerInfo(List<JobSeeker> jobSeekers) {
		printUserInfoGuide();
		jobSeekers.stream().forEach(js->System.out.println(js.getMyInfo(true)));
		printEndGuide();
	}
	private List<JobSeeker> findJobSeekerByAge(String age){
		int ageInt = Integer.parseInt(age);
		int maxAge = Integer.parseInt(String.join("", new String[] {age.substring(0,1),"9"}));
		

		System.out.println("["+age+"대] 의 구직자를 검색합니다.");
		return jobSeekerList.stream().filter(js->{
			int myAge = MyUtil.getAge(js.getUserPrimaryKey());
			
			return ageInt<=myAge&&maxAge>=myAge;
			}).toList();
	}
	private List<JobSeeker> findJobSeekerByGender(String genderStr) {
		Gender gender = MyUtil.getEnumValue(Gender.class, genderStr);
		System.out.println("["+genderStr+"] 인 구직자를 검색합니다.");
		return jobSeekerList.stream().filter(js->js.getGender().equals(gender)).toList();
	}
	private void searchJobSeekerByAgeAndGender(Scanner sc) {
		System.out.println("연령대와 성별로 검색합니다.");
		System.out.println("검색 하실 연령대를 입력해주세요. ex) 20");
		String age = repeatAge(sc);
		List<JobSeeker> ageJsList = findJobSeekerByAge(age);  
		System.out.println("검색 하실 구직자의 성별을 남성 혹은 여성으로 입력해주세요.");
		String genderStr = repeatGender(sc);
		Gender gender = MyUtil.getEnumValue(Gender.class, genderStr);
		System.out.println("["+age+"대]의 구직자 검색 결과에서 ["+genderStr+"] 구직자를 검색합니다.");
		List<JobSeeker> resultList = ageJsList.stream().filter(aj->aj.getGender().equals(gender)).toList();
		
		if(!resultList.isEmpty()) printJobSeekerInfo(resultList);
		else System.out.println("["+age+"대]의 ["+genderStr+"] 인 구직자가 없습니다.");
	}
	private void searchJobSeekerByGender(Scanner sc) {
		System.out.println("검색 하실 구직자의 성별을 남성 혹은 여성으로 입력해주세요.");
		String gender = repeatGender(sc);
		
		List<JobSeeker> resultList = findJobSeekerByGender(gender);
		if( !resultList.isEmpty() ) printJobSeekerInfo(resultList);
		else System.out.println("["+gender+"] 인 구직자가 없습니다.");
	}
	
	private void searchJobSeekerById(Scanner sc) {
		System.out.println("검색 하실 구직자 아이디를 입력해주세요.");
		String id = inputRepeat(sc, UserFieldEnum.ID, false);
		

		System.out.println("["+id+"] 아이디의 구직자를 검색합니다.");
		Optional<JobSeeker> result = findUserById(id);
		if (result.isPresent()) printJobSeekerInfo(List.of(result.get()));
		else System.out.println("["+id+"] 아이디의 구직자가 없습니다.");
	}
	
	private void searchJobSeekerByAge(Scanner sc) {
		System.out.println("검색 하실 연령대를 입력해주세요. ex) 20");
		String age = repeatAge(sc);
		
		List<JobSeeker> resultList = findJobSeekerByAge(age);
		if( !resultList.isEmpty() ) printJobSeekerInfo(resultList);
		else System.out.println("["+age+"대] 의 구직자가 없습니다.");
	}
	
	
	
	
	private String repeatGender(Scanner sc) {
		while(true) {
			String gender = sc.nextLine().trim();
			switch(gender) {
				case "남성" :
				case "여성" :  
					return gender;
				default : System.out.println("잘못 입력됨 남성 혹은 여성만 입력하세요.\n");
			}
		}
	}
	private String repeatAge(Scanner sc) {
		while(true) {
			String age = sc.nextLine().trim();
			switch(age) {
				case "0" : 
				case "20" :
				case "30" :
				case "10" :
				case "40" :
				case "50" :
				case "60" :
				case "70" :
				case "80" : 
					return age;
			default : 
				System.out.println("잘못 입력됨 올바른 연령대를 입력해주세요.\n");
			}
		}
	}

	public void searchMyCompanyJoinUser(RecruitPost post,Scanner sc) {
		List<RequestJoined> myRjList = findJobSeekerByPost(post);
		List<JobSeeker> myJobSeekerList = myRjList.stream().map(rj->rj.getJobSeeker()).toList();
		if(!myJobSeekerList.isEmpty()) {
			System.out.println("======= 우리 회사 채용공고 ["+post.getTitle()+"]의 지원자 목록 =======");
			printJobSeekerInfo(myJobSeekerList);
			printJobSeekerDetails(myRjList,sc);
			return;
		}
		System.out.println("우리회사 채용공고에 지원한 지원자가 없습니다.");
	}

	private void printJobSeekerDetails(List<RequestJoined> myRjList,Scanner sc) {
		RequestJoined selectRj = repeatRjListById(myRjList , sc);
		StringBuilder sb = new StringBuilder();
		sb.append("지원 공고 : "+selectRj.getRecruitPost().getTitle()+"\n");
		sb.append("이름 : "+selectRj.getJobSeeker().getName()+"\n");
		sb.append("성별 : "+selectRj.getJobSeeker().getGender().getValue()+"\n");
		sb.append("만나이 : "+MyUtil.getAge(selectRj.getJobSeeker().getUserPrimaryKey())+"\n");
		sb.append("지원동기 : "+selectRj.getApplyMotive()+"\n");
		sb.append("지원날짜 : "+selectRj.getCreatedAt());
		System.out.println(sb);
	}

	private RequestJoined repeatRjListById(List<RequestJoined> myRjList, Scanner sc) {
		while(true) {
			System.out.println("조회하실 지원자의 아이디를 입력하세요.");
			String id = inputRepeat(sc, UserFieldEnum.ID, false);
			Optional<RequestJoined> opRj = myRjList.stream().filter((rj)-> rj.getJobSeeker().getId().equals(id)).findFirst();
			if(opRj.isPresent()) return opRj.get();
			System.out.println("위의 지원자 목록에 존재하는 구직자의 ID 를입력해주세요.");
		}
	}
	//채용공고번호 회사명 채용제목 채용분야근무형태 채용인원 연봉 채용마감일자
	private List<RequestJoined> findJobSeekerByPost(RecruitPost post) {
	
		return requestJoinedList.stream().filter(rj->rj.getRecruitPost().equals(post))
				.toList();
	}
}
