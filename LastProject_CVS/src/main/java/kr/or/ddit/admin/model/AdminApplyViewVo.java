package kr.or.ddit.admin.model;

public class AdminApplyViewVo {
	
	int rnum;			//넘버링
	String exdate;		//유통기한
	String prod_name;	//상품이름
	int splylist_sum;	//수량
	int prod_price;		//제품가격
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getExdate() {
		return exdate;
	}
	public void setExdate(String exdate) {
		this.exdate = exdate;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getSplylist_sum() {
		return splylist_sum;
	}
	public void setSplylist_sum(int splylist_sum) {
		this.splylist_sum = splylist_sum;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	@Override
	public String toString() {
		return "AdminApplyViewVo [rnum=" + rnum + ", exdate=" + exdate
				+ ", prod_name=" + prod_name + ", splylist_sum=" + splylist_sum
				+ ", prod_price=" + prod_price + "]";
	}
	public AdminApplyViewVo(int rnum, String exdate, String prod_name,
			int splylist_sum, int prod_price) {
		super();
		this.rnum = rnum;
		this.exdate = exdate;
		this.prod_name = prod_name;
		this.splylist_sum = splylist_sum;
		this.prod_price = prod_price;
	}
	public AdminApplyViewVo() {
		super();
	}
	
	
	

}
