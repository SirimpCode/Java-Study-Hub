package my.day19.a.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

  
  === 파일로 부터 입력받은 것을 파일에 출력(기록)하는 예제 ===
              
  1. 데이터소스  : 특정 파일로 부터 읽어들임  (노드스트림: FileInputStream) 
  2. 데이터목적지 : 결과물을 특정 파일에 출력함 (노드스트림: FileOutputStream)
*/
public class FileCopyMain10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 읽을 파일의 이름을 입력 => ");
		String fileName = sc.nextLine();		// C:/NCS/iotestdata/korea.txt
		System.out.print(">> 복사할 파일의 이름을 입력 => ");
		String targetFileName = sc.nextLine();	// C:/NCS/iotestdata/korea_copy.txt
		System.out.println(">> "+fileName+" 파일을 \n"+targetFileName+" 파일로 복사합니다.");
		sc.close();
		byte[] dataArr = new byte[1024*10]; // 10kb 크기의 배열을 생성한다.
		int inputLength = 0; // 흡입한 실제 크기
		int totalByte = 0; // byte 수 누적용도
		int loopCount = 0; // 반복 회수
		
		int sharpCount = 0;
		try {
			//소스 파일 객체 생성하기
			//String 타입인 fileName 을 실제 File 클래스의 객체로 만든다.
			File file = new File(fileName);
			long fileSize = file.length(); // 파일의 크기를 알아온다.
			System.out.println(">> "+fileName+" 파일의 크기 : "+fileSize+" byte 입니다.");
			long maxSize = 10*1024*1024; // = 10mb
			if(fileSize > maxSize) {
				System.out.println(">> "+fileName+" 파일의 크기가 "+maxSize+" byte 보다 큽니다.");
				System.out.println(">> "+targetFileName+" 파일로 복사할 수 없습니다.");
				return; // main() 메서드 종료
			}
			
			FileInputStream fis = new FileInputStream(file);
			File copyFile = new File(targetFileName);
			FileOutputStream fos = new FileOutputStream(copyFile, false); // true : append(추가모드), false : overwrite(덮어쓰기 모드)
			while((inputLength = fis.read(dataArr)) != -1) {
				fos.write(dataArr, 0, inputLength); // 파일에 기록한다.
				fos.flush();
				totalByte += inputLength; // byte 수 누적
				
				if(inputLength == 1024*10) {
					System.out.print("#");
					sharpCount++;
				}
				
				if(sharpCount%40 ==0) {
					System.out.println("");
				}
				
				loopCount++; // 반복 회수
				
			}
			System.out.println("\n복사완료!!");
			fis.close(); // 파일을 닫는다.
			fos.close(); // 파일을 닫는다.
		}catch (FileNotFoundException e) {
			System.out.println(fileName+" 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(targetFileName+" 파일에 총 "+totalByte+" byte 입력되었습니다.");
		System.out.println("반복 회수  : " + loopCount + "회");
		
	}

}
