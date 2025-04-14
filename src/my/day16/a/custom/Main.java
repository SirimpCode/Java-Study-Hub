package my.day16.a.custom;

public class Main {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Product p1 = new Product();
		p1.setJango(100);
		p1.setProductName("새우깡");
		
		Product p2 = new Product("감자깡", 50);
		Product p3 = new Product("양파링", 150);
		
		Product[] productArr = new Product[] {p1,p2,p3};
		
		for(Product p : productArr) {
			System.out.println(p);
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		try {
			productArr[0].order(80);
			productArr[0].order(40);
		} catch (JangoLackException e) {
			// TODO 자동 생성된 catch 블록
			System.out.println("예외메세지 "+e.getMessage());
		}
		
		System.out.println("\n==========================================================================\n");
		
		try {
			productArr[2].jumun(200);
		}catch(JangoLackException e) {
			System.out.println(e.getMessage()); 
		}
		

	}

}
