package kr.or.ddit.model;

import org.springframework.web.multipart.MultipartFile;

public class FiledataVo {
	
	private String file_id;                               // 자료코드
	private String file_name;                               // 파일명
	private String file_upname;                               // 파일업로드명
	private String file_path;                               // 경로
	private int file_size;                               // 크기
	private String file_dot;                               // 확장자
	private String bd_id;                               // 게시판코드
	private String mem_id;                               // 아이디
	
	private String[] flag;	// 추가/삭제여부
	private MultipartFile[] upload_file;
	
	public FiledataVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FiledataVo(String file_id, String file_name, String file_upname,
			String file_path, int file_size, String file_dot, String bd_id,
			String mem_id) {
		super();
		this.file_id = file_id;
		this.file_name = file_name;
		this.file_upname = file_upname;
		this.file_path = file_path;
		this.file_size = file_size;
		this.file_dot = file_dot;
		this.bd_id = bd_id;
		this.mem_id = mem_id;
	}
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_upname() {
		return file_upname;
	}
	public void setFile_upname(String file_upname) {
		this.file_upname = file_upname;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public String getFile_dot() {
		return file_dot;
	}
	public void setFile_dot(String file_dot) {
		this.file_dot = file_dot;
	}
	public String getBd_id() {
		return bd_id;
	}
	public void setBd_id(String bd_id) {
		this.bd_id = bd_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String[] getFlag() {
		return flag;
	}
	public void setFlag(String[] flag) {
		this.flag = flag;
	}
	public MultipartFile[] getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(MultipartFile[] upload_file) {
		this.upload_file = upload_file;
	}
	@Override
	public String toString() {
		return "Filedata [file_id=" + file_id + ", file_name=" + file_name
				+ ", file_upname=" + file_upname + ", file_path=" + file_path
				+ ", file_size=" + file_size + ", file_dot=" + file_dot
				+ ", bd_id=" + bd_id + ", mem_id=" + mem_id + "]";
	}
	
	

}
