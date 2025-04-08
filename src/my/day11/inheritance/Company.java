package my.day11.inheritance;

import java.text.DecimalFormat;

import my.day01.MyUtil;

public class Company extends CommonMember {
	

	private String businessNum;
	
	private String jobType; //직종
	private long seedMoney; // 자본금
	
	private static int count; //company 의 개수
	
	public String getBusinessNum() {
		return this.businessNum;
	}
	public String getJobType() {
		return this.jobType;
	}
	public long getSeedMoney() {
		return this.seedMoney;
	}
	public static int getCount() {
		return count;
	}
	
	
	
	
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public void setSeedMoney(long seedMoney) {
		this.seedMoney = seedMoney;
	}
	
	private void validBusiNum() {
		//첫글자 하나는 1부터 9까지 뒤에 9글자는 0-9까지
		if(!this.businessNum.matches("^[1-9][0-9]{9}$"))
			throw new RuntimeException("사업자 등록번호 유효성 검사 실패");
	}
	private void validSeedMoney() {
		if(this.seedMoney<=0)
			throw new RuntimeException("자본금은 0보다 커야 합니다.");
	}
	
	
	protected Company(Company.Builder builder) {
		super(builder);
		this.businessNum = builder.businessNum;
		validBusiNum();
		this.jobType = builder.jobType;
		this.seedMoney = builder.seedMoney;
		validSeedMoney();
		count++;
	}
	public static Company.Builder builder(){
		return new Company.Builder();
	}


	/* new DecimalFormat("#.###").format(800000000000L);
    
    >>> 삼성 기업의 정보 <<<
    ----------------------------------------------------------------------------------
      아이디     비밀번호      회사명   가입일자      사업자등록번호  직종타입   자본금				 가입일자
    ----------------------------------------------------------------------------------  
      samsung  Abcd1234$   삼성     2025-04-07  8123456789   제조업    8,000,000,000원
*/
	
	public String parsingSeedMoney() {
		return new DecimalFormat("#,###").format(this.seedMoney);
	}
	public String getMyInfo(boolean masking) {
		return masking?
				super.getId()+"\t"+super.maskingPassword()+ "\t"+
				(super.getName().length()<6 ? super.getName()+"\t\t":super.getName()+"\t")+ this.businessNum +"\t\t"+this.jobType+ "\t"+parsingSeedMoney() + "\t"+ super.getRegisterDay():
					super.getId()+"\t"+super.getPassword()+ "\t"+
					(super.getName().length()<6 ? super.getName()+"\t\t":super.getName()+"\t")+ this.businessNum +"\t\t"+this.jobType+ "\t"+parsingSeedMoney() + "\t"+ super.getRegisterDay();
	}

	
	
	public static class Builder extends CommonMember.Builder<Builder>{


		private String businessNum; 
		private String jobType;
		private long seedMoney;
		
		public Company.Builder businessNum(String businessNum){
			this.businessNum = businessNum;
			return this;
		}
		public Company.Builder jobType(String jobType){
			this.jobType = jobType;
			return this;
		}
		public Company.Builder seedMoney(long seedMoney){
			this.seedMoney = seedMoney;
			return this;
		}
		@Override
		public Company build() {
			return new Company(this);
		}
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	public enum CompanyFieldEnum{
		ID,
		PASSWORD,
		BUSINESS_NUM,
		JOB_TYPE,
		SEED_MONEY,
		NAME;
	
	}
}
