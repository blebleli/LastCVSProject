package kr.or.ddit.model;

/* 09.11 KONG :  extends PageVo 추가  */
public class PayVo extends PageVo {
	
	private String pay_id;                      // 결제코드
	private int pay_sum;                        // 결제금액
	private String pay_date;                    // 결제일시
	private String pay_ny;                      // 결제여부
	private String mem_id;                      // 회원: 아이디, 비회원 : null
	private String sd_id;  						// 판매코드
	private String pay_cash   ;                               
	private String pay_card   ;
	private String shiplist_id;
	
	public PayVo() {	
		super();
		// TODO Auto-generated constructor stub
	}

	public PayVo(String pay_id, int pay_sum, String pay_date, String pay_ny,
			String mem_id, String sd_id, String pay_cash, String pay_card,
			String shiplist_id) {
		super();
		this.pay_id = pay_id;
		this.pay_sum = pay_sum;
		this.pay_date = pay_date;
		this.pay_ny = pay_ny;
		this.mem_id = mem_id;
		this.sd_id = sd_id;
		this.pay_cash = pay_cash;
		this.pay_card = pay_card;
		this.shiplist_id = shiplist_id;
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

	public String getPay_cash() {
		return pay_cash;
	}

	public void setPay_cash(String pay_cash) {
		this.pay_cash = pay_cash;
	}

	public String getPay_card() {
		return pay_card;
	}

	public void setPay_card(String pay_card) {
		this.pay_card = pay_card;
	}

	public String getShiplist_id() {
		return shiplist_id;
	}

	public void setShiplist_id(String shiplist_id) {
		this.shiplist_id = shiplist_id;
	}

	@Override
	public String toString() {
		return "PayVo [pay_id=" + pay_id + ", pay_sum=" + pay_sum
				+ ", pay_date=" + pay_date + ", pay_ny=" + pay_ny + ", mem_id="
				+ mem_id + ", sd_id=" + sd_id + ", pay_cash=" + pay_cash
				+ ", pay_card=" + pay_card + ", shiplist_id=" + shiplist_id
				+ "]";
	}

	

	
	

}
