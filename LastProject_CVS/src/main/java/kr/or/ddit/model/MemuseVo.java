package kr.or.ddit.model;

public class MemuseVo {
	
	private String shiplist_id;                               // 맴버쉽사용내역코드
	private int shiplist_point;                               // 사용포인트
	private String shiplist_info;                               // 비고
	private String memship_id;                               // 맵버십코드
	private String mem_id;                               // 아이디
	private String paykind_id;                               // 결제상세코드
	private String sd_id;                               // 판매코드
	public MemuseVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemuseVo(String shiplist_id, int shiplist_point,
			String shiplist_info, String memship_id, String mem_id,
			String paykind_id, String sd_id) {
		super();
		this.shiplist_id = shiplist_id;
		this.shiplist_point = shiplist_point;
		this.shiplist_info = shiplist_info;
		this.memship_id = memship_id;
		this.mem_id = mem_id;
		this.paykind_id = paykind_id;
		this.sd_id = sd_id;
	}
	public String getShiplist_id() {
		return shiplist_id;
	}
	public void setShiplist_id(String shiplist_id) {
		this.shiplist_id = shiplist_id;
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
	public String getMemship_id() {
		return memship_id;
	}
	public void setMemship_id(String memship_id) {
		this.memship_id = memship_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPaykind_id() {
		return paykind_id;
	}
	public void setPaykind_id(String paykind_id) {
		this.paykind_id = paykind_id;
	}
	public String getSd_id() {
		return sd_id;
	}
	public void setSd_id(String sd_id) {
		this.sd_id = sd_id;
	}
	@Override
	public String toString() {
		return "MemuseVo [shiplist_id=" + shiplist_id + ", shiplist_point="
				+ shiplist_point + ", shiplist_info=" + shiplist_info
				+ ", memship_id=" + memship_id + ", mem_id=" + mem_id
				+ ", paykind_id=" + paykind_id + ", sd_id=" + sd_id + "]";
	}
	
	

}
