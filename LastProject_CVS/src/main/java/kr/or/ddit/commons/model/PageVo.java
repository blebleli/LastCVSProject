package kr.or.ddit.commons.model;

/* 09.11 KONG : PageVo 추가  */
public class PageVo {

	private int page;
	
	private int pageSize;
	
	private int tot_cnt;
	
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

	public int getTot_cnt() {
		return tot_cnt;
	}

	public void setTot_cnt(int tot_cnt) {
		this.tot_cnt = tot_cnt;
	}

	
	
}
