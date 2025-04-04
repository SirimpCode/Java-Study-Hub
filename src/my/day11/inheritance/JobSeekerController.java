package my.day11.inheritance;

import java.time.DateTimeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.naming.NameNotFoundException;
import javax.swing.text.DateFormatter;

import my.day01.MyUtil;

public class JobSeekerController {
	List<JobSeeker> jobSeekerList = new ArrayList<>();
	//메인메뉴 출력
	public void mainMenu() {
		System.out.println("\n"+"=".repeat(40)+" 메인메뉴 "+"=".repeat(40)+"\n"
				+ "1. 구직자 회원가입\t\t2.구직자 모두보기\t\t3.검색하기"+"\t\t4.탈퇴하기"+"\n\t\t\t\t5.프로그램 종료\n"
				);
		System.out.print("👉🏻 메뉴번호 선택 : ");
		
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
						yield validPassword(sc.nextLine().trim());
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

	private String validPassword(String pw) {
		if(pw.isBlank()||pw.contains(" "))
			throw new IllegalArgumentException("비밀번호에는 공백이 들어갈 수 없습니다.");
		if(!pw.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).{8,16}$"))
			throw new StringIndexOutOfBoundsException("비밀번호는 8자 이상 16자 이하 영문, 숫자, 특수문자 조합이어야 합니다.");
		return pw;
	}

	
	private String validId(String id, boolean isSignUp) {
		if(id.isBlank())
			throw new IllegalArgumentException("아이디를 입력해주세요.");
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
	
	

	public void getAllUserInfo() {
		if(jobSeekerList.isEmpty()) {
			System.out.println("가입 유저가 없습니다.");
			return;
		}
		System.out.println("=".repeat(40)+" 모든 유저 조회 결과 "+"=".repeat(40));
		printUserInfoGuide();
		jobSeekerList.stream().forEach(
				js-> System.out.println(js.getMyInfo())
		);
		printEndGuide();
	}
	
	
	private void printUserInfoGuide() {
		System.out.println("아이디\t비밀번호\t\t이름\t주민번호\t\t\t만나이\t성별\t가입날짜");
		System.out.println("-".repeat(96));
	}
	private void printEndGuide() {
		System.out.println("-".repeat(96));
	}

	private boolean existUserId(String id) {
		return jobSeekerList.stream().filter(js-> js.getId().equals(id))
				.findFirst().isPresent();
	}
	private void printUserInfoById(Scanner sc) {
		String userId = inputRepeat(sc, JobSeeker.UserFieldEnum.ID, false);
		Optional<JobSeeker> userOp = findUserById(userId);
		if(userOp.isPresent()) {
			printUserInfoGuide();
			System.out.println(userOp.get().getMyInfo()); 
			printEndGuide();
			return;
		}
		System.out.println("입력하신 아이디의 유저가 없습니다.");
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
			System.out.println("해당 아이디로 가입된 유저가 없습니다.");
			return;
		}
		JobSeeker user = userOp.get();
		if(!user.getPassword().equals(password)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		if(jobSeekerList.remove(user))
			System.out.println("유저 탈퇴 성공");;
		
	}

	public void searchUser(Scanner sc) {
		while(true) {
//			if(jobSeekerList.isEmpty()) {
//				System.out.println("가입된 유저가 없습니다."); return;
//			}
			System.out.println("1. 연령대 검색\t2. 성별 검색\t3.아이디 검색\t4. 나이와 성별로 검색\t5. 메인 메뉴로 돌아가기");
			String select = sc.nextLine().trim();
			switch(select) {
				case "1" : searchUserAge(sc); break;
				case "2" : searchUserByGender(sc); break;
				case "3" : printUserInfoById(sc); break;
				case "4" : searchUserByAgeAndGender(sc); break;
				case "5" : return;
				default : System.out.println("잘못 입력됨 1 부터 5 중에 입력 해주세요.");
			}
		}
		
		
	}
	
	public void searchUserByAgeAndGender(Scanner sc) {
		String age = repeatAge(sc);
		String genderStr = repeatGender(sc);
		
		List<JobSeeker> userListByAge = ageFilterUser(age);
		Gender gender = MyUtil.getEnumValue(Gender.class, genderStr);
		
		
		if(userListByAge.isEmpty()) {
			System.out.println(age+"대의 유저가 없습니다."); return;
		}
			
		List<JobSeeker> resultList = userListByAge.stream()
				.filter(ua->ua.getGender().equals(gender)).toList();
		if(resultList.isEmpty()) {
			System.out.println(age+"대의 "+genderStr+" 유저가 없습니다."); return;
		}
		printUserInfoGuide();
		resultList.stream().forEach(r->System.out.println(r.getMyInfo()));
		printEndGuide();
	}
	
	private void searchUserByGender(Scanner sc) {
		String gender = repeatGender(sc);
		printUserInfoByGender(gender);
	}
	private String repeatGender(Scanner sc) {
		while(true) {
			System.out.println("검색하실 성별 남성 혹은 여성을 입력하세요.");
			String gender = sc.nextLine().trim();
			switch(gender) {
				case "남성" :
				case "여성" :  
					return gender;
				default : System.out.println("잘못 입력됨 남성 혹은 여성만 입력하세요.\n");
			}
		}
	}

	private void printUserInfoByGender(String genderStr) {
		Gender gender = MyUtil.getEnumValue(Gender.class, genderStr);
		List<JobSeeker> userList = findUserByGender(gender);
		if(!userList.isEmpty()) {
			printUserInfoGuide();
			userList.stream().forEach(user->
				System.out.println(user.getMyInfo()));
			printEndGuide();
			return;
		}
		System.out.println(genderStr+ "으로 조회된 유저가 없습니다.");
	}

	private List<JobSeeker> findUserByGender(Gender gender) {
		return jobSeekerList.stream().filter(js->js.getGender().equals(gender)).toList();
	}

	private void searchUserAge(Scanner sc) {
		String age = repeatAge(sc);
		printUserByAge(age);
	}
	private String repeatAge(Scanner sc) {
		while(true) {
			System.out.println("검색 하고자 하는 연령대 [예 : 20] => ");
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

	private void printUserByAge(String age) {
		List<JobSeeker> userList = ageFilterUser(age);
		if(userList.isEmpty()) {
			System.out.println(age+"대의 유저가 없습니다.");
			return;
		}
		printUserInfoGuide();
		userList.stream().forEach(
				js-> System.out.println(js.getMyInfo())
		);
		printEndGuide();
	}
	private List<JobSeeker> ageFilterUser(String age){
		int ageInt = Integer.parseInt(age);
		int maxAge = Integer.parseInt(String.join("", new String[] {age.substring(0,1),"9"}));
		
		return jobSeekerList.stream().filter(js->{
			int myAge = MyUtil.getAge(js.getUserPrimaryKey());
			
			return ageInt<=myAge&&maxAge>=myAge;
			}).toList();
	}
}
