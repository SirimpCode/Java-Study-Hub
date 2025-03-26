package my.day02.a.datatype;

import java.text.DecimalFormat;

public class Sungjuk {
	private String stuNo;
	private String name;
	private byte kor;
	private byte eng;
	private byte math;
	private char hakjum;
	
	private Sungjuk (String stuNo, String name, byte kor, byte eng, byte math) {
		this.stuNo = stuNo;
		this.name = name;
		this.eng = eng;
		this.kor = kor;
		this.math = math;
	}
	public static Sungjuk of(String stuNo, String name, int kor, int eng, int math) {
		return new Sungjuk(stuNo, name, (byte) kor , (byte)eng ,(byte)math);
	}
	
	public void toPrintIntegerTypeTest() {
		//int 아래 타입인 byte short char 는 사칙연산을 만나면 자동으로 int로 형 변환 된다.		
		byte aa = 10;
		byte bb = 3;
		int cc = aa/bb;
		
		//정수 나누기 정수는 소숫점을 절삭 하여 몫은 정수로 나온다.
		int a1 = 10;
		int b1 = 3;
		int c1 = a1/b1;
		System.out.println(c1+" 직접연산"+a1/b1);
		//실수형으로 만들었을땐 실수형 그대로나옴
		float a = 10;
		float b = 3;
		float c = a/b;
		double d = a/b;
		System.out.println(c+" 직접연산 "+a/b+" "+d);
		//실수형의 기본타입은 double 이다
		double t = 2.2;
		float j = 2.2f;
		double tj = t+j;
		float tj2 = (float)t+j;
	}
	
	public void toPrintInfo() {
		setHakjum();
		System.out.println(this.name+"님의 성적\n"
				+ "1. 학번 : "+this.stuNo+"\n"
				+ "2. 이름 : "+this.name+"\n"
				+ "3. 국어 : "+this.kor+"\n"
				+ "4. 영어 : "+this.eng+"\n"
				+ "5. 수학 : "+this.math+"\n"
				+ "6. 평균 : "+this.getAvg()+"\n"
				+ "7. 학점 : "+this.hakjum+"\n");
	}
	
	private void setHakjum() {

		if (getAvg()>=90) hakjum = 'A';
		else if (getAvg()>=80) hakjum = 'C';
		else if (getAvg()>=70) hakjum = 'D';
		else hakjum = 'F';
	}
	
	
	
	private double getAvg() {
		DecimalFormat df = new DecimalFormat("#.##");
		double avg = (this.kor+this.eng+this.math) / 3d;
		return Double.parseDouble(df.format(avg));
	}
}
