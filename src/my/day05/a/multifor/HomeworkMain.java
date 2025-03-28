package my.day05.a.multifor;

//1. 제출할 파일명 :  본인이름_Main_homework_5.java.txt (txt 파일로 제출함) 
// 2. 메일주소 :  tjdudgkr0959@naver.com
// 3. 제출기한 :  4월1일(화) 18:00 까지 
// 4. 자바소스 :  for 문 사용하여 만들것.
   
 

public class HomeworkMain {

	public static void main(String[] args) {
		
		
//	    == 숙제 1 == 
//	       *
//	       **
//	       ***
//	       ****
//	       *****
		for(int i =0; i<5; i++) {
			for(int j = 1 ; j <= i+1; j++) {
				System.out.print("*");
			};
			System.out.println();
		}
		
		
		
		
		System.out.println();//공백
//		   == 숙제 2 == 
//			        *
//			       **
//			      ***
//			     ****
//			    ***** 
		for(int i = 5 ; i>=0; i--) {
			String line = "";
			for(int j = i; j>0; j--) line+=" ";
			for(int h = i; h<6; h++) line+="*";
			System.out.println(line);
		}
		
		
		
		
	
		System.out.println();//공백
//		   == 숙제 3 == 
//			*****   
//			****    
//			***    
//			**     
//			*   
		for(int i = 5; i>=0; i--) {
			for(int j = 1 ; j <= i+1; j++) {
				System.out.print("*");
			};
			System.out.println();
		}
		
		
		
		System.out.println();//공백
//		== 숙제 4 ==
//				 
//			      *
//			     ***
//			    ***** 
		for(int i = 2 ; i>=0; i--) {
			String line = "";
			for(int j = i; j>0; j--) line+=" ";
			for(int h = i; h<3+(2-i); h++) line+="*";
			System.out.println(line);
		}
		
//		
		
		
		System.out.println();//공백	          
//			  == 숙제 5 ==
//			          
//			    *****
//			     ***
//			      *
		for(int i = 0 ; i<=2; i++) {
			String line = "";
			for(int j = i; j>0; j--) line+=" ";
			for(int h = i; h<3+(2-i); h++) line+="*";
			System.out.println(line);
		}
		
		
		System.out.println();//공백
//			  == 숙제 6 ==
//			       
//			      *
//			     ***
//			    *****
//			     ***   
//			      *      

		for(int i = 2 ; i>=0; i--) {
			String line = "";
			for(int j = i; j>0; j--) line+=" ";
			for(int h = i; h<3+(2-i); h++) line+="*";
			System.out.println(line);
		}
		
		for(int i = 1 ; i<=2; i++) {
			String line = "";
			for(int j = i; j>0; j--) line+=" ";
			for(int h = i; h<3+(2-i); h++) line+="*";
			System.out.println(line);
		}		
		
		

		System.out.println();//공백
//				== 입사문제 == 
//		        
//				*********1
//				********2
//				*******3
//				******4
//				*****5
//				****6
//				***7
//				**8
//				*9
		for(int i = 9; i>0; i--) {
			for(int j = 0; j<i; j++) System.out.print("*");
			System.out.println(10-i);
		}
		
		
	}

}
