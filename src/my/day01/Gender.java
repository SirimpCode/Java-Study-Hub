package my.day01;

public enum Gender {
	MALE("남성"),
	FEMAIL("여성");
	private final String gender;
	
	Gender (String gender) {
		this.gender = gender;
	}
	public String getKor() {
		return this.gender;
	}
	public static Gender fromKor(String kor) {
        for (Gender gender : Gender.values()) {
        	if(gender.getKor().equals(kor))
        		return gender;
        }
        throw new IllegalArgumentException("성별은 \\\"남성\\\" 혹은 \\\"여성\\\" 이어야 합니다.");
    }

}
