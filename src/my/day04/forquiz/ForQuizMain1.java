package my.day04.forquiz;
//for 문을 사용하여 알파벳 소문자를 아래처럼 출력하세요.
// a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z

import java.util.Scanner;

//for 문을 사용하여 알파벳 소문자를 아래처럼 출력하세요.
/*
   a,b,c,d,e,f,g,h,i,j,k,l,m
   n,o,p,q,r,s,t,u,v,w,x,y,z
*/
public class ForQuizMain1 {
	
	public static void main (String[] args) {
		
		
		String result = ""; 
		for(char i = 'a'; i<='z'; i++) {
			result += i=='z'? i : i+","; 
		}
		System.out.println(result+"\n");
		
		//
		
		
		for(char i = 'a'; i<='z'; i++) {
			if (i=='m' || i=='z') System.out.println(i);
			else System.out.print(i+",");
		}
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("글자입력해 : ");
		
		String str = sc.nextLine();
		
		System.out.println("총 글자수 : "+str.length());
		char[] charArr = str.toCharArray();
		
		int upper = 0;
		int lower = 0;
		int num = 0;
		int kor = 0;
		int space = 0;
		int special = 0;
		
		String upperStr = "";
		String lowerStr = "";
		String numStr = "";
		String korStr = "";
		String specialStr = "";
		
		for(char c : charArr) {
			if (c >='a' && c <='z') {
				lower += 1;
				if (lower ==1) lowerStr += c;
				else lowerStr += ","+ c;
			}
			else if (c >='A' && c <='Z') {
				upper += 1;
				if (upper ==1) upperStr += c;
				else upperStr += ","+ c;
			}
			else if (c >='가' && c <='힣') {
				kor += 1; 
				if (kor==1) korStr += c;
				else korStr += ","+ c;
			}
			else if (c >='0' && c <='9') {
				
				num += 1;
				if (num ==1) numStr += c;
				else numStr += ","+ c;
			}
			else if (c == ' ') space += 1;
			else {
				special += 1;
				if (special ==1) specialStr += c;
				else specialStr += ","+ c;
			}
		}
		System.out.println("대문자 "+upper+" \t"+upperStr);
		System.out.println("소문자 "+lower+" \t"+lowerStr);
		System.out.println("숫자 "+num+" \t"+numStr);
		System.out.println("한글 "+kor+" \t"+korStr);
		System.out.println("공백 "+space);
		System.out.println("특스문자 "+special+" \t"+specialStr);
	}
	
}


/*
>> 글자를 입력하세요 : Abz3쌍a0# $ T
총글자수 : 12
대문자개수:2   대문자:A,T  
소문자개수:3   소문자:b,z,a 
숫자개수:2      숫자:3,0  
한글개수:1      한글:쌍   
공백개수:2
특수문자개수:2   특수문자:#,$  
*/