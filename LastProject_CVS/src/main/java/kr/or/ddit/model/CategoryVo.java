package kr.or.ddit.model;

public class CategoryVo {
	
	private String ctgy_id;                               // 카테고리코드
	private String ctgy_name;                               // 이름
	private String ctgy_info;                               // 비고
	private String ctgy_level;                               // 카테고리코드
	private String ctgy_kind;                               // 제품 : 301, 편의점 : 302
	private String ctgy_parent;                               // 카테고리코드
	
	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryVo(String ctgy_id, String ctgy_name, String ctgy_info,
			String ctgy_level, String ctgy_kind, String ctgy_parent) {
		super();
		this.ctgy_id = ctgy_id;
		this.ctgy_name = ctgy_name;
		this.ctgy_info = ctgy_info;
		this.ctgy_level = ctgy_level;
		this.ctgy_kind = ctgy_kind;
		this.ctgy_parent = ctgy_parent;
	}

	public String getCtgy_id() {
		return ctgy_id;
	}

	public void setCtgy_id(String ctgy_id) {
		this.ctgy_id = ctgy_id;
	}

	public String getCtgy_name() {
		return ctgy_name;
	}

	public void setCtgy_name(String ctgy_name) {
		this.ctgy_name = ctgy_name;
	}

	public String getCtgy_info() {
		return ctgy_info;
	}

	public void setCtgy_info(String ctgy_info) {
		this.ctgy_info = ctgy_info;
	}

	public String getCtgy_level() {
		return ctgy_level;
	}

	public void setCtgy_level(String ctgy_level) {
		this.ctgy_level = ctgy_level;
	}

	public String getCtgy_kind() {
		return ctgy_kind;
	}

	public void setCtgy_kind(String ctgy_kind) {
		this.ctgy_kind = ctgy_kind;
	}

	public String getCtgy_parent() {
		return ctgy_parent;
	}

	public void setCtgy_parent(String ctgy_parent) {
		this.ctgy_parent = ctgy_parent;
	}

	@Override
	public String toString() {
		return "CategoryVo [ctgy_id=" + ctgy_id + ", ctgy_name=" + ctgy_name
				+ ", ctgy_info=" + ctgy_info + ", ctgy_level=" + ctgy_level
				+ ", ctgy_kind=" + ctgy_kind + ", ctgy_parent=" + ctgy_parent
				+ "]";
	}
	
	

}
