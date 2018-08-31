package kr.or.ddit.api.file.test;

public class FileVo {

	private String name;
	private String path;
	private int size;
	
	public FileVo(String name, String path, int size) {
		super();
		this.name = name;
		this.path = path;
		this.size = size;
	}
	public FileVo() {
		super();
	}
	@Override
	public String toString() {
		return "FileVo [name=" + name + ", path=" + path + ", size=" + size
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
