package kr.or.ddit.model;

public class MemberShipVo {
	
	private String memship_id;                               // 맵버십코드
	private String mem_id;                               // 아이디
	private int memship_point;                               // 포인트
	public MemberShipVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberShipVo(String memship_id, String mem_id, int memship_point) {
		super();
		this.memship_id = memship_id;
		this.mem_id = mem_id;
		this.memship_point = memship_point;
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
	public int getMemship_point() {
		return memship_point;
	}
	public void setMemship_point(int memship_point) {
		this.memship_point = memship_point;
	}
	@Override
	public String toString() {
		return "MemberShipVo [memship_id=" + memship_id + ", mem_id=" + mem_id
				+ ", memship_point=" + memship_point + "]";
	}
	
	
	

}
