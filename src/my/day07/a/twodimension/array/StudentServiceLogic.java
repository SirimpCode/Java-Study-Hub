package my.day07.a.twodimension.array;

import java.util.Scanner;
/*
================== >> 메뉴 << =============================
 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료
==========================================================
▷ 메뉴번호선택 : 5
>> [경고] 메뉴에 없습니다.

▷ 메뉴번호선택 : 1
>> 학생점수입력 <<
1) 학번 : 001
2) 성명 : 이순신
3) 국어 : 110
>> [경고] 점수는 0 ~ 100 만 가능합니다. 
3) 국어 : 90
4) 영어 : 100  
5) 수학 : 80
== 학생점수입력 완료 ==

================== >> 메뉴 << =============================
 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료
==========================================================
  ▷ 메뉴번호선택 : 1
  >> 정원(3명)마감되어 더이상 학생점수입력이 불가합니다.
  
  
================== >> 메뉴 << =============================
 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료
==========================================================      
▷ 메뉴번호선택 : 2

=====>> 모든학생성적출력 <<=====
----------------------------------------------
학번  성명   국어   영어  수학  총점  평균  학점  등수 
----------------------------------------------
001  이순신  90   100  80   270  90.0   A   2
002  엄정화  100  100  100  300  100.0  A   1
003  차은우  80   80   80   240  80.0   B   3
----------------------------------------------


================== >> 메뉴 << =============================
 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료
==========================================================      
▷ 메뉴번호선택 : 3
>> 조회할 학번 : 004
>> [경고] 학번 004 는 존재하지 않습니다.

================== >> 메뉴 << =============================
 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료
==========================================================      
▷ 메뉴번호선택 : 3
>> 조회할 학번 : 002

----------------------------------------------
학번  성명   국어   영어  수학  총점  평균  학점  등수 
----------------------------------------------
002  엄정화  100  100  100  300  100.0  A   1  
----------------------------------------------


================== >> 메뉴 << =============================
 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료
*/
public class StudentServiceLogic {
	Student[] stuArr = new Student[3];
	
	private boolean isFullStudent() {
		for(Student s : stuArr)
			if(s == null) return false;
		return true;
	}
	//학생 집어넣기
	private void putStuArr(Student stu) {
		for(int i = 0 ; i< stuArr.length; i++)
			if(stuArr[i] == null) {
				stuArr[i] = stu;
				System.out.println("학생 등록 성공");
				return;
			}
	}
	//학번으로 학생찾기
	private Student getStuByStuId(String id) {
		for(Student s : stuArr) {
			if(s!=null&&s.getStuId().equals(id)) return s;
		}
		return null;
	}
	private boolean isAllNull(Student[] stuList) {
		boolean allNull = true;
		for (Student s : stuList) {
			if (s != null) {
				allNull = false;
				break;
			}
		}
		return allNull; 
	}
	private int getRank(double avg) {
		int rank = 1;
		for(Student s : stuArr) {
			if(s!=null&&avg<s.getAvg()) rank+=1;
		}
		return rank;
	}
	
	private void printStudent(Student[] stuList) {
		if(isAllNull(stuList)) {
			System.out.println("\n!!!학생 리스트가 비어있습니다.!!!");
			return;
		};
		
		System.out.println("\t================성적================");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t등수");
		System.out.println("-----------------------------------------------------------------------");
		for(Student s : stuList) {
			if(s!=null) {
				System.out.println(s.getInfo()+"\t"+getRank(s.getAvg()));
			}
		}
	}
	
	public void start(Scanner sc) {
		outter:
		while(true) {
			System.out.println("================== >> 메뉴 << =============================\r\n");
			System.out.println(" 1.학생점수입력  2.모든학생성적출력  3.특정학생성적출력   4.프로그램종료\r\n");
			System.out.println("==========================================================\r\n");
			System.out.print("메뉴 번호를 눌러 주세요. => ");
			String menuNum = sc.nextLine();
			switch(menuNum) {
				case "1" : 
					putStudent(sc);
					break;
				case "2" : 
					printStudent(stuArr);
					break;
				case "3" : 
					findAndPrint(sc);
					break;
				case "4": 
					sc.close();
					break outter;
				default : System.out.println("\n>> [경고] 메뉴 번호 똑바로 눌러 ");
			}
		}
	}
	private void findAndPrint(Scanner sc) {
		while(true) {
			System.out.print("찾을 사람의 학번 => ");
			String myId = sc.nextLine();
			Student myStu = getStuByStuId(myId);
			if(myStu==null) System.out.println("해당 학번의 학생 존재하지 않음");
			else {
				printStudent(new Student[]{myStu});
			}
		}
	}
	private String inputId(Scanner sc) {
		while(true) {
			System.out.print("1) 학생 학번 => ");
			String stuId = sc.nextLine();
			if(stuId.length()!=3||!stuId.matches("\\d+")) {
				System.out.println("학번은 3자리의 숫자로만 입력 해주세요.");
				continue;
			}

			Student oldStu = getStuByStuId(stuId); 
			if(oldStu!=null) {
				System.out.println("해당 학번의 학생 이미 존재 => 존재 학생 : "+oldStu.getStuName());
				continue;
			}
			return stuId;
		}
	}
	private String inputName(Scanner sc) {
		outter:
		while(true) {
			System.out.print("2) 학생 이름 => ");
			String name = sc.nextLine();
			if(name.length()<2||name.length()>6) {
				System.out.println("2글자 이상 6글자 이하여야 합니다.");
				continue;
			}
			for(char c : name.toCharArray()) {
				if(!(c>='가'&&c<='힣')) {
					System.out.println("한글로만 구성되어야 합니다.");
					continue outter;
				}
			}
			return name;
		}
	}
	
	private int inputScore(Scanner sc, int no, String sub) {
		while(true) {
			try {
				System.out.print(no+") "+sub+" 점수 => ");
				int value = Integer.parseInt(sc.nextLine());
				if(value<0||value>100) throw new NumberFormatException();
				return value;
			}catch(NumberFormatException e) {
				System.out.println("점수는 0에서 100사이의 숫자로 입력해주세요.");
				continue;
			}
		}
		
		
	}
	private void putStudent(Scanner sc) {
		if(isFullStudent()) System.out.println("정원(3명)마감되어 더이상 학생점수입력이 불가합니다.");
		Student newStu = createStudent(sc);
		putStuArr(newStu);
	}
	private Student createStudent(Scanner sc) {
		System.out.println("\r>> 학생점수입력 <<\r");
		String stuId = inputId(sc);
		String stuName = inputName(sc);
		int kor = inputScore(sc, 3, "국어");
		int eng = inputScore(sc, 4, "영어");
		int math = inputScore(sc, 5, "수학");		
		Student stu = Student.of(stuId, stuName, kor, eng, math);
		stu.setPersonnel(stuArr.length);
		return stu;
	}

}
