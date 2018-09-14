package kr.or.ddit.model;

// 09.11 KONG : prod_name , prod_price 항목 추가함
public class BookmarkVo {
	
	private String star_id;                               	// 즐겨찾기코드
	private String mem_id;                               	// 회원
	private String star_kind;                               // 제품 :111 , 장소 : 222
	private String prod_id;                              	 // 제품바코드
	private String place_id;  								// 편의점
	
	private String star_content;                               // 내용
	private String star_info;                               // 비고
	private int star_x;                               // 좌표_x
	private int star_y;                               // 좌표_y
                             
	private String prod_name;
	private String prod_price;
	
	private String file_path;
	private String file_upname;
	
	
	public BookmarkVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookmarkVo(String star_id, String mem_id, String star_kind,
			String star_content, String star_info, int star_x, int star_y,
			String prod_id, String place_id) {
		super();
		this.star_id = star_id;
		this.mem_id = mem_id;
		this.star_kind = star_kind;
		this.star_content = star_content;
		this.star_info = star_info;
		this.star_x = star_x;
		this.star_y = star_y;
		this.prod_id = prod_id;
		this.place_id = place_id;
	}

	public String getStar_id() {
		return star_id;
	}

	public void setStar_id(String star_id) {
		this.star_id = star_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getStar_kind() {
		return star_kind;
	}

	public void setStar_kind(String star_kind) {
		this.star_kind = star_kind;
	}

	public String getStar_content() {
		return star_content;
	}

	public void setStar_content(String star_content) {
		this.star_content = star_content;
	}

	public String getStar_info() {
		return star_info;
	}

	public void setStar_info(String star_info) {
		this.star_info = star_info;
	}

	public int getStar_x() {
		return star_x;
	}

	public void setStar_x(int star_x) {
		this.star_x = star_x;
	}

	public int getStar_y() {
		return star_y;
	}

	public void setStar_y(int star_y) {
		this.star_y = star_y;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_price() {
		return prod_price;
	}

	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
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

	@Override
	public String toString() {
		return "BookmarkVo [star_id=" + star_id + ", mem_id=" + mem_id
				+ ", star_kind=" + star_kind + ", star_content=" + star_content
				+ ", star_info=" + star_info + ", star_x=" + star_x
				+ ", star_y=" + star_y + ", prod_id=" + prod_id + ", place_id="
				+ place_id + "]";
	}
	
	

}
