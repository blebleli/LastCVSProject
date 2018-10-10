package kr.or.ddit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.commons.model.PageVo;

public class BoardVo extends PageVo {
	
	private String bd_id;                               // 게시판코드
	private String bd_title;                            // 제목
	private String bd_content;                          // 내용
	private Date bd_date;                             // 시간
	private String bd_del;                              // 삭제여부
	private int    bd_rating;                           // 평점
	private int    bd_views;                            // 조회수
	private String bd_group;                            // 그룹코드
	private String prod_id;                             // 제품바코드
	private String mem_id;                              // 아이디
	private String bd_parent;                           // 부모코드
	private String bd_kind_id;                          // 공지사항 : 44 , 리뷰 : 55, 이벤트 : 66
	private String levels;
	
	// 관리자 - review 
	private String prod_name;		// 상품명
	private String mem_name;		// 작성자
	
	private List<FiledataVo> fileList = new ArrayList<FiledataVo>(); // 파일 여러개를 등록하기 위해서...	
	
	public List<FiledataVo> getFileList() {
		return fileList;
	}

	public void setFileList(List<FiledataVo> fileList) {
		this.fileList = fileList;
	}	
	
	public BoardVo() {
		super();
	}

	public BoardVo(String bd_id, String bd_title, String bd_content,
			Date bd_date, String bd_del, int bd_rating, int bd_views,
			String bd_group, String prod_id, String mem_id, String bd_parent,
			String bd_kind_id, String prod_name, String mem_name, String levels) {
		super();
		this.bd_id = bd_id;
		this.bd_title = bd_title;
		this.bd_content = bd_content;
		this.bd_date = bd_date;
		this.bd_del = bd_del;
		this.bd_rating = bd_rating;
		this.bd_views = bd_views;
		this.bd_group = bd_group;
		this.prod_id = prod_id;
		this.mem_id = mem_id;
		this.bd_parent = bd_parent;
		this.bd_kind_id = bd_kind_id;
		this.prod_name = prod_name;
		this.mem_name = mem_name;
		this.levels = levels;
	}
	
	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}
	
	public String getBd_id() {
		return bd_id;
	}

	public void setBd_id(String bd_id) {
		this.bd_id = bd_id;
	}

	public String getBd_title() {
		return bd_title;
	}

	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}

	public String getBd_content() {
		return bd_content;
	}

	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}

	public Date getBd_date() {
		return bd_date;
	}

	public void setBd_date(Date bd_date) {
		this.bd_date = bd_date;
	}

	public String getBd_del() {
		return bd_del;
	}

	public void setBd_del(String bd_del) {
		this.bd_del = bd_del;
	}

	public int getBd_rating() {
		return bd_rating;
	}

	public void setBd_rating(int bd_rating) {
		this.bd_rating = bd_rating;
	}

	public int getBd_views() {
		return bd_views;
	}

	public void setBd_views(int bd_views) {
		this.bd_views = bd_views;
	}

	public String getBd_group() {
		return bd_group;
	}

	public void setBd_group(String bd_group) {
		this.bd_group = bd_group;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getBd_parent() {
		return bd_parent;
	}

	public void setBd_parent(String bd_parent) {
		this.bd_parent = bd_parent;
	}

	public String getBd_kind_id() {
		return bd_kind_id;
	}

	public void setBd_kind_id(String bd_kind_id) {
		this.bd_kind_id = bd_kind_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	@Override
	public String toString() {
		return "BoardVo [bd_id=" + bd_id + ", bd_title=" + bd_title
				+ ", bd_content=" + bd_content + ", bd_date=" + bd_date
				+ ", bd_del=" + bd_del + ", bd_rating=" + bd_rating
				+ ", bd_views=" + bd_views + ", bd_group=" + bd_group
				+ ", prod_id=" + prod_id + ", mem_id=" + mem_id
				+ ", bd_parent=" + bd_parent + ", bd_kind_id=" + bd_kind_id
				+ ", levels=" + levels + ", prod_name=" + prod_name
				+ ", mem_name=" + mem_name + ", fileList=" + fileList + "]";
	}
}