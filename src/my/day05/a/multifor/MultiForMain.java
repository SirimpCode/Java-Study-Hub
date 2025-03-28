package my.day05.a.multifor;

import java.util.Scanner;

public class MultiForMain {
	public static void main(String[] args) {
		
		/* abcdefg
		 * hijklmn
		 * opqrstu
		 */
		
		for(char i= 'a'; i<='u'; i++) {
			if(i=='g'||i=='n') {
				System.out.println(i);
				continue;
			}
			System.out.print(i);
		}
		System.out.println("\n\n");
		
		//2중으로 해봄
		char ch = 'a';
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<7; j++) {
				System.out.print(ch);
				ch++;
			}
			System.out.print("\n");
		}
		
		

//[0,0],[0,1],[0,2]
//[1,0],[1,1],[1,2]
//[2,0],[2,1],[2,2]
//[3,0],[3,1],[3,2]
//		[m,n] n은 가로로 0,1,2 반복 m은 세로로 0,1,2,3 
		for(int i=0 ; i<4; i++) {
			for(int j=0; j<3; j++) {
				if(j==2) {
					System.out.println("["+i+","+j+"]");
					break;
				}
				System.out.print("["+i+","+j+"],");	
			}
		}
		
		System.out.print("\n\n");
//		단일으로 만들어보기
		int m = 0, n = 0;
		for(int i=0;i<12; i++) {
			if(n==2) {
				System.out.println("["+m+","+n+"]");
				m++;
				n=0;
				continue;
			}
			System.out.print("["+m+","+n+"],");
			n++;
		}
		
		System.out.print("\n\n");System.out.print("\n\n");
		

		//[0,0],[0,1],[0,2]
		//[1,0],[1,1],[1,2]
		//[3,0],[3,1],[3,2]
		for(int i=0 ; i<4; i++) {
			if(i==2) continue;
			for(int j=0; j<3; j++) {
				if(j==2) {
					System.out.println("["+i+","+j+"]");
					break;
				}
				System.out.print("["+i+","+j+"],");	
			}
		}
		System.out.println(" 경계선");
//		단일으로 만들어보기
		int m2 = 0, n2 = 0;
		for(int i=0;i<10; i++) {
			if(m2==2) {//스킵에 한바퀴를 소모하니 9+1 = 10바퀴이다
				m2++; continue;
			}
			if(n2==2) {
				System.out.println("["+m2+","+n2+"]");
				m2++;
				n2=0;
				continue;
			}
//			if(m2==2) continue;
			System.out.print("["+m2+","+n2+"],");
			n2++;
		}
		
		
		/*
		 * 501호		502호	503호	505호
		 * 301호		302호	303호	305호
		 * 201호		202호	203호	205호
		 * 101호		102호	103호	105호		
		 */
		System.out.println();
		for(int i = 5; i>0; i--) {
			if(i==4) continue;
			for(int j = 1; j<6 ; j++) {
				if(j == 4) continue;
				else if (j==5) {
					System.out.println(i+"0"+j+"호");
					continue;
				}
				System.out.print(i+"0"+j+"호\t");
				
			}
			
			
		}
		
		/* 구구단
		   >> 몇단볼래? => 8엔터
		   
		   === 8단 ===
		   8*1=8
		   8*2=16 
		   8*3=24
		   8*4=32
		   8*5=40
		   8*6=48
		   8*7=56
		   8*8=64
		   8*9=72 
		   
		   >> 또 하시겠습니까?[Y/N] => y엔터 또는 Y엔터
		   
		   >> 몇단볼래? => 1.34엔터 또는 똘똘이엔터
		   >>> 2단부터 9단까지만 가능합니다 <<<
		   
		   >> 몇단볼래? => 345엔터
		   >>> 2단부터 9단까지만 가능합니다 <<<
		   
		   >> 몇단볼래? => 3엔터
		   
		   === 3단 ===
		   3*1=3
		   3*2=6 
		   3*3=9
		   3*4=12
		   3*5=15
		   3*6=18
		   3*7=21
		   3*8=24
		   3*9=27
		      
		   >> 또 하시겠습니까?[Y/N] => s엔터 또는 S엔터
		   >>> Y 또는 N 만 가능합니다!! <<<
		   
		   >> 또 하시겠습니까?[Y/N] => n엔터 또는 N엔터
		   
		   == 프로그램종료 ==   
		*/
//		System.out.println();
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			int num = 0;
//			try {
//				System.out.print("몇단볼래? ");
//				num = Integer.parseInt(sc.nextLine());
//				if(num>9||num<2) throw new NumberFormatException();
//			}catch(NumberFormatException e){
//				System.out.println("'2' 부터 '9' 까지만 입력 가능합니다.");	
//				continue;
//			}
//			
//			for(int i=1; i<10; i++) {
//				int value = num * i;
//				System.out.println(num+" * "+i+" = "+value);
//			}
//			
//			boolean repeat = false;
//			while(true) {
//				System.out.print("또 할래? [Y/N] => ");
//				String input = sc.nextLine().toUpperCase();
//				
//				if(input.equals("Y")) break;
//				else if (input.equals("N")) {
//					System.out.println("종료 합니다.");
//					return;
//				}
//				
//				System.out.println("Y 나 N 중에 입력해 소문자도 가능");	
//			}				
//		} ⬆️ 이건 메인메서드까지 return으로 종료된다 즉 아래는 도달할수없게됨
		//레이블을 활용하여 브레이크를 할수도있음
		System.out.println();
		Scanner sc = new Scanner(System.in);
		first:
		while(true) {
			int num = 0;
			try {
				System.out.print("몇단볼래? ");
				num = Integer.parseInt(sc.nextLine());
				if(num>9||num<2) throw new NumberFormatException();
			}catch(NumberFormatException e){
				System.out.println("'2' 부터 '9' 까지만 입력 가능합니다.");	
				continue;
			}
			
			for(int i=1; i<10; i++) {
				int value = num * i;
				System.out.println(num+" * "+i+" = "+value);
			}
			
			while(true) {
				System.out.print("또 할래? [Y/N] => ");
				String input = sc.nextLine().toUpperCase();
				
				if(input.equals("Y")) break; //아무것도 없을땐 가장가까운거 탈출
				else if (input.equals("N")) {
					break first; //바깥 반복문까지 타알추울
				}
				
				System.out.println("Y 나 N 중에 입력해 소문자도 가능");	
			}		
		}
		System.out.println("종료 합니다.");
		
	}
}
