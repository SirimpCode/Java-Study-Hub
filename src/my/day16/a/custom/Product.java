package my.day16.a.custom;

public class Product {
	//field
	private String productName;//("새우깡", "감자깡", "양파링")
	private int jango;			//잔고 (100, 50, 150)
	//constructor
	public Product() {}
	
	public Product(String productName, int jango) {
		this.jango = jango;
		this.productName = productName;
	}
	
	//method
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getJango() {
		return this.jango;
	}
	public void setJango(int jango) {
		this.jango = jango;
	}
	@Override
	public String toString() {
		return "1. 제품명 : "+this.productName+"\n2. 수량 : "+this.jango+"개\n";
	}
	
	// 주문받기1
	public void order(int jumunSu) throws JangoLackException {
		if(this.jango < jumunSu ) 
			throw JangoLackException.fromMessage("제품의 개수가 주문량 보다 부족하여 주문할 수 없습니다.");
		jumunProduction(jumunSu);
	}
	private void jumunProduction(int jumunSu) {
		System.out.println(productName+" 제품을 "+ jumunSu+"개를 주문하셨습니다.");
		this.jango -= jumunSu;	
		System.out.println(toString());
	}
	//주문받기2
	public void jumun(int jumunSu) throws JangoLackException{
		if(this.jango < jumunSu ) 
			throw JangoLackException.of(this.jango, jumunSu);
		jumunProduction(jumunSu);
	}

}
