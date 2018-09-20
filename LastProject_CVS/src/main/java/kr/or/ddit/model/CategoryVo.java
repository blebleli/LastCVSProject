package kr.or.ddit.model;

public class CategoryVo {
	
	private String ctgy_id     ;	// 카테고리코드
	private String ctgy_name   ;    // 이름
	private String ctgy_info   ;    // 비고
	private String ctgy_group  ;    // 그룹코드
	private String ctgy_kind   ;    // 제품 : 301, 편의점 : 302
	private String ctgy_parent ;    // 부모코드
	private int level ;				// 계층구조 
	
	
	public CategoryVo() {
		super();
	}

	public CategoryVo(String ctgy_id, String ctgy_name, String ctgy_info,
			String ctgy_group, String ctgy_kind, String ctgy_parent) {
		super();
		this.ctgy_id = ctgy_id;
		this.ctgy_name = ctgy_name;
		this.ctgy_info = ctgy_info;
		this.ctgy_group = ctgy_group;
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

	public String getCtgy_group() {
		return ctgy_group;
	}

	public void setCtgy_group(String ctgy_group) {
		this.ctgy_group = ctgy_group;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "CategoryVo [ctgy_id=" + ctgy_id + ", ctgy_name=" + ctgy_name
				+ ", ctgy_info=" + ctgy_info + ", ctgy_group=" + ctgy_group
				+ ", ctgy_kind=" + ctgy_kind + ", ctgy_parent=" + ctgy_parent
				+ ", level=" + level + "]";
	}



	

}
