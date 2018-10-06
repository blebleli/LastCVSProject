package kr.or.ddit.user.model;

import java.util.Date;

public class PocketProdVo {
	private String pocket_id;    // 주머니 id
    private Date pocket_date;  // 주머니 날짜
    private String prod_name;    // 상품이름
    private String prod_price;    // 상품이름
    private String bcd_path;      // 바코트 경로
	public PocketProdVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PocketProdVo(String pocket_id, Date pocket_date, String prod_name,
			String prod_price, String bcd_path) {
		super();
		this.pocket_id = pocket_id;
		this.pocket_date = pocket_date;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.bcd_path = bcd_path;
	}
	public String getPocket_id() {
		return pocket_id;
	}
	public void setPocket_id(String pocket_id) {
		this.pocket_id = pocket_id;
	}
	public Date getPocket_date() {
		return pocket_date;
	}
	public void setPocket_date(Date pocket_date) {
		this.pocket_date = pocket_date;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_price() {
		return prod_price;
	}
	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}
	public String getBcd_path() {
		return bcd_path;
	}
	public void setBcd_path(String bcd_path) {
		this.bcd_path = bcd_path;
	}
	@Override
	public String toString() {
		return "PocketProdVo [pocket_id=" + pocket_id + ", pocket_date="
				+ pocket_date + ", prod_name=" + prod_name + ", prod_price="
				+ prod_price + ", bcd_path=" + bcd_path + "]";
	}
    
    
}
