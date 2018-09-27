package kr.or.ddit.model;

import java.util.Date;

public class SupplyListVo {
	
	private String splylist_id;                         // 제품리스트코드
	private String splylist_info;                       // 비고
	private Date splylist_exdate;                       // 유통기한
	private int splylist_sum;                           // 수량
	private String supply_bcd;                          // 수불바코드
	private String prod_id;   							// 제품바코드
	
	public SupplyListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SupplyListVo(String splylist_id, String splylist_info,
			Date splylist_exdate, int splylist_sum, String supply_bcd,
			String prod_id) {
		super();
		this.splylist_id = splylist_id;
		this.splylist_info = splylist_info;
		this.splylist_exdate = splylist_exdate;
		this.splylist_sum = splylist_sum;
		this.supply_bcd = supply_bcd;
		this.prod_id = prod_id;
	}
	
	public String getSplylist_id() {
		return splylist_id;
	}
	public void setSplylist_id(String splylist_id) {
		this.splylist_id = splylist_id;
	}
	public String getSplylist_info() {
		return splylist_info;
	}
	public void setSplylist_info(String splylist_info) {
		this.splylist_info = splylist_info;
	}
	public Date getSplylist_exdate() {
		return splylist_exdate;
	}
	public void setSplylist_exdate(Date splylist_exdate) {
		this.splylist_exdate = splylist_exdate;
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
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	
	@Override
	public String toString() {
		return "SupplyListVo [splylist_id=" + splylist_id + ", splylist_info="
				+ splylist_info + ", splylist_exdate=" + splylist_exdate
				+ ", splylist_sum=" + splylist_sum + ", supply_bcd="
				+ supply_bcd + ", prod_id=" + prod_id + "]";
	}
	
	
	

}
