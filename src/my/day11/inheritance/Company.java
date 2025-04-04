package my.day11.inheritance;

public class Company extends CommonMember {
	

	private String businessNum;
	
	public String getBusinessNum() {
		return this.businessNum;
	}
	
	protected Company(Company.Builder builder) {
		super(builder);
		this.businessNum = builder.businessNum;
		
	}
	public static Company.Builder builder(){
		return new Company.Builder();
	}
	
	
	public static class Builder extends CommonMember.Builder<Builder>{

		// 주민번호인데 앞자리 6자리에 + 성별을 나타내는 1자리까지만 입력한다.
	    // 예: "9506201"  "9607202"   "0006203"  "0007204"  "1106203"
		private String businessNum; 

		
		public Company.Builder businessNum(String businessNum){
			this.businessNum = businessNum;
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
	
	
}
