package kr.or.ddit.store_owner.model;

public class OnedayChartVo {

	private String year;
	private String month;
	private String day;
	private int total;
	
	public OnedayChartVo() {
		super();
	}

	public OnedayChartVo(String year, String month, String day, int total) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.total = total;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OnedayChartVo [year=" + year + ", month=" + month + ", day="
				+ day + ", total=" + total + "]";
	}
	
	
	
}
