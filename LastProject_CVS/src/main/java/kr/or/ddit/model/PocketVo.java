package kr.or.ddit.model;

import java.util.Date;

public class PocketVo {
	
	private String pocket_useny;                               // 사용여부
	private Date pocket_date;                               // 발급시간
	private String pocket_delny;                               // 삭제여부
	private String mem_id;                               // 아이디
	private String pay_id;                               // 결제 바코드
	private String pocket_id;                               // 상품저장바코드
	private String prod_id;
	
	
	public String getProd_id() {
		return prod_id;
	}


	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}


	public PocketVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PocketVo(String pocket_useny, Date pocket_date, String pocket_delny,
			String mem_id, String pay_id, String pocket_id) {
		super();
		this.pocket_useny = pocket_useny;
		this.pocket_date = pocket_date;
		this.pocket_delny = pocket_delny;
		this.mem_id = mem_id;
		this.pay_id = pay_id;
		this.pocket_id = pocket_id;
	}


	public String getPocket_useny() {
		return pocket_useny;
	}
	public void setPocket_useny(String pocket_useny) {
		this.pocket_useny = pocket_useny;
	}
	public Date getPocket_date() {
		return pocket_date;
	}
	public void setPocket_date(Date pocket_date) {
		this.pocket_date = pocket_date;
	}
	public String getPocket_delny() {
		return pocket_delny;
	}
	public void setPocket_delny(String pocket_delny) {
		this.pocket_delny = pocket_delny;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getPocket_id() {
		return pocket_id;
	}
	public void setPocket_id(String pocket_id) {
		this.pocket_id = pocket_id;
	}
	@Override
	public String toString() {
		return "PocketVo [pocket_useny=" + pocket_useny + ", pocket_date="
				+ pocket_date + ", pocket_delny=" + pocket_delny + ", mem_id="
				+ mem_id + ", pay_id=" + pay_id + ", pocket_id=" + pocket_id
				+ "]";
	}

	

}
