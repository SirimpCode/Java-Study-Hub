package my.day11.inheritance.user.jobseeker;

import my.day11.inheritance.utils.EnumInterface;

public enum Gender implements EnumInterface{
	MAIL("남성"),
	FEMAIL("여성");
	private final String kor;
	Gender(String kor){
		this.kor = kor;
	}
	public String getValue() {
		return this.kor;
	}
}
