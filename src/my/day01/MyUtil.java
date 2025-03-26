package my.day01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyUtil {
	public static String currentTime() {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy년MM월dd일 hh:mm:ss");
		return LocalDateTime.now().format(formatter);
		
	}
}
