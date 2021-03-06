package kr.or.ddit.supply.model;

public class SupplyScanInfoVo {
	
	int rnum;			//넘버링
	String prod_id;		//제품 코드
	String splylist_info;	//비고
	String prod_name;	//제품 이름
	int prod_price;		//제품 가격
	int splylist_sum;	//발주 수량
	String supply_bcd;	//수불 바코드
	String supply_state;//발주 상태)10 = 발주, 11 = 결제, 12 = 입고
	
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
	public String getSupply_bcd() {
		return supply_bcd;
	}
	public void setSupply_bcd(String supply_bcd) {
		this.supply_bcd = supply_bcd;
	}
	public String getSupply_state() {
		return supply_state;
	}
	public void setSupply_state(String supply_state) {
		this.supply_state = supply_state;
	}
	@Override
	public String toString() {
		return "SupplyScanInfoVo [rnum=" + rnum + ", prod_id=" + prod_id
				+ ", splylist_info=" + splylist_info + ", prod_name="
				+ prod_name + ", prod_price=" + prod_price + ", splylist_sum="
				+ splylist_sum + ", supply_bcd=" + supply_bcd
				+ ", supply_state=" + supply_state + "]";
	}
	public SupplyScanInfoVo(int rnum, String prod_id, String splylist_info,
			String prod_name, int prod_price, int splylist_sum,
			String supply_bcd, String supply_state) {
		super();
		this.rnum = rnum;
		this.prod_id = prod_id;
		this.splylist_info = splylist_info;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.splylist_sum = splylist_sum;
		this.supply_bcd = supply_bcd;
		this.supply_state = supply_state;
	}
	public SupplyScanInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
