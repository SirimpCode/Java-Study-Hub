package my.day01;

import java.util.Arrays;
import java.util.List;

public class MemberMain {

	public static void main(String[] args) {

    	List<Member> memberList = Arrays.asList(
    			Member.of("아이디1", "비번", "이순신", "남성", "장수"),
    			 Member.of("아이디2", "비번", "이시후", "남성", "장수풍뎅이"),
    			 Member.of("아이디5", "비번", "철수", "남성", "짱구친구"),
    			 Member.of("아이디2", "비번", "엄정화", "여성", "가수"),
    			 Member.of("아이디3", "비번", "세종대왕", "남성", "왕"),
    			 Member.of("아이디4", "비번", "이방원", "남성", "세종대왕아빠") 
    			);
    	
    	

    	
    	Member.printFirst();
    	memberList.forEach( member-> member.printMethod());
    	
    	System.out.println("\n----------------------------------------------------------\n");
    	memberList.stream().map(member-> member.toStringJr())
    	.forEach(str-> System.out.println(str));
    	
    	
    	System.out.println(MyUtil.currentTime());
	}

}
