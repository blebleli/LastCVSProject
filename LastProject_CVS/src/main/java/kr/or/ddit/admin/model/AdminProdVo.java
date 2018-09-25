package kr.or.ddit.admin.model;


public class AdminProdVo {

	private int cnt;
	private int page;
	private int pageSize;
	
	private String prod_id ;
	private String prod_name;
	private String pr_class_lg;
	private String pr_class_md;
	private String event_id;
	private String prod_intro;
	private String file_path;
	private String file_upname;

	private int prod_cost;
	private int cost_min;
	private int prod_price;
	private int price_min;
	private int prod_exnum;
	
	public AdminProdVo() {
		super();
	}

	public AdminProdVo(int cnt, int page, int pageSize, String prod_id,
			String prod_name, String pr_class_lg, String pr_class_md,
			String event_id, int prod_cost, int cost_min, int prod_price,
			int price_min, int prod_exnum) {
		super();
		this.cnt = cnt;
		this.page = page;
		this.pageSize = pageSize;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.pr_class_lg = pr_class_lg;
		this.pr_class_md = pr_class_md;
		this.event_id = event_id;
		this.prod_cost = prod_cost;
		this.cost_min = cost_min;
		this.prod_price = prod_price;
		this.price_min = price_min;
		this.prod_exnum = prod_exnum;
	}


	

	public String getProd_intro() {
		return prod_intro;
	}

	public void setProd_intro(String prod_intro) {
		this.prod_intro = prod_intro;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
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

	public String getPr_class_lg() {
		return pr_class_lg;
	}

	public void setPr_class_lg(String pr_class_lg) {
		this.pr_class_lg = pr_class_lg;
	}

	public String getPr_class_md() {
		return pr_class_md;
	}

	public void setPr_class_md(String pr_class_md) {
		this.pr_class_md = pr_class_md;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public int getProd_cost() {
		return prod_cost;
	}

	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}

	public int getCost_min() {
		return cost_min;
	}

	public void setCost_min(int cost_min) {
		this.cost_min = cost_min;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getPrice_min() {
		return price_min;
	}

	public void setPrice_min(int price_min) {
		this.price_min = price_min;
	}

	public int getProd_exnum() {
		return prod_exnum;
	}

	public void setProd_exnum(int prod_exnum) {
		this.prod_exnum = prod_exnum;
	}

	@Override
	public String toString() {
		return "AdminProdVo [cnt=" + cnt + ", page=" + page + ", pageSize="
				+ pageSize + ", prod_id=" + prod_id + ", prod_name="
				+ prod_name + ", pr_class_lg=" + pr_class_lg + ", pr_class_md="
				+ pr_class_md + ", event_id=" + event_id + ", prod_intro="
				+ prod_intro + ", file_path=" + file_path + ", file_upname="
				+ file_upname + ", prod_cost=" + prod_cost + ", cost_min="
				+ cost_min + ", prod_price=" + prod_price + ", price_min="
				+ price_min + ", prod_exnum=" + prod_exnum + "]";
	}

}
