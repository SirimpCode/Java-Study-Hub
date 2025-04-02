package my.day08.a.string;

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
			int t =  path.indexOf("/",15);
			System.out.println(t);
			System.out.println(path.substring(index+1));
		}
	}

}
