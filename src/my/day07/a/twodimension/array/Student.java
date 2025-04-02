package my.day07.a.twodimension.array;




public class Student {
	private String stuId;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	
	private double avg;
	private char rating;
	private int sum;

	//Getter 메서드들
	public String getStuId() {
		return this.stuId;
	}
	public String getStuName() {
		return this.stuName;
	}
	public int getKor() {
		return this.kor;
	}
	public int getEng() {
		return this.eng;
	}
	public int getMath() {
		return this.math;
	}
	public char getRating() {
		return this.rating;
	}
	public int getSum() {
		return this.sum;
	}
	public double getAvg() {
		return this.avg;
	}
	//Getter 메서드들
	private Student(String id, String name, int kor, int eng, int math) {
		this.stuId = id;
		this.stuName = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
	}
	public static Student of(String id, String name, int kor, int eng, int math) {
		return new Student(id,name, kor, eng, math);
	}
	public void setPersonnel(int personnel) {
		this.avg = Math.round((double)this.sum / personnel*10 )/10d;
		this.rating = ratingSetting();  
	}
	private char ratingSetting() {
		return switch((int)this.avg/10) {
			case 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
	}
	
	public String getInfo() {
		return this.stuId+"\t"+this.stuName+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+
	this.sum+"\t"+this.avg+"\t"+this.rating;
	}
}
