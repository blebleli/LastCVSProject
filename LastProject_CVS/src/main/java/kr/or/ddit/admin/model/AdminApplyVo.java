package kr.or.ddit.admin.model;

public class AdminApplyVo {
	
	int rnum;				//넘버링
	String supply_bcd;		//수불바코드
	String mem_name;		//점주 이름
	String mem_cvs_name;	//편의점 이름
	String supply_state;	//신청처리상태 (10=수불,11=결제,12=입고)
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
	@Override
	public String toString() {
		return "AdminApplyVo [rnum=" + rnum + ", supply_bcd=" + supply_bcd
				+ ", mem_name=" + mem_name + ", mem_cvs_name=" + mem_cvs_name
				+ ", supply_state=" + supply_state + "]";
	}
	public AdminApplyVo(int rnum, String supply_bcd, String mem_name,
			String mem_cvs_name, String supply_state) {
		super();
		this.rnum = rnum;
		this.supply_bcd = supply_bcd;
		this.mem_name = mem_name;
		this.mem_cvs_name = mem_cvs_name;
		this.supply_state = supply_state;
	}
	public AdminApplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
