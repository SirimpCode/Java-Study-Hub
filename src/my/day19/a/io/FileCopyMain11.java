package my.day19.a.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
>>>>> BufferedInputStream 와 BufferedOutputStream <<<<<
   -- 1 byte 기반 스트림.
   -- 필터스트림(다른말로 보조스트림 이라고 부른다.)
   -- 단독으로 사용할 수 없고, 반드시 노드스트림에 장착되어 사용되는 것이다.
      마치 수영장에서 오리발처럼 보조기구로 사용한다.
      이것을 사용하면 오리발처럼 속도가 향상되므로 많이 사용한다.
           
   -- 읽어올 데이터를 매번 1 byte 마다 읽고,쓰고 한다라면 입.출력에 너무 많은 시간이 소요된다. 
      그래서 쓰는 작업없이 메모리 버퍼에 데이터를 한꺼번에 쭉~~ 읽기만 하여 모아두면
      그만큼 쓰는 작업이 없으므로 읽기 속도는 빨라질 것이다.
      그리고 나서 메모리 버퍼에 읽어서 모아두었던 내용을 한방에 쓰기를 하면 매번 1byte 씩 쓰는 것보다
      속도가 빨라진다.
           
    BufferedInputStream 와  BufferedOutputStream 의 기본 버퍼크기는 512 byte 이다.
    
    [예제]
    필터스트림(보조스트림)을 이용해서 파일로 부터 입력받고, 
    입력받은 그 내용을 파일에 출력해본다. 즉, 파일복사하기
       
    >>> 데이터소스 : 파일(FileInputStream --> 노드스트림)
                + 필터스트림(보조스트림)으로 BufferedInputStream 을 사용함.
    
    >>> 데이터목적지 : 파일(FileOutputStream --> 노드스트림)
                  + 필터스트림(보조스트림)으로  BufferedOutputStream 을 사용함.
*/
public class FileCopyMain11 {

	public static void main(String[] args) {
		String fileName = "C:/NCS/iotestdata/02.eclipse_2024_06_다운로드매뉴얼.zip";
		String targetFileName = "C:/NCS/iotestdata/Copied_02.eclipse_2024_06_다운로드매뉴얼.zip";
		try {
			// 입력노드스트림

			System.out.println(">> " + fileName + " 파일을 \n" + targetFileName + " 파일로 복사합니다.");

			File file = new File(fileName);
			// BufferedInputStream 을 장착하기
			FileInputStream fis = new FileInputStream(file);// 내 발 에 아래의 오리발 장착하기
			// 입력보조스트림 장착
//		BufferedInputStream bis = new BufferedInputStream(fis);//오리발 오리발의 기본 사이즈는 512byte 이다.
			BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 1024);// 이렇게 넣으면 오리발의 기본 사이즈는 1mb가 된다.

			File targetFile = new File(targetFileName);
			// BufferedInputStream 을 장착하기
			FileOutputStream fos = new FileOutputStream(targetFile);// 내 발 에 아래의 오리발 장착하기
//		출력노드 스트림에 보조스트림 장착 얘도 용량 명시안하면 기본은 512byte 이다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 1024 * 1024);// 이렇게 넣으면 오리발의 기본 사이즈는 1mb가 된다.

			byte[] dataArr = new byte[1024 * 10]; // 10kb 크기의 배열을 생성한다.
			int inputLength = 0; // 흡입한 실제 크기
			int totalByte = 0; // byte 수 누적용도
			int loopCount = 0; // 반복 회수
			int sharpCount = 0;

			// 소스 파일 객체 생성하기
			// String 타입인 fileName 을 실제 File 클래스의 객체로 만든다.

			long fileSize = file.length(); // 파일의 크기를 알아온다.
			System.out.println(">> " + fileName + " 파일의 크기 : " + fileSize+" byte 입니다.");
			long maxSize = 10*1024*1024; // = 10mb
			if(fileSize > maxSize) {
				System.out.println(">> "+fileName+" 파일의 크기가 "+maxSize+" byte 보다 큽니다.");
				System.out.println(">> "+targetFileName+" 파일로 복사할 수 없습니다.");
				bis.close(); // 오리발을 닫는다..
				fis.close(); // 파일을 닫는다.
				bos.close(); // 오리발을 닫는다
				fos.close(); // 파일을 닫는다.
				return; // main() 메서드 종료
			}
			while((inputLength = bis.read(dataArr)) != -1) {
				bos.write(dataArr, 0, inputLength); // 파일에 기록한다.
				bos.flush();
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
			//닫을때는 오리발부터 닫고 닫고, 노드스트림을 닫는다.
			bis.close(); // 오리발을 닫는다..
			fis.close(); // 파일을 닫는다.
			bos.close(); // 오리발을 닫는다
			fos.close(); // 파일을 닫는다.
			
			System.out.println(targetFileName+" 파일에 총 "+totalByte+" byte 입력되었습니다.");
			System.out.println("반복 회수  : " + loopCount + "회");
		}catch (FileNotFoundException e) {
			System.out.println(fileName+" 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
