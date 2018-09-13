package kr.or.ddit.user.model;

public class MainReviewsVo {

	 private String prod_id    ;
     private String file_path  ;
     private String file_upname;
     private String bd_id      ;
     private String bd_title   ;
     private String bd_content ;
     private String bd_date    ;
     private String bd_views   ;
     private String bd_kind_id ;
     private String bd_rating;
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
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
	public String getBd_date() {
		return bd_date;
	}
	public void setBd_date(String bd_date) {
		this.bd_date = bd_date;
	}
	public String getBd_views() {
		return bd_views;
	}
	public void setBd_views(String bd_views) {
		this.bd_views = bd_views;
	}
	public String getBd_kind_id() {
		return bd_kind_id;
	}
	public void setBd_kind_id(String bd_kind_id) {
		this.bd_kind_id = bd_kind_id;
	}
	public String getBd_rating() {
		return bd_rating;
	}
	public void setBd_rating(String bd_rating) {
		this.bd_rating = bd_rating;
	}
	@Override
	public String toString() {
		return "MainReviewsVo [prod_id=" + prod_id + ", file_path=" + file_path
				+ ", file_upname=" + file_upname + ", bd_id=" + bd_id
				+ ", bd_title=" + bd_title + ", bd_content=" + bd_content
				+ ", bd_date=" + bd_date + ", bd_views=" + bd_views
				+ ", bd_kind_id=" + bd_kind_id + ", bd_rating=" + bd_rating
				+ "]";
	}

  
     
}
