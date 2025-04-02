package my.day08.b.stringbuilder;

public class StringBuilderMain {

	public static void main(String[] args) {
		String name = "일순신"; // 메모리상에 name 1개 소모
		name += ",이순신";	// 메모리상에 name 1개 소모
		name += ",삼순신";	// 메모리상에 name 1개 소모
		name += ",사순신";	// 메모리상에 name 1개 소모
		name += ",오순신";	// 메모리상에 name 1개 소모
		name += ",육순신";	// 메모리상에 name 1개 소모
		name += ",칠순신";	// 메모리상에 name 1개 소모
		name += ",팔순신";	// 메모리상에 name 1개 소모
		name += ",구순신";	// 메모리상에 name 1개 소모
		name += ",십순신";	// 메모리상에 name 1개 소모
		//매번 메모리상의 name 이 소모가 된다.
		System.out.println(name);
		
		System.out.println("\n"+"~".repeat(50)+"\n");
		
		StringBuffer sb1 = new StringBuffer();
		sb1.append("일순신");
		sb1.append(",이순신");
		sb1.append(",삼순신");
		sb1.append(",사순신");
		sb1.append(",오순신");
		sb1.append(",육순신");
		sb1.append(",칠순신");
		sb1.append(",팔순신");
		sb1.append(",구순신");
		sb1.append(",십순신");
		System.out.println(sb1);
		
		
		System.out.println("\n"+"~".repeat(50)+"\n");
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("일순신");
		sb2.append(",이순신");
		sb2.append(",삼순신");
		sb2.append(",사순신");
		sb2.append(",오순신");
		sb2.append(",육순신");
		sb2.append(",칠순신");
		sb2.append(",팔순신");
		sb2.append(",구순신");
		sb2.append(",십순신");
		System.out.println(sb2);
		
		System.out.println("\n"+"~".repeat(50)+"\n");
		//sb2 초기화 하기
		sb2.setLength(0);
		sb2.append("다시 처음부터 시작");
		sb2.append("덧 붙임");
		sb2.append("끝");
		System.out.println(sb2);
		//두번째 방법 인스턴스 새로 만들어버림
		sb2 = new StringBuilder();
		sb2.append("또 다시 처음부터 시작");
		sb2.append("또 덧 붙임");
		sb2.append("또 끝");
		System.out.println(sb2);
		
		System.out.println("\n"+"~".repeat(50)+"\n");
		
		//문자열 거꾸로 뒤집기
		String str = "안녕하세요";
		StringBuilder sb3 = new StringBuilder(str);
		sb3.reverse();//문자열을 뒤집어 버림
		System.out.println(sb3);//기대값 요세하녕안

	}

}
