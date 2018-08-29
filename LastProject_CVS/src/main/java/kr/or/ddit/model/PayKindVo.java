package kr.or.ddit.model;

public class PayKindVo {
	
	private String paykind_id;                               // 결제상세코드
	private String pay_id;                               // 결제코드
	private int pkind_cash;                               // 사용금액
	private int pkind_card;                               // 결제금액
	private int pkind_point;                               // 사용포인트
	public PayKindVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayKindVo(String paykind_id, String pay_id, int pkind_cash,
			int pkind_card, int pkind_point) {
		super();
		this.paykind_id = paykind_id;
		this.pay_id = pay_id;
		this.pkind_cash = pkind_cash;
		this.pkind_card = pkind_card;
		this.pkind_point = pkind_point;
	}
	public String getPaykind_id() {
		return paykind_id;
	}
	public void setPaykind_id(String paykind_id) {
		this.paykind_id = paykind_id;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public int getPkind_cash() {
		return pkind_cash;
	}
	public void setPkind_cash(int pkind_cash) {
		this.pkind_cash = pkind_cash;
	}
	public int getPkind_card() {
		return pkind_card;
	}
	public void setPkind_card(int pkind_card) {
		this.pkind_card = pkind_card;
	}
	public int getPkind_point() {
		return pkind_point;
	}
	public void setPkind_point(int pkind_point) {
		this.pkind_point = pkind_point;
	}
	@Override
	public String toString() {
		return "PayKindVo [paykind_id=" + paykind_id + ", pay_id=" + pay_id
				+ ", pkind_cash=" + pkind_cash + ", pkind_card=" + pkind_card
				+ ", pkind_point=" + pkind_point + "]";
	}
	
	

}
