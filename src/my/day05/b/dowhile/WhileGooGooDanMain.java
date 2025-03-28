package my.day05.b.dowhile;

public class WhileGooGooDanMain {
	public static void main(String[] args) {
		
		int a = 1;
		while(a<10) {
			System.out.println(5+"*"+a+"="+a*5);
			a++;
		}
		
		//구구단 2단 컬럼 3단 컬럼 4단 컬럼 이런식으로
		System.out.println("\t2단\t3단\t4단\t5단\t6단\t7단\t8단\t9단");
		int dan = 1, num = 0;
		while(++num<=9) {
			while(++dan<=9) {
				System.out.printf("\t%d*%d=%d", dan,num, dan*num);
			}
			dan =1;
			System.out.println();
		}
		
	}
}
