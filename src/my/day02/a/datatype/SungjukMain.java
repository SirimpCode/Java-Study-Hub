package my.day02.a.datatype;

import java.util.Arrays;
import java.util.List;

public class SungjukMain {

	public static void main(String[] args) {
		
		List<Sungjuk> sungjukList = Arrays.asList(
				Sungjuk.of("012493", "이순신", 67, 57, 80),
				Sungjuk.of("012494", "이순신2", 87, 33, 100),
				Sungjuk.of("012495", "이순신3", 84, 70, 90),
				Sungjuk.of("012496", "이순신4", 70, 60, 50),
				Sungjuk.of("012497", "이순신5", 80, 80, 80)
				);
		
		sungjukList.stream().forEach(s->s.toPrintInfo());
	}

}
