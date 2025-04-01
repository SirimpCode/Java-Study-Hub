package my.day01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MyUtil {
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
}
