package kr.or.ddit.supply.model;

public class SupplySumProdVo {
	
	int rnum;				//넘버링
	String supply_bcd;		//수불바코드
	String supply_date;		//수불날짜
	String supply_state;	//처리상태
	int splylist_sum;		//수량
	int sum;			//제품가격
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getSupply_bcd() {
		return supply_bcd;
	}
	public void setSupply_bcd(String supply_bcd) {
		this.supply_bcd = supply_bcd;
	}
	public String getSupply_date() {
		return supply_date;
	}
	public void setSupply_date(String supply_date) {
		this.supply_date = supply_date;
	}
	public String getSupply_state() {
		return supply_state;
	}
	public void setSupply_state(String supply_state) {
		this.supply_state = supply_state;
	}
	public int getSplylist_sum() {
		return splylist_sum;
	}
	public void setSplylist_sum(int splylist_sum) {
		this.splylist_sum = splylist_sum;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "SupplySumProdVo [rnum=" + rnum + ", supply_bcd=" + supply_bcd
				+ ", supply_date=" + supply_date + ", supply_state="
				+ supply_state + ", splylist_sum=" + splylist_sum + ", sum="
				+ sum + "]";
	}
	public SupplySumProdVo(int rnum, String supply_bcd, String supply_date,
			String supply_state, int splylist_sum, int sum) {
		super();
		this.rnum = rnum;
		this.supply_bcd = supply_bcd;
		this.supply_date = supply_date;
		this.supply_state = supply_state;
		this.splylist_sum = splylist_sum;
		this.sum = sum;
	}
	public SupplySumProdVo() {
		super();
	}

	
	
}
