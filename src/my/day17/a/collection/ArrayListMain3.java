package my.day17.a.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
/*
Stream 클래스는 컬렉션(리스트, 셋 등)에 저장된 데이터를 쉽게 처리할 수 있게 해주는 기능을 가진 클래스이다.
  Stream 은 반복문(for, while) 없이도 데이터를 필터링, 변환, 정렬, 집계 등 다양한 작업을 간단하게 할 수 있게 해준다.
  
  >> Stream 클래스의 주요 메서드 요약 <<
---------------------------------------------------   
 메서드           설명
---------------------------------------------------   
.stream()       컬렉션에서 Stream 생성
.filter()       조건에 맞는 값만 추림
.map()           어떤 객체를 다른 객체로 변환할 때 사용 <예: String 을 Integer, Person 을 이름>
.mapToInt()     스트림 요소를 int 윈시형으로 변환. 숫자 연산시 사용
.mapToLong()    스트림 요소를 long 윈시형으로 변환. 숫자 연산시 사용
.mapToDouble()  스트림 요소를 double 윈시형으로 변환. 숫자 연산시 사용
.sorted()       정렬
.collect()       다시 리스트 등으로 모음
.forEach()       각각에 대해 실행
.count()       개수 반환
.anyMatch()       조건 만족하는 게 하나라도 있으면 true, 모두가 만족하지 않으면 false
.allMatch()       모두 조건을 만족하면 true, 하나라도 조건을 만족하지 않으면 false
.reduce()       누적 연산(합계 등)
.max()          최대값
.min()          최소값
.sum()          합계
.average()      평균
  ---------------------------------------------------
*/
public class ArrayListMain3 {
	private static List<Member> mbrList = new ArrayList<>();

	public static void main(String[] args) {
		// Member 클래스의 객체 7개를 생성하여 mbrList 에 저장한다.
		mbrList.addAll(List.of(
				 Member.startBuilder().id("youjs").passwd("Qwer1234$").name("유재석").jubun("7209101").build(), 
				 Member.startBuilder().id("eom").passwd("Qwer1234$").name("엄정화").jubun("6808152").build(), 
				 Member.startBuilder().id("kanghd").passwd("Qwer1234$").name("강호동").jubun("7006151").build(), 
				 Member.startBuilder().id("leess").passwd("Qwer1234$").name("이순신").jubun("0010203").build(),
				 Member.startBuilder().id("kimth").passwd("Qwer1234$").name("김태희").jubun("0105064").build(), 
				 Member.startBuilder().id("kangkc").passwd("Qwer1234$").name("강감찬").jubun("9812301").build(),
				 Member.startBuilder().id("kimss").passwd("Qwer1234$").name("김순신").jubun("0203203").build()));
		
		System.out.println("\n"+"=".repeat(40)+"\n");
		
		//차이점 컬렉션의 forEach() 메서드와 Stream 의 forEach() 메서드
		// 컬렉션의 forEach() 메서드는 컬렉션에 저장된 모든 요소를 순회하면서 각 요소에 대해 지정된 작업을 수행한다.
		// Stream 의 forEach() 메서드는 스트림에 저장된 모든 요소를 순회하면서 각 요소에 대해 지정된 작업을 수행한다.
		mbrList.forEach(m -> System.out.println(m.getInfo()));
		mbrList.stream().forEach(m -> System.out.println(m.getInfo()));
		System.out.println("\n"+"=".repeat(40)+"\n");
		
		mbrList.forEach(Member::getInfo);
		System.out.println("\n"+"@".repeat(40)+"\n");
		
		mbrList.stream().forEach(m-> m.getInfo());
		
		mbrList.stream().map(Member::getInfo).forEach(System.out::println);
		
		//연습 mbrList 에 저장된 모든 회원들의 이름을 출력하시오.
		mbrList.stream().map(Member::getName).forEach(System.out::println);
		
		
		/*
		 레퍼런스의 종류
		 1. 인스턴스 메서드 레퍼런스
		 2. 정적 메서드 레퍼런스
		 3. 생성자 레퍼런스
		 4. 매개변수 레퍼런스
		 */
		// 1. 인스턴스 메서드 레퍼런스
		// Member::getInfo 는 Member 클래스의 인스턴스 메서드 getInfo() 를 레퍼런스로 사용한다.
		Member memberTest = Member.startBuilder().build();// 예제 mbrList에 동일한 객체가 존재하는지 filter 문에서 확인함
		mbrList.stream().filter(memberTest::equals).forEach(System.out::println);
		// 2. 정적 메서드 레퍼런스
		// System 클래스의 정적 메서드 println() 을 레퍼런스로 사용
		// System.out::println 은 매개변수로 넘어온 문자열 값을 스태틱메서드를 호출하며 매개변수로 넘어온 매개변수를 넣고 돌려진다.
		// 3. 생성자 레퍼런스
		// Member::new 는 Member 클래스의 생성자를 레퍼런스로 사용한다. 매개변수로 넘어온 값을 Member 클래스의 생성자에 넣고 돌려준다.
		// 4. 매개변수 레퍼런스
		// Member 클래스의 인스턴스 메서드 getInfo() 를 레퍼런스로 사용
		// Member::getInfo 는 매개변수로 넘어온 member 객체 Member 클래스의 인스턴스 메서드 getInfo() 를 레퍼런스로 사용한다.
		
		
		
		System.out.println("\n"+"=".repeat(40)+"\n");
		// 퀴즈1 저장되어진 모든 회원들중에 남자만 성명을 오름차순 출력
		mbrList.stream().filter(m -> m.getGender().equals("남")).sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).forEach(m -> System.out.println(m.getName()));
		System.out.println("\n"+"=".repeat(40)+"\n");
		// 퀴즈2 저장되어진 모든 회원들중에 남자만 나이만 오름차순 출력
		mbrList.stream().filter(m -> m.getGender().equals("남")).sorted(Comparator.comparingInt(m->m.getAge())).forEach(m -> System.out.println(m.getAge()));
		//역순
		mbrList.stream().filter(m -> m.getGender().equals("남")).sorted(Comparator.comparingInt(Member::getAge).reversed()).forEach(m -> System.out.println(m.getAge()));
		
		System.out.println("\n"+"=".repeat(40)+"\n");
		List<Member> manList = mbrList.stream()
				.filter(m -> m.getGender().equals("남")).sorted(Comparator.comparingInt(Member::getAge)).toList();
		
		manList.stream().map(Member::getInfo).forEach(System.out::println);
		
		// 나이가 50대인 회원들만 성명의 오름차순으로
		System.out.println("나이가 50대인 회원들만 성명의 오름차순으로");
		List<Member> oldManList = mbrList.stream()
				.filter(m -> m.getGender().equals("남"))
				.filter(m -> m.getAge() >= 50)
				.sorted(Comparator.comparing(Member::getName))
				.toList();

		
		oldManList.stream().map(Member::getInfo).forEach(System.out::println);
		//여자몇명인지만 불러오기
		long femaleCount = mbrList.stream()
				.filter(m -> m.getGender().equals("여"))
				.count();
		
		System.out.println(femaleCount+"명");
		
		boolean isFind = mbrList.stream()
				.filter(m -> m.getGender().equals("여"))
				.anyMatch(m -> m.getName().startsWith("팕"));
		System.out.println("여자중에 "+(isFind ? "김씨가 있습니다." : "김씨가 없습니다."));
		
		// reduce() 메서드 차곡차곡 쌓기
		long sum = mbrList.stream()
				.filter(m -> m.getGender().equals("여"))
				.mapToInt(Member::getAge)
				.reduce(0, (a, b) -> a + b);//0은 초기값 a는 결과물이 쌓이는곳 b는 현재값
		System.out.println("여자들의 나이 합계 : " + sum);
		//이름 쌓기
		String name = mbrList.stream()
				.filter(m -> m.getGender().equals("여"))
				.map(Member::getName)
				.reduce("", (a, b) -> a + b+", ");//""은 초기값 a는 결과물이 쌓이는곳 b는 현재값
		System.out.println("여자들의 이름 : " + name.substring(0, name.length()-2));
		
		// 나이 평균
		double avg = mbrList.stream()
				.mapToInt(Member::getAge)
				.average()
				.orElse(0.0);
		System.out.println("나이 평균 : " + Math.round(avg*100)/100d);
		// 나이 최대값
		int max = mbrList.stream()
				.mapToInt(Member::getAge)
				.max()
				.orElse(0);
		System.out.println("나이 최대값 : " + max);
		// 나이 최소값
		int min = mbrList.stream()
				.mapToInt(Member::getAge)
				.min()
				.orElse(0);
		System.out.println("나이 최소값 : " + min);
		// 나이 합계
		int sum2 = mbrList.stream()
				.mapToInt(Member::getAge)
				.sum();
		System.out.println("나이 합계 : " + sum2);
		
		
		
		// reduce 활용하기
		int myMin = mbrList.stream()
				.mapToInt(Member::getAge)
				.reduce(Integer.MAX_VALUE, (a, b) -> Math.min(a, b));
		System.out.println("나이 최소값 리듀스 방식 : " + myMin);
		//여기서 mapToInt 는 스트림의 각 요소를 int 원시자료형으로 변환하는 메서드이다.
		
		
		
		
	}

}
