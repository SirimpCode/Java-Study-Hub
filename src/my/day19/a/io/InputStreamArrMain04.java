package my.day19.a.io;

import java.io.IOException;

public class InputStreamArrMain04 {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		int input = 0;
		// 키보드에서 "대한민국서울시쌍용센터엔터" 했다라면
		// "대한민국서" 까지가 10byte , "울시쌍용센" 까지가 10byte , "터엔터" 까지가 4바이트 >> 터 = 2Byte 엔터는 \r\n 2Byte
		
		byte[] dataArr = new byte[10]; // 10byte 크기의 배열을 생성한다.
		// 이 변수의 용도는 빨대 (System.in, 키보드)에서 흡입할때 단위크기를 10Byte로 하는 것이다.
		
		int inputLength = 0;
		//이 변수의 용도는 빨대 에서 흡입한 실제 크기를 나타내는 용도이다.
		int totalByte = 0;//byte 수 누적용도
		int count = 0; // while문의 반복횟수를 알기 위한 것
		while(( inputLength = System.in.read(dataArr)) != -1 ){
			System.out.println("");
			// 키보드로 Ctrl +Z 를 누르지 않으면 계속 실행해랑
			System.out.write(dataArr, 0, inputLength);
			//파라미터설명
			//1.배열 dataArr 에 저장된 데이터에서 2.시작점 0번째  index부터(처음부터) , 3.실제크기 inputLength byte 수만큼 출력해라 라는 말이다.
			System.out.flush();
			totalByte += inputLength;// 10 + 10 + 4
			count++; // 3번 증가할고야
		}
		System.out.println("총 : " + (totalByte-2) + "byte 입력함");
		System.out.println("반복회수 : "+count +"번 반복함.");

	}

}


/*
 PS C:\NCS\Java-Study-Hub\bin> java my.day19.a.io.InputStreamArrMain04
대한민국서울시쌍용센터

대한민국서
울시쌍용센
터
^Z
총 : 22byte 입력함
반복회수 : 3번 반복함.
PS C:\NCS\Java-Study-Hub\bin>
터미널출력결과
*/
/*
System.in.read(data_arr)은 
입력한 데이터가 "대한민국서울시쌍용센터엔터" 이라면
입력한 내용에서 배열 data_arr의 크기만큼(지금은 10byte) 읽어들인다(지금은 "대한민국서"). 
읽어들인 "대한민국서"을 배열 data_arr 에 저장시키고, 읽어들인 크기를(지금은 10byte) 리턴시켜준다. 

반복문의 첫번째일때
  data_arr 에는 "대한민국서" 가 들어가고, input_length 에는 10 이 들어간다.

반복문의 두번째일때
  data_arr 에는  "울시쌍용센" 이 들어가고, input_length 에는 10 이 들어간다.
 
반복문의 세번째일때
  data_arr 에는  "터엔터" 가 들어가고, input_length 에는 4 가 들어간다.   
*/