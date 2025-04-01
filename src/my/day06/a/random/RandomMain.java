package my.day06.a.random;

import java.util.Random;
import java.util.UUID;

import my.day01.MyUtil;

public class RandomMain {
	public static void main(String[] args) {
		
		double a= Math.random();
		System.out.println(a);
		//1부터 10까지의 수를 가져오려면
		long b = Math.round(Math.random()*10);
		System.out.println(b);
		int c = (int) (a*10+1);
		System.out.println(c);
		
		// (int)(Math.random()*구간범위) + 시작값; 
		// 구간범위 => 최대 값 - 최소 값 + 1
		//2부터 5까지 중 랜덤한 정수 구간범위 => 최대 값 - 최소 값 + 1
		int d = (int) (a*(5-2+1))+2;
		System.out.println(d);
		
		//random.nextInt(구간범위)+시작값
		//2부터 5까지 랜덤한 정수 
		Random random = new Random();
		int aa = random.nextInt(5 - 2 +1 ) + 2;
		System.out.println(aa);
		
		
		char bb = (char) (random.nextInt('z' - 'a' +1)+'a');
		System.out.println(bb);
		
		//랜덤 키 발급 
		String cc = UUID.randomUUID().toString();
		System.out.println(cc);
		
		String myKey = MyUtil.certificationKey();
		System.out.println(myKey);
	}
	
}
