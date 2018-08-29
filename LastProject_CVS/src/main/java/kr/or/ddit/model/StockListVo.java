package kr.or.ddit.model;

public class StockListVo {
	
	private String stcklist_id;                               // 재고리스트코드
	private int stcklist_amount;                               // 수량
	private String sicklist_exdate;                               // 유통기한
	private String stck_date;                               // 날짜
	private String stcklist_info;                               // 비고
	private String stcklist_kind;                               // 재고 : 888, 마감 : 999
	private String stock_id;                               // 재고코드
	private String prod_id;                               // 제품바코드
	public StockListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockListVo(String stcklist_id, int stcklist_amount,
			String sicklist_exdate, String stck_date, String stcklist_info,
			String stcklist_kind, String stock_id, String prod_id) {
		super();
		this.stcklist_id = stcklist_id;
		this.stcklist_amount = stcklist_amount;
		this.sicklist_exdate = sicklist_exdate;
		this.stck_date = stck_date;
		this.stcklist_info = stcklist_info;
		this.stcklist_kind = stcklist_kind;
		this.stock_id = stock_id;
		this.prod_id = prod_id;
	}
	public String getStcklist_id() {
		return stcklist_id;
	}
	public void setStcklist_id(String stcklist_id) {
		this.stcklist_id = stcklist_id;
	}
	public int getStcklist_amount() {
		return stcklist_amount;
	}
	public void setStcklist_amount(int stcklist_amount) {
		this.stcklist_amount = stcklist_amount;
	}
	public String getSicklist_exdate() {
		return sicklist_exdate;
	}
	public void setSicklist_exdate(String sicklist_exdate) {
		this.sicklist_exdate = sicklist_exdate;
	}
	public String getStck_date() {
		return stck_date;
	}
	public void setStck_date(String stck_date) {
		this.stck_date = stck_date;
	}
	public String getStcklist_info() {
		return stcklist_info;
	}
	public void setStcklist_info(String stcklist_info) {
		this.stcklist_info = stcklist_info;
	}
	public String getStcklist_kind() {
		return stcklist_kind;
	}
	public void setStcklist_kind(String stcklist_kind) {
		this.stcklist_kind = stcklist_kind;
	}
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	@Override
	public String toString() {
		return "StockListVo [stcklist_id=" + stcklist_id + ", stcklist_amount="
				+ stcklist_amount + ", sicklist_exdate=" + sicklist_exdate
				+ ", stck_date=" + stck_date + ", stcklist_info="
				+ stcklist_info + ", stcklist_kind=" + stcklist_kind
				+ ", stock_id=" + stock_id + ", prod_id=" + prod_id + "]";
	}
	
	

}
