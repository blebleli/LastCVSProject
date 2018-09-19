package kr.or.ddit.admin.model;

public class CvsCountVo {
	
	private String local;
	private int count;
	
	public CvsCountVo(){
		super();
	}
	
	public CvsCountVo(String local, int count) {
		super();
		this.local = local;
		this.count = count;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "CvsCountVo [local=" + local + ", count=" + count + "]";
	}
	
	
}
