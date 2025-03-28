package my.day05.a.multifor;

public class ForGooGooDanMain {
	/*
    == 구구단 ==
2*1=2   3*1=3   4*1=4   ....   9*1=9
2*2=4   3*2=6   4*2=8   ....   9*2=18
2*3=6   3*3=9   4*3=12   ....   9*3=27
2*4=8   3*4=12   4*4=16   ....   9*4=36
2*5=10   3*5=15   4*5=20   ....   9*5=45
2*6=12   3*6=18   4*6=24   ....   9*6=54
2*7=14   3*7=21   4*7=28   ....   9*7=63
2*8=16   3*8=24   4*8=32   ....   9*8=72
2*9=18   3*9=27   4*9=36   ....   9*9=81
*/
	public static void main(String[] args) {
//		System.out.printf(%s %d %f, s 스트링, d 데시멀, f 플롯); 
		for(int i = 1; i<10; i++) {
			for(int j = 2; j<10; j++) {
				if(j==9) {
					System.out.printf("%d*%d=%d\n", j, i, j*i);
					break;
				}
				System.out.printf("%d*%d=%d\t", j, i, j*i);
			}
		}
	}
}
