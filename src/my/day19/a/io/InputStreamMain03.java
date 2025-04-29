package my.day19.a.io;

import java.io.IOException;

public class InputStreamMain03 {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		int input = 0;
		int totalByte = 0; //byte 수 누적용도
		
		while((input = System.in.read()) != -1) {
			if(input != 13 && input != 10) {
				// 13 : CR, 10 : LF
				// Enter키를 누르면 CRLF가 입력되므로
				// Enter키를 누르면 13과 10이 입력되므로
				// Enter키는 제외하고 나머지 문자만 출력한다.
				totalByte++; //byte 수 누적
				System.out.write(input);
				System.out.flush();
			} else {//엔터일경우
				System.out.println("");
			}
		}
		System.out.println("총 : " + totalByte + "byte 입력되었습니다.");

	}

}
