package my.day11.inheritance.user.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import my.day11.inheritance.user.CommonMember;
import my.day11.inheritance.user.company.Company.Builder;

public class RecruitPost {
	
	private int postId;  //1001 시작해서 매번 1씩 증가
	private Company company; // 회사
	private String title; //채용제목  낫널 과 isBlank 적용
	private	String workType; //근무형태 낫널 과 isBlank 적용
	private int cnt; // 채용인원 0명초과여야함
	private int salGrade; //영봉 0원 초과
	private String createdAt; // 채용공고 등록일자
	private String finishDay; //채용 마감일자
	
	
	public static int genereatedId = 1001; // 객체의 고유 번호 
	
	public String getPostInfo() {
		return postId+"\t"+title+"\t\t"+(title.length()>10 ? "":"\t")+company.getName()+"\t"+workType+"\t"+cnt+"명\t"+salGrade+"\t"+finishDay+"\t"+createdAt;
	}
	
	private RecruitPost(RecruitPost.Builder builder) {
		this.finishDay = setDateToString( validFinishDay(builder.finishDay) );
		this.title = builder.title;
		this.workType = builder.workType;
		this.cnt = builder.cnt;
		this.salGrade = builder.salGrade;
		this.company = builder.company;
		validFields();
		this.createdAt = this.setDateToString(LocalDate.now());
		this.postId = genereatedId++;
	}
	private void validFields( ) {
		if(this.cnt<=0||this.salGrade<=0)
			throw new NumberFormatException("채용 인원과 연봉 값은 0이 초과되어야 합니다.");
		if(this.company==null||this.title==null||this.workType==null||this.finishDay==null)
			throw new NullPointerException("게시물 필수 필드값에 null 발견");
		if(this.title.isBlank()||this.workType.isBlank()||this.finishDay.isBlank())
			throw new NullPointerException("게시물 필수 필드 값에 공백만 들어옴");
	}
	private LocalDate validFinishDay(String dayStr) {
		
		try {
			int year = Integer.parseInt(dayStr.substring(0,4));
			int month = Integer.parseInt(dayStr.substring(4,6));
			int day = Integer.parseInt(dayStr.substring(6,8));
			
//			LocalDate finishDate = LocalDate.of(year, month, day);
//			if(LocalDate.now().isBefore(finishDate))
//				throw new RuntimeException("마감일자는 현재 날짜 보다 이전 이어야 합니다.");
			
			return LocalDate.of(year, month, day);
		}catch(NumberFormatException e) {
			throw new NumberFormatException("마감 일자에 숫자가 아닌 다른값이 들어왔습니다.");
		}catch(DateTimeException e) {
			throw new DateTimeException("마감 일자가 존재하지 않는 날짜입니다.");
		}
	}
	private String setDateToString(LocalDate date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return df.format(date);
	}
	
	//게터세터
	public int getPostId() {
		return postId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSalGrade() {
		return salGrade;
	}
	public void setSalGrade(int salGrade) {
		this.salGrade = salGrade;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getFinishDay() {
		return finishDay;
	}
	public void setFinishDay(String finishDay) {
		this.finishDay = finishDay;
	}
	
	public static Builder fromBuilder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private Company company; // 회사
		private String title; //채용제목  낫널 과 isBlank 적용
		private	String workType; //근무형태 낫널 과 isBlank 적용
		private int cnt; // 채용인원 0명초과여야함
		private int salGrade; //영봉 0원 초과
		private String finishDay; //채용 마감일자 yyyyMMdd 방식
		
		public RecruitPost.Builder company(Company company){
			this.company = company;
			return this;
		}
		public RecruitPost.Builder title(String title){
			this.title = title;
			return this;
		}
		public RecruitPost.Builder salGrade(int salGrade){
			this.salGrade = salGrade;
			return this;
		}
		public RecruitPost.Builder cnt(int cnt){
			this.cnt = cnt;
			return this;
		}
		public RecruitPost.Builder finishDay(String finishDay){
			this.finishDay = finishDay;
			return this;
		}
		public RecruitPost.Builder workType(String workType){
			this.workType = workType;
			return this;
		}
		public RecruitPost build() {
			return new RecruitPost(this);
		}
	}
}
