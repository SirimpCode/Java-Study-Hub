package my.day17.a.collection;

import java.util.ArrayList;
import java.util.List;

/*
== ArrayList == 
1. 출력시 저장된 순서대로 나온다.
2. 중복된 데이터를 저장할 수 있다.
3. 데이터를 읽어오는 속도는 ArrayList 가 LinkedList 보다 상대적으로 빠르다.
4. 순차적으로 데이터를 추가/삭제하는 경우에는 ArrayList 가 LinkedList 보다 상대적으로 빠르다.
5. 일반적인 데이터 추가/삭제는 데이터 중간 중간마다 발생하므로 이러한 경우에는 ArrayList 가 LinkedList 보다 상대적으로 느리다.
6. 결과값은 ArrayList 를 사용하든지 LinkedList 를 사용하든지 동일한 결과값을 가진다.
7. LinkedList 보다는 ArrayList 를 사용하도록 하자.
*/
public class ArrayListMain {
	public static void main(String[] args) {
		List<Member> mbrList = new ArrayList<>();
		Member member1 = Member.startBuilder().id("youjs").passwd("Qwer1234$").name("유재석").jubun("7209101").build();
		Member member2 = Member.startBuilder().id("eom").passwd("Qwer1234$").name("엄정화").jubun("6808152").build();
		Member member3 = Member.startBuilder().id("kanghd").passwd("Qwer1234$").name("강호동").jubun("7006151").build();
		Member member4 = Member.startBuilder().id("leess").passwd("Qwer1234$").name("이순신").jubun("0010203").build();
		Member member5 = Member.startBuilder().id("kimth").passwd("Qwer1234$").name("김태희").jubun("0105064").build();
		Member member6 = Member.startBuilder().id("kangkc").passwd("Qwer1234$").name("강감찬").jubun("9812301").build();
		Member member7 = Member.startBuilder().id("kimss").passwd("Qwer1234$").name("김순신").jubun("0203203").build();
		// Member 클래스의 객체 7개를 생성하여 mbrList 에 저장한다.
		mbrList.addAll(List.of(member1,member2,member3,member4,member5,member6,member7));
		for(Member mem :mbrList) 
			System.out.println(mem);
		
		
		
		List<Member> testListOf = List.of(member1,member2,member3,member4,member5,member6,member7);//이건 불변리스트로 만들어짐 
//		testListOf.add(member7);
//		testListOf.set(0, member7); 이거 둘다 에러뜬다.
		
	}
}
