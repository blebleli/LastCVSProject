package kr.or.ddit.model;

import java.util.Date;

import kr.or.ddit.commons.model.PageVo;
/* 09.11 KONG :  extends PageVo 추가  */
public class PayVo extends PageVo {
	
	private String pay_id;                      // 결제코드
	private int pay_sum;                        // 결제금액
	private Date pay_date;                    // 결제일시
	private String pay_ny;                      // 결제여부
	private String mem_id;                      // 회원: 아이디, 비회원 : null
	private String sd_id;  						// 판매코드
	private String shiplist_id;
	private int pay_cash   ;                               
	private int pay_card   ;
	
	public PayVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PayVo(String pay_id, int pay_sum, Date pay_date, String pay_ny,
			String mem_id, String sd_id, String shiplist_id, int pay_cash,
			int pay_card) {
		super();
		this.pay_id = pay_id;
		this.pay_sum = pay_sum;
		this.pay_date = pay_date;
		this.pay_ny = pay_ny;
		this.mem_id = mem_id;
		this.sd_id = sd_id;
		this.shiplist_id = shiplist_id;
		this.pay_cash = pay_cash;
		this.pay_card = pay_card;
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
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
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
	public String getShiplist_id() {
		return shiplist_id;
	}
	public void setShiplist_id(String shiplist_id) {
		this.shiplist_id = shiplist_id;
	}
	public int getPay_cash() {
		return pay_cash;
	}
	public void setPay_cash(int pay_cash) {
		this.pay_cash = pay_cash;
	}
	public int getPay_card() {
		return pay_card;
	}
	public void setPay_card(int pay_card) {
		this.pay_card = pay_card;
	}
	
	@Override
	public String toString() {
		return "PayVo [pay_id=" + pay_id + ", pay_sum=" + pay_sum
				+ ", pay_date=" + pay_date + ", pay_ny=" + pay_ny + ", mem_id="
				+ mem_id + ", sd_id=" + sd_id + ", shiplist_id=" + shiplist_id
				+ ", pay_cash=" + pay_cash + ", pay_card=" + pay_card + "]";
	}
	
	

	
	

}
