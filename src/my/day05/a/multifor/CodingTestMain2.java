package my.day05.a.multifor;

public class CodingTestMain2 {
	public static void main(String[] args) {
		
		for(int i=1; i<10; i++) {
			for(int j = 2; j<10; j++) {
				if(j==5) {
					System.out.printf("%d*%d=%d\n",j,i,j*i);
					break;
				}
				System.out.printf("%d*%d=%d\t",j,i,j*i);
			}
		}
		System.out.println();
		for(int i=1; i<10; i++) {
			for(int j = 6; j<10; j++) {
				if(j==9) {
					System.out.printf("%d*%d=%d\n",j,i,j*i);
					break;
				}
				System.out.printf("%d*%d=%d\t",j,i,j*i);
			}
		}
		
		
		
//		
//		for(int main = 0 ; main<2; main++) {
//			if (main==1) {
//				for(int i=1; i<10; i++) {
//					for(int j = 6; j<10; j++) {
//						if(j==9) {
//							System.out.printf("%d*%d=%d\n",j,i,j*i);
//							break;
//						}
//						System.out.printf("%d*%d=%d\t",j,i,j*i);
//					}
//				}
//				break;
//			}
//			for(int i=1; i<10; i++) {
//				for(int j = 2; j<10; j++) {
//					if(j==5) {
//						System.out.printf("%d*%d=%d\n",j,i,j*i);
//						break;
//					}
//					System.out.printf("%d*%d=%d\t",j,i,j*i);
//				}
//			}
//			System.out.println();
//		}
		
	}
}
