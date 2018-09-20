package kr.or.ddit.admin.model;

public class MonthTopVo {
	private String month;
	private String id;
	private int amount;
	private int rnk;
	
	
	public MonthTopVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MonthTopVo(String month, String id, int amount, int rnk) {
		super();
		this.month = month;
		this.id = id;
		this.amount = amount;
		this.rnk = rnk;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getId() {
		return id;
	}


	public void setPlace_id(String id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getRnk() {
		return rnk;
	}


	public void setRnk(int rnk) {
		this.rnk = rnk;
	}


	@Override
	public String toString() {
		return "MonthTopVo [month=" + month + ", id=" + id
				+ ", amount=" + amount + ", rnk=" + rnk + "]";
	}
	
	
}
