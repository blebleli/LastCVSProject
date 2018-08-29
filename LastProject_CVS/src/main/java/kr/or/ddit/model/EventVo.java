package kr.or.ddit.model;

public class EventVo {
	
	private String event_id;                               // 행사제품코드
	private String event_date;                               // 행사 마감 날짜
	private String event_kind;                               // 일반 : 200, 1+1 : 201 , 2+1 : 202 , 증정 : 203 , 할인 : 204
	public EventVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventVo(String event_id, String event_date, String event_kind) {
		super();
		this.event_id = event_id;
		this.event_date = event_date;
		this.event_kind = event_kind;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getEvent_kind() {
		return event_kind;
	}
	public void setEvent_kind(String event_kind) {
		this.event_kind = event_kind;
	}
	@Override
	public String toString() {
		return "EventVo [event_id=" + event_id + ", event_date=" + event_date
				+ ", event_kind=" + event_kind + "]";
	}
	
	

}
