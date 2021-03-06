package kr.or.ddit.model;

import java.util.Date;

public class EventVo {
	private String event_id      ; // BASIC, EVENT, DIS
//	private String event_startday;   // 시작일
//	private String event_endday  ;   // 종료일
	private String event_kind    ; // 일반, 행사, 할인 
	private String event_name    ; // 이벤트이름
	private double event_discount; // 할인율
	
	private Date event_startday;   // 시작일
	private Date event_endday  ;   // 종료일
	
	public EventVo() {
		super();
	}
	
	

	public EventVo(String event_id, String event_kind, String event_name,
			double event_discount, Date event_startday, Date event_endday) {
		super();
		this.event_id = event_id;
		this.event_kind = event_kind;
		this.event_name = event_name;
		this.event_discount = event_discount;
		this.event_startday = event_startday;
		this.event_endday = event_endday;
	}



	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getEvent_kind() {
		return event_kind;
	}

	public void setEvent_kind(String event_kind) {
		this.event_kind = event_kind;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public double getEvent_discount() {
		return event_discount;
	}

	public void setEvent_discount(double event_discount) {
		this.event_discount = event_discount;
	}

	public Date getEvent_startday() {
		return event_startday;
	}

	public void setEvent_startday(Date event_startday) {
		this.event_startday = event_startday;
	}

	public Date getEvent_endday() {
		return event_endday;
	}

	public void setEvent_endday(Date event_endday) {
		this.event_endday = event_endday;
	}

	@Override
	public String toString() {
		return "EventVo [event_id=" + event_id + ", event_kind=" + event_kind
				+ ", event_name=" + event_name + ", event_discount="
				+ event_discount + ", event_startday=" + event_startday
				+ ", event_endday=" + event_endday + "]";
	}
	
	


}
