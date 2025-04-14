package my.day16.a.custom;

public class CustomException extends RuntimeException{
	
	private CustomException(String message) {
		super(message);
	}
	public static CustomException fromMessage(String message) {
		return new CustomException(message);
	}
}
