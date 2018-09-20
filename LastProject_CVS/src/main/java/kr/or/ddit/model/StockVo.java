package kr.or.ddit.model;

import java.util.Date;

public class StockVo {
	
	private String stock_id;          // 재고코드 
	private String mem_id;            // 편의점 
	private String stock_info;        // 비고 
	private Date stock_date;          // 일시
	private String stock_kind;        // 재고 : 888, 마감 : 999
	public StockVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockVo(String stock_id, String mem_id, String stock_info,
			Date stock_date, String stock_kind) {
		super();
		this.stock_id = stock_id;
		this.mem_id = mem_id;
		this.stock_info = stock_info;
		this.stock_date = stock_date;
		this.stock_kind = stock_kind;
	}
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getStock_info() {
		return stock_info;
	}
	public void setStock_info(String stock_info) {
		this.stock_info = stock_info;
	}
	public Date getStock_date() {
		return stock_date;
	}
	public void setStock_date(Date stock_date) {
		this.stock_date = stock_date;
	}
	public String getStock_kind() {
		return stock_kind;
	}
	public void setStock_kind(String stock_kind) {
		this.stock_kind = stock_kind;
	}
	@Override
	public String toString() {
		return "StockVo [stock_id=" + stock_id + ", mem_id=" + mem_id
				+ ", stock_info=" + stock_info + ", stock_date=" + stock_date
				+ ", stock_kind=" + stock_kind + "]";
	}
	
	
	

}
