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
		for(int i = 0; i<3; i++) {
			
		 }
		 
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
}
