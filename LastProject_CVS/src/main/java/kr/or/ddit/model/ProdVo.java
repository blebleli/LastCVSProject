package kr.or.ddit.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.commons.model.PageVo;

public class ProdVo extends PageVo {
	
	private String file_path;               // 파일 경로
	private String file_upname;             // 파일 이름
	private String prod_id;                 // 제품바코드
	private String prod_name;               // 이름
	private String prod_intro;              // 설명
	private String prod_info;               // 비고
	private int    prod_price;              // 가격
	private int    prod_exnum;              // 유통기한값
	private String pr_class_lg;             // 대분류
	private String pr_class_md;             // 중분류
	private String event_id;                // 행사제품코드
	private int    prod_cost;				// 단가
	
	private MultipartFile[] upload_file;	// 이미지
	
	
	private List<ProdVo> prodList;
	
	public List<ProdVo> getProdList() {
		return prodList;
	}
	public void setProdList(List<ProdVo> prodList) {
		this.prodList = prodList;
	}
	
	// 제품 상세 보기 평점 처리 위해서 추가 -2018.09.12-jw
	private int bd_rating;		// 평점
	
	public int getBd_rating() {
		return bd_rating;
	}
	public void setBd_rating(int bd_rating) {
		this.bd_rating = bd_rating;
	}
	// 사진 처리 위해서 추가 - 2018-09-26-jw
	public MultipartFile[] getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(MultipartFile[] upload_file) {
		this.upload_file = upload_file;
	}
	public ProdVo() {
		super();
	}
	
	public ProdVo(String file_path, String file_upname, String prod_id,
			String prod_name, String prod_intro, String prod_info,
			int prod_price, int prod_exnum, String pr_class_lg,
			String pr_class_md, String event_id, int prod_cost, int bd_rating) {
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
		this.event_id = event_id;
		this.prod_cost = prod_cost;
		this.bd_rating = bd_rating;
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
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public int getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}
	@Override
	public String toString() {
		return "ProdVo [file_path=" + file_path + ", file_upname="
				+ file_upname + ", prod_id=" + prod_id + ", prod_name="
				+ prod_name + ", prod_intro=" + prod_intro + ", prod_info="
				+ prod_info + ", prod_price=" + prod_price + ", prod_exnum="
				+ prod_exnum + ", pr_class_lg=" + pr_class_lg
				+ ", pr_class_md=" + pr_class_md + ", event_id=" + event_id
				+ ", prod_cost=" + prod_cost + ", bd_rating=" + bd_rating + "]";
	}
	
	

	
	
}
