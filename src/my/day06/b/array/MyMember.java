package my.day06.b.array;

import java.net.PasswordAuthentication;

public class MyMember {
	private final String name;
	private final String id;
	private final String pw;
	
	private MyMember(String name, String no, String pw) {
		this.name =  name;
		this.id = no;
		this.pw = pw;
	}
	public static MyMember of(String name, String id, String pw) {
		return new MyMember(name, id, pw);
	}
	
	public String getName() {
		return this.name;
	}
	public String getNo() {
		return this.id;
	}
	
	public String getInfo() {
		String maskingPw = "";
		for(int i = 0; i <this.pw.length(); i++) {
			if(i<4)	maskingPw += this.pw.charAt(i);
			else maskingPw += "*";
		}
		return "이름 : "+this.name+"\t\t아이디 : "+this.id+"\t\t비밀번호 : "+maskingPw;
	}
	//두번째 방법
	public String getInfo2() {
		String maskingPw = "";
		for(char i : this.pw.toCharArray()) {
			if(maskingPw.length() >= 4) maskingPw += "*";
			else maskingPw += i;
		}
		return "이름 : "+this.name+"\t\t아이디 : "+this.id+"\t\t비밀번호 : "+maskingPw;
	}
}
