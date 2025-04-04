package my.day11.inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import my.day01.MyUtil;

public class JobSeeker extends CommonMember{
	
	private String userPrimaryKey; 
	private Gender gender;
	
	private static int count;
	
	
	private JobSeeker(JobSeeker.Builder builder) {
		super(builder);
		this.userPrimaryKey = builder.userPrimaryKey;
		this.gender = createGenderByUserPk(builder.userPrimaryKey);
		count++;
	}
	
	private Gender createGenderByUserPk(String userPk) {
		return switch(userPk.substring(6)) {
		case "1","3" -> Gender.MAIL;
		case "2", "4" -> Gender.FEMAIL;
		default -> throw new StringIndexOutOfBoundsException("주민번호 뒷자의 성별 구분자가 잘못 입력됨");
		};
	}
	
	private String replaceUserPk() {
		return this.userPrimaryKey.substring(0,6)+"-"+this.userPrimaryKey.substring(6)+"******";
	}
	
	private String maskingPassword() {
		String password = super.getPassword();
		return password.substring(0,3)+"*".repeat(password.length()-3);
	}
	public String getMyInfo() {
		
		return super.getId()+"\t"+maskingPassword()+ "\t"+super.getName()+	"\t"+ replaceUserPk() +"\t\t"+MyUtil.getAge(userPrimaryKey)+ "\t"+this.gender.getValue() + "\t"+ super.getRegisterDay();
	}

	//게터 메서드들
	public static int getCount() {
		return count;
	}
	public Gender getGender() {
		return this.gender;
	}
	public String getUserPrimaryKey() {
		return this.userPrimaryKey;
	}
	
	
	
	//빌더
	public static JobSeeker.Builder builder(){
		return new JobSeeker.Builder();
	}
	public static class Builder extends CommonMember.Builder<Builder>{

		// 주민번호인데 앞자리 6자리에 + 성별을 나타내는 1자리까지만 입력한다.
	    // 예: "9506201"  "9607202"   "0006203"  "0007204"  "1106203"
		private String userPrimaryKey; 

		
		public JobSeeker.Builder userPrimaryKey(String userPrimaryKey){
			this.userPrimaryKey = userPrimaryKey;
			return this;
		}
		@Override
		public JobSeeker build() {
			return new JobSeeker(this);
		}
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	
	public enum UserFieldEnum{
		ID,
		PASSWORD,
		PRIMARY_KEY,
		NAME;
	
	}
}
