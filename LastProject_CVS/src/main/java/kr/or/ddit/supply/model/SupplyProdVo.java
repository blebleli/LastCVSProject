package kr.or.ddit.supply.model;

public class SupplyProdVo {
	
	int splylist_sum;	//발주 수량
	String prod_name;	//제품 이름
	String prod_id;		//제품 코드
	int prod_price;		//제품 가격
	public SupplyProdVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplyProdVo(int splylist_sum, String prod_name, String prod_id,
			int prod_price) {
		super();
		this.splylist_sum = splylist_sum;
		this.prod_name = prod_name;
		this.prod_id = prod_id;
		this.prod_price = prod_price;
	}
	@Override
	public String toString() {
		return "SupplyProdVo [splylist_sum=" + splylist_sum + ", prod_name="
				+ prod_name + ", prod_id=" + prod_id + ", prod_price="
				+ prod_price + "]";
	}
	public int getSplylist_sum() {
		return splylist_sum;
	}
	public void setSplylist_sum(int splylist_sum) {
		this.splylist_sum = splylist_sum;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
}
