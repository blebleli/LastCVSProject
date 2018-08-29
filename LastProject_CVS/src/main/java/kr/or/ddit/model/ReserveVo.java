package kr.or.ddit.model;

public class ReserveVo {
	
	private String reserve_id;                               // 알람코드
	private String reserve_date;                               // 시간
	private String mem_id;                               // 아이디
	private String prod_id;                               // 제품바코드
	private String place_id;                               // 편의점
	public ReserveVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReserveVo(String reserve_id, String reserve_date, String mem_id,
			String prod_id, String place_id) {
		super();
		this.reserve_id = reserve_id;
		this.reserve_date = reserve_date;
		this.mem_id = mem_id;
		this.prod_id = prod_id;
		this.place_id = place_id;
	}
	public String getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(String reserve_id) {
		this.reserve_id = reserve_id;
	}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	@Override
	public String toString() {
		return "ReserveVo [reserve_id=" + reserve_id + ", reserve_date="
				+ reserve_date + ", mem_id=" + mem_id + ", prod_id=" + prod_id
				+ ", place_id=" + place_id + "]";
	}
	
	

}
