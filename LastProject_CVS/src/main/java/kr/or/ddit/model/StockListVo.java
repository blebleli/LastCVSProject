package kr.or.ddit.model;

public class StockListVo {
	
	private String bcd_id;                               // 재고리스트코드
	private int stcklist_amount;                               // 수량
	private String stcklist_exdate;                               // 유통기한
	private String stck_date;                               // 날짜
	private String stcklist_info;                               // 비고
	private String stcklist_kind;                               // 재고 : 888, 마감 : 999
	private String stock_id;                               // 재고코드
	private String prod_id;    								// 제품바코드
	private String splylist_id;								// 제품리스트코드
	
	
	
	public StockListVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockListVo(String bcd_id, int stcklist_amount, String stcklist_exdate, String stck_date,
			String stcklist_info, String stcklist_kind, String stock_id, String prod_id, String splylist_id) {
		super();
		this.bcd_id = bcd_id;
		this.stcklist_amount = stcklist_amount;
		this.stcklist_exdate = stcklist_exdate;
		this.stck_date = stck_date;
		this.stcklist_info = stcklist_info;
		this.stcklist_kind = stcklist_kind;
		this.stock_id = stock_id;
		this.prod_id = prod_id;
		this.splylist_id = splylist_id;
	}

	public String getBcd_id() {
		return bcd_id;
	}

	public void setBcd_id(String bcd_id) {
		this.bcd_id = bcd_id;
	}

	public int getStcklist_amount() {
		return stcklist_amount;
	}

	public void setStcklist_amount(int stcklist_amount) {
		this.stcklist_amount = stcklist_amount;
	}

	public String getStcklist_exdate() {
		return stcklist_exdate;
	}

	public void setStcklist_exdate(String stcklist_exdate) {
		this.stcklist_exdate = stcklist_exdate;
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
	
	

	public String getSplylist_id() {
		return splylist_id;
	}

	public void setSplylist_id(String splylist_id) {
		this.splylist_id = splylist_id;
	}

	@Override
	public String toString() {
		return "StockListVo [bcd_id=" + bcd_id + ", stcklist_amount="
				+ stcklist_amount + ", stcklist_exdate=" + stcklist_exdate
				+ ", stck_date=" + stck_date + ", stcklist_info="
				+ stcklist_info + ", stcklist_kind=" + stcklist_kind
				+ ", stock_id=" + stock_id + ", prod_id=" + prod_id
				+ ", splylist_id=" + splylist_id + "]";
	}

	
	

	

}
