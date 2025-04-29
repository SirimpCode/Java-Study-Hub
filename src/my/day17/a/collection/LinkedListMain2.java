package my.day17.a.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 == LinkedList == 
   1. 출력시 저장된 순서대로 나온다.
   2. 중복된 데이터를 저장할 수 있다.
   3. 데이터를 읽어오는 속도는 LinkedList 가 ArrayList 보다 상대적으로 느리다.
   4. 순차적으로 데이터를 추가/삭제하는 경우에는 LinkedList 가  ArrayList 보다 상대적으로 느리다.
   5. 일반적인 데이터 추가/삭제는 데이터 중간 중간마다 발생하므로 이러한 경우에는 LinkedList 가 ArrayList 보다 상대적으로 빠르다.    
   6. 결과값은 ArrayList 를 사용하든지 LinkedList 를 사용하든지 동일한 결과값을 가진다.
   7. LinkedList 보다는 ArrayList 를 사용하도록 하자. 
   
   == LinkedList (저장소) ==   
   
             유재석(자신의 메모리주소 1372)----(앞서존재하던객체의 메모리주소 1372)엄정화(자신의 메모리주소 3236)----(앞서존재하던객체의 메모리주소 3236)강호동(자신의 메모리주소 1034)----(앞서존재하던객체의 메모리주소 1034)이순신(자신의 메모리주소 2340)---(앞서존재하던객체의 메모리주소 2340)김태희(자신의 메모리주소 5236)   
   
   == 엄정화 를 삭제할 경우
             유재석(자신의 메모리주소 1372)----(앞서존재하던객체의 메모리주소 1372)강호동(자신의 메모리주소 1034)----(앞서존재하던객체의 메모리주소 1034)이순신(자신의 메모리주소 2340)---(앞서존재하던객체의 메모리주소 2340)김태희(자신의 메모리주소 5236)
       
   == 엄정화 를 특정 위치에 추가할 경우
             엄정화(자신의 메모리주소 7876)를 유재석 다음에 추가하고자 한다.
             유재석(자신의 메모리주소 1372)----(앞서존재하던객체의 메모리주소 1372)엄정화(자신의 메모리주소 7876)----(앞서존재하던객체의 메모리주소 7876)강호동(자신의 메모리주소 1034)----(앞서존재하던객체의 메모리주소 1034)이순신(자신의 메모리주소 2340)---(앞서존재하던객체의 메모리주소 2340)김태희(자신의 메모리주소 5236)
 */
public class LinkedListMain2 {
	public static void main(String[] args) {
		List<Member> mbrList = new LinkedList<>();
		Member member1 = Member.startBuilder().id("youjs").passwd("Qwer1234$").name("유재석").jubun("7209101").build();
		Member member2 = Member.startBuilder().id("eom").passwd("Qwer1234$").name("엄정화").jubun("6808152").build();
		Member member3 = Member.startBuilder().id("kanghd").passwd("Qwer1234$").name("강호동").jubun("7006151").build();
		Member member4 = Member.startBuilder().id("leess").passwd("Qwer1234$").name("이순신").jubun("0010203").build();
		Member member5 = Member.startBuilder().id("kimth").passwd("Qwer1234$").name("김태희").jubun("0105064").build();
		Member member6 = Member.startBuilder().id("kangkc").passwd("Qwer1234$").name("강감찬").jubun("9812301").build();
		Member member7 = Member.startBuilder().id("kimss").passwd("Qwer1234$").name("김순신").jubun("0203203").build();
		// Member 클래스의 객체 7개를 생성하여 mbrList 에 저장한다.
		mbrList.addAll(List.of(member1, member2, member3, member4, member5, member6, member7));
		for (Member mem : mbrList)
			System.out.println(mem.getInfo());

		List<Member> testListOf = List.of(member1, member2, member3, member4, member5, member6, member7);// 이건 불변리스트로
																											// 만들어짐
//		testListOf.add(member7);
//		testListOf.set(0, member7); 이거 둘다 에러뜬다.

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		mbrList.forEach(m -> System.out.println(m.getInfo()));
		mbrList.stream().forEach(m -> System.out.println(m.getInfo()));

		System.out.println("\n퀴즈1 저장되어진 모든 회원들중에 여자만 정보를 출력\n");
		// for문
		boolean isFind = false;
		for (Member mem : mbrList)
			if (mem.getGender().equals("여")) {
				isFind = true;
				System.out.println(mem.getInfo());
			}
		if(!isFind) System.out.println(">> mbrList에는 여자가 없어여 <<");		
			

		System.out.println("\n퀴즈1 저장되어진 모든 회원들중에 여자만 정보를 출력 스트림 필터 활용\n");
		// stream filter
		mbrList.stream().filter(m -> m.getGender().equals("여")).forEach(m -> System.out.println(m.getInfo()));
		
		
		System.out.println("\n[퀴즈2] 김씨만 출력하기 \n");
		boolean isFind2 = false;
		for(Member mem:mbrList) {
			if(mem.getName().startsWith("김")) {
				isFind2 = true;
				System.out.println(mem.getInfo());
			}
		}
		if(!isFind2) System.out.println(">> mbrList에는 김씨가 없어여 <<");		

		
		System.out.println("\n[퀴즈3] 순신이만 출력하기 \n");
		isFind2 = false;
		for(Member mem:mbrList) {
			if(mem.getName().endsWith("순신")) {
				isFind2 = true;
				System.out.println(mem.getInfo());
			}
		}
		if(!isFind2) System.out.println(">> mbrList에는 순신이가 없어여 <<");
		

		System.out.println("\n[퀴즈4] 성명에 \"정\" 글자가 들어간 회원 출력 \n");
		isFind2 = false;
		for(Member mem : mbrList) {
			if(mem.getName().contains("정")) {
				isFind2 = true;
				System.out.println(mem.getInfo());
			}
		}
		if(!isFind2) System.out.println(">> mbrList에는 정자들어간 회원이 없어여 <<");
		
		System.out.println("\n[퀴즈5] 나이가 20대인 회원만 출력\n");
		isFind = false;
		for(Member mem : mbrList) {
			if((mem.getAge()/10)==2) {
				isFind = true;
				System.out.println(mem.getInfo());
			}
		}
		if(!isFind) System.out.println(">> mbrList에는 20대 회원이 없어여 <<");
		
		System.out.println("\n~~~~~~~또는~~~~~~~~\n");
		isFind = false;
		for(Member mem : mbrList) {
			switch(mem.getAge()/10) {
				case 2: 
					isFind = true;
					System.out.println(mem.getInfo());
			}
		}
		if(!isFind) System.out.println(">> mbrList에는 20대 회원이 없어여 <<");
		
		
		
		mbrList.add(Member.startBuilder().id("seolh").passwd("Qwer1234$").name("설현").jubun("9910152").build());
		//index가 없으면 맨뒤에 추가됨
		System.out.println(mbrList.get(mbrList.size()-1).getInfo());		
		
		
		//인덱스를 넣으면 해당인덱스에 삽입된다. 그리고  원래있던 객체들은 한칸씩 뒤로밀린다.
		mbrList.add(3, Member.startBuilder().id("seokj").passwd("Qwer1234$").name("서강준").jubun("0110153").build());
		System.out.println(mbrList.get(3).getInfo());
		
		

		System.out.println("\n남자들 다지우기\n");
		
		//에러 발생 한다. 원래 콜렉션 크기가 10이었다면 스트림으로 10개를 내려보낼텐데 리무브를 진행하면 지워지며 인덱스가 앞으로땡겨지고 뒤쪽인덱스는 null값이 되어버린다.
//		mbrList.stream().filter(m->m.getGender().equals("남")).forEach(m->mbrList.remove(m));
		List<Member> deleteList = mbrList.stream().filter(m->m.getGender().equals("남")).toList();
		mbrList.removeAll(deleteList);//이렇게 한다면 해결
		mbrList.forEach(m->System.out.println(m.getInfo()));
		
		mbrList.clear();//리스트내에 모든 객체를 지운다.
		
	}
}
