package my.day11.inheritance.user.jobseeker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import my.day01.MyUtil;
import my.day11.inheritance.user.CommonMember;
import my.day11.inheritance.user.CommonMember.Builder;

public class JobSeeker extends CommonMember{
	
	private String userPrimaryKey; 
	private Gender gender;
	
	private static int count;
	
	public void setUserPrimaryKey(String pk) {
		this.userPrimaryKey = pk;
	}
	
	private JobSeeker(JobSeeker.Builder builder) {
		super(builder);
		this.userPrimaryKey = builder.userPrimaryKey;
		try {
			if(!(MyUtil.validationUserField(UserFieldEnum.PRIMARY_KEY, userPrimaryKey)))
				throw new RuntimeException("주민등록번호 유효성 검사 실패");
		}catch(NullPointerException e) {
			throw new RuntimeException("주민등록번호값은 필수 입니다.");
		}
		
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
	
	public String getMyInfo(boolean masking) {
		
		return masking?
				super.getId()+"\t"+super.maskingPassword()+ "\t"+super.getName()+	"\t"+ replaceUserPk() +"\t\t"+MyUtil.getAge(userPrimaryKey)+ "\t"+this.gender.getValue() + "\t"+ super.getRegisterDay() :
					super.getId()+"\t"+super.getPassword()+ "\t"+super.getName()+	"\t"+ replaceUserPk() +"\t\t"+MyUtil.getAge(userPrimaryKey)+ "\t"+this.gender.getValue() + "\t"+ super.getRegisterDay();
					
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
