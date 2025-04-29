package my.day19.b.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {
	/*
	 File 클래스
	 자바에서 File 클래스의 객체라 함은 파일 및 폴더(디렉토리)를 다 포함한다.
	 */
	public static void main(String[] args) {
		
		System.out.print(">> 읽을 파일의 이름을 입력 => ");
		String fileName = "C:/NCS/iotestdata/쉐보레전면.jpg";// C:/NCS/iotestdata/쉐보레전면.jpg
		File file = new File(fileName);
		System.out.println("파일명만 : "+file.getName());
		System.out.println("파일의 경로 : "+file.getPath());
		System.out.println("파일의 절대경로 : "+file.getAbsolutePath());
		System.out.println("파일의 크기 : "+file.length()+" byte");
		System.out.println("파일의 크기 : "+(file.length()/1024)+" kb");
		//경로만 출력
		String path = file.getPath().substring(0, file.getPath().lastIndexOf(File.separator));
		
		System.out.println("파일명을 제외한 경로 : "+path);
		
		System.out.println("파일의 마지막 수정일 : "+file.lastModified());
		
		System.out.println("==========================================================\n");
		System.out.println("폴더만들기 시이자아악!");
		File dir = new File("C:/NCS/iotestdata/폴더만들기");
		if(!dir.exists()) {
			boolean isSuccess = dir.mkdir(); //폴더 만들기
			String result = isSuccess ? "폴더가 생성되었습니다." : "폴더 생성에 실패했습니다.";
			System.out.println("C:/NCS/iotestdata/폴더만들기 "+result);
		}
		//파일인지 폴더인지 구분하기
		if(dir.isFile())
			System.out.println(dir.getName()+" 은 파일입니다.");
		else if(dir.isDirectory())
			System.out.println(dir.getName()+" 은 폴더입니다.");
		else
			System.out.println(dir.getName()+" 은 파일도 아니고 폴더도 아닙니다.");
		
		System.out.println("==========================================================\n");
		System.out.println(">>파일생성핟기<<");
		File file2 = new File("C:/NCS/iotestdata/폴더만들기/파일생성하기.txt");
		if (!file2.exists()) {
			try { // 파일 만들기
				boolean isSuccess = file2.createNewFile();
				String result = isSuccess ? "파일이 생성되었습니다." : "파일 생성에 실패했습니다.";
				System.out.println( file2.getPath() + " => " + result);
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
		if(file2.isFile())
			System.out.println(file2.getName()+" 은 파일입니다.");
		else if(dir.isDirectory())
			System.out.println(file2.getName()+" 은 폴더입니다.");
		else
			System.out.println(file2.getName()+" 은 파일도 아니고 폴더도 아닙니다.");
		
//		System.out.println("==========================================================\n");
//		System.out.println(">>파일삭제하기<<");
//		if (file2.exists()) {
//			boolean isSuccess = file2.delete(); // 파일 삭제하기
//			String result = isSuccess ? "파일이 삭제되었습니다." : "파일 삭제에 실패했습니다.";
//			System.out.println(file2.getPath() + " => " + result);
//		}
		System.out.println("==========================================================\n");
		System.out.println(">>텅빈 폴더 삭제하기 <<");//텅빈폴더가 아닐땐 삭제 가 안됨.
		if (dir.exists()) {
			boolean isSuccess = dir.delete(); // 폴더 삭제하기
			String result = isSuccess ? "폴더가 삭제되었습니다." : "폴더 삭제에 실패했습니다.";
			System.out.println(dir.getPath() + " => " + result);
		}
		System.out.println("==========================================================\n");
		System.out.println(">> 파일의 목록을 출력합니다. <<\n");
		
		if(dir.exists()) {
			String[] fileList = dir.list(); // 폴더의 목록을 가져온다.
			for (String fileName2 : fileList) {
				System.out.println(fileName2);
			}
		} 
		System.out.println("==========================================================\n");
		System.out.println(">> 폴더의 내의 파일 삭제 합니다. <<\n");
		if(dir.exists()) {
			String[] fileList = dir.list(); // 폴더의 목록을 가져온다.
			for (String fileName2 : fileList) {
				File file3 = new File(dir.getPath()+File.separator+fileName2);
				if(file3.isFile()) {
					boolean isSuccess = file3.delete(); // 파일 삭제하기
					String result = isSuccess ? "파일이 삭제되었습니다." : "파일 삭제에 실패했습니다.";
					System.out.println(file3.getPath() + " => " + result);
				}else if(file3.isDirectory()) {
					System.out.println(file3.getName()+" 은 폴더입니다.");
					System.out.println(file3.getName()+" 삭제 합니다.");
					boolean isSuccess = file3.delete(); // 폴더 삭제하기
					String result = isSuccess ? "폴더가 삭제되었습니다." : "폴더 삭제에 실패했습니다.";
					System.out.println(file3.getPath() + " => " + result);
				}
			}
		}
		
		// 먼저 아래의 실습을 하려면 탐색기에서 C:/NCS/iotestdata 밑에 images 라는 폴더를 생성하고
	      // images 폴더 속에 파일을 몇 개 올려둔다.
		File imgesDir = new File("C:/NCS/iotestdata/images");
		if(imgesDir.exists()) {
			File[] fileList = imgesDir.listFiles(); // 폴더의 목록을 가져온다.
			for (File fileName2 : fileList) {
				System.out.println(fileName2.getName()+" 삭제");
				
				fileName2.delete();
			}
		}
		
		
	}//

}
