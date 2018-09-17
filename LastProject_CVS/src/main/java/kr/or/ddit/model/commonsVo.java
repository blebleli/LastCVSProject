package kr.or.ddit.model;

public class commonsVo {

	private int page;
	private int pageSize;
	private int cnt;
	
	public commonsVo() {
		super();
	}

	public commonsVo(int page, int pageSize, int cnt) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "commonsVo [page=" + page + ", pageSize=" + pageSize + ", cnt="+ cnt + "]";
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
