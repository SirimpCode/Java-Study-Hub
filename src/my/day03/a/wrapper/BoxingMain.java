package my.day03.a.wrapper;

public class BoxingMain {
	//boxing
	int a1 = 10;
	Integer a2 = Integer.valueOf(a1);
	//auto-boxing
	int b1 = 10;
	Integer b2 = a1;
	
	//un-boxing
	Integer a3 = 20;
	int a4 = a3.intValue();
	//auto-boxing
	Integer a5 = 20;
	int a6 = a5;
	
	
}
