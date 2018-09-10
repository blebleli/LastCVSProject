package kr.or.ddit.store_owner.model;

import java.util.Date;

public class salelistJoinVo {
	
	private String prod_name; // 제품명
	private int sale_amount; // 판매수량
	private int sale_sum; // 판매금액
	private String mem_id; // 점주 아이디
	private int sd_sum; // 판매 총 금액
	private Date sd_date; // 날짜
	
	public salelistJoinVo() {
		super();
	}
	
	public salelistJoinVo(String prod_name, int sale_amount, int sale_sum,
			String mem_id, int sd_sum, Date sd_date) {
		super();
		this.prod_name = prod_name;
		this.sale_amount = sale_amount;
		this.sale_sum = sale_sum;
		this.mem_id = mem_id;
		this.sd_sum = sd_sum;
		this.sd_date = sd_date;
	}
	
	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getSd_sum() {
		return sd_sum;
	}

	public void setSd_sum(int sd_sum) {
		this.sd_sum = sd_sum;
	}

	public Date getSd_date() {
		return sd_date;
	}

	public void setSd_date(Date sd_date) {
		this.sd_date = sd_date;
	}

	@Override
	public String toString() {
		return "salelistJoinVo [prod_name=" + prod_name + ", sale_amount="
				+ sale_amount + ", sale_sum=" + sale_sum + ", mem_id=" + mem_id
				+ ", sd_sum=" + sd_sum + ", sd_date=" + sd_date + "]";
	}	
}