package my.day18.collection.gujikja.repository;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Company extends CommonMember{
// 	Company 클래스는 CommonMember 클래스에 생성되어진 field 및 method 및 기본생성자를 상속 받아온다.
//  CommonMember 클래스는 Company 클래스의 부모클래스 가 되어지고,
//  Company 클래스는 CommonMember 클래스의 자식클래스 가 되어진다.	
	
	// field 생성
	// field 의 캡슐화(Encapsulation == 은닉화)
	private String business_number;  // 사업자등록번호
	private String job_type;         // 회사직종타입(제조업, 서비스업, IT, ....)
	private long seed_money;         // 자본금
	

	// 기본생성자 생략됨!!
	/*
		public Company() {
			super();
		}
	*/
		
	// method 생성
		
	// 캡슐화(Encapsulation == 은닉화) 되어진 field 를 메소드를 통해 접근하도록 만들기 //
	// == getter, setter 하기 ==
	
	public String getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(String business_number) {
				
		// 사업자등록번호는 오로지 숫자로만 들어와야 하며
		// 첫글자는 0 이 들어올 수 없다.
		// 또한 사업자 등록번호의 길이는 10글자가 되어야 한다.
		
		// >> 정규표현식(Regular Expression)이란? <<
		// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어
					
		// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		Pattern p = Pattern.compile("^[1-9][0-9]{9}$");
		// ^ 은 시작을 의미한다.
		// $ 는 끝을 의미한다.
		// [] 는 글자 1개가 들어오는 것을 의미한다.
		// [1-9] 는 글자 1개가 들어오는데 1 부터 9 까지만 가능하다.
		// [0-9] 는 글자 1개가 들어오는데 0 부터 9 까지만 가능하다.
		// [0-9]{9} 는 0 부터 9 까지만 가능한 것이 9번 들어와야 한다.
		
		// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
		Matcher m = p.matcher(business_number);
					
		// == 3. 판별하도록 한다. == //
		if(m.matches()) {
			this.business_number = business_number;
		}
		else {
			System.out.println("[경고] 사업자등록번호는 숫자로 10자리만 가능합니다. 첫글자는 0이 안돼요!! \n"); 
		}
		
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		
		if(job_type == null || job_type.isBlank()) {
			System.out.println("[경고] 회사직종군은 공백이 아닌 글자로 입력하셔야 합니다.\n");
		}
		else {
			this.job_type = job_type;
		}
	}

	public long getSeed_money() {
		return seed_money;
	}

	public void setSeed_money(long seed_money) {
		
		if(seed_money <= 0) {
			System.out.println("[경고] 자본금은 0 보다 커야 합니다.\n");
		}
		else {
			this.seed_money = seed_money;
		}
	}
	
	@Override
	public void setName(String name) {
		// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		Pattern p = Pattern.compile("^[가-힣A-Za-z]{2,6}$");
		
		// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
		Matcher m = p.matcher(name);
		
		// == 3. 판별하도록 한다. == //
		if(m.matches()) {
			super.setName(name);
		}
		else {
			System.out.println("[경고] 회사명은 공백이 없는 한글 또는 영어로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 합니다.\n"); 
		}
	}
	
	@Override
	public String getInfo() {
		                                                     
		return  super.getName() + "\t"    // 회사명
		        + job_type + "\t"         // 업종 
		        + business_number + "\t"  // 사업자등록번호
		        + new DecimalFormat("#,###").format(seed_money)+"원";  // 자본금         
	}

	@Override
	public boolean allNotNull() {
		return this.getId() != null && this.getPasswd() != null && this.getName() != null
				&& this.getBusiness_number() != null && this.getJob_type() != null && this.getSeed_money() > 0;
	}
	
}








