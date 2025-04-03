package my.day10.abstraction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.NameNotFoundException;
import javax.swing.text.DateFormatter;

public class JobSeekerController {
	List<JobSeeker> jobSeekerList = new ArrayList<>();
	//메인메뉴 출력
	public void mainMenu() {
		System.out.println("\n === 메인메뉴 ===\n"
				+ "1. 구직자 회원가입	2.구직자 모두보기	3.검색하기		4.프로그램 종료\n"
				);
		System.out.print("👉🏻 메뉴번호 선택 : ");
		
	}

	//회원 가입
	public void signUp(Scanner sc) {
		if (jobSeekerList.size()==10) {
			System.out.println("정원이 가득 차 가입이 불가능 합니다.");
			return;
		}
			
		String id = inputRepeat(sc, InputValue.ID);
		String password = inputRepeat(sc, InputValue.PASSWORD);
		String name = inputRepeat(sc, InputValue.NAME);
		String userPk = inputRepeat(sc, InputValue.PRIMARY_KEY);
		
		jobSeekerList.add(
				JobSeeker.builder()
					.userId(id)
					.password(password)
					.userPrimaryKey(userPk.substring(2))
					.name(name)
					.build()
		);
		System.out.println("회원가입 완료 "+ name + "님 환영합니다.");
	}
	
	
	
	private String idInputRepeat(Scanner sc) {
		while(true) {
			System.out.print("1. 아이디 : ");
			try {
				return validId(sc.nextLine());
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
	}
	
	//유저의 입력을 반복 시켜주기 위한 메서드
	private String inputRepeat(Scanner sc, InputValue iv) {
		return switch(iv) {
			case ID -> {
				while(true) {
					System.out.print("아이디 : ");
					try {
						yield validId(sc.nextLine());
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
						yield validPassword(sc.nextLine());
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
						yield validName(sc.nextLine());
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
						yield validPk(sc.nextLine());
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
			if(e instanceof DateTimeParseException) 
				throw new IllegalArgumentException("생년월일이 존재하지 않는 날짜 입니다.");
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
		if(pw.matches("/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/"))
			throw new StringIndexOutOfBoundsException("비밀번호는 8자 이상 16자 이하 영문, 숫자, 특수문자 조합이어야 합니다.");
		return pw;
	}

	
	private String validId(String id) throws NameNotFoundException {
		if(id.isBlank())
			throw new IllegalArgumentException("아이디를 입력해주세요.");
		if(id.length()<4||id.length()>8)
			throw new StringIndexOutOfBoundsException("아이디는 4자 이상 8자 이하여야 합니다.");
		for(char ch : id.toCharArray()) {
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9'))
				continue;
			throw new IllegalArgumentException("아이디는 영문자 대문자, 소문자 또는 숫자로만 구성되야 합니다.");
		}
		return id;
	}
	
	private enum InputValue{
		ID,
		PASSWORD,
		PRIMARY_KEY,
		NAME;
	}

	public void getAllUserInfo() {
		if(jobSeekerList.isEmpty()) {
			System.out.println("가입 유저가 없습니다.");
			return;
		}
		jobSeekerList.stream().forEach(
				js-> System.out.println(js.getMyInfo())
		);
	}

	public void findUserById(Scanner sc) {
		String userId = inputRepeat(sc, InputValue.ID);
		jobSeekerList.stream().filter(js-> js.getUserId().equals(userId))
		.forEach(js-> System.out.println(js.getMyInfo()));
	}
}
