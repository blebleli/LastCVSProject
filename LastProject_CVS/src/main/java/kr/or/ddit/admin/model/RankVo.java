package kr.or.ddit.admin.model;

public class RankVo {

	private String id;
	private int amount;
	private int rnk;
	
	public RankVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RankVo(String id, int amount, int rnk) {
		super();
		this.id = id;
		this.amount = amount;
		this.rnk = rnk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "RankVo [id=" + id + ", amount=" + amount + ", rnk=" + rnk + "]";
	}
	
	
	
}
