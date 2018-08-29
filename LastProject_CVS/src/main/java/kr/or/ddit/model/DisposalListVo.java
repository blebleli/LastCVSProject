package kr.or.ddit.model;

public class DisposalListVo {
	
	private String disp_id;                               // 폐기상세코드
	private int disp_amount;                               // 수량
	private String disp_exdate;                               // 유통기한
	private String sd_id;                               // 판매코드
	private String prod_id;                               // 제품바코드
	public DisposalListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DisposalListVo(String disp_id, int disp_amount, String disp_exdate,
			String sd_id, String prod_id) {
		super();
		this.disp_id = disp_id;
		this.disp_amount = disp_amount;
		this.disp_exdate = disp_exdate;
		this.sd_id = sd_id;
		this.prod_id = prod_id;
	}
	public String getDisp_id() {
		return disp_id;
	}
	public void setDisp_id(String disp_id) {
		this.disp_id = disp_id;
	}
	public int getDisp_amount() {
		return disp_amount;
	}
	public void setDisp_amount(int disp_amount) {
		this.disp_amount = disp_amount;
	}
	public String getDisp_exdate() {
		return disp_exdate;
	}
	public void setDisp_exdate(String disp_exdate) {
		this.disp_exdate = disp_exdate;
	}
	public String getSd_id() {
		return sd_id;
	}
	public void setSd_id(String sd_id) {
		this.sd_id = sd_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	@Override
	public String toString() {
		return "DisposalListVo [disp_id=" + disp_id + ", disp_amount="
				+ disp_amount + ", disp_exdate=" + disp_exdate + ", sd_id="
				+ sd_id + ", prod_id=" + prod_id + "]";
	}
	
	

}
