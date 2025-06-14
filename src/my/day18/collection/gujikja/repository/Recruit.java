package my.day18.collection.gujikja.repository;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recruit  {

	// field
	private int recruit_no;       // 채용공고순번 (1001 시작해서 매번 1씩 증가)
	private Company cp;           // 회사
	private String subject;       // 채용제목
	private String work_type;     // 채용분야(근무형태)
	private int cnt;              // 채용인원
	private int yearpay;          // 연봉
	private String register_day;  // 채용공고 등록일자
	private String finish_day;    // 채용마감일자 
	
	static int count = 1001;  
	
	// 기본생성자
	public Recruit() {
		
		Date now = new Date(); // 현재시각
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		register_day = sdf.format(now); // "20250408"

		recruit_no = count++;
	}

	
	// method 
	public int getRecruit_no() {
		return recruit_no;
	}

	public Company getCp() {
		return cp;
	}

	public void setCp(Company cp) {
		
		if(cp != null) {
			this.cp = cp;
		}
		else {
			System.out.println("[경고] 채용하려면 반드시 회사정보를 입력하세요!!\n");
		}
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		
		if(subject != null && !subject.isBlank()) {
			this.subject = subject;	
		}
		else {
			System.out.println("[경고] 채용제목을 필수로 입력해야 합니다.!!\n");
		}
		
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		
		if(work_type != null && !work_type.isBlank()) {
			this.work_type = work_type;	
		}
		else {
			System.out.println("[경고] 채용분야(근무형태)를 필수로 입력해야 합니다.!!\n");
		}
		
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		
		if(cnt > 0) {
			this.cnt = cnt;
		}
		else {
			System.out.println("[경고] 채용인원수는 1명 이상이어야 합니다.!!\n");
		}
	}

	public int getYearpay() {
		return yearpay;
	}

	public void setYearpay(int yearpay) {
		
		if(yearpay > 0) {
			this.yearpay = yearpay;
		}
		else {
			System.out.println("[경고] 연봉은 1 이상이어야 합니다.!!\n");
		}
		
	}

	public String getRegister_day() {
		return register_day;
	}

	public String getFinish_day() {
		return finish_day;
	}

	public void setFinish_day(String finish_day) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		// false 로 해주어야만 입력한 값을 날짜 타입으로 변경할때 날짜로 되지 못하는 값일 경우 오류가 발생한다.
		// 날짜로 파싱될 때 허술하게 하지 말고 엄격하게 하라고 설정해주는 것이라고 생각하면 된다. 
		
		try {
			 Date date_register_day = sdf.parse(register_day);
			 // 채용공고 등록일자 문자열값을 날짜 타입으로 변환
			
			 Date date_finish_day =  sdf.parse(finish_day);
			 // 채용마감 일자 문자열값을 날짜 타입으로 변환
			
			 if(date_finish_day.after(date_register_day)) {
				 this.finish_day = finish_day;
			 }
			 else {
				 System.out.println("[경고] 채용마감일자는 현재일자 보다 이후인 날짜이어야 합니다.\n");
			 }
			
		} catch (ParseException e) {
			System.out.println("[경고] 채용마감일자는 달력에 존재하는 날짜이어야 합니다.\n");
		} 
		
	}
	
	
	// ===== 채용정보를 알려주는 메소드 ===== //
	public String recruit_info() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("=".repeat(50)+"\n");
		sb.append("1.채용번호 : " + recruit_no + "\n");
		sb.append("2.채용제목 : " + subject + "\n");
		sb.append("3.채용분야 : " + work_type + "\n");
		sb.append("4.채용인원 : " + cnt + "\n");
		sb.append("5.연봉 : " + new DecimalFormat("#,###").format(yearpay) + "만원\n");
		sb.append("6.등록일자 : " + register_day.substring(0, 4)+ "-" + register_day.substring(4, 6) +"-" + register_day.substring(6)+"\n"); // 2025-04-08             
		sb.append("7.채용마감일자 : " + finish_day.substring(0, 4)+ "-" + finish_day.substring(4, 6) +"-" + finish_day.substring(6)+"\n");
		sb.append("=".repeat(50)+"\n");
		
		return sb.toString();
	}// end of public String recruit_info()--------------------------------
	
	
	// ===== 채용정보를 알려주는 메소드 ===== //
	public String detail_recruit_info() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("=".repeat(50)+"\n");
		sb.append("1.채용번호 : " + recruit_no + "\n");
		sb.append("2.채용제목 : " + subject + "\n");
		sb.append("3.채용분야 : " + work_type + "\n");
		sb.append("4.채용인원 : " + cnt + "\n");
		sb.append("5.연봉 : " + new DecimalFormat("#,###").format(yearpay) + "만원\n");
		sb.append("6.등록일자 : " + register_day.substring(0, 4)+ "-" + register_day.substring(4, 6) +"-" + register_day.substring(6)+"\n"); // 2025-04-08             
		sb.append("7.채용마감일자 : " + finish_day.substring(0, 4)+ "-" + finish_day.substring(4, 6) +"-" + finish_day.substring(6)+"\n");
		sb.append("8.회사명 : " + cp.getName() + "\n");
		sb.append("9.업종 : " + cp.getJob_type() + "\n");
		sb.append("10.자본금 : " + new DecimalFormat("#,###").format(cp.getSeed_money()) +"원\n");
		sb.append("=".repeat(50)+"\n");
		
		return sb.toString();
	}// end of public String recruit_info()--------------------------------
	
	
}




