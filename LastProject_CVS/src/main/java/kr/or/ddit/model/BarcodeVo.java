package kr.or.ddit.model;

public class BarcodeVo {
	
	private String bcd_id;                               // 바코드코드
	private String bcd_content;                               // 내용
	private String bcd_path;                               // 경로
	private String bcd_info;                               // 비고
	private String bcd_kind;                               // 제품 : 100, 저장소 : 101, 수불 : 102
	
	public BarcodeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BarcodeVo(String bcd_id, String bcd_content, String bcd_path,
			String bcd_info, String bcd_kind) {
		super();
		this.bcd_id = bcd_id;
		this.bcd_content = bcd_content;
		this.bcd_path = bcd_path;
		this.bcd_info = bcd_info;
		this.bcd_kind = bcd_kind;
	}

	public String getBcd_id() {
		return bcd_id;
	}

	public void setBcd_id(String bcd_id) {
		this.bcd_id = bcd_id;
	}

	public String getBcd_content() {
		return bcd_content;
	}

	public void setBcd_content(String bcd_content) {
		this.bcd_content = bcd_content;
	}

	public String getBcd_path() {
		return bcd_path;
	}

	public void setBcd_path(String bcd_path) {
		this.bcd_path = bcd_path;
	}

	public String getBcd_info() {
		return bcd_info;
	}

	public void setBcd_info(String bcd_info) {
		this.bcd_info = bcd_info;
	}

	public String getBcd_kind() {
		return bcd_kind;
	}

	public void setBcd_kind(String bcd_kind) {
		this.bcd_kind = bcd_kind;
	}

	@Override
	public String toString() {
		return "BarcodeVo [bcd_id=" + bcd_id + ", bcd_content=" + bcd_content
				+ ", bcd_path=" + bcd_path + ", bcd_info=" + bcd_info
				+ ", bcd_kind=" + bcd_kind + "]";
	}
	
	
}
