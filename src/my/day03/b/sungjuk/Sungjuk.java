package my.day03.b.sungjuk;

public class Sungjuk {
	private final String hakbun;
	private final String name;
	private final byte kor;
	private final byte eng;
	private final byte math;
	private final short age;
	private final double avg;
	private final char ratings;
	
	
	public void toPrint() {
		System.out.println("학번 : " + hakbun);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("평균 : " + ((int)(avg*100))/100d); //소수점 2자리까지 절삭
		System.out.println("학점 : " + ratings);
	}
	
	private Sungjuk ( Builder builder ) {
		this.name = builder.name;
		this.hakbun = builder.hakbun;
		this.kor= builder.kor;
		this.eng = builder.eng;
		this.math = builder.math;
		this.age = builder.age;
		this.avg = builder.avg;
		this.ratings = builder.ratings;
	}
	public static Sungjuk.Builder building(){
		return new Builder();
	}
	public static class Builder {
		private  String hakbun;
		private  String name;
		private  byte kor;
		private  byte eng;
		private  byte math;
		private  short age;
		private double avg;
		private char ratings;
		
		public void validScoreOrAge(Number num, String subject) {
			if ( num instanceof Byte)
				validScore((Byte)num, subject);				
			else if ( num instanceof Short )
				validAge((Short) num);
			else throw new NumberFormatException(
					num instanceof Byte ?
							subject+ " 과목의 성적 타입이 잘못들어옴" :
					"나이의 타입이 잘못들어옴");
		}

		private void validScore(Byte score, String subject) {
			if(!(score >=0 && score <=100))
				throw new NumberFormatException("성적은 0점에서 100점 사이여야 합니다. "+ subject+" 가  잘못 입력됨");
		}
		private void validAge(Short age) {
			if(!(age >=20 && age <=50))
				throw new NumberFormatException("나이는 20세에서 50세 사이여야 합니다.");
		}
		
		

		public Builder hakbun(String hakbun) {
			this.hakbun = hakbun;
			return this;		
		}
		public Builder name(String name) {
			this.name = name;
			return this;		
		}
		
		public Builder kor(byte kor) {
			validScoreOrAge(kor, "국어");
			this.kor= kor;
			return this;		
		}
		public Builder eng(byte eng) {
			validScoreOrAge(eng, "영어");
			this.eng = eng;
			return this;		
		}
		public Builder math(byte math) {
			validScoreOrAge(math, "수학");
			this.math = math;
			return this;		
		}
		public Builder age(short age) {
			validScoreOrAge(age, null);
			this.age = age;
			return this;		
		}
		public Sungjuk build() {
			this.avg = (this.eng + this.kor + this.math) / 3d;
			this.ratings = switch((int) avg/10) {
			case 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C'; 
			case 6 ->'D';
			default -> 'F';
		};
			return new Sungjuk(this);
		}
		
	}
	
}
