package kr.or.ddit.store_owner.model;

import java.util.Date;

public class PosPayVo {
	
	private String bcd_id;       // 재고리스트코드
	private int stcklist_amount; // 수량
	private int prod_price; 
	private String prod_id;
	private String pay_kind;
	private Date stcklist_exdate;
	
	public PosPayVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PosPayVo(String bcd_id, int stcklist_amount, int prod_price,
			String prod_id, String pay_kind, Date stcklist_exdate) {
		super();
		this.bcd_id = bcd_id;
		this.stcklist_amount = stcklist_amount;
		this.prod_price = prod_price;
		this.prod_id = prod_id;
		this.pay_kind = pay_kind;
		this.stcklist_exdate = stcklist_exdate;
	}

	public String getBcd_id() {
		return bcd_id;
	}

	public void setBcd_id(String bcd_id) {
		this.bcd_id = bcd_id;
	}

	public int getStcklist_amount() {
		return stcklist_amount;
	}

	public void setStcklist_amount(int stcklist_amount) {
		this.stcklist_amount = stcklist_amount;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getPay_kind() {
		return pay_kind;
	}

	public void setPay_kind(String pay_kind) {
		this.pay_kind = pay_kind;
	}

	public Date getStcklist_exdate() {
		return stcklist_exdate;
	}

	public void setStcklist_exdate(Date stcklist_exdate) {
		this.stcklist_exdate = stcklist_exdate;
	}

	@Override
	public String toString() {
		return "PosPayVo [bcd_id=" + bcd_id + ", stcklist_amount="
				+ stcklist_amount + ", prod_price=" + prod_price + ", prod_id="
				+ prod_id + ", pay_kind=" + pay_kind + ", stcklist_exdate="
				+ stcklist_exdate + "]";
	}
	
	
}
