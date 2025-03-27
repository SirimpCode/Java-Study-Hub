package my.day04.a.forrepeat;

import java.util.List;

public class forMain {

	public static void main(String[] args) {
		for(int i = 1; i<11; i++) {
			//i++는 한바퀴를 돈 후에 i 에 1을 더한다. 즉 for문 내용을 한번 실행한 후 i + 1 이 연산된다.
			System.out.println(i+"번째 바퀴");
		}
		
		System.out.println("\n");
		for(int i = 1; i<11; ++i) {
			//전위 연산자도 동일하게 동작함
			System.out.println(i+"번째 바퀴");
		}
		
		//배열에 for문을 이용하기
		System.out.println("\n");
		List<String> kor = List.of("가","나","다","라","마","바","사","아","자","차","카","타","파","하");
		for(int i=0; i<kor.size(); i++) {
			System.out.printf(kor.get(i)+" ");
			if(i==kor.size()-1) System.out.println("\n");
		}
		for(String k : kor) {//향상된 for 문 위에 것과 동일하게 동작
			System.out.printf(k+" ");
		}
		System.out.println("\n");
		
		for(int i = 10; i>0; i--) {
			System.out.println(i);
		}
		
		//짝수 건너뛰기
		for(int i = 10; i>0; i--) {
			if(i%2==0) continue;
			System.out.println(i);
		}
		//변수 두개 활용
		for(int i=0, j=10; i<10; i++,j-- ) {
			System.out.printf(j+" ");
		}
		
		
	}
}
