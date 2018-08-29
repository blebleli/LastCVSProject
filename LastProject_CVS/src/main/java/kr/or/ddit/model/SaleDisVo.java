package kr.or.ddit.model;

public class SaleDisVo {
	
	private String sd_id;                               // 판매코드
	private String sd_date;                               // 판매일시
	private int sd_sum;                               // 총금액
	private String sale_kind;                               // 판매 : 88, 폐기 : 99
	private String mem_id;                               // 아이디
	public SaleDisVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleDisVo(String sd_id, String sd_date, int sd_sum,
			String sale_kind, String mem_id) {
		super();
		this.sd_id = sd_id;
		this.sd_date = sd_date;
		this.sd_sum = sd_sum;
		this.sale_kind = sale_kind;
		this.mem_id = mem_id;
	}
	public String getSd_id() {
		return sd_id;
	}
	public void setSd_id(String sd_id) {
		this.sd_id = sd_id;
	}
	public String getSd_date() {
		return sd_date;
	}
	public void setSd_date(String sd_date) {
		this.sd_date = sd_date;
	}
	public int getSd_sum() {
		return sd_sum;
	}
	public void setSd_sum(int sd_sum) {
		this.sd_sum = sd_sum;
	}
	public String getSale_kind() {
		return sale_kind;
	}
	public void setSale_kind(String sale_kind) {
		this.sale_kind = sale_kind;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "SaleDisVo [sd_id=" + sd_id + ", sd_date=" + sd_date
				+ ", sd_sum=" + sd_sum + ", sale_kind=" + sale_kind
				+ ", mem_id=" + mem_id + "]";
	}
	
	

}
