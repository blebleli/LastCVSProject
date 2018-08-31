package kr.or.ddit.api.batch;

import java.util.Date;

public class EventVo {	
	private String event_id; 	// 행사제품코드
	private Date event_date; 	// 기간
    private String event_kind;  // 구분  
    
    public EventVo() {
    	
    }
    
	public EventVo(String event_id, Date event_date, String event_kind) {
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

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
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