package my.day19.a.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
※ Data Source (File, 키보드, 원격 컴퓨터)
: 데이터의 근원

※ Data Destination (파일, 모니터, 프린터, 메모리)
: 데이터가 최종적으로 도착하는 곳

Data Sourceㅇ======>ㅇ 프로그램 ㅇ======>ㅇ Data Destination
           입력스트림           출력스트림
          InputStream        OutputStream          

  
=== 키보드로 부터 입력받은 것을 파일(C:\NCS\iotestdata\result.txt)에 기록(출력)하기로 한다. ===

1. 데이터 소스  : 키보드로 부터 입력받음    [노드스트림 : System.in]
2. 데이터 목적지 : 결과를 특정 파일에 출력함 [노드스트림 : FileOutputStream] 
*/
public class FileOutputStreamArrMain08 {

	public static void main(String[] args)   {
		System.out.println(">> 내용을 입력하세요 [입력하신 내용은 C:\\NCS\\iotestdata\\result.txt 파일에 저장됨.]");

		String fileName = "C:/NCS/iotestdata/result.txt";

		int loopCount = 0;
		int totalByte = 0; // byte 수 누적용도
		byte[] dataArr = new byte[10]; // 10byte 크기의 배열을 생성한다.
		int inputLength = 0; // 이 변수의 용도는 빨대에서 흡입한 실제 크기를 나타내는 용도이다.
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName, false); // true : append(추가모드), false : overwrite(덮어쓰기 모드)
			while((inputLength = System.in.read(dataArr)) != -1) {
				fos.write(dataArr, 0, inputLength); // 키보드로 입력받은 내용을 파일에 기록한다.
				fos.flush();
				totalByte+=inputLength; // byte 수 누적
				loopCount++; // 반복 회수
			}
			fos.close(); // 파일을 닫는다.
		}catch (FileNotFoundException e) {
			System.out.println(fileName+" 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		System.out.println(fileName+" 파일에 총 "+totalByte+" byte 입력되었습니다.");
		System.out.println("반복 회수  : " + loopCount + "회");
		
		System.out.println("\n======================================================");
		System.out.println(">> 입력된 내용 <<");
		System.out.println("======================================================\n");
		byte[] dataArr2 = new byte[64]; 
		int inputLength2 = 0; // 이 변수의 용도는 빨대에서 흡입한 실제 크기를 나타내는 용도이다.
		try {
			FileInputStream fist = new FileInputStream(fileName);
			while((inputLength2 = fist.read(dataArr2)) != -1) {
				System.out.write(dataArr2, 0, inputLength2);
				System.out.flush();
			}			
			fist.close(); // 파일을 닫는다.
		}catch (FileNotFoundException e) {
			System.out.println(fileName+" 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}

	}

}
