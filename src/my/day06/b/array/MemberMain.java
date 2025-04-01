package my.day06.b.array;

import java.util.Scanner;

import my.day01.Member;
import my.day01.MyUtil;

public class MemberMain {

	private static MyMember[] memberArr = new MyMember[3];
	
	//자리 있는지 확인
	private static boolean isFullMember() {
		for(MyMember m : memberArr)
			if(m == null) return false;
		return true;
	}
	private static void addMember(MyMember[] memberArr, MyMember newMember) {
        for (int i = 0; i < memberArr.length; i++) {
            if (memberArr[i] == null) {
                memberArr[i] = newMember;
                System.out.println(newMember.getName() + "를  " + i+"번째 인덱스에 가입 시킴");
                return;
            }
        }
        System.out.println(newMember.getName()+"를 추가하지 못했어 회원 꽉참");
    }
	//중복확인
	private static boolean duplicationId(String id) {
		for(MyMember m : memberArr) 
			if(m!=null)
				if(m.getNo().equals(id))
					return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String userSelect = "";
		while( !(userSelect.equals("3")) ) {
			
			System.out.println("\n============ >> 메뉴 << ============\n"
                + "1.회원가입   2.모든회원조회   3.프로그램종료\n"
                + "=====================================");
			System.out.print("▷ 선택하세요 => ");
			userSelect = sc.nextLine().trim();
			// trim 으로 앞 뒤 모든 공백제거 ⬆️ (중앙에 낀 공백은 제거 되지 않는다.)
			
			
			switch(userSelect) {
			case "1" :
				if(isFullMember()) {
					System.out.println(">>[경고] 유저가 꽉 찼습니다. 가입 불가");
					break;
				}
				String id = null;
				String pw = null;
				String name = null;
				while(true) {
					System.out.print("\n✔️아이디 => ");
					id = MyUtil.deleteSpace2(sc.nextLine());
					if(id.isBlank()) {
						System.out.println(">>[경고] 아이디값을 공백이 아닌 다른 값으로 입력하세요\n");
						continue;
					}else if(duplicationId(id)) {
						System.out.println(">>[경고] 아이디값 중복 다른 아이디로 설정하세요\n");
						continue;
					}
					break;
				}
				
				while(true) {
					System.out.print("\n✔️비밀번호 => ");
					pw = sc.nextLine();
				 if(!MyUtil.passwordVerify(pw)) {
					System.out.println(">>[경고] 비밀번호는 8글자 이상 15글자 이하의 영문 대,소문자 및 숫자와 특수문자가 혼합되어야만 합니다.\n");
					continue;
				}
					break;
				}
				while(true) {
					System.out.print("\n✔️이름 => ");
					name = sc.nextLine();
					if(!MyUtil.nameVerify(name)) {
						System.out.println(">>[경고]성명은 공백이 없는 한글로만 2글자 이상 6글자 이하로 입력하세요!! \n");
						continue;
					}
					break;
				}
				
				MyMember newMember = MyMember.of(name,id, pw);
				addMember(memberArr, newMember);
				
				break;
			case "2" : 
				if(memberArr[1] == null && memberArr[0] == null && memberArr[2] == null)
					System.out.println(">> 현재 가입된 회원이 없습니다.\n");
				for(int i=0;i< memberArr.length;i++) {
					if(memberArr[i] != null) 
						System.out.println(i+1+"번째 유저 => "+memberArr[i].getInfo());
				}
				break;
			case "3" : break;
			default : 
				System.out.println("\n\t다시 입력 하세요.");
				break;
			}
			
			
		}
		sc.close();
		System.out.println("\n=================종료=================");
		String test = "";
		//JDK 11 이전 비어있는지 확인 방법
		test.isEmpty();// 비어있으면 true ("       " 는 false )
		//JDK 11 포함 그 이후 방법 
		test.isBlank();// 비어있거나 공백만 있을 경우 true (공백만 있을 경우에도 true 이므로 trim을 사용할 필요 없다.)
	}
}
