package my.day02.d.operator;

public class OperatorMain {

	public static void main(String[] args) {
		
		
		int n = 10;
		System.out.println("n+3 = "+ (n+3));//괄호 안쓰면 103 이라고나옴
		System.out.println("n-3 = "+ (n-3));//괄호 안쓰면 컴파일 에러남
		System.out.println("n*3 = "+ n*3); //곱하기 나누기는 먼저 연산되서 그런지 괄호없어도됨
		System.out.println("n/3 = "+ n/3);// 3 이라고 나옴
		System.out.println("n/3 = "+ (double)n/3); // 3.333333333333335 식은 괄호로 안 묶여있어서 n에만 형변환 지정됨
		
		//증감 연산자  ++ or --
		int a = 7;
		int b = 3;
		int c = 7, d = 3; //변수 선언 이렇게도가능
		
		
		System.out.println(a); //7
		System.out.println(a+1); //8
		a++;//8
		a++;//9
		System.out.println(a);//9
		System.out.println(++a);//10
		//a++는 값을 먼저 뱉고 값을 증가시키고 ++a는 증가를 먼저 시킨후 값을 뱉는다.
		//뒤에 붙은건 후위 증감연산자 앞에는 전위증감연산자
		//후위 증감연산자는 다른 연산 다 마친후 증감시킴
		//전위 증감연산자는 먼저 증감을 시키고 다른 연산을 진행
		
		int x = 10, y = 10;
		System.out.println(x+" "+y);
		int z = ++x; //x와 z 둘다 11 -> x에 1 더한 후 z에 대입 
		int z1 = y++; // y를 먼저 z1에 대입한 후 y 1 증감 
		System.out.println(x+" "+y+" "+z+" "+z1);// x=11 y=11 z==11 z1=10
		
		int i = 1;
		int j = i++;
		
		if((i>++j) & (i++ ==j)) i= i+j;
		System.out.println(i);
		
		if((i>++j)) i=i+j;
		System.out.println(i);
		
		
		int no = 3;
		no+=5;
		System.out.println(no);//no+3 즉 8이 no에 대입된다.
		no-=5;
		System.out.println(no);// = 3
		no*=5;
		System.out.println(no);// = 15
		no/=5;
		System.out.println(no);// = 3
		

boolean bl = true;
String str = bl ? "앞 값" : "뒷 값";
System.out.println(str);
		
		
		
	}

}
