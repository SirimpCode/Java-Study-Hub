package my.day06.b.array;

import java.util.List;

public class ArrayMain1 {

	public static void main(String[] args) {
		//선언
		char[] arrSubjects;
		// 배열에 크기 할당 (메모리에 미리 크기 할당)
		arrSubjects = new char[7];
		//배열로 선언된 변수에는 자동적으로 초기값이 들어간다.
		//정수는 0, 실수는 0.0, char는 ' ', 객체는 null
	
//		for(int i = 0; i<arrSubjects.length; i++) {
//			System.out.println(i+1+"번째 출력 => "+arrSubjects[i]);
//		}
		
		
		List<Integer> test = List.of(1,2,3,4,5);
		String[] a = {"a", "asdf", "c"};
		
		
		int[] scores = {90,85,75,60,95,100,70};
		scores[7] = 1;
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		System.out.println("총점 => "+sum + " 평균 => " + Math.round((double)sum/scores.length*10)/10d);
		
		
		
		for(int score : scores) {
			
		}
		for(int t : test) {
			
		}
		
	}

}
