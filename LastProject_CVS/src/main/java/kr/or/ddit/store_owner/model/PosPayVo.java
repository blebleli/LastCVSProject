package kr.or.ddit.store_owner.model;

public class PosPayVo {

	private PresentStockListVo presentStockListVo;
	private String pay_kind;
	
	
	public PosPayVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PosPayVo(PresentStockListVo presentStockListVo, String pay_kind) {
		super();
		this.presentStockListVo = presentStockListVo;
		this.pay_kind = pay_kind;
	}



	public PresentStockListVo getPresentStockListVo() {
		return presentStockListVo;
	}

	public void setPresentStockListVo(PresentStockListVo presentStockListVo) {
		this.presentStockListVo = presentStockListVo;
	}

	public String getPay_kind() {
		return pay_kind;
	}

	public void setPay_kind(String pay_kind) {
		this.pay_kind = pay_kind;
	}

	@Override
	public String toString() {
		return "posPayVo [presentStockListVo=" + presentStockListVo
				+ ", pay_kind=" + pay_kind + "]";
	} 
	
	
	
}
