package kr.or.ddit.admin.model;

import java.util.Date;

public class AdminApplyVo {
	
	private int rnum;				//넘버링
	private String supply_bcd;		//수불바코드
	private String mem_name;		//점주 이름
	private String mem_cvs_name;	//편의점 이름
	private String supply_state;	//신청처리상태 (10=수불,11=결제,12=입고)
	private Date supply_date;		//신청 날짜
	private String mem_id;			//사용자 아이디
	private String supply_info;      // 정보
	
	
	
	public String getSupply_info() {
		return supply_info;
	}
	public void setSupply_info(String supply_info) {
		this.supply_info = supply_info;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getSupply_bcd() {
		return supply_bcd;
	}
	public void setSupply_bcd(String supply_bcd) {
		this.supply_bcd = supply_bcd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_cvs_name() {
		return mem_cvs_name;
	}
	public void setMem_cvs_name(String mem_cvs_name) {
		this.mem_cvs_name = mem_cvs_name;
	}
	public String getSupply_state() {
		return supply_state;
	}
	public void setSupply_state(String supply_state) {
		this.supply_state = supply_state;
	}
	public Date getSupply_date() {
		return supply_date;
	}
	public void setSupply_date(Date supply_date) {
		this.supply_date = supply_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
	@Override
	public String toString() {
		return "AdminApplyVo [rnum=" + rnum + ", supply_bcd=" + supply_bcd
				+ ", mem_name=" + mem_name + ", mem_cvs_name=" + mem_cvs_name
				+ ", supply_state=" + supply_state + ", supply_date="
				+ supply_date + ", mem_id=" + mem_id + ", supply_info="
				+ supply_info + "]";
	}
	public AdminApplyVo(int rnum, String supply_bcd, String mem_name,
			String mem_cvs_name, String supply_state, Date supply_date,
			String mem_id) {
		super();
		this.rnum = rnum;
		this.supply_bcd = supply_bcd;
		this.mem_name = mem_name;
		this.mem_cvs_name = mem_cvs_name;
		this.supply_state = supply_state;
		this.supply_date = supply_date;
		this.mem_id = mem_id;
	}
	public AdminApplyVo() {
		super();
	}
	
}
