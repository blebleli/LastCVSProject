package kr.or.ddit.model;

public class CommentsVo {
	
	private String cm_id;                               // 댓글코드
	private String bd_id;                               // 게시판코드
	private String cm_group;                               // 그룹코드
	private String mem_id;                               // 회원
	private String cm_content;                               // 내용
	private String cm_date;                               // 시간
	private String cm_delny;                               // 삭제여부
	private String cm_openny;                               // 공개여부
	private String cm_id2;                               // 부모코드
	
	public CommentsVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentsVo(String cm_id, String bd_id, String cm_group,
			String mem_id, String cm_content, String cm_date, String cm_delny,
			String cm_openny, String cm_id2) {
		super();
		this.cm_id = cm_id;
		this.bd_id = bd_id;
		this.cm_group = cm_group;
		this.mem_id = mem_id;
		this.cm_content = cm_content;
		this.cm_date = cm_date;
		this.cm_delny = cm_delny;
		this.cm_openny = cm_openny;
		this.cm_id2 = cm_id2;
	}

	public String getCm_id() {
		return cm_id;
	}

	public void setCm_id(String cm_id) {
		this.cm_id = cm_id;
	}

	public String getBd_id() {
		return bd_id;
	}

	public void setBd_id(String bd_id) {
		this.bd_id = bd_id;
	}

	public String getCm_group() {
		return cm_group;
	}

	public void setCm_group(String cm_group) {
		this.cm_group = cm_group;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getCm_content() {
		return cm_content;
	}

	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}

	public String getCm_date() {
		return cm_date;
	}

	public void setCm_date(String cm_date) {
		this.cm_date = cm_date;
	}

	public String getCm_delny() {
		return cm_delny;
	}

	public void setCm_delny(String cm_delny) {
		this.cm_delny = cm_delny;
	}

	public String getCm_openny() {
		return cm_openny;
	}

	public void setCm_openny(String cm_openny) {
		this.cm_openny = cm_openny;
	}

	public String getCm_id2() {
		return cm_id2;
	}

	public void setCm_id2(String cm_id2) {
		this.cm_id2 = cm_id2;
	}

	@Override
	public String toString() {
		return "CommentsVo [cm_id=" + cm_id + ", bd_id=" + bd_id
				+ ", cm_group=" + cm_group + ", mem_id=" + mem_id
				+ ", cm_content=" + cm_content + ", cm_date=" + cm_date
				+ ", cm_delny=" + cm_delny + ", cm_openny=" + cm_openny
				+ ", cm_id2=" + cm_id2 + "]";
	}
	
	

}
