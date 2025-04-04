package my.day11.inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class CommonMember {
	
	private String id;
	private String password;
	private String name;
	private String registerDay;
	
	
	private String registerSetting() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return df.format(LocalDateTime.now());
	}
	protected CommonMember (Builder<? extends Builder<?>> builder) {
		this.name = builder.name;
        this.id = builder.id;
        this.password = builder.password;    
		this.registerDay = registerSetting();
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
    	private String registerDay;

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
        public T withPrice(String registerDay) {
            this.registerDay = registerDay;
            return self();
        }

        protected abstract T self();

        public abstract CommonMember build();
    }
	
}
