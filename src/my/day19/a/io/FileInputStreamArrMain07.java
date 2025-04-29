package my.day19.a.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/*
※ Data Source (File, 키보드, 원격 컴퓨터)
: 데이터의 근원

※ Data Destination (파일, 모니터, 프린터, 메모리)
: 데이터가 최종적으로 도착하는 곳

Data Sourceㅇ======>ㅇ 프로그램 ㅇ======>ㅇ Data Destination
             입력스트림          출력스트림
           InputStream       OutputStream          

  
  === C:\NCS\iotestdata\korea.txt 파일을 읽어서 그 내용을 모니터(콘솔화면)에 출력하는 예제 ===
              
  1. 데이터소스   : 파일로 부터 읽어들임 (노드스트림: FileInputStream) 
  2. 데이터목적지 : 결과물을 모니터에 출력(노드스트림: System.out)
  
  >>>> FileInputStream
     - Node 스트림(접속점이 파일인 입력스트림)
     - 1byte 기반 스트림.
    
  >>>>> System.out :
        부모클래스가 추상클래스 OutputStream(기본 출력 스트림) 타입인 것으로서
        접속점(빨대)이 콘솔화면(모니터)인 출력 스트림(PrintStream)이다.
                
   -- Node(접속점)가 콘솔화면(모니터)인 출력스트림이다.
   -- 1byte 기반 스트림이다.
   -- 주요 메소드 : println(String str),
                 print(String str),
                 write(int b)      
*/
public class FileInputStreamArrMain07 {
//배열형식으로 읽어오기
	public static void main(String[] args)     {
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 읽을 파일의 이름을 입력 => ");
		String fileName = sc.nextLine();
//		C:\NCS\iotestdata/korea.txt
		
		byte[] dataArr = new byte[64]; // 64byte 크기의 배열을 생성한다.
		//이 변수의 용도는 빨대 파일에서 흡입할때 단위크기를 64Byte로 하는 것이다.
		int inputLength = 0; //이 변수의 용도는 빨대 에서 흡입한 실제 크기를 나타내는 용도이다.
		int totalByte = 0;//byte 수 누적용도
		//반복회수
		int loopCount = 0; // while문의 반복횟수를 알기 위한 것
		try {
			FileInputStream fist = new FileInputStream(fileName);
			while((inputLength = fist.read(dataArr)) != -1) {
				/*				      읽어온 값은 dataArr에 저장이된다. inputLength 는 읽어온 값의 크기가 저장된다.
	              fist.read(data_arr) 메소드는 해당 파일에서 
	              데이터를 배열 data_arr 크기인 64byte 씩 잘라서 읽는데
	              실제 읽어온 byte 크기(int 타입)를 input_length 에 넣어준다.
	              이어서 읽어온 내용물은 data_arr 에 저장시킨다.
	               
	              만약에 파일의 내용물에서 읽어들일 데이터가 없다라면 -1 을 리턴시켜준다.
	              즉, 파일속의 내용물이 끝이 아니라면 계속해서 while{} 부분을 실행해라는 말이다.
	            */
				//콘솔에 출력
				System.out.write(dataArr, 0, inputLength);
				System.out.flush();
				totalByte+=inputLength; //byte 수 누적
				loopCount++; // 1회 증가할고야
			}
			fist.close();
		} catch (FileNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			System.out.println("파일이 존재하지 않습니다. [ "+fileName+" ]");
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			System.out.println("파일을 읽어오는 중 오류가 발생했습니다.");
		} finally {
			System.out.println("\n=====================================================");
			System.out.println("총 : " + totalByte + "byte 입력되었습니다.");
			System.out.println("반복 회수 : "+loopCount +"회 반복되었습니다.");
			System.out.println("=====================================================");
			
		}
		
		sc.close();
		
		
	}

}
