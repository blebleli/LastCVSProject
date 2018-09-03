package kr.or.ddit.user.search.model;

public class CvsSearchVo {

	//  점포 정보
	private String mem_id          ; // 사업자번호
    private String mem_name        ; // 업주명
    private String mem_tel         ; // 업주전화번호
    private String mem_birth       ; // 업주 생년월일
    private String mem_gen         ; // 업주 성별
    private String mem_zip         ; // 매장 우편번호
    private String mem_add         ; // 매장 구주소 
    private String mem_addr        ; // 매장 신주소
    private String mem_cvs_name    ; // 매장명
    private String mem_cvs_tel     ; // 매장번호
    private String mem_intro       ; // 매장소개
    private String mem_x           ; // 매장X좌표
    private String mem_y           ; // 매장Y좌표
    
    // 제품 정보       
    private String stcklist_id     ; // 재고리스트코드
    private String stcklist_amount ; // 수량
    private String sicklist_exdate ; // 유통기한
    private String stck_date       ; // 날짜
    private String stcklist_info   ; // 비고
    
	public CvsSearchVo() {
		super();
	}

	public CvsSearchVo(String mem_id, String mem_name, String mem_tel,
			String mem_birth, String mem_gen, String mem_zip, String mem_add,
			String mem_addr, String mem_cvs_name, String mem_cvs_tel,
			String mem_intro, String mem_x, String mem_y, String stcklist_id,
			String stcklist_amount, String sicklist_exdate, String stck_date,
			String stcklist_info) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_birth = mem_birth;
		this.mem_gen = mem_gen;
		this.mem_zip = mem_zip;
		this.mem_add = mem_add;
		this.mem_addr = mem_addr;
		this.mem_cvs_name = mem_cvs_name;
		this.mem_cvs_tel = mem_cvs_tel;
		this.mem_intro = mem_intro;
		this.mem_x = mem_x;
		this.mem_y = mem_y;
		this.stcklist_id = stcklist_id;
		this.stcklist_amount = stcklist_amount;
		this.sicklist_exdate = sicklist_exdate;
		this.stck_date = stck_date;
		this.stcklist_info = stcklist_info;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_gen() {
		return mem_gen;
	}

	public void setMem_gen(String mem_gen) {
		this.mem_gen = mem_gen;
	}

	public String getMem_zip() {
		return mem_zip;
	}

	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}

	public String getMem_add() {
		return mem_add;
	}

	public void setMem_add(String mem_add) {
		this.mem_add = mem_add;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public String getMem_cvs_name() {
		return mem_cvs_name;
	}

	public void setMem_cvs_name(String mem_cvs_name) {
		this.mem_cvs_name = mem_cvs_name;
	}

	public String getMem_cvs_tel() {
		return mem_cvs_tel;
	}

	public void setMem_cvs_tel(String mem_cvs_tel) {
		this.mem_cvs_tel = mem_cvs_tel;
	}

	public String getMem_intro() {
		return mem_intro;
	}

	public void setMem_intro(String mem_intro) {
		this.mem_intro = mem_intro;
	}

	public String getMem_x() {
		return mem_x;
	}

	public void setMem_x(String mem_x) {
		this.mem_x = mem_x;
	}

	public String getMem_y() {
		return mem_y;
	}

	public void setMem_y(String mem_y) {
		this.mem_y = mem_y;
	}

	public String getStcklist_id() {
		return stcklist_id;
	}

	public void setStcklist_id(String stcklist_id) {
		this.stcklist_id = stcklist_id;
	}

	public String getStcklist_amount() {
		return stcklist_amount;
	}

	public void setStcklist_amount(String stcklist_amount) {
		this.stcklist_amount = stcklist_amount;
	}

	public String getSicklist_exdate() {
		return sicklist_exdate;
	}

	public void setSicklist_exdate(String sicklist_exdate) {
		this.sicklist_exdate = sicklist_exdate;
	}

	public String getStck_date() {
		return stck_date;
	}

	public void setStck_date(String stck_date) {
		this.stck_date = stck_date;
	}

	public String getStcklist_info() {
		return stcklist_info;
	}

	public void setStcklist_info(String stcklist_info) {
		this.stcklist_info = stcklist_info;
	}

	@Override
	public String toString() {
		return "CvsSearchVo [mem_id=" + mem_id + ", mem_name=" + mem_name
				+ ", mem_tel=" + mem_tel + ", mem_birth=" + mem_birth
				+ ", mem_gen=" + mem_gen + ", mem_zip=" + mem_zip
				+ ", mem_add=" + mem_add + ", mem_addr=" + mem_addr
				+ ", mem_cvs_name=" + mem_cvs_name + ", mem_cvs_tel="
				+ mem_cvs_tel + ", mem_intro=" + mem_intro + ", mem_x=" + mem_x
				+ ", mem_y=" + mem_y + ", stcklist_id=" + stcklist_id
				+ ", stcklist_amount=" + stcklist_amount + ", sicklist_exdate="
				+ sicklist_exdate + ", stck_date=" + stck_date
				+ ", stcklist_info=" + stcklist_info + "]";
	}
	
	
}
