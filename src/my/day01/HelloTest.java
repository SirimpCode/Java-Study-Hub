package my.day01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HelloTest {

    public static void main(String[] args) {
        
        for (int i=0; i<10; i++) {
//        	System.out.println(i+1+"번 반복");
        	switch(i) {
        		case 5: System.out.println(i+1+"왜두번나옴"); break;
        		case 6: System.out.println(i+1+"af왜두번나옴ㅇㅇ"); break;
//        		default : System.out.println("기본값");
        	}
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 - hh시 mm분 ss초");
    	String now1 = LocalDateTime.now().format(format);
    	Date now2 = new Date();
    	System.out.println(now1+"\n"+now2);
       
    }

}
