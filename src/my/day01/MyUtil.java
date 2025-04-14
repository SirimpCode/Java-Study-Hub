package my.day01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.EnumSet;
import java.util.Random;

import javax.management.RuntimeErrorException;
import javax.naming.NameNotFoundException;
import javax.security.auth.login.AccountNotFoundException;

import my.day11.inheritance.user.jobseeker.JobSeeker.UserFieldEnum;
import my.day11.inheritance.utils.EnumInterface;


public class MyUtil {
	/**인스턴스화 방지*/
	private MyUtil() {}
	
	public static String currentTime() {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy년MM월dd일 hh:mm:ss");
		return LocalDateTime.now().format(formatter);
		
	}

	public static String certificationKey() {
		Random random = new Random();
	//랜덤한 소문자 3개 + 랜덤한숫자 4개 + 랜덤한 대문자 3개
		String lower = "", upper="", str="";
		 
		String result = "";
		for(int i = 0; i<3; i++) {
			result += (char) (random.nextInt('z'-'a'+1)+'a');
		 }
		for(int i = 0; i<4; i++) {
			result += random.nextInt(9-1+1)+1;
		}
		for(int i = 0; i<3; i++) {
			result += (char) (random.nextInt('Z'-'A'+1)+'A');
		 }
		return result;
	}
	
	// == 비밀번호가 규칙에 맞는지 틀리는지 알려주는 static 메소드 생성하기 == //
	   /*
	      비밀번호 규칙은 비밀번호의 길이는 8글자 이상 15글자 이하이어야 하고,
	      또한 비밀번호는 영문대문자, 영문소문자, 숫자, 특수기호가 혼합되어야만 한다.
	      우리는 규칙에 맞으면 true 를 리턴해주고, 규칙에 틀리면 false 를 리턴하도록 만든다.  
	   */
	public static boolean passwordVerify(String pw) {
		return pw.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,15}$");
	}
	public static boolean nameVerify(String name) {
		if(name.length()<2||name.length()>6)
			return false;
		
		for(char i : name.toCharArray())
			if(!(i>='가'&& i<='힣'))	return false;
		
		return true;
	}
	//for문 방식
	public static String deleteSpace(String str) {
		String response = "";
		for(char ch : str.toCharArray()) {
			if(ch != ' ') response+=ch;
			
		}
		return response;
	}
	//split 방식
	public static String deleteSpace2(String str) {
		String[] strArr = str.split(" ");
		return String.join("", strArr);
	}

	
	
	/**
	 유저 의 주민번호 앞 6자리와 뒤 1자리를 받아서 만 나이 계산해주는 스태틱 메서드
	 */
	public static int getAge(String userPk) {
		if(userPk.length() != 7)
			throw new StringIndexOutOfBoundsException("7자리의 숫자만 입력하세요");
		
		Gender gender = createGender(userPk);
		
		int month = getPkParseInt(MyPkEnum.MONTH, userPk);
		int day = getPkParseInt(MyPkEnum.DAY, userPk);
		int year = pasingYear(userPk, gender);
		
		LocalDate now = LocalDate.now();
		LocalDate user = LocalDate.of(year, month, day);
		
		return now.isBefore(user.withYear(now.getYear())) ?
				now.getYear() - user.getYear() - 1 : now.getYear() - user.getYear();
	}
	public static Gender createGender(String userPk) {
		
		int genderInt = getPkParseInt(MyPkEnum.GENDER, userPk);
		return parseGenderInt(genderInt);
	}
	private static int pasingYear(String userPk,Gender gender) {
		int year = getPkParseInt(MyPkEnum.YEAR, userPk);
		return switch(gender) {
		case OLDMALE,OLDFEMALE -> 1900+year;
		case MALE,FEMALE -> 2000+year;
		};
	}
	
	
	//주민번호 뒷자리의 앞숫자를 Gender 타입으로 파싱 메서드
	private static Gender parseGenderInt(int genderInt) {
		return switch(genderInt) {
			case 1 ->  Gender.OLDMALE;
			case 2 -> Gender.OLDFEMALE;
			case 3 -> Gender.MALE;
			case 4 -> Gender.FEMALE;
			default -> throw new StringIndexOutOfBoundsException("마지막 숫자는 1 ~ 4 사이여야 합니다.");
		};
	}
	
	//주민번호를 년 월 일 성별 의 숫자로 분리 메서드
	private static int getPkParseInt(MyPkEnum pkEnum, String userPk) {
		return switch(pkEnum) {
		case YEAR -> Integer.parseInt(userPk.substring(0,2));
		case MONTH -> Integer.parseInt(userPk.substring(2,4));
		case DAY ->  Integer.parseInt(userPk.substring(4,6));
		case GENDER -> Integer.parseInt(userPk.substring(6));
		};	
		
	}
	public static <T extends Enum<T>&EnumInterface> T getEnumValue(Class<T> enumClass,String str){
		for(T myEnum : EnumSet.allOf(enumClass)) {
			if(myEnum.getValue().equals(str))
				return myEnum;
		}
		throw new NullPointerException("이넘값을 찾을 수 없습니다.");
	}
	
	
	public static boolean validationUserField(UserFieldEnum myEnum, String value) {
		return switch(myEnum) {
			case ID -> value.matches("^[A-Za-z][A-Za-z0-9]{3,9}");
			case PASSWORD -> value.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).{8,16}$");
			case PRIMARY_KEY -> {
				if(value.matches("^[0-9]{7,7}")) {
					try {
						Gender gender = createGender(value);
						int year = pasingYear(value, gender);
						int month = getPkParseInt(MyPkEnum.MONTH, value);
						int day = getPkParseInt(MyPkEnum.DAY, value);;
						LocalDate.of(year, month, day);
					}catch(Exception e) {
						yield false;
					}
					yield true;
				};
				yield false;
				
			}
			case NAME -> value.matches("^[가-힣]{2,7}");
		};
	}

	public static int dateCompareTo(String strFinishDay, String yyyyMMdd) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		// false 로 해주어야만 입력한 값을 날짜 타입으로 변경할때 날짜로 되지 못하는 값일 경우 오류가 발생한다.
		try {
			Date registerDay = sdf.parse(yyyyMMdd);
			Date finishDay = sdf.parse(strFinishDay);
			// 마감일자가 등록일자보다 이후인지 비교
			// finishDay 가 registerDay 보다 이후이면 1을 리턴
			// finishDay 가 registerDay 보다 이전이면 -1을 리턴
			return finishDay.compareTo(registerDay);
		}  catch (ParseException e) {
			throw new RuntimeException("[경고] 채용마감일자는 달력에 존재하는 날짜이어야 합니다.\n");
        }

    }


	// 성별과 주민번호의 enum 클래스
	public static enum Gender {
		OLDMALE,
		OLDFEMALE,
		MALE,
		FEMALE;
	}
	
	private static enum MyPkEnum {
		YEAR,
		MONTH,
		DAY,
		GENDER;
	}

	
	
}
