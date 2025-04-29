
public class TestMain {

	public static void main(String[] args) {
		String str ="abacabcd";
		int length = str.length();
		boolean[] seen = new boolean[256];
		System.out.println(fn(str,length-1,seen));
	}

	private static String fn(String str, int index, boolean[] seen) {
		if (index < 0) {
			return "";
		}
		char c = str.charAt(index);
		String result = fn(str, index - 1, seen);
		if (!seen[c]) {
			seen[c] =true;
			return c+result;
		}
		return result;
	}

}
