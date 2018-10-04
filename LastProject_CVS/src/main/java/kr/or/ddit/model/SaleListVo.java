package kr.or.ddit.model;

public class SaleListVo {
	
	private String sale_id;     // 판매상세코드
	private int sale_amount;    // 수량
	private int sale_sum;       // 금액
	private String sale_kind;   // 판매유형
	private String sd_id;       // 판매코드
	private String prod_id;     // 제품코드
	private String bcd_id;	    // 재고코드
	public SaleListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleListVo(String sale_id, int sale_amount, int sale_sum,
			String sale_kind, String sd_id, String prod_id, String bcd_id) {
		super();
		this.sale_id = sale_id;
		this.sale_amount = sale_amount;
		this.sale_sum = sale_sum;
		this.sale_kind = sale_kind;
		this.sd_id = sd_id;
		this.prod_id = prod_id;
		this.bcd_id = bcd_id;
	}
	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}
	public int getSale_amount() {
		return sale_amount;
	}
	public void setSale_amount(int sale_amount) {
		this.sale_amount = sale_amount;
	}
	public int getSale_sum() {
		return sale_sum;
	}
	public void setSale_sum(int sale_sum) {
		this.sale_sum = sale_sum;
	}
	public String getSale_kind() {
		return sale_kind;
	}
	public void setSale_kind(String sale_kind) {
		this.sale_kind = sale_kind;
	}
	public String getSd_id() {
		return sd_id;
	}
	public void setSd_id(String sd_id) {
		this.sd_id = sd_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getBcd_id() {
		return bcd_id;
	}
	public void setBcd_id(String bcd_id) {
		this.bcd_id = bcd_id;
	}
	
	@Override
	public String toString() {
		return "SaleListVo [sale_id=" + sale_id + ", sale_amount="
				+ sale_amount + ", sale_sum=" + sale_sum + ", sale_kind="
				+ sale_kind + ", sd_id=" + sd_id + ", prod_id=" + prod_id
				+ ", bcd_id=" + bcd_id + "]";
	}
	
	
	

}
