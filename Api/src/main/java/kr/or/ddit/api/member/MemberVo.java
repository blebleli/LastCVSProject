package kr.or.ddit.api.member;

// 점주 및 편의점 정보 insert Vo
public class MemberVo {
	
	private String mem_id; 		 // 사업자번호
	private String mem_pw; 		 // 비밀번호
	private String mem_kind;	 // 회원종류
	private String mem_name;	 // 점주이름
	private String mem_tel; 	 // 점주연락처
	private String mem_birth;    // 점주 생년월일
	private String mem_gen;		 // 점주 성별
	private int mem_zip; 		 // 편의점 우편번호
	private String mem_add; 	 // 편의점 주소
	private String mem_addr; 	 // 편의점 상세주소
	private String mem_cvs_name; // 편의점 이름
	private String mem_cvs_tel;  // 편의점 연락처
	private String mem_intro; 	 // 편의점 소개
	private double mem_x; 			 // 편의점 x좌표
	private double mem_y; 			 // 편의점 y좌표
	
	public MemberVo(){
		super();
	}

	public MemberVo(String mem_id, String mem_pw, String mem_kind,
			String mem_name, String mem_tel, String mem_birth, String mem_gen,
			int mem_zip, String mem_add, String mem_addr,
			String mem_cvs_name, String mem_cvs_tel, String mem_intro,
			double mem_x, double mem_y) {
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

	public double getMem_x() {
		return mem_x;
	}

	public void setMem_x(double mem_x) {
		this.mem_x = mem_x;
	}

	public double getMem_y() {
		return mem_y;
	}

	public void setMem_y(double mem_y) {
		this.mem_y = mem_y;
	}

	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_pw=" + mem_pw
				+ ", mem_kind=" + mem_kind + ", mem_name=" + mem_name
				+ ", mem_tel=" + mem_tel + ", mem_birth=" + mem_birth
				+ ", mem_gen=" + mem_gen + ", mem_zip=" + mem_zip
				+ ", mem_add=" + mem_add + ", mem_addr=" + mem_addr
				+ ", mem_cvs_name=" + mem_cvs_name + ", mem_cvs_tel="
				+ mem_cvs_tel + ", mem_intro=" + mem_intro + ", mem_x=" + mem_x
				+ ", mem_y=" + mem_y + "]";
	}
}