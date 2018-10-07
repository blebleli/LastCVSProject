package kr.or.ddit.model;

public class MemberShipVo {
	
	private String shiplist_id;                               // 맵버십코드
	private String mem_id;                               // 아이디
	private int shiplist_point;                               // 포인트
	private String shiplist_info;	// 비고
	public String getShiplist_id() {
		return shiplist_id;
	}
	public void setShiplist_id(String shiplist_id) {
		this.shiplist_id = shiplist_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getShiplist_point() {
		return shiplist_point;
	}
	public void setShiplist_point(int shiplist_point) {
		this.shiplist_point = shiplist_point;
	}
	public String getShiplist_info() {
		return shiplist_info;
	}
	public void setShiplist_info(String shiplist_info) {
		this.shiplist_info = shiplist_info;
	}
	@Override
	public String toString() {
		return "MemberShipVo [shiplist_id=" + shiplist_id + ", mem_id="
				+ mem_id + ", shiplist_point=" + shiplist_point
				+ ", shiplist_info=" + shiplist_info + "]";
	}
	public MemberShipVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberShipVo(String shiplist_id, String mem_id, int shiplist_point,
			String shiplist_info) {
		super();
		this.shiplist_id = shiplist_id;
		this.mem_id = mem_id;
		this.shiplist_point = shiplist_point;
		this.shiplist_info = shiplist_info;
	}
	
	

}
