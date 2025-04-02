package my.day08.a.string;

import java.text.DecimalFormat;
import java.util.Scanner;

public class StringMain {

	public static void main(String[] args) {
		String str = "안녕하세요";
		String result = "";
		//문자열 뒤집기 
		for(int i = str.length()-1; i>=0; i--)
			result += str.charAt(i);
		
		System.out.println(result);
		
		
		/*toCharArray() 활용*/
		for(char i : str.toCharArray()) {
			System.out.print("|'"+i+"'");
			if (i == str.charAt(str.length()-1))
				System.out.println("|");
		}
		
		/*문자열.substring(int 시작인덱스, int 끝인덱스) !주의! 끝인덱스는 제외된다.
		 * 끝인덱스를 입력 안할시 시작인덱스부터 끝까지 나온다.*/
		System.out.println(str.substring(1,4));/* `녕하세` 가 출력된다.*/
		
		
		str = "안녕하세요 오늘도 행복하시고 좋은 하루 되세요~~^^";
		
		
		
		// === 5. "문자열".indexOf("찾을문자열") ====
	    //        "문자열" 에서 최초로 나오는 "찾을문자열"의 인덱스(int)를 알려준다.
		// 못찾으면 -1 나오는듯
		
		
		
		
		
		
		
		
		System.out.println();System.out.println();System.out.println();
		//퀴즈 파일명만 꺼내오기
		String[] pathFileNameArr = {
				"C:/mydocument/resume/나의이력서.hwp",
				"D:/mymusic.mp3",
				"C:/photo/니얼굴.jpg"
		};
		//lastIndexOf를 활용
		for(String path : pathFileNameArr) {
			int index = path.lastIndexOf("/");
			System.out.println(path.substring(index+1));
		}
		
		System.out.println("--------------------------------------------------------");//공백
		//그냥 indexOf 활용 이번엔 확장자도 없애봤음
		for(String path : pathFileNameArr) {
			int index = 0;
			int lastIndex = 0;
			for(int i = path.length()-1 ; i>=0; i-- ) {
				if(lastIndex == 0)
					if(path.charAt(i)=='.')
						lastIndex = i;
				if(path.charAt(i)=='/') {
					index = i;
					break;
				}	
			}
			System.out.println(path.substring(index+1,lastIndex));
		}
		System.out.println("--------------------------------------------------------------");
		
		//split 
//		String food = "제육볶음.볶음밥.닭가슴살.함박스테이크.소고기덮밥";
//		String[] foodArr = food.split("\\.");
//		
//		for(int i = 0 ; i<foodArr.length; i++) {
//			System.out.println(i+1+"."+foodArr[i]);
//		}
		
		
		System.out.println("--------------------------------------------------------------");
		
		//split 
		String food = "제육볶음,볶음밥.닭가슴살|함박스테이크	소고기덮밥	라면";
		String[] foodArr = food.split("\\.|,|\\||\t");
		// '|'로 구분하고 \\.	,	|	\t    이렇게 총 네개로 끊었다.
		for(int i = 0 ; i<foodArr.length; i++) {
			System.out.println(i+1+"."+foodArr[i]);
		}
		
		String food2 = "제육볶음,볶음밥.닭가슴살|함박스테이크	소고기덮밥	라면";
		String[] foodArr2 = food2.split("[.|,\t]");
		// 대괄호 안에 작성하면 가독성이 더 좋아진다. 의미는 위에것과 동일함
		for(int i = 0 ; i<foodArr2.length; i++) {
			System.out.println(i+1+"."+foodArr2[i]);
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        // === [참고] \ 를 escape 문자라고 부른다. ===
		// 문자열안에 문자를 있는 그대로 넣고 싶을때 사용
        System.out.println("나의 이름은 \"이순신\" 입니다.");
        // 나의 이름은 "이순신" 입니다. 
        
        System.out.println("C:\\NCS\\workspace_java");
        // C:\NCS\workspace_java
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        //join
        String hello = "시작하세요 안녕하세요 건강하세요";
//        hello = hello.join(" ", foodArr2) 
        
        String money1 = "$2,000,000";
        String money2 = "$500,000";
        int money3 = 0;
        String[] sp1 = money1.split("[$,]");
        String[] sp2 = money2.split("[$,]");
        
        String s1 = money1.join("", money1.split("[$,]"));
        String s2 = money2.join("", money2.split("[$,]"));
        
        money3+=Integer.parseInt(s1);
        money3+=Integer.parseInt(s2);
        System.out.println(money1 + " + " + money2 + " = "+ money3);
        //기대값 = $2,000,000 + $500,000 = 2500000
        
        DecimalFormat df = new DecimalFormat("#,###");
        // 정수를 세자리 마다 ',' 를 찍어서 String 타입으로 만들어 주는 것. 특히 금액을 나타낼 때 많이 쓰인다.
        String sum = df.format(money3);
        System.out.println(money1 + " + " + money2 + " = "+ "$"+sum);
        	       
        
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
//        
//        Scanner sc = new Scanner(System.in);
//        System.out.print("은행계좌번호 입력 : ");
//        String bankNumber = sc.nextLine();
//        System.out.println(bankNumber);
//        String resultNumber2 = bankNumber.join("", bankNumber.split("\\-"));
//        
//        String resultNumber = "";
//        for(char  a: bankNumber.toCharArray()) {
//        	if(a>='0'&&a<='9')
//        		resultNumber += a;
//        }
//        sc.close();
//        System.out.println("입력받은 은행계좌번호 : "+ resultNumber + " 요건 조인 "+ resultNumber2);
        //대시빼고 출력하기
        
        //repeat : 문자열을 파라미터로 주어진 수 만큼 반복
        System.out.println("\n"+"=".repeat(100) + "\n"); // =가 100번 찍힌다.
        System.out.println("\n"+"안녕 ".repeat(50) + "\n"); // 안녕 이 50번 찍힌다.
        
        //strip : 문자열 공백 제거 (문자열 사이에 있는건 제거 안됨)
        //stripLeading : 문자열 앞의 공백 제거
        //stripTrailing : 문자열 뒤의 공백 제거
        System.out.println(" 안 녕 안녕 헿 헤   헤    ".strip());
        System.out.println(" 안 녕 안녕 헿 헤   헤    ".stripLeading());
        System.out.println(" 안 녕 안녕 헿 헤   헤    ".stripTrailing());
        
        //replaceAll  해당 문자열을 새로운 문자열로 전부 치환 한다.
        String names = "한석규-두석규-세석규-네석규-오석규";
        System.out.println(names);//한석규-두석규-세석규-네석규-오석규
        names = names.replaceAll("석규", "SK");
        System.out.println(names);//한SK-두SK-세SK-네SK-오SK
        //replaceFirst  해당 문자열의 첫번째 값만 새로운 문자열로 치환한다.
        names = names.replaceFirst("SK", "석규");
        System.out.println(names);//한석규-두SK-세SK-네SK-오SK
        
        System.out.println("\n"+"-".repeat(100)+"\n");
        
        
        names = "한SK-두SK-세SK-네SK-오SK";
        //replaceFirst 를 사용하여 첫번째, 두번째, 세번째 "SK" 를 "석규"로 변환
        String[] nameArr1 = names.split("-");
        for(int i = 0; i<3; i++)
        	nameArr1[i] = nameArr1[i].replace("SK", "석규");
        
        System.out.println("첫번째 문제 : "+ String.join("-", nameArr1));
        
        
        
        //홀수번째 나오는 "SK" 를 "석규"로 변환
        names = "한SK-두SK-세SK-네SK-오SK";
        String[] nameArr = names.split("-");
        for(int i = 0; i< nameArr.length; i++)
        	if(i%2==0)
        		nameArr[i] = names.split("-")[i].replace("SK", "석규");
        
        
        System.out.println("두번째 문제 : "+String.join("-", nameArr));
        
        
        System.out.println("\n"+"#".repeat(100)+"\n");
        
        String[] contents = {"호호안녕하세요","건강하세요","행복하세요 또봐요","즐겁고 건강한 하루되세요"};
        
        //"건강" 이라는 단어가 포함된 것을 출력하세요.
        //contains
        for(String a : contents) {
        	if (a.contains("건강"))
        		System.out.println(a);
        }
        for(String a : contents) {
        	if(a.indexOf("건강")>=0)
        		System.out.println(a);
        }
        
     // === 11. "문자열".toUpperCase()  ===
        //         "문자열"에서 소문자가 있으면 모두 대문자로 변경해서 반환.
        String words = "My Name is Tom 입니다.";
        System.out.println(words.toUpperCase());
        // MY NAME IS TOM 입니다. 
                 
                 
        // === 12. "문자열".toLowerCase()  ===
        //         "문자열"에서 대문자가 있으면 모두 소문자로 변경해서 반환.
        words = "My Name is Tom 입니다.";
        System.out.println(words.toLowerCase());
        // my name is tom 입니다.
         
       System.out.println("=================".repeat(10));
        
       
       // "건강" 이라는 문자열로 시작하는 것만 출력
       //startWith 활용
       for(String a : contents) {
    	   if(a.startsWith("건강"))
    		   System.out.println(a);
       }
       //indexOf 활용
       for(String a : contents) {
    	   if(a.indexOf("건강")==0)
    		   System.out.println(a);
       }
       System.out.println("=================".repeat(10));
       //하세요 라는 문자열로 끝나는 것만 출력
       for(String a : contents) {
    	   if(a.endsWith("하세요"))
    		   System.out.println(a);
       }
       System.out.println("=================".repeat(10));
       //substring 활용 (뒤에서 3번째의 index 번호를 사용해서 하세요라는 문자열인지 확인)
       for(String a : contents) {
    	   int length = a.length();
    	   int doIt = "하세요".length();
    	   int index = length - doIt;
    	   
    	   if( a.substring(index).equals("하세요"))
    		   System.out.println(a);
       }
       
       
       Object[] objArr = "한줄\n두줄\n세줄\n네줄\n다섯줄\n여섯줄".lines().toArray();
       for(Object obj:objArr) {
    	   if(obj instanceof String)
    		   System.out.println(((String) obj));
       }
       
       
       // jdk 17 부터 추가된 String  관련 내용
       //텍스트 블록 쌍따옴표 세개를 사용하여 편리하게 사용가능하다
       
       String msg = """
       		안녕하세요
       		오늘은 수요일 입니다.
       		즐거운 오후 되세요.
       		""";
       String oldMsg = "안녕하세요\n오늘은 수요일 입니다.\n즐거운 오후 되세요."; //위에것과 동일하다.
       
       System.out.println(msg);
       System.out.println(oldMsg);
	}

}
