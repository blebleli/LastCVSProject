package kr.or.ddit.supply.model;

public class SupplyProdVo {
	
	String splylist_sum;	//발주 수량
	String prod_name;	//제품 이름
	String prod_id;		//제품 코드
	
	public String getSplylist_sum() {
		return splylist_sum;
	}


	public void setSplylist_sum(String splylist_sum) {
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


	@Override
	public String toString() {
		return "supplyProdVo [splylist_sum=" + splylist_sum + ", prod_name="
				+ prod_name + ", prod_id=" + prod_id + "]";
	}


	public SupplyProdVo() {
		super();
	}


	public SupplyProdVo(String splylist_sum, String prod_name, String prod_id) {
		super();
		this.splylist_sum = splylist_sum;
		this.prod_name = prod_name;
		this.prod_id = prod_id;
	}
	
	

}
