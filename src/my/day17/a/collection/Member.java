package my.day17.a.collection;

import my.day01.MyUtil;
import my.day01.MyUtil.Gender;

public class Member {
	private String id;
	private String passwd;
	private String name;
	private String jubun;
	private Member(Builder builder) {
		this.id =builder.id;
		this.passwd =builder.passwd;
		this.name =builder.name;
		this.jubun =builder.jubun;
	}
	public Member(String id, String passwd, String name, String jubun) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.jubun = jubun;
	}
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getName() {
		return name;
	}
	public String getJubun() {
		return jubun;
	}
	public static Builder startBuilder() {
		return new Builder();
	}
	
	
	public static class Builder {

		private String id;
		private String passwd;
		private String name;
		private String jubun;
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public Builder passwd(String passwd) {
			this.passwd = passwd;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder jubun(String jubun) {
			this.jubun = jubun;
			return this;
		}
		public Member build() {
			return new Member(this);
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return "==="+this.name+"님의 회원정보 ===\n"
				+"1. 아이디 : "+this.id+"\n"
				+"2. 암호 : "+this.passwd+"\n"
				+"3. 성명 : "+this.name+"\n"
				+"4. 성별 : "+getGender()+"\n"
				+"5. 만나이 : "+getAge()+"\n";
	}
	public int getAge() {
		return MyUtil.getAge(this.jubun);
	}
	public String getGender() {
		Gender gender = MyUtil.createGender(jubun);
		return switch(gender) {
			case FEMALE,OLDFEMALE -> "여";
			case MALE,OLDMALE -> "남";
		};
	}
	public void printInfo() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println(getInfo());
	};
	
}
