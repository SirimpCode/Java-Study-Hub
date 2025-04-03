package my.day09.a.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.DateFormatter;

import my.day01.MyUtil;

public class CalendarMain {

	public static void main(String[] args) {
	//LocalDateTime 타입
	LocalDateTime now = LocalDateTime.now();
	System.out.println(now);//포매터 사용하기  hh 는 12시 표기 방식 HH 는 24시 표기 방식
	DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	System.out.println(now.format(df));
		
		
	LocalDateTime myDate = LocalDateTime.of(2000, 12, 5, 23, 58, 0);
	System.out.println(myDate.format(df));
		
		
		//Date 타입
	Date dateNow= new Date();
	System.out.println(dateNow);//포매터 사용하기
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	System.out.println(sdf.format(dateNow));
		/*
	       <참고>
	         날짜 타입 format         설명
	        --------------------------------------------------
	           %tF              날짜를 yyyy-mm-dd 형식으로 포맷해주는 것
	         %tT              날짜의 시각을 HH:MM:SS 형식으로 포맷해주는 것  
	           %tp              오전, 오후를 출력
	         %tA              요일명 출력
	         %tY              4자리 년도만 출력
	           %tB              월의 이름(January, February ...)출력
	         %tm              월의 01,02,03 ~~ 10,11,12 로 출력
	         %td              일수를 1~31 로 출력
	         %te              %td와 동일함
	         %tk              시간을 0~23 으로 출력
	           %tl              시간을 1~12 으로 출력
	         %tM              분을 00~59 으로 출력
	           %tS              초를 00~59 으로 출력
	         %tZ              타임존을 출력(한국은 KST로 나옴).
	      */
		//String.format 활용 파라미터 LocalDateTime, Date 다 지원 , LocalDateTime 엔 타임존을 포함 안하기 때문에 %tZ는 지원 안한다.
	String currentTime = String.format("%tF %tp %tT %ta %tZ" , dateNow, now, now,now,dateNow);
	System.out.println("세번째출력 "+currentTime);
	
	ZonedDateTime zonedNow = ZonedDateTime.now();
	System.out.println(zonedNow);
		
	sdf = new SimpleDateFormat("yyyyMMdd");
	sdf.setLenient(false);// 실제로 있는 날짜만 대입이 됨. 없을경우 20050431 과 같이 없는 날짜도 익셉션이 안뜸
		
		
	df = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		//문자열을 날짜형태로 변환하기
	try {
		TemporalAccessor ta = df.parse("20050430");
//			LocalDateTime.from(ta);
			
		Date d = sdf.parse("20050430");
			

		Date date1 = sdf.parse(String.join("", "2005-04-03".split("\\-")));
		Date date2 = sdf.parse("20050405");//뜬금 스플릿조인 연습해보기
		
		if(date1.after(date2))
			System.out.println("date1이 date2 이후입니다.");
		if(date1.before(date2))
			System.out.println("date1이 date2 이전입니다.");
		if(date1.equals(date2))
			System.out.println("date1이 date2 이 같은 날 입니다.");
			
		System.out.println(date1.compareTo(date2));
	}catch(ParseException e) {
		//존재 하지 않는 날짜는 여기로 잡혀온다. 또는 이상한 문자열을 넣었을때도
		e.printStackTrace();
	}
		
		
		/* 
        >> Date 클래스에서 제공하는 compareTo() 메소드 <<
        
           date1.compareTo(date2);
        
             date1 날짜와 date2 날짜가 동일하면 0을 반환하고,
             date1 날짜가 date2 날짜 보다 이전 날짜인 경우 -1을 반환하고, 
             반대로 date1 날짜가 date2 날짜 보다 이후 날짜인 경우 경우 1을 반환한다. 
     */
		
		
	LocalDateTime sihu = LocalDateTime.of(2000, 12, 5, 0, 0);
	LocalDateTime jihe = LocalDateTime.of(2000, 3, 1, 0, 0);
		

	int sihuAge = now.isBefore(sihu.withYear(now.getYear())) ? 
			now.getYear()-sihu.getYear() - 1 : now.getYear()-sihu.getYear();
		
	int jiheAge = now.isBefore(jihe.withYear(now.getYear())) ? 
			now.getYear()-jihe.getYear() - 1 : now.getYear()-jihe.getYear();
		
		
		
		
//		
//		System.out.printf("""
//				시후 나이 : %d
//				지헤 나이 : %d  
//				""",sihuAge, jiheAge);
		
				
			
			
	System.out.println("\n"+"=".repeat(100)+"\n");
		
		// 주민번호 7자리로 만 나이를 알려주기
		
	String sihuId = "0004053";
//		String sihuId = "0012054";
	int sihuAge2 = MyUtil.getAge(sihuId);
		
	System.out.println(sihuAge2);
		
	System.out.println("\n"+"=".repeat(100)+"\n");
		
		/* 
        Date 클래스 보다 조금 더 향상시켜서 나온 것이 Calendar 클래스이다.
        간단한 날짜표현에는 Date 클래스를 사용하는 것이 더 나을 수 있으나,
        두 개 날짜사이의 날짜연산을 할 경우에는 메소드기능이 더 많이 추가된 
        Calendar 클래스를 사용하는 것이 나을 수 있다.
     */
	Calendar calendar = Calendar.getInstance();//현재 날짜와 시간
		
		//년도 가져오기
	int year = calendar.get(Calendar.YEAR);
	System.out.println(year);
		//월 가져오기 (0 ~ 11 까지 나오므로 +1 을 꼭 넣어줘야한다.)
	int month = calendar.get(Calendar.MONTH)+1;
	System.out.println(month);
	/*주의해야할 것은 get(Calendar.MONTH)로 얻어오는 값의 범위가 1~12가 아닌, 0~11 이라는 것이다. 
         그래서 get(Calendar.MONTH)로 얻어오는 값이 0이면 1월을 의미하고 11이면 12월을 의미한다.*/
		
		// WEEK_OF_ 메서드
	System.out.println("이 해의 몇 째 주: " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("이 달의 몇 째 주: " + calendar.get(Calendar.WEEK_OF_MONTH));
	    
	    
    System.out.println("이 달의 몇 일: " + calendar.get(Calendar.DATE));
    System.out.println("이 달의 몇 일: " + calendar.get(Calendar.DAY_OF_MONTH));
	     // currentDate.get(Calendar.DATE) 와 Calendar.DAY_OF_MONTH 은 같은 것이다.
    System.out.println("이 해의 몇 일: " + calendar.get(Calendar.DAY_OF_YEAR));
	       
	       // 1:일요일, 2:월요일, 3:화요일, 4:수요일, 5:목요일, 6:금요일, 7:토요일
    System.out.println("요일(1~7, 1:일요일): " + calendar.get(Calendar.DAY_OF_WEEK)); 
    System.out.println("이 달의 몇 째 주: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    System.out.println("오전_오후(0:오전, 1:오후): " + calendar.get(Calendar.AM_PM));
    System.out.println("시간(0~11): " + calendar.get(Calendar.HOUR));
    System.out.println("시간(0~23): " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("분(0~59): " + calendar.get(Calendar.MINUTE));
    System.out.println("초(0~59): " + calendar.get(Calendar.SECOND));
    System.out.println("1000분의 1초(0~999): " + calendar.get(Calendar.MILLISECOND));
	 // 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
    System.out.println("TimeZone(-12~+12): " + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
	      
	      // 이 달의 마지막 일을 찾는다.
    System.out.println("이 달의 마지막 날: " + calendar.getActualMaximum(Calendar.DATE) );
	       
	    
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	      
    Calendar current_now = Calendar.getInstance();
    SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      
	    
	      // === 어제시각 나타내기 ===
    current_now.add(Calendar.DATE, -1);
    System.out.println("어제시각 => " + current_now);
    System.out.println("어제시각 => " + current_now.getTime() );
    System.out.println("어제시각 => " + sdfmt.format(current_now.getTime()) );
	    
	    
	 // === 현재시각 나타내기 ===
	current_now = Calendar.getInstance();
	System.out.println("현재시각 => " + sdfmt.format(current_now.getTime()) );

	       //년 월 일 요일 출력
	System.out.println(now.minusDays(4).getDayOfWeek().getValue());
	    
	
	
	System.out.println("현재시각으로 부터 1년 2개월 3일 4시간 5분 6초 후");
	
	LocalDateTime mission = now.plusYears(1)
			.plusMonths(2)
			.plusDays(3)
			.plusHours(4)
			.plusMinutes(5)
			.plusMinutes(6);
	
	df = df.ofPattern("yyyy-MM-dd HH:mm:dd");
	System.out.println(df.format(mission));
	   
	}

}
