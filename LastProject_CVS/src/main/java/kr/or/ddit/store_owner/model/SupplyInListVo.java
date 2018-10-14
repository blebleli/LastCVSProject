package kr.or.ddit.store_owner.model;

import java.util.Date;

public class SupplyInListVo {
	private String splylist_id    ;
	private String splylist_info  ;
	private Date   splylist_exdate;
	private String splylist_sum   ;
	private String supply_bcd     ;
	private String prod_id        ;
	private String prod_name        ;
	public SupplyInListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplyInListVo(String splylist_id, String splylist_info, Date splylist_exdate, String splylist_sum,
			String supply_bcd, String prod_id, String prod_name) {
		super();
		this.splylist_id = splylist_id;
		this.splylist_info = splylist_info;
		this.splylist_exdate = splylist_exdate;
		this.splylist_sum = splylist_sum;
		this.supply_bcd = supply_bcd;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
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
	public String getSplylist_sum() {
		return splylist_sum;
	}
	public void setSplylist_sum(String splylist_sum) {
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
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	@Override
	public String toString() {
		return "SupplyInListVo [splylist_id=" + splylist_id + ", splylist_info=" + splylist_info + ", splylist_exdate="
				+ splylist_exdate + ", splylist_sum=" + splylist_sum + ", supply_bcd=" + supply_bcd + ", prod_id="
				+ prod_id + ", prod_name=" + prod_name + "]";
	}
	
	
}
