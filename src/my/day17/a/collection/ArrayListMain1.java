package my.day17.a.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
== Array(배열) 와 Collection(자료구조)의 차이점은 ==     

1. Array(배열)은 크기가 한정 되어져 있지만
   Collection(구조체)은 크기가 무한정 이다.
   
2. Array(배열)은 배열에 선언되어진 동일한 타입의 데이터만 입력가능하지만  
   Collection(구조체)은 입력되어지는 데이터가 객체(Object)이기만 하면
   어떤것이든지 입력가능하다. 


==== 배열(Array)과 자료구조(Collection)의 차이점 ====

1. 배열(Array)은 오로지 동일한 데이터 타입만 들어가는 저장소이다.
   배열(Array)은 그 크기가 한번 정해지면 크기를 변경할 수 없다.!!!
 
2. 자료구조(Collection)은 동일한 타입의 객체가 아니더라도
   객체타입이기만 하면 모두 들어가는 저장소이다.
   자료구조(Collection)은 저장되는 크기가 자동적으로 늘어난다.!!!

웹에서 가장 많이 사용하는 대표적인 Collection 타입은 List 계열과 Map 계열이다.

-------------------------------------------------------------------------
              Web에서 주로 사용하는 클래스       게임프로그램밍에서 주로 사용하는 클래스
Interface       (Single Thread 방식)          (Multi Thread 방식)
-------------------------------------------------------------------------           
List 계열    --      ArrayList      ,         Vector
Map  계열    --      HashMap        ,         Hashtable 

ArrayList 및 HashMap 은 Multi Thread를 지원안해주므로 가볍다.
Vector 및 Hashtable 이 Multi Thread를 지원해주므로 무겁다.

Multi Thread를 지원해주는냐 안해주느냐만 차이가 있을 뿐 그 나머지 기능은 동일하다.  
*/
public class ArrayListMain1 {
	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<>(1);//jdk8이후부터는 <> 값 생략해도 변수타입으로 자동적으로 인식한다.
		myList.add("이순신");
		myList.add("엄정화");
		myList.add("마이아파");
		myList.addAll(List.of("일","이","삼"));//크기 1로 할당시켰지만 자동 증가
		myList.add("사");//가능 List.of로 생성된것을 수정하는것이아닌 그냥 어레이리스트를 수정하는것이다.
		myList.set(0, "set으로바꿔버리기");
		System.out.println(myList.get(0));
		System.out.println(myList.size());
		
		
		List<String> myStringList = Arrays.asList("일","이","삼");
//		myStringList.remove(0); 이거 두개 는 불가능 추가 삭제는 안된다 Arrays.asList로 만든건 추가 삭제는 안되고 변경은된다 
//		myStringList.add(0,"테스트");
		myStringList.set(0,"테스트");//가능
		System.out.println(myStringList.get(0));
		
		//아래는 불변 리스트 로 생성된다
		List<String> myOfList = List.of("일","이","삼");
//		myOfList.add("되나"); //얘네 둘다 안됨 불변리스트로생성됨
//		myOfList.set(0, "얘는 안됨");
		System.out.println(myOfList.get(0));
		
		//3으로 고정된크기를 가진 리스트 생성
		List<String> asListTest = Arrays.asList(new String[3]);
		System.out.println(asListTest.size());
		asListTest.set(0, "바꿔");
		for(String a : asListTest)
			System.out.println("포문 "+a);
		/*포문 바꿔
		포문 null
		포문 null*/
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
}
