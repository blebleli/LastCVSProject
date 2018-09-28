package kr.or.ddit.supply.model;

import java.util.Date;

public class SupRequestListVo {

	private String supply_bcd;                               // 수불바코드
	private Date supply_date;                               // 날짜
	private String supply_state;                               // 발주 : 10 , 결제 : 11 , 입고 : 12
	private String place_id;                               // 편의점
	private int total_amount;								//발주내역 총 수량
	private int total;										// 총 금액
	
	
	
	public SupRequestListVo() {
		super();
	}


	public SupRequestListVo(String supply_bcd, Date supply_date,
			String supply_state, String place_id, int total_amount, int total) {
		super();
		this.supply_bcd = supply_bcd;
		this.supply_date = supply_date;
		this.supply_state = supply_state;
		this.place_id = place_id;
		this.total_amount = total_amount;
		this.total = total;
	}


	public String getSupply_bcd() {
		return supply_bcd;
	}


	public void setSupply_bcd(String supply_bcd) {
		this.supply_bcd = supply_bcd;
	}


	public Date getSupply_date() {
		return supply_date;
	}


	public void setSupply_date(Date supply_date) {
		this.supply_date = supply_date;
	}


	public String getSupply_state() {
		return supply_state;
	}


	public void setSupply_state(String supply_state) {
		this.supply_state = supply_state;
	}


	public String getPlace_id() {
		return place_id;
	}


	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}


	public int getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "SupRequestListVo [supply_bcd=" + supply_bcd + ", supply_date="
				+ supply_date + ", supply_state=" + supply_state
				+ ", place_id=" + place_id + ", total_amount=" + total_amount
				+ ", total=" + total + "]";
	}
	
	
	
	
}
