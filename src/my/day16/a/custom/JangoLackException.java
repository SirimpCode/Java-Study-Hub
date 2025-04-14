package my.day16.a.custom;

public class JangoLackException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JangoLackException(String message) {
		super(message);
	}
	private JangoLackException(int jango, int jumunSu) {
		super("제품 수량은 "+jango+"개 있는데 "+jumunSu+"개를 주문하려하여 수량이 "+(jumunSu-jango)+"개 부족 합니다.");
	}
	public static JangoLackException fromMessage(String message) {
		return new JangoLackException(message);
	}
	public static JangoLackException of(int jango, int jumunSu) {
		return new JangoLackException(jango, jumunSu);
	}
}
