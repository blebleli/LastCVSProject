package kr.or.ddit.admin.event.service;

import java.util.List;

import kr.or.ddit.model.EventVo;

public interface EventServiceInf {

	int newEvnet(EventVo eventVo);
	
	List<EventVo> getEventList();
	
	int updateEvent(EventVo eventVo);
	
	int deleteEvent(String EVENT_ID);
}
