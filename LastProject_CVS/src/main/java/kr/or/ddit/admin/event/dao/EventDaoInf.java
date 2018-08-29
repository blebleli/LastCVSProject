package kr.or.ddit.admin.event.dao;

import java.util.List;

import kr.or.ddit.model.EventVo;

public interface EventDaoInf {

	int newEvnet(EventVo eventVo);
	
	List<EventVo> getEventList();
	
	int updateEvent(EventVo eventVo);
	
	int deleteEvent(String EVENT_ID);
}
