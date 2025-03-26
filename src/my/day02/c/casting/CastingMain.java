package my.day02.c.casting;

public class CastingMain {

	//=== casting 연산자에 대해서 알아본다. === 

	/*
	   === 데이터형 변환하기 ===
	   1. 자동 형변환(묵시적 형변환)
	   --> 데이터타입의 크기가 작은 것에서 크기가 큰쪽으로는 자동적으로 형변환이 발생된다. 
	   
	    byte(1byte) --> short(2byte) --> int(4byte) --> long(8byte)
	       개미             병아리            강아지           사람   
	      개미집            병아리집           강아지집          안방
	    
	    float(4byte) --> double(8byte) 
	    
	    --> 정수타입은 실수타입으로 자동형변환이 발생한다.
	    
	    char(2byte)
	    --> char타입은 int형으로 자동형변환이 발생한다.
	   
	   
	   2. 강제 형변환(casting)
	   --> 데이터타입의 크기가 큰것을 작은것으로 강제적으로 형변환 시키는 것을 말한다.
	       크기가작은타입 = (크기가작은타입)크기가큰타입
	                
	       실수를 정수로 강제적으로 형변환하는 것을 말한다.
	       소수부는 무조건 절삭을 해버리고 정수만 나온다.
	       정수 = (정수)실수         

	*/
	public static void main(String[] args) {
		
		
		float a = 1f;
		double b = a;
//		float c = b;
		
		
		//엉뚱한 값이 나옴
		int in2 = 50000;
		short sh2 = (short) in2;
		System.out.println(sh2); // = -15536
		long ln1 = 12081732509L;
		int in1 = (int) ln1;
		System.out.println(in1); // = -803169379
		
		 
		
		long ln2 = 1560000000l;
		float ft3 = ln2;
		System.out.println(ft3);// = 1.56E9 1.56 곱하기 10의 9승 이다 라고 나옴.
		
		//소수점 그냥 없애버림
		double db3 = 123.98765;
		int in3 = (int) db3;
		System.out.println(in3);
		
		
		
		
		

	}

}
