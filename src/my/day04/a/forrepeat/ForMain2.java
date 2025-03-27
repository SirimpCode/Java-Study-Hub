package my.day04.a.forrepeat;

public class ForMain2 {
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			System.out.print(!(i==9) ? i+1+"," : i+1);
		}
		System.out.println("\n\n");
		
		for (int i=0; i<10; i++) {
			if(!(i%2==0))continue;
			System.out.print(!(i==8) ? i+1+"," : i+1);
		}
		
	}
}
