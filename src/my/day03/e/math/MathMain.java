package my.day03.e.math;

public class MathMain {
	public static void main(String[] args) {
		double db1 = 59.53123, db2 = 86.23543;
		System.out.println("그냥 출력 "+db1+" "+db2);
		
		//반올림하기
		System.out.println("그냥 반올림 "+Math.round(db1)+" "+ Math.round(db2));
		
		//원하는 특정한 곳에서 반올림
		System.out.println("특정한곳 반올림 "+(Math.round(db1*100))/100d+" "+ Math.round(db2*100)/100d);
		
		//올림 기냥 무지성으로 올려버림
		System.out.println("\n올림 "+Math.ceil(db1)+" "+ Math.ceil(db2));
		//내림 그냥 소수점 버림
		System.out.println("내림 "+Math.floor(db1)+" "+ Math.floor(db2));
		
		//절대값 
		int a = 20, b = -30;
		System.out.println(a+" "+b);
		System.out.println("\n절대 값 "+Math.abs(a)+" "+Math.abs(b));
	}
}
