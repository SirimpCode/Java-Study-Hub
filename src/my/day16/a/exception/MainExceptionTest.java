package my.day16.a.exception;

public class MainExceptionTest {

	public static void main(String[] args) {

		System.out.println("\n==1. \"ArrayIndexOutOfBoundsException\" ");
		// 배열의 크기를 넘는 인덱스값 요청이 들어갈때
		String[] subjectArr = { "자바", "오라클", "JSP" };

		try {
			for (int i = 0; i <= subjectArr.length; i++) {
				System.out.println(subjectArr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 범위 넘김");
			System.out.println(e.getMessage());
		}

		System.out.println("\n== 2. \"ArithmeticException\" ==");

		// ArithmeticException
		// ==> 분모에 0 이 들어가는 경우에 발생하는 익셉션
		try {
			int num = 10;
			for (int i = 2; i >= 0; i--) {
				System.out.println(num / i);
			} // end of for-----------
		} catch (ArithmeticException e) {
			// e.printStackTrace(); // 어디가 오류인지를 추적해서 알려준다.
			System.out.println(">> 분모에는 0 이 올 수 없습니다.");
			// System.out.println(e.getMessage());
			// e.getMessage() 은 오류메시지를 알려주는 것이다.
		}

		System.out.println("\n== 3. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ==");

		int[] num_arr = { 10, 20, 30 };

		for (int i = 3; i >= 0; i--) {
			try {
				int val = num_arr[i] / i;
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(">> 배열의 인덱스 범위가 초과되었습니다. <<");
			} catch (ArithmeticException e) {
				// e.printStackTrace(); // 어디가 오류인지를 추적해서 알려준다.
				System.out.println(">> 분모에는 0 이 올 수 없습니다.");
				// System.out.println(e.getMessage());
				// e.getMessage() 은 오류메시지를 알려주는 것이다.
			}

		} // end of for------------------------
		System.out.println("\n== 4. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ==");

		for (int i = 3; i >= 0; i--) {
			try {
				int val = num_arr[i] / i;
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
				if (e instanceof ArrayIndexOutOfBoundsException)
					System.out.println("배열의 인덱스 범위 초과");
				else if (e instanceof ArithmeticException)
					System.out.println("분모에는 0이 올수 엄슴");
			}

		} // end of for------------------------

		System.out.println("\n== 5. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ==");
		for (int i = 3; i >= 0; i--) {
			try {
				int val = num_arr[i] / i;
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
				if (e instanceof ArrayIndexOutOfBoundsException)
					System.out.println("배열의 인덱스 범위 초과");
				else if (e instanceof ArithmeticException)
					System.out.println("분모에는 0이 올수 엄슴");
			}

		} // end of for------------------------

		System.out.println("\n== 6. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ==");
		String[] strArr = { "10", "스물", "30" };
		for (int i = 3; i >= 0; i--) {
			try {
				int val = Integer.parseInt(strArr[i]) / i;
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
				if (e instanceof ArrayIndexOutOfBoundsException)
					System.out.println("배열의 인덱스 범위 초과");
				else if (e instanceof ArithmeticException)
					System.out.println("분모에는 0이 올수 엄슴");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 파싱 오류");
			}

		}

		
		System.out.println("\n== 7. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ==");
		String[] strArr2 = { "10", "스물", "30" };
		int cnt = 0;
		for (int i = 3; i >= 0; i--) {
			try {
				int val = Integer.parseInt(strArr2[i]) / i;
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
				if (e instanceof ArrayIndexOutOfBoundsException)
					System.out.println("배열의 인덱스 범위 초과");
				else if (e instanceof ArithmeticException)
					System.out.println("분모에는 0이 올수 엄슴");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 파싱 오류");
			} finally {
				System.out.println(++cnt+"번 반복함");
			}
		}
		
		

	}
}
