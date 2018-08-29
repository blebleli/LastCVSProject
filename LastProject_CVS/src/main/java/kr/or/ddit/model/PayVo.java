package kr.or.ddit.model;

public class PayVo {
	
	private String pay_id;                               // 결제코드
	private int pay_sum;                               // 결제금액
	private String pay_date;                               // 결제일시
	private String pay_ny;                               // 결제여부
	private String mem_id;                               // 회원: 아이디, 비회원 : null
	private String sd_id;                               // 판매코드
	public PayVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayVo(String pay_id, int pay_sum, String pay_date, String pay_ny,
			String mem_id, String sd_id) {
		super();
		this.pay_id = pay_id;
		this.pay_sum = pay_sum;
		this.pay_date = pay_date;
		this.pay_ny = pay_ny;
		this.mem_id = mem_id;
		this.sd_id = sd_id;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public int getPay_sum() {
		return pay_sum;
	}
	public void setPay_sum(int pay_sum) {
		this.pay_sum = pay_sum;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getPay_ny() {
		return pay_ny;
	}
	public void setPay_ny(String pay_ny) {
		this.pay_ny = pay_ny;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getSd_id() {
		return sd_id;
	}
	public void setSd_id(String sd_id) {
		this.sd_id = sd_id;
	}
	@Override
	public String toString() {
		return "PayVo [pay_id=" + pay_id + ", pay_sum=" + pay_sum
				+ ", pay_date=" + pay_date + ", pay_ny=" + pay_ny + ", mem_id="
				+ mem_id + ", sd_id=" + sd_id + "]";
	}
	
	

}
