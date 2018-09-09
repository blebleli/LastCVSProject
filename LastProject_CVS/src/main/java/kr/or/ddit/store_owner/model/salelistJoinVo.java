package kr.or.ddit.store_owner.model;

public class salelistJoinVo {
	
	private String prod_name; // 제품명
	private int sale_amount; // 판매수량
	private int sale_sum; // 판매금액
	private String mem_id; // 점주 아이디
	
	public salelistJoinVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public salelistJoinVo(String prod_name, int sale_amount, int sale_sum,
			String mem_id) {
		super();
		this.prod_name = prod_name;
		this.sale_amount = sale_amount;
		this.sale_sum = sale_sum;
		this.mem_id = mem_id;
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
	
	@Override
	public String toString() {
		return "salelistJoinVo [prod_name=" + prod_name + ", sale_amount="
				+ sale_amount + ", sale_sum=" + sale_sum + ", mem_id=" + mem_id
				+ ", mem_cvs_name=]";
	}	
}