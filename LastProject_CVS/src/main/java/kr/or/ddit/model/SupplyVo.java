package kr.or.ddit.model;

public class SupplyVo {
	
	private String supply_bcd;                               // 수불바코드
	private String supply_date;                               // 날짜
	private String supply_state;                               // 발주 : 10 , 결제 : 11 , 입고 : 12
	private String supply_info;                               // 비고
	private String place_id;                               // 편의점
	public SupplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplyVo(String supply_bcd, String supply_date, String supply_state,
			String supply_info, String place_id) {
		super();
		this.supply_bcd = supply_bcd;
		this.supply_date = supply_date;
		this.supply_state = supply_state;
		this.supply_info = supply_info;
		this.place_id = place_id;
	}
	public String getSupply_bcd() {
		return supply_bcd;
	}
	public void setSupply_bcd(String supply_bcd) {
		this.supply_bcd = supply_bcd;
	}
	public String getSupply_date() {
		return supply_date;
	}
	public void setSupply_date(String supply_date) {
		this.supply_date = supply_date;
	}
	public String getSupply_state() {
		return supply_state;
	}
	public void setSupply_state(String supply_state) {
		this.supply_state = supply_state;
	}
	public String getSupply_info() {
		return supply_info;
	}
	public void setSupply_info(String supply_info) {
		this.supply_info = supply_info;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	@Override
	public String toString() {
		return "SupplyVo [supply_bcd=" + supply_bcd + ", supply_date="
				+ supply_date + ", supply_state=" + supply_state
				+ ", supply_info=" + supply_info + ", place_id=" + place_id
				+ "]";
	}
	
	

}
