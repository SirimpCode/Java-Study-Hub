package my.day11.inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import my.day01.MyUtil;
import my.day11.inheritance.JobSeeker.UserFieldEnum;


public abstract class CommonMember {
	
	private String id;
	private String password;
	private String name;
	private String registerDay;
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRegisterDay(String day) {
		this.registerDay = day;
	}
	private String registerSetting() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return df.format(LocalDateTime.now());
	}
	private void validation() {
		boolean validId = MyUtil.validationUserField(UserFieldEnum.ID, this.id);
		boolean validPw = MyUtil.validationUserField(UserFieldEnum.PASSWORD, this.password);
		boolean validName = MyUtil.validationUserField(UserFieldEnum.NAME, this.name);
		
		if(!validId||!validPw||!validName) {
			throw new RuntimeException("유저 생성 실패 - 필드 유효성 검사를 통과하지 못했습니다.");
		}
			
	}
	protected String maskingPassword() {
		String password = this.password;
		return password.substring(0,3)+"*".repeat(password.length()-3);
	}
	
	protected CommonMember (Builder<? extends Builder<?>> builder) {
		this.name = builder.name;
        this.id = builder.id;
        this.password = builder.password;    
		this.registerDay = registerSetting();
		try {
			validation();
		}catch(NullPointerException e) {
			throw new RuntimeException("유저 필수 필드 값에 null 값이 들어왔습니다.");
		}
		
	}
	
	//Getter 메서드
	public String getId() {
		return this.id;
	}
	public String getPassword() {
		return this.password;
	}
	public String getName() {
		return this.name;
	}
	public String getRegisterDay() {
		return this.registerDay;
	}
	
	//빌더패턴 추상화
    public abstract static class Builder<T extends Builder<T>> {

    	private String id;
    	private String password;
    	private String name;


        public T withId(String id) {
            this.id = id;
            return self();
        }
        public T withName(String name) {
            this.name = name;
            return self();
        }
        public T withPassword(String password) {
            this.password = password;
            return self();
        }


        protected abstract T self();

        public abstract CommonMember build();
    }
	
}
