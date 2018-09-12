package kr.or.ddit.model;

public class ProdVo extends PageVo {
	
	private String file_path;                               // 
	private String file_upname;                               // 
	private String prod_id;                               // 제품바코드
	private String prod_name;                               // 이름
	private String prod_intro;                               // 설명
	private String prod_info;                               // 비고
	private int prod_price;                               // 가격
	private int prod_exnum;                               // 유통기한값
	private String pr_class_lg;                               // 대분류
	private String pr_class_md;                               // 중분류
	private String pr_class_sm;                               // 소분류
	private String event_id;                               // 행사제품코드
	
	// 제품 상세 보기 평점 처리 위해서 추가 -2018.09.12-jw
	private int bd_rating;		// 평점
	
	public int getBd_rating() {
		return bd_rating;
	}
	public void setBd_rating(int bd_rating) {
		this.bd_rating = bd_rating;
	}
	
	// 제품 상세 보기 평점 처리 위해서 추가 -2018.09.12-jw
	public ProdVo() {
		super();
	}
	public ProdVo(String file_path, String file_upname, 
			String prod_id, String prod_name, String prod_intro,
			String prod_info, int prod_price, int prod_exnum,
			String pr_class_lg, String pr_class_md, String pr_class_sm,
			String event_id) {
		super();
		this.file_path = file_path;
		this.file_upname = file_upname;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_intro = prod_intro;
		this.prod_info = prod_info;
		this.prod_price = prod_price;
		this.prod_exnum = prod_exnum;
		this.pr_class_lg = pr_class_lg;
		this.pr_class_md = pr_class_md;
		this.pr_class_sm = pr_class_sm;
		this.event_id = event_id;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_upname() {
		return file_upname;
	}
	public void setFile_upname(String file_upname) {
		this.file_upname = file_upname;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_intro() {
		return prod_intro;
	}
	public void setProd_intro(String prod_intro) {
		this.prod_intro = prod_intro;
	}
	public String getProd_info() {
		return prod_info;
	}
	public void setProd_info(String prod_info) {
		this.prod_info = prod_info;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_exnum() {
		return prod_exnum;
	}
	public void setProd_exnum(int prod_exnum) {
		this.prod_exnum = prod_exnum;
	}
	public String getPr_class_lg() {
		return pr_class_lg;
	}
	public void setPr_class_lg(String pr_class_lg) {
		this.pr_class_lg = pr_class_lg;
	}
	public String getPr_class_md() {
		return pr_class_md;
	}
	public void setPr_class_md(String pr_class_md) {
		this.pr_class_md = pr_class_md;
	}
	public String getPr_class_sm() {
		return pr_class_sm;
	}
	public void setPr_class_sm(String pr_class_sm) {
		this.pr_class_sm = pr_class_sm;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	@Override
	public String toString() {
		return "ProdVo [file_path=" + file_path + ", file_upname="
				+ file_upname + ", prod_id="
				+ prod_id + ", prod_name=" + prod_name + ", prod_intro="
				+ prod_intro + ", prod_info=" + prod_info + ", prod_price="
				+ prod_price + ", prod_exnum=" + prod_exnum + ", pr_class_lg="
				+ pr_class_lg + ", pr_class_md=" + pr_class_md
				+ ", pr_class_sm=" + pr_class_sm + ", event_id=" + event_id
				+ ", bd_rating=" + bd_rating + "]";
	}

}
