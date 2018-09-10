package kr.or.ddit.store_owner.model;

import java.util.Date;

public class PresentStockListVo {

	private String prod_id;
	private String prod_name;                               // 이름
	private Date supply_date;                               // 날짜
	private Date stcklist_exdate;                               // 유통기한
	private int prod_price;                               // 가격
	private int stcklist_amount;                               // 수량
	private String event_id;                               // 행사제품코드
	private String stcklist_id;                               // 재고리스트코드
	
	public PresentStockListVo(){
		super();
	}

	

	public PresentStockListVo(String prod_id, String prod_name,
			Date supply_date, Date stcklist_exdate, int prod_price,
			int stcklist_amount, String event_id, String stcklist_id) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.supply_date = supply_date;
		this.stcklist_exdate = stcklist_exdate;
		this.prod_price = prod_price;
		this.stcklist_amount = stcklist_amount;
		this.event_id = event_id;
		this.stcklist_id = stcklist_id;
	}



	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public Date getSupply_date() {
		return supply_date;
	}

	public void setSupply_date(Date supply_date) {
		this.supply_date = supply_date;
	}

	public Date getStcklist_exdate() {
		return stcklist_exdate;
	}

	public void setStcklist_exdate(Date stcklist_exdate) {
		this.stcklist_exdate = stcklist_exdate;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getStcklist_amount() {
		return stcklist_amount;
	}

	public void setStcklist_amount(int stcklist_amount) {
		this.stcklist_amount = stcklist_amount;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getStcklist_id() {
		return stcklist_id;
	}

	public void setStcklist_id(String stcklist_id) {
		this.stcklist_id = stcklist_id;
	}

	@Override
	public String toString() {
		return "PresentStockListVo [prod_id=" + prod_id + ", prod_name="
				+ prod_name + ", supply_date=" + supply_date
				+ ", stcklist_exdate=" + stcklist_exdate + ", prod_price="
				+ prod_price + ", stcklist_amount=" + stcklist_amount
				+ ", event_id=" + event_id + ", stcklist_id=" + stcklist_id
				+ "]";
	}
	
	
}
