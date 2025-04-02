package my.day07.a.twodimension.array;

public class TwoDimensionMain {

	public static void main(String[] args) {
		//1차원 배열
		int[] subjectArr = new int[5];
		//2차원 배열
		int[][] pointArr = new int[4][3]; // 행 = 4 ,  열 = 3
		pointArr[0][0] = 1;
		
		/*
		 * index =>
		 * ---------------------------
		 * | [0][0] | [0][1] | [0][2]| 
		 * ---------------------------
		 * | [1][0] | [1][1] | [1][2]| 
		 * ---------------------------
		 * | [2][0] | [2][1] | [2][2]| 
		 * ---------------------------
		 * | [3][0] | [3][1] | [3][2]| 
		 * ---------------------------
		 * 
		 * */
		
		pointArr[0][0] = 10;
		pointArr[0][1] = 20;
		pointArr[0][2] = 30;
		
		pointArr[1][0] = 40;
		pointArr[1][1] = 50;
		pointArr[1][2] = 60;
		
		pointArr[2][0] = 70;
		pointArr[2][1] = 80;
		pointArr[2][2] = 90;
		
		pointArr[3][0] = 100;
		pointArr[3][1] = 100;
		pointArr[3][2] = 100;
		
		
		System.out.println("2차원 배열의 길이 => "+pointArr.length);// 4라고 나옴
		// .length 메서드는 행의 길이가 나온다.
		
		System.out.println("pointArr[0].length => "+ pointArr[0].length); // 3 이라고 나옴
		// .2차원배열명[행의인덱스].length 는 그 행에 존재하는 열의 길이(크기)가 나온다.
		
		
		for(int i = 0; i < pointArr.length; i++) {
			//바깥 for문에는 행이 돈다.
			for(int j = 0; j < pointArr[j].length; j++) {
				//안쪽 for문에는 열이 돈다.
				String add = j < pointArr[j].length-1 ? ",": "\n";
				System.out.printf("%d%s", pointArr[i][j], add);
			}	
		}
		
		
		/*
	      ----------------------------------------------------
	      국어       영어       수학      총점    평균      학점   등수
	      ----------------------------------------------------
	      90       80       70      240    80.0       B   4
	      80       85       76      241    80.3       B   2
	      80       85       76      241    80.3       B   2
	      85       70       90      245    81.7       B   1
	      60       80       50      190    63.3       D   5
	      ====================================================
	      395       400       362   
	      79.0   80.0   72.4
	
	*/
		System.out.println("\n=================== 성적결과 ===================\n");
//		이순신, 엄정화, 홍길동, 공유, 아이유 점수 구하기 과목은 국어 영어 수학 순
		int[][] scoreArr = { {90,80,70},	//이순신
							 {80,85,76},	//엄정화
							 {80,85,76},	//홍길동
							 {85,70,90},	//공유
							 {60,80,50}		//아이유
							 }; 
		

		System.out.println("-----------------------------------------------------");
		System.out.println("국어\t영어\t수학\t총점\t평균\t학점\t등수");
		System.out.println("-----------------------------------------------------");
		//학생별 총점 저장 변수 
		int[] scoreSum = new int[scoreArr.length];
		//출력 결과 저장 변수
		String[] result = new String[scoreArr.length];
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		int[] a = new int[3];
		for(int i = 0; i<scoreArr.length; i++) {
			int sum = 0;
			for(int j = 0; j<scoreArr[i].length; j++) {
				//학생들 점수 과목별 총합
				if(j == 0) korSum+=scoreArr[i][j]; 
				else if(j == 1) engSum+=scoreArr[i][j];
				else if(j == 2) mathSum+=scoreArr[i][j];
				
				sum += scoreArr[i][j];//국영수 합산
				if (result[i]==null) result[i]=""; 
				result[i] += scoreArr[i][j]+"\t";//국영수 점수를 담는다
			}
			scoreSum[i] = sum;

		}
		int[] rankArr = new int[scoreArr.length];//등수 배열 인덱스는 각 학생과 동일
		for(int i = 0; i<scoreArr.length; i++) {
			int rank = 1;
			for(int j : scoreSum) {
				if(scoreSum[i] < j) rank += 1;
			}
			rankArr[i] = rank;
		}
		for(int i = 0 ; i< scoreArr.length ; i++) {
			
			double avg = Math.round(scoreSum[i]/3d*10)/10d;//평균
			char rating = switch((int) avg/10) {//학점
			case 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
			};
			
			System.out.println(result[i]+scoreSum[i]+"\t"+avg+"\t"+rating+"\t"+rankArr[i]);
		}
		
		double korAvg = Math.round((double)korSum/scoreArr.length*10)/10d;
		double engAvg = Math.round((double)engSum/scoreArr.length*10)/10d;
		double mathAvg = Math.round((double)mathSum/scoreArr.length*10)/10d;
		System.out.println("====================================================");
		System.out.println(korSum+"\t"+engSum+"\t"+mathSum);
		System.out.println(korAvg+"\t"+engAvg+"\t"+mathAvg);
		
	}
}
