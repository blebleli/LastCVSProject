package kr.or.ddit.user.search.model;

public class SearchCvsServiceVo {

	private String mem_id;         // 일반:이메일, 점주:사업자번호, 관리자:일괄부여
	private String mem_pw;         // 비밀번호
	private String mem_kind;       // 관리자 : 00, 점주 : 01, 일반 : 02
	private String mem_name;       // 일반:일반회원 점주:점주이름
	private String mem_tel;        // 연락처
	private String mem_birth;      // 생년월일
	private String mem_gen;        // 성별
	private int mem_zip;           // 일반: 개인집주소, 점주:편의점주소
	private String mem_add;        // 일반: 개인집주소, 점주:편의점주소
	private String mem_addr;       // 일반: 개인집주소, 점주:편의점주소
	private String mem_cvs_name;   // 편의점명
	private String mem_cvs_tel;    // 편의점연락처
	private String mem_intro;      // 소개
	private String mem_x;          // 좌표_x
	private String mem_y;          // 좌표_y
	private int mem_point;		   // 포인트
	private String ctgy_id;
	private String ctgy_name;
	
	public SearchCvsServiceVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchCvsServiceVo(String mem_id, String mem_pw, String mem_kind,
			String mem_name, String mem_tel, String mem_birth, String mem_gen,
			int mem_zip, String mem_add, String mem_addr, String mem_cvs_name,
			String mem_cvs_tel, String mem_intro, String mem_x, String mem_y,
			String ctgy_id, String ctgy_name) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_kind = mem_kind;
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
		this.ctgy_id = ctgy_id;
		this.ctgy_name = ctgy_name;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_kind() {
		return mem_kind;
	}

	public void setMem_kind(String mem_kind) {
		this.mem_kind = mem_kind;
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

	public int getMem_zip() {
		return mem_zip;
	}

	public void setMem_zip(int mem_zip) {
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

	@Override
	public String toString() {
		return "SearchCvsVo [mem_id=" + mem_id + ", mem_pw=" + mem_pw
				+ ", mem_kind=" + mem_kind + ", mem_name=" + mem_name
				+ ", mem_tel=" + mem_tel + ", mem_birth=" + mem_birth
				+ ", mem_gen=" + mem_gen + ", mem_zip=" + mem_zip
				+ ", mem_add=" + mem_add + ", mem_addr=" + mem_addr
				+ ", mem_cvs_name=" + mem_cvs_name + ", mem_cvs_tel="
				+ mem_cvs_tel + ", mem_intro=" + mem_intro + ", mem_x=" + mem_x
				+ ", mem_y=" + mem_y + ", ctgy_id=" + ctgy_id + ", ctgy_name="
				+ ctgy_name + "]";
	}
	
	
	
	
}
