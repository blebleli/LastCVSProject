package kr.or.ddit.model;

public class CvsServiceVo {
	
	private String service_id;                               // 현황코드
	private String ctgy_id;                               // 카테고리코드
	private String place_id;                               // 편의점
	public CvsServiceVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CvsServiceVo(String service_id, String ctgy_id, String place_id) {
		super();
		this.service_id = service_id;
		this.ctgy_id = ctgy_id;
		this.place_id = place_id;
	}
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public String getCtgy_id() {
		return ctgy_id;
	}
	public void setCtgy_id(String ctgy_id) {
		this.ctgy_id = ctgy_id;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	@Override
	public String toString() {
		return "CvsServiceVo [service_id=" + service_id + ", ctgy_id="
				+ ctgy_id + ", place_id=" + place_id + "]";
	}
	
	

}
