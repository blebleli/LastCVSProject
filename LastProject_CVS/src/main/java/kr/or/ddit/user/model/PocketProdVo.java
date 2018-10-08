package kr.or.ddit.user.model;

import java.util.Date;

public class PocketProdVo {
    
    private String pocket_id   	; // 주머니 id
    private Date pocket_date 	; // 기프티콘 유효날짜(90일)
    private String pocket_useny ; // 사용여부
    private String pocket_delny ; // 삭제여부
    private String prod_id      ; //
    private String prod_name    ; // 상품이름
    private String prod_price	; // 상품가격
    private String file_path    ; // 제품경로
    private String file_upname  ; // 제품이미지명
    private String bcd_path    	; // 바코드 경로
    private String bcd_id      	; // 바코드이미지명
    private String pay_date 	; // 결제일시
    
    
	public PocketProdVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PocketProdVo(String pocket_id, Date pocket_date,
			String pocket_useny, String pocket_delny, String prod_id,
			String prod_name, String prod_price, String file_path,
			String file_upname, String bcd_path, String bcd_id, String pay_date) {
		super();
		this.pocket_id = pocket_id;
		this.pocket_date = pocket_date;
		this.pocket_useny = pocket_useny;
		this.pocket_delny = pocket_delny;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.file_path = file_path;
		this.file_upname = file_upname;
		this.bcd_path = bcd_path;
		this.bcd_id = bcd_id;
		this.pay_date = pay_date;
	}


	public String getPocket_id() {
		return pocket_id;
	}


	public void setPocket_id(String pocket_id) {
		this.pocket_id = pocket_id;
	}


	public Date getPocket_date() {
		return pocket_date;
	}


	public void setPocket_date(Date pocket_date) {
		this.pocket_date = pocket_date;
	}


	public String getPocket_useny() {
		return pocket_useny;
	}


	public void setPocket_useny(String pocket_useny) {
		this.pocket_useny = pocket_useny;
	}


	public String getPocket_delny() {
		return pocket_delny;
	}


	public void setPocket_delny(String pocket_delny) {
		this.pocket_delny = pocket_delny;
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


	public String getBcd_path() {
		return bcd_path;
	}


	public void setBcd_path(String bcd_path) {
		this.bcd_path = bcd_path;
	}


	public String getBcd_id() {
		return bcd_id;
	}


	public void setBcd_id(String bcd_id) {
		this.bcd_id = bcd_id;
	}


	public String getPay_date() {
		return pay_date;
	}


	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}


	@Override
	public String toString() {
		return "PocketProdVo [pocket_id=" + pocket_id + ", pocket_date="
				+ pocket_date + ", pocket_useny=" + pocket_useny
				+ ", pocket_delny=" + pocket_delny + ", prod_id=" + prod_id
				+ ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", file_path=" + file_path + ", file_upname=" + file_upname
				+ ", bcd_path=" + bcd_path + ", bcd_id=" + bcd_id
				+ ", pay_date=" + pay_date + "]";
	}
	
    
}
