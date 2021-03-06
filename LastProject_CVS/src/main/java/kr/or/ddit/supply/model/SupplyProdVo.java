package kr.or.ddit.supply.model;

public class SupplyProdVo {
	
	int rnum;			//넘버링
	String prod_id;		//제품 코드
	String splylist_info;	//비고
	String prod_name;	//제품 이름
	int prod_price;		//제품 가격
	int splylist_sum;	//발주 수량
	
	int prod_cost;		//제품 단가
	int price;			//합계 
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getSplylist_info() {
		return splylist_info;
	}
	public void setSplylist_info(String splylist_info) {
		this.splylist_info = splylist_info;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getSplylist_sum() {
		return splylist_sum;
	}
	public void setSplylist_sum(int splylist_sum) {
		this.splylist_sum = splylist_sum;
	}
	
	
	public int getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "SupplyProdVo [rnum=" + rnum + ", prod_id=" + prod_id
				+ ", splylist_info=" + splylist_info + ", prod_name="
				+ prod_name + ", prod_price=" + prod_price + ", splylist_sum="
				+ splylist_sum + ", prod_cost=" + prod_cost + ", price="
				+ price + "]";
	}
	
	
	public SupplyProdVo(int rnum, String prod_id, String splylist_info,
			String prod_name, int prod_price, int splylist_sum, int prod_cost,
			int price) {
		super();
		this.rnum = rnum;
		this.prod_id = prod_id;
		this.splylist_info = splylist_info;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.splylist_sum = splylist_sum;
		this.prod_cost = prod_cost;
		this.price = price;
	}
	public SupplyProdVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
