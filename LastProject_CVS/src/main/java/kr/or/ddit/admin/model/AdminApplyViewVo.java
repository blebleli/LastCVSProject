package kr.or.ddit.admin.model;

import java.util.Date;


public class AdminApplyViewVo {
	
	private int rnum;			//넘버링
	private Date exdate;		//유통기한
	private String prod_name;	//상품이름
	private int splylist_sum;	//수량
	private int prod_price;		//제품가격
	private int prod_cost;		//단가
	private String prod_id;		//제품 코드
	private String supply_state;//수불 상태(10=발주,11=결제,12=입고)
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public Date getExdate() {
		return exdate;
	}
	public void setExdate(Date exdate) {
		this.exdate = exdate;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getSplylist_sum() {
		return splylist_sum;
	}
	public void setSplylist_sum(int splylist_sum) {
		this.splylist_sum = splylist_sum;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getSupply_state() {
		return supply_state;
	}
	public void setSupply_state(String supply_state) {
		this.supply_state = supply_state;
	}
	@Override
	public String toString() {
		return "AdminApplyViewVo [rnum=" + rnum + ", exdate=" + exdate
				+ ", prod_name=" + prod_name + ", splylist_sum=" + splylist_sum
				+ ", prod_price=" + prod_price + ", prod_cost=" + prod_cost
				+ ", prod_id=" + prod_id + ", supply_state=" + supply_state
				+ "]";
	}
	public AdminApplyViewVo(int rnum, Date exdate, String prod_name,
			int splylist_sum, int prod_price, int prod_cost, String prod_id,
			String supply_state) {
		super();
		this.rnum = rnum;
		this.exdate = exdate;
		this.prod_name = prod_name;
		this.splylist_sum = splylist_sum;
		this.prod_price = prod_price;
		this.prod_cost = prod_cost;
		this.prod_id = prod_id;
		this.supply_state = supply_state;
	}
	public AdminApplyViewVo() {
		super();
	}
	
	
}
